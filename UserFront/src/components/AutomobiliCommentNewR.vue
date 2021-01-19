<template>
    <div id="report-new">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Unesi <span id='titleEffect'>Komentar</span></h1>
            <h4 style="margin-top:10px;color:#35424a;">(Lista narudzbenica u <span id='titleEffect'>Rezervaciji</span>)</h4>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
            <h1><small v-if='disableComment()' style='color:crimson;'>! Ostavljanje komentara i ocena je zabranjeno </small></h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Automobil</th>
                        <th>Planirana km</th>
                        <th>Cenovnik</th>
                        <th>Cena po danu</th>
                        <th>Cena po km</th>
                        <th>Napiši komentar</th>
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
                        <a href="#new-report" ><button v-on:click='showCreateReport(narudzbenica.oglas)' class="btn-outline-primary" :disabled='disableComment()'> komentar </button></a>
                    </td>
                </tr>
                </tbody>
            </table>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='showNewReport' id="car-new-comment">
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Komentar</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                
                <label>Komentar:</label> 
                <div v-if='messages.errorText' class="alert alert-danger" v-html="messages.errorText"></div>
                <textarea v-model='review.text' placeholder="Enter comment..."></textarea>
                <br>
                <!-- <label>Rating: </label> -->
                <label>Ocena:</label> 
                <div v-if='messages.errorStar' class="alert alert-danger" v-html="messages.errorStar"></div>
                <star-rating
                    inactive-color="#35424a"
                    active-color="gold"
                    glow:2
                    glow-color="#e8491d"
                    v-model="review.star"></star-rating>
                <br>
            
                <button class="btn btn-lg btn-success shadow" v-on:click='addComment'> Potvrdi </button>
                <button class="btn btn-lg btn-danger shadow" v-on:click='cancelNewReport()'> Odustani </button>
            </div>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
import StarRating from "vue-star-rating";
export default {
    name: 'ReportNew',
    data:function(){
        return {
            showNewReport:false,
            
            review: {
                usertId: '',
                carId: '',
                text: '',
                star: null,
                visible: false,
                username:'',
                reservationId:''
            },

            rezervacija:{
            },

            ocena:{
                vrednostOcene:null,
                automobilId:null,
                rezervacijaId:null,
                username:null,
                // protected LocalDateTime datumIzmene, datumKreiranja;
            },

            komentar:{
                tekstKomentara:null,
                autor:null,
                odobren:null,
                automobilId:null,
                rezervacijaId:null,
            },

            messages: {
                errorText: '',
                errorStar: '',
                errorResponse: '',
                successResponse: '',
            },

            permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
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
                //OBRISATIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                // this.permissions.allowedToCommend = false;
                console.log(JSON.stringify(this.permissions));
            });
        },

        addComment: function () {
            if (this.review.text == '' && this.review.star != null) {
                this.messages.errorText = `<h4>Text of comment can't be empty!</h4>`;
                setTimeout(() => this.messages.errorText = '', 3000);
            }
            else if (this.review.text != '' && this.review.star == null) {
                this.messages.errorStar = `<h4>Rating can't be empty!</h4>`;
                setTimeout(() => this.messages.errorStar = '', 3000);
            }
            else if (this.review.text == '' && this.review.star == null) {
                this.messages.errorText = `<h4>Text of comment can't be empty!</h4>`;
                this.messages.errorStar = `<h4>Rating can't be empty!</h4>`;
                setTimeout(() => this.messages.errorText = '', 3000);
                setTimeout(() => this.messages.errorStar = '', 3000);
            }
            else {
                console.log('Review: ' + JSON.stringify(this.review));

                this.ocena.vrednostOcene = this.review.star,
                this.ocena.automobilId = this.review.carId,
                this.ocena.rezervacijaId =  this.review.reservationId,
                this.ocena.username = this.review.username,

                console.log('Ocena: ' + JSON.stringify(this.ocena));
                
                this.komentar.autor = this.review.username,
                this.komentar.odobren = this.review.visible,
                this.komentar.automobilId = this.review.carId,
                this.komentar.rezervacijaId =  this.review.reservationId
                this.komentar.tekstKomentara = this.review.text,
                
                console.log('Komentar: ' + JSON.stringify(this.komentar));
                
                UserDataService.addKomentar(this.komentar).then(response =>  {
                }).catch(error => {
                    if(error.response.data === 'Vec postoji oglas!'){
                    this.messages.errorResponse= `<h4>Ups! Izgleda da ste već ostavili komentar i ocenu za automobil iz ove rezervacije!</h4>`;
                        setTimeout(() => this.messages.errorResponse='', 5000);
                        showNewReport = !showNewReport;
                    }
                    if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>We had some server errors, please try again later!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });

                UserDataService.addOcena(this.ocena).then(response => { 
                    this.messages.successResponse = `<h4>Vaša ocena i komentar su uspešno poslati!</h4>`;
                    this.review.text = '';
                    this.review.star = null;
                    setTimeout(() => this.messages.successResponse = '', 5000);
                    
                }).catch(error => {
                    if(error.response.data == 'Vec postoji ocena!'){
                        this.messages.errorResponse= `<h4>Ups! Izgleda da ste već ostavili komentar i ocenu za automobil iz ove rezervacije!</h4>`;
                        setTimeout(() => this.messages.errorResponse='', 5000);
                        
                    }
                    else if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>We had some server errors, please try again later!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
        },

        showCreateReport(oglas){
            //ako je vec otvoren prozor za kreiranje novog izvestaja samo neka se doda drugi id
            if(this.showNewReport === true){
                this.review.carId =  oglas.automobil.id,
                this.review.text =  '',
                this.review.star =  null,
                this.review.visible =  false
                //U created
                // this.review.usertId =  '',
                // this.review.username = '',
                // this.review.reservationId = this.id;
            }
            //ako je zatvoren prozor klikom na dugme se prvo otvara prozor za kreiranje pa se dodaje i id auta.
            else{
                this.showNewReport = !this.showNewReport;
                this.review.carId =  oglas.automobil.id,
                this.review.text =  '',
                this.review.star =  null,
                this.review.visible =  false
                //U created
                // this.review.usertId =  '',
                // this.review.username = '',
                // this.review.reservationId = this.id;
            }
        },
        cancelNewReport(){
            this.showNewReport = !this.showNewReport;
            this.review.carId =  null,
            this.review.text =  '',
            this.review.star =  null,
            this.review.visible =  false
            //U created
            // this.review.usertId =  '',
            // this.review.username = '',
            // this.review.reservationId = this.id;
        },

        disableComment(){
            if(this.permissions.allowedToCommend == true && this.permissions.status == 'aktivan'){
                return false
            }
            else{
                return true;
            }
        }

    },
    components: {
        "star-rating": StarRating,
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
            const parsToken = JSON.parse(localStorage.getItem('parsToken'));
            this.review.usertId =  parsToken.jti;
            this.review.username = parsToken.sub;
            this.review.reservationId = this.id;

            console.log(`
            this.review.usertId =  ${this.review.usertId};
            this.review.username = ${this.review.username};
            this.review.reservationId = ${this.review.reservationId};`);
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