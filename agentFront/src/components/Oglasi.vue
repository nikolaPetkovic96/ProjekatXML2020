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
                        <th>Od</th>
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
                        <td>{{oglas.odDatuma}}</td>
                        <td>{{oglas.doDatuma}}</td>
                        <td>{{oglas.adresa.mesto}}</td>
                        <td>{{oglas.planiranaKilometraza}} km</td>
                        <td>{{oglas.cenovnik.nazivCenovnika}}</td>
                        <td>{{oglas.cenovnik.cenaPoDanu}} din</td>
                        <td>{{oglas.cenovnik.cenaPoKilometru}} din</td>
                        <td>
                            <button v-on:click='deleteAds(oglas.id)' class="btn-danger"> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <!-- <router-link to="/ads/new"> <button class=' btn btn-success shadow'>Kreiraj oglas</button></router-link> -->
        </div> <!--main-->
    </div>
   
</template>

<script>
import agentDataService from '../services/AgentDataService'
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
        }
    },
    methods:{
        getAllAgentsOglas:function(){
            agentDataService.getAllAgentsOglas().then(response => {
                this.oglasi = response.data;
            });
        },
        deleteAds:function(id){
            if (confirm('Da li ste sigurni da želite obrisati ovaj oglas?')) {
                console.log(`Usao u delete ads za ${id}`);
                agentDataService.deleteOglas(id).then(response => {
                    this.getAllAgentsOglas();
                })
                .catch(error => {
                    if(error.response.status === 500 || error.response.data.message === 'There are reservations connected to this ad!'){
                        this.messages.errorResponse= `<h4>Ne možete obrisati ovaj oglas jer postoje rezervacije vezane za njega!</h4>`;
                        setTimeout(() => this.messages.errorResponse='', 5000);
                    }
                });
            }
        },
    },
    created(){
        this.getAllAgentsOglas();
    }
}
</script>

<style scoped>
    #titleEffect{
        color:gold;
        font-weight: bold;
    }
</style>
