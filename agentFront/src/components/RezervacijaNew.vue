<template>
    <div id="reservation-new">
    <div class="container" id='page-title'>
        <h1 style="margin-top:10px;color:#35424a;">Kreiranje <span id='titleEffect'>Rezervacije</span></h1>
        <hr style='background:#35424a;height:1px;'>
    </div>

    <div id='main' class='container'>
       <div id='carInfo'>
            <div class="card-header">
                <h4><b>Automobil:</b> {{automobil.markaAut}} {{automobil.modelAut}} (marka/model)</h4>
                <h4><b>Klasa automobila:</b> {{automobil.klasaAut}}</h4>
            </div>
        </div>
        <label>Datum pocetka rezervacije:</label>
        <input type="date" v-model="rezervacijaOglasDTO.odDatuma">
        <label>Broj dana:</label>
        <select style="padding:7px; margin-right: 10px" id='NoOfDays' v-model="odabran_br_dana"
            v-on:click="calculatePriceAndDate()">
            <option disabled value="">Broj dana</option>
            <option v-bind:key="dan" v-for='dan in br_dana'>{{dan}}</option>
        </select>

        <div id='cenovnik'>
            <div id='odabirCene'>
                <label>Cenovnik:</label>
                <select style="padding:7px; margin-right: 10px" id='prices' v-model="odabran_cenovnik.nazivCenovnika">
                    <option disabled value="">Cenovnici</option>
                    <option  v-on:click="addChoosenPrice()" v-bind:key="cenovnik.id" v-for='cenovnik in cenovnici'>{{cenovnik.nazivCenovnika}}</option>
                </select>
            </div>
            <table v-if='odabran_cenovnik.nazivCenovnika !== ""' id='showPriceTable'>
                <thead>
                    <tr><b>Cenovnik sadrzi:</b></tr>
                    <tr>
                        <th>Naziv cenovnika</th>
                        <th>Cena po danu</th>
                        <th>Cena po kilometru</th>
                        <th>CDW</th>
                        <th>Popust preko 30 dana</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{{odabran_cenovnik.nazivCenovnika}}</td>
                        <td>{{odabran_cenovnik.cenaPoDanu}}</td>
                        <td>{{odabran_cenovnik.cenaPoKilometru}}</td>
                        <td>{{odabran_cenovnik.cenaCollisionDamageWaiver}}</td>
                        <td>{{odabran_cenovnik.popustZaPreko30Dana}}</td>
                    </tr>     
                </tbody>            
            </table>
        </div>

        <label>Ukupna cena:</label>
        <h4>{{rezervacijaOglasDTO.ukupnaCena}} din</h4>

        <label>Tekst rezervacije:</label>
        <textarea v-model='rezervacijaOglasDTO.poruka' placeholder="message..."></textarea>
        <button class="btn btn-lg btn-success" v-on:click='makeReservation(vehId)'> Send </button>
    </div>
</div>
</template>

<script>
//import KlijentDataService from './components/KlijentDataService'
export default {
    data(){
        return{
            user: {
                username: '',
                role: ''
            },
            vehId: '',
            isAdmin: false,
            isHost: false,
            isGuest: true,

            //PITATI STEVU 
            //Prilikom rucnog dodavanja rezervacije kreira se odmah i oglas koji je rezervisan za taj termin,
            //DTO koji spaja atribute rezervacije i oglasa.
            rezervacijaOglasDTO:{
                //Ime i prezime onoga za koga se rezervise da li treba???
                //rezervacija
                ukupnaCena:0, //cena_po_danu * broj_dana
                bundle: false, //agent moze samo za pojedinacna vozila da fizicki zauzima...
                statusRezervacije:'PENDING', //defaultni status
                poruka:'',
                //oglas
                automobilId:null,
                cenovnikId:null,
                //za oba isto
                odDatuma: null,
                doDatuma: null,
                //commonDataId:
                datumKreiranja:'',
                userId:null,
            },

            odabran_br_dana: null, //za racunanje ukupne cene i doDatuma
            br_dana: null, //broj dana od 1-28
            
            //Za prikaz podataka o automobilu napraviti ovakav DTO na beku
            automobil:{
                id:'1',
                markaAut:'BMW',
                modelAut:'M5',
                klasaAut:'SUV',
                tipMenjaca:'',
                vrstaGoriva:'',
                predjenaKilometraza:500,
                // planiranaKilometraza:250, ovo ide u oglase
                brojSedistaZaDecu:3,
                collisionDamageWaiver: true,
                ukupna_ocena:5, //ovo treba dodati u automobil
            },

            //lista svih cenovnika koji se getuju prilikom kreiranja stranice;
            cenovnici:[
               {
                    id:'1',
                    cenaPoDanu:100,
                    nazivCenovnika:'Cenovnik 1',
                    popustZaPreko30Dana:'10%',
                    cenaCollisionDamageWaiver:1000,
                    cenaPoKilometru:10
                },
                {
                    id:'2',
                    cenaPoDanu:200,
                    nazivCenovnika:'Cenovnik 2',
                    popustZaPreko30Dana:'20%',
                    cenaCollisionDamageWaiver:null,
                    cenaPoKilometru:20
                },
                {
                    id:'3',
                    cenaPoDanu:300,
                    nazivCenovnika:'Cenovnik 3',
                    popustZaPreko30Dana:null,
                    cenaCollisionDamageWaiver:3000,
                    cenaPoKilometru:30
                },
                {
                    id:'4',
                    cenaPoDanu:400,
                    nazivCenovnika:'Cenovnik 4',
                    popustZaPreko30Dana:'20%',
                    cenaCollisionDamageWaiver:null,
                    cenaPoKilometru:40
                },
                {
                    id:'5',
                    cenaPoDanu:500,
                    nazivCenovnika:'Cenovnik 5',
                    popustZaPreko30Dana:null,
                    cenaCollisionDamageWaiver:5000,
                    cenaPoKilometru:50
                },
            ],

            odabran_cenovnik:{
                id:null,
                cenaPoDanu:null,
                nazivCenovnika:'',
                popustZaPreko30Dana:null,
                cenaCollisionDamageWaiver:null,
                cenaPoKilometru:null
            },

            // prikaz datuma koji su zuzeti
			disabledDates: {
				to: null,
				from: null,
				ranges: [],
			},

            //za odabir datuma 
			dates: {
				from: new Date,
				to: null,
				includeDisabled: true
            },
            
            //poruke za error ili success odgovore.
			messages: {
				errorDates: '',
				errorMessage: '',
				errorResponse: '',
				successResponse: '',
			},
			error: false,
        }
    },
    methods:{
        makeReservation(id){
            // console.log('SLANJE ZAHTEVA ZA REGISTRACIJU NA SERVER');
            // KlijentDataService.vehReservation(id).then(response =>{

            // }).catch(error =>{

            // });
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
            this.rezervacijaOglasDTO.ukupnaCena = this.odabran_br_dana * this.odabran_cenovnik.cenaPoDanu;
            if(this.odabran_br_dana > 20){
                this.rezervacijaOglasDTO.ukupnaCena = this.rezervacijaOglasDTO.ukupnaCena * (this.odabran_cenovnik.popustZaPreko30Dana/100);
            }
			// this.dates.to = new Date(this.dates.from.getTime() + this.reservation.night * 1000 * 60 * 60 * 24);
			// this.error = false;
        },

        addChoosenPrice:function(){
            for(let i = 0; i < this.cenovnici.length; i++){
                console.log(this.cenovnici[i].nazivCenovnika);
                if(this.odabran_cenovnik.nazivCenovnika === this.cenovnici[i].nazivCenovnika){
                    this.odabran_cenovnik.id = this.cenovnici[i].id;
                    this.odabran_cenovnik.cenaPoDanu = this.cenovnici[i].cenaPoDanu;
                    this.odabran_cenovnik.popustZaPreko30Dana = this.cenovnici[i].popustZaPreko30Dana;
                    this.odabran_cenovnik.cenaCollisionDamageWaiver = this.cenovnici[i].cenaCollisionDamageWaiver;
                    this.odabran_cenovnik.cenaPoKilometru = this.cenovnici[i].cenaPoKilometru;
                    this.calculatePriceAndDate();
                }
            }
        },

		insertReservData: function () {
			// dodaje se u rezervaciju id automobila za koji se pravi rezervacija
			this.rezervacijaOglasDTO.automobilId = this.automobilId;

			// dodaje se u rezervaciju id agenta koji pravi rezervaciju
			this.rezervacija.user = this.user.username;

			// dodaje se u rezervaciju inicijalni broj dana koji je uvek bar 1
			this.odabran_br_dana = 1;

			// dodaje se u rezervaciju cene rezervacije spram cene_po_danu * broj_dana kao i krajnji datum(odDatuma + br_dana);
			this.calculatePriceAndDate();
		},
    },
 	components: {
		// vuejsDatepicker
	},
	computed: {
		id() {
			return this.$route.params.id; //preuzimam id automobila za koji zelim da napravim rezervaciju.
		},
	},
	created() {
		// if (!localStorage.getItem('jwt'))
		// 	this.$router.push('/login');

		// this.user.username = localStorage.getItem('user');
		// this.user.role = localStorage.getItem('role');
		// if (this.user.role == "ADMIN") {
		// 	this.isAdmin = true;
		// } else if (this.user.role == "HOST") {
		// 	this.isHost = true;
		// } else {
		// 	this.isGuest = true;
		// 	//preuzima se id apartmana iz url-a
		// 	this.apartmentId = this.id;
		// }

	},
	mounted() {
		//dodaje se opseg dana za izbor trajanja iznajmljivanja
		this.br_dana = this.range(1, 28);

		// axios
		// 	.get('rest/apartment/' + this.$route.params.id)
		// 	.then(Response => (this.setApartment(Response.data)));
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
    color:crimson;
    margin-top:10px;
    border-bottom: 1px solid lightgrey;
} 

#showPriceTable thead{
    border-bottom: 1px solid lightgrey;
}

#showPriceTable thead th{
    padding-right:15px;
}

/* #cenovnik #odabirCene{
    float:left;
    width:25%;
}

#cenovnik #table{
    float:right;
    margin-top:35px;
    width:70%;
} */

</style>