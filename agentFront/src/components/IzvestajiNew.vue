<template>
    <div id="report-new">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Unesi <span id='titleEffect'>Izvestaj</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
            <!-- <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div> -->

            <table class="table">
                <thead>
                    <tr>
                        <th>Automobil</th>
                        <th>Planirana km</th>
                        <th>Cenovnik</th>
                        <th>Cena po danu</th>
                        <th>Cena po km</th>
                        <th>Napisi izvestaj</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="oglas.id" v-for='oglas in rezervacija.oglasi'>
                    <td>{{oglas.automobil.markaAut}} {{oglas.automobil.modelAut}} ({{oglas.automobil.klasaAut}})</td>
                    <td>{{oglas.planiranaKilometraza}} km</td>
                    <td>{{oglas.cenovnik.nazivCenovnika}}</td>
                    <td>{{oglas.cenovnik.cenaPoDanu}} din</td>
                    <td>{{oglas.cenovnik.cenaPoKilometru}} din</td>
                    <td>
                        <a href="#new-report"><button v-on:click='showCreateReport(oglas)' class="btn-outline-primary"> izvestaj </button></a>
                    </td>
                </tr>
                </tbody>
            </table>

            <div v-if='showNewReport' id='new-report'>
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Izvestaj</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="card-header">
                    <h4><b>Za automobil:</b> {{newReportPom.automobilReport.markaAut}} {{newReportPom.automobilReport.modelAut}} - {{newReportPom.automobilReport.klasaAut}} (marka/model/klasa)</h4>
                </div>
                <div style="margin-top:20px" v-if='messages.errorKm' class="alert alert-danger"
				v-html="messages.errorKm"></div>
                <label>Predjena kilometraza:</label>
                <input class='half-size' type="text" placeholder="Unesite predjenu kilometrazu..." v-model='izvestaj.predjenaKilometraza' v-on:input='calculateKilometeres()'>
                
                <label v-if='showDodatniTrosk'>Dodatni troskovi:</label>
                <table id='dodatni-troskovi' class='showPriceTable'>
                    <thead>
                        <tr>
                            <th>Planirana kilometraza</th>
                            <th>Prekoracena kilometraza</th>
                            <th>Cena po kilometru</th>
                            <th>Dodatni troskovi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>{{newReportPom.planiranaKilometraza}} km</td>
                            <td>{{newReportPom.prekoracenaKilometraza}} km</td>
                            <td>{{newReportPom.cenaPoKilometru}} din</td>
                            <td>{{newReportPom.dodatniTroskovi}} din</td>   
                        </tr>     
                    </tbody>            
                </table>

                <div id='bill-warning' class="alert alert-danger">
                    <h5>Racun u iznosu od {{newReportPom.dodatniTroskovi}} dinara ce biti poslat korisniku na naplatu.</h5>
                </div>
                
                <label>Dodatne informacije:</label> 
                <div v-if='messages.errorText' class="alert alert-danger" v-html="messages.errorText"></div>
                <textarea v-model='izvestaj.tekstIzvestaja' placeholder="Unesi info..."></textarea>
                <br>

                <button class="btn btn-lg btn-success shadow" v-on:click='addReport()'> Potvrdi </button>
                <button class="btn btn-lg btn-danger shadow" v-on:click='cancelNewReport()'> Odustani </button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'ReportNew',
    data:function(){
        return {
            showNewReport:false,
            showDodatniTrosk:false,
            //pomocni objekat za smestanje podataka koji ce se prikazati kada se 
            //odabere kreiranje novog izvestaja...
            newReportPom:{
                automobilReport:null,
                cenaPoKilometru:null,
                planiranaKilometraza:null,
                prekoracenaKilometraza:0,
                cenaPoKilometru:0, //mora se proveriti da li se uopste moze uneti prekoracenje tj da li postoji cena po km...
                dodatniTroskovi:0,
            },

            izvestaj:{
                automobilId:null,
                predjenaKilometraza:0,
                tekstIzvestaja:'',
            },

            rezervacija: {
                id:1,
                odDatuma:'18.6.2020',
                doDatuma:'25.7.2020',
                ukupnaCena:6500,
                statusRezervacije:'RESERVED',
                username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                bundle:true,
                //Oglase vratiti kao array jer ih moze biti vise u bundleu
                //iz svakog oglasa koji je vezan za rezervaciju izvlacimo automobil
                //getAllAdsByReservId();
                oglasi:[
                    {
                        //Oglas
                        id:1,
                        odDatuma:'25.5.2020',
                        doDatuma:'25.6.2020',
                        lokacija:'9. Marta bb Novi Sad',
                        TAdresa:{
                            mesto:'',
                            ulica:'',
                            broj:'',
                            postanskiBroj:'',
                            longitude:'',
                            latitude:'',
                        },
                        planiranaKilometraza:2000,
                        //Oglas/Automobil
                        automobil:{
                            id:1,
                            markaAut:'Audi',
                            modelAut:'A6',
                            klasaAut:'Gradski',
                            vrstaGoriva:'dizel',
                            tipMenjaca:'manuelni',
                            ukupnaOcena:5,
                            brojSedistaZaDecu:1,
                            predjenaKilometraza:5000,
                            collisionDamageWaiver:true,
                            images:[],
                        },
                        //Oglas/Cenovnik
                        cenovnik:{ 
                            id:'1',
                            cenaPoDanu:100,
                            nazivCenovnika:'Cenovnik 1',
                            popustZaPreko30Dana:'10%',
                            cenaCollisionDamageWaiver:1000,
                            cenaPoKilometru:10
                        },
                    },
                    {
                        //Oglas
                        id:2,
                        odDatuma:'18.6.2020',
                        doDatuma:'25.7.2020',
                        lokacija:'Ne znanog i znanog junaka bb Beograd',
                        TAdresa:{
                            mesto:'',
                            ulica:'',
                            broj:'',
                            postanskiBroj:'',
                            longitude:'',
                            latitude:'',
                        },
                        planiranaKilometraza:2500,
                    
                        //Oglas/Automobil
                        automobil:                
                        {
                            id:2,
                            markaAut:'BMW',
                            modelAut:'R5',
                            klasaAut:'Gradski',
                            vrstaGoriva:'dizel',
                            tipMenjaca:'manuelni',
                            ukupnaOcena:3,
                            brojSedistaZaDecu:2,
                            predjenaKilometraza:800,
                            collisionDamageWaiver:true,
                            images:[],
                        },
                        //Oglas/Cenovnik
                        cenovnik:{ 
                            id:'2',
                            cenaPoDanu:200,
                            nazivCenovnika:'Cenovnik 2',
                            popustZaPreko30Dana:'20%',
                            cenaCollisionDamageWaiver:null,
                            cenaPoKilometru:20
                        },
                    },

                ],
                //getujemo poruke preko id rezervacije getAllMessagesByReservId();
                poruke:[
                    //Za prvi automobil u bundleu
                    {
                        id:1,
                        tekstPoruke:'Da li imate automobil u crvenoj boji? Asdasd dasdsad dsad dsa da das . Asdasd dasdsad dsad dsa da das .',
                        rezervacijaId:1,
                        automobilId:1, //Kako ako ih je vise u rezerv. tj. ako je rezerv bundle?
                        commonData:{
                            userId:1,
                            datumKreiranja:'16.6.2020',
                        }
                    },
                    {
                        id:2,
                        tekstPoruke:'Nazalost nemamo.',
                        rezervacijaId:1,
                        automobilId:1,
                        commonData:{
                            userId:2,
                            datumKreiranja:'16.6.2020',
                        }
                    },
                    {
                        id:3,
                        tekstPoruke:'Nista... Hvala na brzom odgovoru!',
                        rezervacijaId:1,
                        automobilId:1,
                        commonData:{
                            userId:1,
                            datumKreiranja:'17.6.2020',
                        }
                    },
                    {
                        id:4,
                        tekstPoruke:'Nema na cemu!',
                        rezervacijaId:1,
                        automobilId:1,
                        commonData:{
                            userId:2,
                            datumKreiranja:'17.6.2020',
                        }
                    },
                    //Za drugi automobil u bundleu
                    {
                        id:5,
                        tekstPoruke:'A da li ovaj dolazi u plavoj boji?! Hvala unapred!',
                        rezervacijaId:1,
                        automobilId:2,
                        commonData:{
                            userId:1,
                            datumKreiranja:'17.6.2020',
                        }
                    },
                    {
                        id:6,
                        tekstPoruke:'Dolazi, nema na cemu!',
                        rezervacijaId:1,
                        automobilId:2,
                        commonData:{
                            userId:2,
                            datumKreiranja:'17.6.2020',
                        }
                    }
                ]
            },
            messages: {
                errorKm: '',
                errorText: '',
                errorResponse: '',
                successResponse: '',
            }
        }
    },
    methods:{
        showCreateReport(oglas){
            //ako je vec otvoren prozor za kreiranje novog izvestaja samo neka se doda drugi id
            if(this.showNewReport === true){
                this.izvestaj.automobilId = oglas.automobil.id;
                this.newReportPom.planiranaKilometraza = oglas.planiranaKilometraza;
                this.newReportPom.cenaPoKilometru = oglas.cenovnik.cenaPoKilometru;
                console.log('this.izvestaj.automobilId:' + this.izvestaj.automobilId);
                console.log('this.izvestaj.planiranaKilometraza:' + this.izvestaj.planiranaKilometraza);
                console.log('this.newReportPom.cenaPoKilometru:' + this.newReportPom.cenaPoKilometru);
            }
            //ako je zatvoren prozor klikom na dugme se prvo otvara prozor za kreiranje pa se dodaje i id auta.
            else{
                this.showNewReport = !this.showNewReport;
                this.izvestaj.automobilId = oglas.automobil.id;
                this.newReportPom.planiranaKilometraza = oglas.planiranaKilometraza;
                this.newReportPom.cenaPoKilometru = oglas.cenovnik.cenaPoKilometru;
                console.log('this.izvestaj.automobilId:' + this.izvestaj.automobilId);
                console.log('this.newReportPom.planiranaKilometraza:' + this.newReportPom.planiranaKilometraza);
                console.log('this.newReportPom.cenaPoKilometru:' + this.newReportPom.cenaPoKilometru);
            }

            this.newReportPom.automobilReport = oglas.automobil;
        },
        cancelNewReport(){
            this.showNewReport = !this.showNewReport;
            this.izvestaj.automobilId = null;
            this.izvestaj.predjenaKilometraza = 0;

            this.newReportPom.automobilReport = null;
            this.newReportPom.cenaPoKilometru=null;
            this.newReportPom.planiranaKilometraza=null;
            this.newReportPom.prekoracenaKilometraza=0;
            this.newReportPom.cenaPoKilometru=0; //mora se proveriti da li se uopste moze uneti prekoracenje tj da li postoji cena po km...
            this.newReportPom.dodatniTroskovi=0;
        },
        calculateKilometeres:function(){
            this.showDodatniTrosk = true;
            
            this.newReportPom.prekoracenaKilometraza = this.izvestaj.predjenaKilometraza - this.newReportPom.planiranaKilometraza; 
            //ukoliko je predjena km veca od planirane km racuna se cena koja mora da se plati...
            if(this.newReportPom.prekoracenaKilometraza > 0){
                this.newReportPom.dodatniTroskovi = this.newReportPom.cenaPoKilometru * this.newReportPom.prekoracenaKilometraza;   
            }
            else{
                //ako nije predjena planirana km prekoracena km se stavlja na 0 i mnozi sa cenom kako bi troskovi bili = 0;
                this.newReportPom.prekoracenaKilometraza = 0;
                this.newReportPom.dodatniTroskovi = this.newReportPom.cenaPoKilometru * this.newReportPom.prekoracenaKilometraza;   
            }
            
        },

        addReport: function () {
            if (this.isNumeric(this.izvestaj.predjenaKilometraza)) {
				this.messages.errorKm = `<h4>Broj predjenih kilometara mora biti broj!</h4>`;
				setTimeout(() => this.messages.errorKm = '', 3000);
			}

			else if (this.izvestaj.predjenaKilometraza == 0 || this.izvestaj.predjenaKilometraza == '') {
				this.messages.errorKm = `<h4>Morate uneti broj predjenih kilometara!</h4>`;
				setTimeout(() => this.messages.errorKm = '', 3000);
            }
            
            // else if (this.izvestaj.tekstIzvestaja == '') {
			// 	this.messages.errorText = `<h4>Polje broj predjenih kilometara ne sme biti prazno!</h4>`;
			// 	setTimeout(() => this.messages.errorText = '', 3000);
			// }
            else {
                alert(`Izvestaj:
                automobilId: ${this.izvestaj.automobilId},
                predjenaKm: ${this.izvestaj.predjenaKilometraza},
                tekstIzv: ${this.izvestaj.tekstIzvestaja},
                
                `);
                // axios
                //     .post('rest/reviews/', this.review)
                //     .then(response => {
                //         this.messages.successResponse = `<h4>Your review was sent successfully! Thank you for your feedback!</h4>`;
                //         this.review.text = '';
                //         this.review.star = null;
                //         setTimeout(() => this.messages.successResponse = '', 5000);

                //     })
                //     .catch(error => {
                //         if (error.response.status === 500 || error.response.status === 404) {
                //             this.messages.errorResponse = `<h4>We had some server errors, please try again later!</h4>`;
                //             setTimeout(() => this.messages.errorResponse = '', 5000);
                //         }
                //     });
            }
        },

        isNumeric(num) {
			//isNaN(num) returns true if the variable does NOT contain a valid number
			return isNaN(num);
		}
    },

    computed: {
        id() {
            return this.$route.params.id; //preuzimam id automobila za koga dodajem novi komentara
        }
    },
    created() {
        
    },
    
}
</script>

<style scoped>
#titleEffect{
    color:gold;
    font-weight: bold;
}
#report-new label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

#report-new textarea{
    display: block;
    width: 100%;
    height: 200px;
    padding:8px;
}

#report-new  .half-size{
  width:49%;
  padding:10px;
  margin-bottom:25px
}

/* Za cenu */
.showPriceTable{
    color:#35424a;
    margin-top:10px;
    border-bottom: 1px solid lightgrey;
} 

.showPriceTable thead{
    border-bottom: 1px solid lightgrey;
}

.showPriceTable thead th{
    padding-right:15px;
}

#bill-warning{
    color:white;
    background-color: #35424a;
}

#bill-ok{
    color:white;
    background-color: #35424a;
}

#dodatni-troskovi{
    margin-bottom:25px;
}
#dodatni-troskovi tbody{
    font-size: 20px;
}
</style>