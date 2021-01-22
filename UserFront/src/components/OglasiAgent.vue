<template>
    <div id="ads">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Oglasa</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <div id='main' class='container'>
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Automobil</th> <!--Marka + model-->
                        <th>Od (mm:dd:yy)</th>
                        <th>Do</th>
                        <th>Lokacija</th>
                        <th>Planirana km</th>
                        <th>Cenovnik</th>
                        <th>Cena po danu</th>
                        <th>Cena po km</th>
                        <th>Obrsi oglas</th>
                    </tr>
                </thead>
                <tbody>                
                    <tr v-bind:key="oglas.id" v-for='oglas in oglasi'>
                        <td>{{oglas.automobil.markaAut}} {{oglas.automobil.modelAut}} ({{oglas.automobil.klasaAut}})</td>
                        <td>{{formatDatuma(oglas.odDatuma)}}</td>
                        <td>{{formatDatuma(oglas.doDatuma)}}</td>
                        <td>{{oglas.adresa.mesto}}</td>
                        <td>{{oglas.planiranaKm}} km</td>
                        <td>{{oglas.cenovnik.nazivCenovnika}}</td> 
                        <td>{{oglas.cenovnik.cenaPoDanu}} din</td>
                        <td>{{oglas.cenovnik.cenaPoKilometru}} din</td>
                        <td>
                            <button :disabled='btnEnabled' v-on:click='deleteAds(oglas.id)' class="btn-danger"> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <!-- <router-link to="/ads/new"> <button class=' btn btn-success shadow'>Kreiraj oglas</button></router-link> -->
        </div> <!--main-->
    </div>
   
</template>

<script>
import UserDataService from '../services/UserDataService'
export default {
    name: 'ads',
    data:function(){
        return {
            oglasi:[],
            
            messages: {
				errorDates: '',
				errorResponse: '',
				successResponse: '',
            },
            permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
            },
            btnEnabled:false
        }
    },
    methods:{
        getAllUsersOglas:function(){
            UserDataService.getAllUsersOglas().then(response => {
                this.oglasi = response.data;
                console.log("Oglasi: " + JSON.stringify(this.oglasi));
                
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
        deleteAds:function(id){
            if (confirm('Da li ste sigurni da želite obrisati ovaj oglas?')) {
                console.log(`Usao u delete ads za ${id}`);
                UserDataService.deleteOglas(id).then(response => {
                    this.getAllUsersOglas();
                })
                .catch(error => {
                    console.log(error.response.data);
                    if(error.response.data === 'There are reservations connected to this ad!'){
                        
                        this.messages.errorResponse= `<h4>Ne možete obrisati ovaj oglas jer postoje rezervacije vezane za njega!</h4>`;
                        setTimeout(() => this.messages.errorResponse='', 5000);
                    }
                });
            }
        },
        formatDatuma(datum){
            const date = new Date(datum);       //konvertujemo input tip u Date
            return date.toLocaleDateString();
        },
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
           this.$router.push(`/login`);
        }
        else{
            this.getAllUsersOglas();
            this.getAllPermissions();
        }
        
    }
}
</script>

<style scoped>
    #titleEffect{
        color:#FF8C00;
        font-weight: bold;
    }
</style>
