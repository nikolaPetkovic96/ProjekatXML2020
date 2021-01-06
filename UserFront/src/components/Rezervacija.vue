<template>
    <div id="reservation">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>napravljenih rezervacija</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        
        <div id='main' class='container'>
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Rezervisan od</th>
                        <th>Cena</th>
                        <th>Bundle</th>
                        <th>Status</th>
                        <th>Detaljnije</th>
                        <th>Poruke</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="rezervacija.id" v-for='rezervacija in rezervacije'>
                    <td>{{rezervacija.username}}</td>
                    <td>{{rezervacija.ukupnaCena}}</td>
                    <td>{{rezervacija.bundle}}</td>
                    <td>{{rezervacija.statusRezervacije}}</td>
                    <td>
                        <button v-on:click='showDetails(rezervacija.id)' class=" btn-outline-primary"> detalji </button>
                    </td>
                       <td>
                        <button v-on:click='openMessage(rezervacija.id)'  :disabled='statusMessage(rezervacija.statusRezervacije)' class=" btn-outline-dark"> poruke </button>
                    </td>               
                </tr>
                </tbody>
            </table>
        
        </div> <!--main-->
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
export default {
    data(){
        return{
            user: {
                username: '',
                role: ''
            },
            vehId: '',

            rezervacije:[],

            promenaStatusa:{
                rezervacijaId:null,
                statusRezervacije:'',
            },

            messages: {
                errorResponse: '',
                successResponse: '',
            }

        }
    },
    methods:{
        getAllReservation:function(){
            UserDataService.getAllRezervacijeOsnovno().then(response => {
               this.rezervacije = response.data;
            });
        },

        status:function (status){
            if (status === "PENDING") {
				return false; //nemoj disable uraditi
			}
			return true; //za sve ostale ce uraditi disable
        },

        statusMessage:function (status){
            if (status === "RESERVED") {
				return false; //nemoj disable uraditi
			}
			return true; //za sve ostale ce uraditi disable
        },

        openMessage:function(id){
           this.$router.push(`/messages/${id}/overview`);
        },

        showDetails(id){
            this.$router.push(`/reservation/${id}/details`);
        }
    },
    created() {
        if(JSON.parse(localStorage.getItem('token')) == null){
           this.$router.push(`/login`);
        }
        else{
            this.getAllReservation();
        }
        
    }
}
</script>

<style>

#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}

</style>