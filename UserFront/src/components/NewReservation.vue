<template>
    <div id="reservation-new">
    <div class="container" id='page-title'>
        <h1 style="margin-top:10px;color:#35424a;">Kreiranje <span id='titleEffect'>Rezervacije</span></h1>
        <hr style='background:#35424a;height:1px;'>
    </div>
    <div id='main' class='container'>
        <div id='carInfo'>
            <div class="card-header">
                <h4><b>Automobil:</b> {{odabraniOglas.automobil.markaAut}} {{odabraniOglas.automobil.modelAut}} (marka/model)</h4>
                <h4><b>Klasa automobila:</b> {{odabraniOglas.automobil.klasaAut}}</h4>
                <h5><b>Ocena: </b>{{odabraniOglas.automobil.ukupnaOcena}}</h5>
            </div>
        </div>

        <div style="margin-top:20px" v-if='messages.errorDates' class="alert alert-danger" v-html="messages.errorDates"></div>
        <label>Datum pocetka rezervacije:</label>
        <vuejsDatepicker placeholder="Select Start Date" :disabled-dates="disabledDates" :highlighted="dates"
            v-model="rezervacijaOglasDTO.odDatuma" v-on:input="calculatePriceAndDate()">
        </vuejsDatepicker>
        <label>Broj dana:</label>
        <select style="padding:7px; margin-right: 10px" id='NoOfDays' v-model="odabran_br_dana"
            v-on:click="calculatePriceAndDate()">
            <option disabled value="">Broj dana</option>
            <option v-bind:key="dan" v-for='dan in br_dana'>{{dan}}</option>
        </select>

        <div id='cenovnik'>
            <label> Cenovnik rezervacije: </label>
            <table id='showPriceTable'>
                <thead>
                    <tr>
                        <th>Naziv cenovnika</th>
                        <th>Cena po danu</th>
                        <th>Cena po kilometru</th>
                        <th>CDW</th>
                        <th></th>
                        <th>Popust preko 20 dana</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{{odabraniOglas.cenovnik.nazivCenovnika}}</td>
                        <td>{{odabraniOglas.cenovnik.cenaPoDanu}} din</td>
                        <td>{{odabraniOglas.cenovnik.cenaPoKilometru}} din</td>
                        <td>{{odabraniOglas.cenovnik.cenaCollisionDamageWaiver}} din</td>
                        <td></td>
                        <td>{{odabraniOglas.cenovnik.popustZaPreko30Dana}} %</td>
                    </tr>     
                </tbody>            
            </table>
        </div>

        <h5><label for="">Vrednost popusta</label> </h5>
        <h5>{{popust}} din</h5>

        <label>Ukupna cena:</label>
        <h4>{{rezervacijaOglasDTO.ukupnaCena}} din</h4>

        <label>Tekst rezervacije:</label>
        <textarea v-model='rezervacijaOglasDTO.poruka' placeholder="message..."></textarea>
        <button class="btn btn-lg btn-success margTop" v-on:click='makeReservation()'> Rezerviši </button>
    </div>
</div>
</template>

<script>
//import KlijentDataService from './components/KlijentDataService'
import Datepicker from 'vuejs-datepicker'
export default {
    data(){
        return{
            user: {
                username: '',
                role: ''
            },

            rezervacijaOglasDTO:{
            //Rezervacija
                ukupnaCena:0,                   //cena_po_danu * broj_dana
                bundle: false,                  //agent moze samo za pojedinacna vozila da fizicki zauzima...
                statusRezervacije:'PENDING',    //defaultni status
                poruka:'',
            //Narudzbenica
                oglasId:null,                   
                odDatuma: null,
                doDatuma: null,
                agentId:null, 
            },
            
            terminOglasa:{
                odDatuma:null,
                doDatuma:null,
            },
            
            odabraniOglas:{
                //oglas
                id:1,
                odDatuma:1607003400000, //3 dec
                doDatuma:1609077000000, //27 dec
                lokacija:'9. Marta bb Novi Sad',
                TAdresa:{
                    mesto:'Novi Sad',
                    ulica:'9. Marta',
                    broj:'bb',
                    postanskiBroj:'21000',
                    longitude:'45',
                    latitude:'54',
                },
                planiranaKilometraza:2000,
                username:'This host', //u DTOu za korisnika koji je kreirao oglas.
                zauzetiTermini:[
                    {
                        from:1607004000000, //4 dec
                        to: 1607263200000, // 6 dec
                    },
                    {
                        from: 1607609580000, //10 dec
                        to: 1608041580000, // 15 dec
                    }
                ],
                //automobil
                automobil:{
                    id:'1',
                    markaAut:'BMW',
                    modelAut:'M5',
                    klasaAut:'SUV',
                    vrstaGoriva:'dizel',
                    tipMenjaca:'manuelni',
                    ukupnaOcena:5,
                    brojSedistaZaDecu:1,
                    predjenaKilometraza:5000,
                    collisionDamageWaiver:true,
                },
                //cena    
                cenovnik:{
                    id:'1',
                    cenaPoDanu:100,
                    nazivCenovnika:'Cenovnik 1',
                    popustZaPreko30Dana:10,
                    cenaCollisionDamageWaiver:1000,
                    cenaPoKilometru:10
                },
            },

            messages: {
				errorDates: '',
				errorResponse: '',
				successResponse: '',
			},

            odabran_br_dana: null, //za racunanje ukupne cene i doDatuma
            br_dana: null, //broj dana od 1-28
            
            //Za prikaz i smestanje vrednosti popusta
            popust:0,

            //Prikaz datuma koji su zuzeti
			disabledDates: {
				to: null,
				from: null,
				ranges: [],
			},

            //Za smestanje odabranog datuma 
			dates: {
				from: new Date,
				to: null,
				includeDisabled: true
            },
            
            //poruke za error ili success odgovore.
			messages: {
                errorDates: '',
                errorPrice:'',
				errorMessage: '',
				errorResponse: '',
				successResponse: '',
			},
			error: false,
        }
    },
    methods:{ 
        setAd: function (data) {
            this.odabraniOglas = data;
			this.disabledDates.to = new Date(this.odabraniOglas.odDatuma - 1000 * 60 * 60 * 24);
            this.disabledDates.from = new Date(this.odabraniOglas.doDatuma);

			let today = new Date();
			if (this.disabledDates.to < today) {
				today.setDate(today.getDate() - 1);

				this.disabledDates.to = today;
			}
			this.insertReservData();

			if (this.odabraniOglas.zauzetiTermini != null) {
				for (let i = 0; i < this.odabraniOglas.zauzetiTermini.length; i++) {
					let available = {
						from: new Date(this.odabraniOglas.zauzetiTermini[i].from),
						to: new Date(this.odabraniOglas.zauzetiTermini[i].to + 1000 * 60 * 60 * 24)
					}
					this.disabledDates.ranges.push(available);
				}
			}
		},

        makeReservation(){
            //Provera da li je odabrani interval usao u neki nedostupni/rezervisani podinterval
            for (let i = 0; i < this.disabledDates.ranges.length; i++) {
				if (this.dates.from <= this.disabledDates.ranges[i].from && this.dates.to > this.disabledDates.ranges[i].from) {
					this.error = true;
				}
            }
            //Provera da je unet pocetni interval
            if(this.rezervacijaOglasDTO.odDatuma == null){
                this.messages.errorDates = `<h4>Morate odabrati početni termin rezervacije!</h4>`;
                setTimeout(() => this.messages.errorDates = '', 5000);
            }

			else if (this.dates.to >= this.disabledDates.from || this.error) {
				this.messages.errorDates = `<h4>Odabrani interval nije dostupan!</h4>`;
				setTimeout(() => this.messages.errorDates = '', 10000);
			}
            else{
                this.rezervacijaOglasDTO.odDatuma = this.dates.from; //nije potrebno
                this.rezervacijaOglasDTO.doDatuma = this.dates.to;
                //OBRISATI POSLE
                /*console.log(`Rezervacija koju saljem: 
                    UkupnaCena: ${this.rezervacijaOglasDTO.ukupnaCena},
                    Bundle: ${this.rezervacijaOglasDTO.bundle},
                    StatusRezervacije: ${this.rezervacijaOglasDTO.statusRezervacije},
                    Poruka: ${this.rezervacijaOglasDTO.poruka},
                    OglasId:${this.rezervacijaOglasDTO.oglasId},                   
                    OdDatuma: ${this.rezervacijaOglasDTO.odDatuma},
                    DoDatuma: ${this.rezervacijaOglasDTO.doDatuma},
                    AgentId:${this.rezervacijaOglasDTO.agentId},
                `);*/
            }
        },

		range: function (start = 1, end) {
			var ans = [];
			for (let i = start; i <= end; i++) {
				ans.push(i);
			}
			return ans;
		},
		calculatePriceAndDate: function () {
            this.rezervacijaOglasDTO.ukupnaCena = this.odabran_br_dana * this.odabraniOglas.cenovnik.cenaPoDanu;
            if(this.odabran_br_dana > 20){
               
                if(this.odabraniOglas.cenovnik.popustZaPreko30Dana != null){
                    this.popust =  this.rezervacijaOglasDTO.ukupnaCena * (this.odabraniOglas.cenovnik.popustZaPreko30Dana/100);
                }
                if(this.odabraniOglas.cenovnik.popustZaPreko30Dana === null && this.popust !== 0){
                    this.popust = 0;
                }

                this.rezervacijaOglasDTO.ukupnaCena = this.rezervacijaOglasDTO.ukupnaCena -  this.popust;
                
            }
            this.dates.from = new Date(this.rezervacijaOglasDTO.odDatuma);
			this.dates.to = new Date(this.dates.from.getTime() + this.odabran_br_dana * 1000 * 60 * 60 * 24);
            this.error = false;

            console.log('VREME NARUDZB OD: ' + this.dates.from.getTime());
            console.log('VREME NARUDZB DO: ' + this.dates.to.getTime());

        },

		insertReservData: function () {
            this.rezervacijaOglasDTO.oglasId = this.id;
            this.odabran_br_dana = 1;

			this.calculatePriceAndDate();
		},
    },
 	components: {
		vuejsDatepicker:Datepicker,
    },
	computed: {
		id() {
			return this.$route.params.id; 
		},
	},
	created() {

	},
	mounted() {
		this.br_dana = this.range(1, 28);
        this.setAd(this.odabraniOglas);
	}
}
</script>

<style>
#titleEffect{
  color:gold;
  font-weight: bold;
}
                        
#reservation-new label {
  display: block;
  margin: 20px 0 10px;
  font-size: 20px;
  font-weight: bold;
}

#reservation-new textarea {
  display: block;
  width: 100%;
  height: 200px;
  padding:8px;
}

/* Za ocenu */
#showPriceTable{
    /* color:crimson; */
    color:#35424a;
    margin-top:10px;
    border-bottom: 1px solid lightgrey;
} 

#showPriceTable thead{
    border-bottom: 1px solid lightgrey;
}

#showPriceTable thead th{
    padding-right:15px;
}

.margTop{
    margin-top: 15px;
}

</style>