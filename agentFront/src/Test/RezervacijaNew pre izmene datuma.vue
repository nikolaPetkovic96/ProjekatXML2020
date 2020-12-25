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
                <h5><b>Interval u kojem je automobil dostupan:</b> {{odabraniOglas.odDatuma}} - {{odabraniOglas.doDatuma}} </h5>
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

            //Prilikom rucnog dodavanja rezervacije kreira se odmah i narudzbenica za taj termin koja se poveze sa rezervacijom,
            //DTO koji spaja atribute rezervacije i narudzbenice.
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
                agentId:null, // ili samo username pa na beku id da dodelimo...
                //userId:null //Ili Ime i prezime onoga za koga se rezervise da li treba???
            //Na beku se dodaje:
                //commonDataId: u oba
                //NarudzbenicaId: u rezervaciju
            },
            odabraniOglas:{
                //oglas
                id:1,
                odDatuma:1604323680000, //2 nov
                doDatuma:1604496240000, //30 nov
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
                        from: 1604496540000, //4 nov
                        to: 1604669340000, // 6 nov
                    },
                    {
                        from: 1605015000000, //10 nov
                        to: 1605447000000, // 15 nov
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
        //Metoda koja se poziva u create fazi stranice
        //Sluzi da se iz oglasa izvuce interval od kada do kada oglas vazi,
        //Kao i zauzeti podintervali, tako sto se uzima od do datum svih rezervacija(narudzbenica) vezanih za taj oglas.  
        setAd: function (data) {
			this.odabraniOglas = data;
			this.disabledDates.to = new Date(this.odabraniOglas.doDatuma - 1000 * 60 * 60 * 24);
			this.disabledDates.from = new Date(this.odabraniOglas.odDatuma);

			let today = new Date();
			if (this.disabledDates.to < today) {
				today.setDate(today.getDate() - 1);

				this.disabledDates.to = today;
			}
			this.insertReservData();

			if (this.odabraniOglas.zauzetiTermini != null) {
				for (let i = 0; i < this.odabraniOglast.zauzetiTermini.length; i++) {
					let available = {
						from: new Date(this.odabraniOglas.zauzetiTermini[i].from),
						to: new Date(this.odabraniOglas.zauzetiTermini[i].to + 1000 * 60 * 60 * 24)
					}
					this.disabledDates.ranges.push(available);
				}
			}
		},


        makeReservation(){
           
            if(this.rezervacijaOglasDTO.odDatuma == null){
                this.messages.errorDates = `<h4>Morate odabrati početni termin rezervacije!</h4>`;
                setTimeout(() => this.messages.errorDates = '', 5000);
            }
            else{
                this.rezervacijaOglasDTO.doDatuma = this.dates.to;
                //OBRISATI POSLE
                console.log(`Rezervacija koju saljem: 
                    UkupnaCena: ${this.rezervacijaOglasDTO.ukupnaCena},
                    Bundle: ${this.rezervacijaOglasDTO.bundle},
                    StatusRezervacije: ${this.rezervacijaOglasDTO.statusRezervacije},
                    Poruka: ${this.rezervacijaOglasDTO.poruka},
                    OglasId:${this.rezervacijaOglasDTO.oglasId},                   
                    OdDatuma: ${this.rezervacijaOglasDTO.odDatuma},
                    DoDatuma: ${this.rezervacijaOglasDTO.doDatuma},
                    AgentId:${this.rezervacijaOglasDTO.agentId},
                `);
            }
        },

        // pomocna metoda za ogranicen odabir dana:
		range: function (start = 1, end) {
			var ans = [];
			for (let i = start; i <= end; i++) {
				ans.push(i);
			}
			return ans;
		},
		//Metoda za automatsko racunanje krajnjeg datuma spram broja nocenja i cene rezervacija spram cene apartmana * broj nocenja
		calculatePriceAndDate: function () {
            this.rezervacijaOglasDTO.ukupnaCena = this.odabran_br_dana * this.odabraniOglas.cenovnik.cenaPoDanu;
            if(this.odabran_br_dana > 20){
               
                if(this.odabraniOglas.cenovnik.popustZaPreko30Dana != null){
                    this.popust =  this.rezervacijaOglasDTO.ukupnaCena * (this.odabraniOglas.cenovnik.popustZaPreko30Dana/100);
                }
                //Ukoliko korisnik odabere neki cenovnik koji ima popust, a zatim odabere cenovnik koji nema popust
                //ostaje upamcen popust prethodnog cenovnika... Zato se resetuje na 0;
                if(this.odabraniOglas.cenovnik.popustZaPreko30Dana === null && this.popust !== 0){
                    this.popust = 0;
                }

                this.rezervacijaOglasDTO.ukupnaCena = this.rezervacijaOglasDTO.ukupnaCena -  this.popust;
                
            }
            this.dates.from = new Date(this.rezervacijaOglasDTO.odDatuma);
			this.dates.to = new Date(this.dates.from.getTime() + this.odabran_br_dana * 1000 * 60 * 60 * 24);
            this.error = false;

            console.log('VREME OD: ' + this.dates.from.getTime());
            console.log('VREME DO: ' + this.dates.to.getTime());

        },

		insertReservData: function () {
            // dodaje se u rezervaciju id oglasa za koji se pravi rezervacija
            this.rezervacijaOglasDTO.oglasId = this.id;

			// dodaje se u rezervaciju id agenta koji pravi rezervaciju
			// this.manuelnaRezervacija.userId = this.user.id iz cookia; ovo moze i na beku da se odradi 

			// dodaje se u rezervaciju inicijalni broj dana koji je uvek bar 1
			this.odabran_br_dana = 1;

			// dodaje se u rezervaciju cene rezervacije spram cene_po_danu * broj_dana kao i krajnji datum(odDatuma + br_dana);
			this.calculatePriceAndDate();
		},
    },
 	components: {
		vuejsDatepicker:Datepicker,
    },
	computed: {
		id() {
			return this.$route.params.id; //preuzimam id oglasa za koji zelim da napravim rezervaciju.
		},
	},
	created() {
        // za sada se ovde poziva, kasnije kada getujemo reklamu
        // ce se pozvati iz setAd metode u mounted fazi...
        this.insertReservData(); 
    
        // Ako je prazan token znaci da user nije ulogovan pa se preusmerava na login stranicu.
		// if (!localStorage.getItem('jwt'))
		// 	this.$router.push('/login');

	},
	mounted() {
		//dodaje se opseg dana za izbor trajanja iznajmljivanja
		this.br_dana = this.range(1, 28);

		// axios
		// 	.get('rest/ad/' + this.$route.params.id)
		// 	.then(Response => (this.setAd(Response.data)));
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