<template>
    <div id="reservation-details">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Detalji <span id='titleEffect'>Rezervacije</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
           <div id='reservInfo'>
                <div class="card-header">
                    <h4><b>Rezervacija obuhvata:</b></h4>
                </div>
                <div class="car-info">
                    <h4  style='margin-top:5px;'><b>Termin rezervacije:</b> {{narudzbenica.odDatuma}} - {{narudzbenica.doDatuma}}</h4>
                    <h5><b>Trajanje rezervacije:</b> {{dodatneInfo.odabran_br_dana}} dana</h5>
                    
                    <h4><b>Automobil:</b> {{oglas.automobil.markaAut}} {{oglas.automobil.modelAut}} (marka/model)</h4>
                    <h5><b>Klasa automobila:</b> {{oglas.automobil.klasaAut}}</h5>
                    <h5><b>Vrsta goriva:</b> {{oglas.automobil.vrstaGoriva}}</h5>
                    <h5><b>Tip menjaca:</b> {{oglas.automobil.tipMenjaca}}</h5>
                </div>
                <div id='cenovnik' class="car-info">
                    <h4><b>Cenovnik:</b> </h4>
                    <table id='showPriceTable'>
                        <thead>
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
                                <td>{{oglas.cenovnik.nazivCenovnika}}</td>
                                <td>{{oglas.cenovnik.cenaPoDanu}} din</td>
                                <td>{{oglas.cenovnik.cenaPoKilometru}} din</td>
                                <td>{{oglas.cenovnik.cenaCollisionDamageWaiver}} din</td>
                                <td>{{oglas.cenovnik.popustZaPreko30Dana}} %</td>
                            </tr>     
                        </tbody>            
                    </table>
                </div>
                <div class="cart-total">
                    <h5><b>Vrednost popusta:</b> {{dodatneInfo.popust}} dinara</h5>
                    <h5><b>Ukupna cena:</b> {{dodatneInfo.ukupnaCena}} dinara</h5>
                </div>        
            </div>
        </div>
    </div>
</template>


<script>
export default {
    data(){
        return{
            user: {
                username: '',
                role: ''
            },
            korpa:[], //nalaze se narudzbenice preuzete iz localStorage
            /*
            korpa:[
                {
                agentId:null,
                userId:null,
                oglasId:null,
                odDatuma:null,
                doDatuma:null,
                },
                {
                agentId:null,
                userId:null,
                oglasId:null,
                odDatuma:null,
                doDatuma:null,
                },
            ]
            */
           narudzbenica:{
               odDatuma:null,
               doDatuma:null,
           },
            dodatneInfo:{
                odDatuma:null,          //preuzeto iz narudzbenice
                doDatuma:null,          //preuzeto iz narudzbenice
                odabran_br_dana: null,  //Za racunanje ukupne cene...
                popust:0,               //Za prikaz i smestanje vrednosti popusta...
                ukupnaCena:0,           //izracunata na osnovu broja dana, cene po danu i popusta...
            },

            oglas:{
                //oglas
                id:1,
                odDatuma:'25.5.2020',
                doDatuma:'25.6.2020',
                TAdresa:{
                    mesto:'Novi Sad',
                    ulica:'9. Marta',
                    broj:'bb',
                    postanskiBroj:'21000',
                    longitude:'45',
                    latitude:'54',
                },
                planiranaKilometraza:2000,
                username:'This host', //U DTO-u za korisnika koji je kreirao oglas.
                agentId:1,
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
        }
    },
    methods:{
        extractDate:function(korpa, oglasId){
            console.log('ExtractDate: ');
            console.log('OglasId: ' + oglasId);
            for(let i = 0; i< korpa.length; i ++){
                if(korpa[i].oglasId == oglasId){
                    console.log(`Pronasao poklapanje za ${korpa[i].oglasId} i ${oglasId}`);
                    this.dodatneInfo.odDatuma = korpa[i].odDatuma;
                    this.dodatneInfo.doDatuma = korpa[i].doDatuma;
                    console.log('odDatuma: ' + this.dodatneInfo.odDatuma);
                    console.log('doDatuma: ' + this.dodatneInfo.doDatuma);
                }
            }
        },

        //Pomocna metoda za racunanje broja dana na osnovu pocetnog i krajnjeg datuma u narudzbenici...
        calculateNoOfDays(odDatuma,doDatuma){
            //Konvertovanje datuma u broj dana... 
            const odDat = new Date(odDatuma);       //konvertujemo input tip u Date
            const doDat = new Date(doDatuma);       //konvertujemo input tip u Date

            const NoOfDays = doDat - odDat;         //Dobijeni rezultat je u milisekundama
            const noOFMill = 1000 * 60 * 60 * 24;   //broj milisekundi sa kojima delimo NoOfDays da se dobije broj dana.
            
            this.narudzbenica.odDatuma = odDat.toLocaleDateString();
            this.narudzbenica.doDatuma = doDat.toLocaleDateString(); 
            return NoOfDays/noOFMill;
        },

        //Metoda za automatsko racunanje cene rezervacija spram cene apartmana * broj nocenja
		calculatePrice: function () {
            this.dodatneInfo.ukupnaCena = this.dodatneInfo.odabran_br_dana * this.oglas.cenovnik.cenaPoDanu;
            if(this.dodatneInfo.odabran_br_dana > 30){
               
                if(this.oglas.cenovnik.popustZaPreko30Dana != null){
                    this.dodatneInfo.popust =  this.dodatneInfo.ukupnaCena * (this.oglas.cenovnik.popustZaPreko30Dana/100);
                }
                //Ukoliko korisnik odabere neki cenovnik koji ima popust, a zatim odabere cenovnik koji nema popust
                //ostaje upamcen popust prethodnog cenovnika... Zato se resetuje na 0;
                if(this.oglas.cenovnik.popustZaPreko30Dana === null && this.dodatneInfo.popust !== 0){
                    this.dodatneInfo.popust = 0;
                }

                this.dodatneInfo.ukupnaCena = this.dodatneInfo.ukupnaCena -  this.dodatneInfo.popust;
                
            }
        }
    },
    components: {
	},
	computed: {
		id() {
			return this.$route.params.id; //preuzimam id oglasa za ciju rezervaciju zelim da vidim podatke.
		},
	},
	created() {
        // Ako je prazan token znaci da user nije ulogovan pa se preusmerava na login stranicu.
		// if (!localStorage.getItem('jwt'))
		// 	this.$router.push('/login');

	},
	mounted() {
        // getuje se oglas za prosledjeni id.
		// axios
		// 	.get('rest/apartment/' + this.id)
        // 	.then(Response => (this.odabraniOglas = this.Response.data));
        this.korpa = JSON.parse(localStorage.getItem('cart'));
        console.log('lenght:', this.korpa.length);
        this.extractDate(this.korpa, this.id);
        this.dodatneInfo.odabran_br_dana = this.calculateNoOfDays(this.dodatneInfo.odDatuma, this.dodatneInfo.doDatuma);
        this.calculatePrice();
        alert(`Dodatne info:
           odDatuma: ${this.dodatneInfo.odDatuma}
           doDatuma: ${this.dodatneInfo.doDatuma}
           br_dana: ${this.dodatneInfo.odabran_br_dana}
           popust: ${this.dodatneInfo.popust}
           ukCena ${this.dodatneInfo.ukupnaCena}
        `);

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

/* Za cenu */
#showPriceTable{
    width: 100%;
    color:#35424a;
    margin-top:10px;
    font-size: 20px;
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

.car-info h4{
    padding:10px;
    margin-bottom:15px;
    margin-top:35px;
    background-color:gold;
    color:#fff;
    font-weight: bold;
    border-bottom:2px solid #35424a;;
}

.car-info b{
    color: #35424a;
}

.cart-total{
  padding:10px;
  margin-bottom:15px;
  margin-top:35px;
  background-color:#35424a;
  color:#fff;
  font-size: 16px;
  font-weight: bold;
  border-bottom:2px solid gold;
}

</style>