<template>
    <div id="report-new">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Unesi <span id='titleEffect'>Izvestaj</span></h1>
            <h4 style="margin-top:10px;color:#35424a;">(Lista narudzbenica u <span id='titleEffect'>Rezervaciji</span>)</h4>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
            
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
                <tr v-bind:key="narudzbenica.id" v-for='narudzbenica in rezervacija.narudzbenice'>
                    <td>{{narudzbenica.oglas.automobil.markaAut}} {{narudzbenica.oglas.automobil.modelAut}} ({{narudzbenica.oglas.automobil.klasaAut}})</td>
                    <td>{{narudzbenica.oglas.planiranaKm}} km</td>
                    <td>{{narudzbenica.oglas.cenovnik.nazivCenovnika}}</td>
                    <td>{{narudzbenica.oglas.cenovnik.cenaPoDanu}} din</td>
                    <td>{{narudzbenica.oglas.cenovnik.cenaPoKilometru}} din</td>
                    <td>
                        <a href="#new-report" v-if='narudzbenica.izvestajId ==null '><button :disabled='btnEnabled' v-on:click='showCreateReport(narudzbenica.oglas, narudzbenica.id)' class="btn-outline-primary"> izvestaj </button></a>
                        <p v-if='narudzbenica.izvestajId !=null ' style="color:crimson;"> ! Postoji izveštaj</p>
                    </td>
                </tr>
                </tbody>
            </table>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
             <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='showNewReport' id='new-report'>
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Izveštaj</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="card-header">
                    <h4><b>Za automobil:</b> {{newReportPom.automobilReport.markaAut}} {{newReportPom.automobilReport.modelAut}} - {{newReportPom.automobilReport.klasaAut}} (marka/model/klasa)</h4>
                </div>
                <div style="margin-top:20px" v-if='messages.errorKm' class="alert alert-danger"
				v-html="messages.errorKm"></div>
                <label>Pređena kilometraža:</label>
                <input class='half-size' type="text" placeholder="Unesite predjenu kilometrazu..." v-model='izvestaj.predjenaKilometraza' v-on:input='calculateKilometeres()'>
                
                <label v-if='showDodatniTrosk'>Dodatni troskovi:</label>
                <table id='dodatni-troskovi' class='showPriceTable'>
                    <thead>
                        <tr>
                            <th>Planirana kilometraža</th>
                            <th>Prekoračena kilometraža</th>
                            <th>Cena po kilometru</th>
                            <th>Dodatni troškovi</th>
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
                    <h5>Račun u iznosu od {{newReportPom.dodatniTroskovi}} dinara će biti poslat korisniku na naplatu.</h5>
                </div>
                
                <label>Dodatne informacije:</label>
                <div v-if='messages.errorText' class="alert alert-danger" v-html="messages.errorText"></div>
                <textarea v-model='izvestaj.tekstIzvestaja' placeholder="Unesi info..."></textarea>
                <br>
               
                <button :disabled='btnEnabled' class="btn btn-lg btn-success shadow" v-on:click='addReport()'> Potvrdi </button>
                <button :disabled='btnEnabled' class="btn btn-lg btn-danger shadow" v-on:click='cancelNewReport()'> Odustani </button>
            </div>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
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

            //OVO SE SALJE NA BEK...
            izvestaj:{
                automobilId:null,
                rezervacijaId:null, 
                narudzbenicaId:null,
                predjenaKilometraza:0,
                prekoracenaKilometraza:0,
                dodatniTroskovi:0,
                tekstIzvestaja:'',
            },
            permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
            },
            btnEnabled:false,
            rezervacija:{
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
        getAllNarudzbenice:function(){
            console.log("Get all narudzbenice!")
            UserDataService.getRezervacijaDetails(this.id).then(response => {
                this.rezervacija = response.data;
                console.log(JSON.stringify(this.rezervacija.oglas));
            });
        },
        getAllPermissions:function(){
            UserDataService.getAllPermissions().then(response => {
                this.permissions = response.data;
                if(this.permissions.status != "aktivan"){
                    this.btnEnabled = true
                }
                console.log(JSON.stringify(this.permissions));
            });
        },
        showCreateReport(oglas, narudzbenicaId){
            //ako je vec otvoren prozor za kreiranje novog izvestaja samo neka se doda drugi id
            if(this.showNewReport === true){
                this.izvestaj.narudzbenicaId = narudzbenicaId,
                this.izvestaj.automobilId = oglas.automobil.id;
                this.izvestaj.predjenaKilometraza = 0;
                this.izvestaj.tekstIzvestaja = '';
                this.newReportPom.planiranaKilometraza = oglas.planiranaKm;
                this.newReportPom.cenaPoKilometru = oglas.cenovnik.cenaPoKilometru;
            }
            //ako je zatvoren prozor klikom na dugme se prvo otvara prozor za kreiranje pa se dodaje i id auta.
            else{
                this.showNewReport = !this.showNewReport;
                this.izvestaj.narudzbenicaId = narudzbenicaId,
                this.izvestaj.automobilId = oglas.automobil.id;
                this.izvestaj.predjenaKilometraza = 0;
                this.izvestaj.tekstIzvestaja = '';
                this.newReportPom.planiranaKilometraza = oglas.planiranaKm;
                this.newReportPom.cenaPoKilometru = oglas.cenovnik.cenaPoKilometru;
            }

            this.newReportPom.automobilReport = oglas.automobil;
        },
        cancelNewReport(){
            this.showNewReport = !this.showNewReport;
            this.izvestaj.automobilId = null;
            this.izvestaj.predjenaKilometraza = 0;

            this.newReportPom.automobilReport = null;
            this.newReportPom.cenaPoKilometru= null;
            this.newReportPom.planiranaKilometraza= null;
            this.newReportPom.prekoracenaKilometraza= 0;
            this.newReportPom.cenaPoKilometru= 0; 
            this.newReportPom.dodatniTroskovi= 0;
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
            else {
                this.izvestaj.rezervacijaId = this.id;
                this.izvestaj.prekoracenaKilometraza = this.newReportPom.prekoracenaKilometraza;
                this.izvestaj.dodatniTroskovi = this.newReportPom.dodatniTroskovi;
                console.log(JSON.stringify(this.izvestaj));
               UserDataService.addIzvestaj(this.izvestaj)
                    .then(response => {
                        this.messages.successResponse = `<h4>Vaš izveštaj je uspešno poslat!</h4>`;
                        this.showNewReport = false;
                        setTimeout(() => this.messages.successResponse = '', 5000);

                    })
                    .catch(error => {
                         if(error.response.data === 'Već postoji napravljen izveštaj za dati automobil!') {
                            this.messages.errorResponse = `<h4>Već postoji napravljen izveštaj za dati automobil!</h4>`;
                            this.showNewReport = false;
                            setTimeout(() => this.messages.errorResponse = '', 5000);
                        }
                        else if(error.response.status === 500 || error.response.status === 404) {
                            this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokušajte ponovo kasnije!</h4>`;
                            setTimeout(() => this.messages.errorResponse = '', 5000);
                        }
                       
                    });
            }
        },

        isNumeric(num) {
			//isNaN(num) returns true if the variable does NOT contain a valid number
			return isNaN(num);
		}
    },
    computed: {
        id() {
            return this.$route.params.id; //preuzimam id rezervacije kako bih izvukao narudzbenice vezane za nju
        }
    },
    created() {
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.getAllPermissions();
            this.getAllNarudzbenice();
        }
    },
    
}
</script>

<style scoped>
#titleEffect{
    color:#FF8C00;
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