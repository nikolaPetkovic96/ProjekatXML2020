<template>
    <div id="reservation">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>Rezervacija</span> </h1>
            <h3 style="margin-top:10px;color:#35424a;"> Nad Vašim <span id='titleEffect'>Oglasima </span> </h3>
            
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
                        <th>Promena statusa</th>
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
                    <td>
                        <button v-on:click='exceptReserv(rezervacija.id)' :disabled='status(rezervacija.statusRezervacije)' class="btn-outline-success"> prihvati </button>
                        <button v-on:click='rejectReserv(rezervacija.id)' :disabled='status(rezervacija.statusRezervacije)' class="btn-outline-danger"> odbij </button>
                        <!-- <button v-on:click='testStat(rezervacija.id)'  class="btn-outline-danger"> test </button> -->
                    </td>               
                </tr>
                </tbody>
            </table>
        </div> <!--main-->
    </div>
</template>

<script>
import userDataService from '../services/UserDataService'
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
            userDataService.getAllRezervOsnovnoAgent().then(response => {
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

        newManualReservation:function(){
            this.$router.push(`/reservationAgent/ads_overview`);
        },

        showDetails(id){
            this.$router.push(`/reservation/${id}/details`);
        },
        // testStat(id){
        //         this.promenaStatusa.rezervacijaId = id;
        //         this.promenaStatusa.statusRezervacije = 'PENDING';
        //         userDataService.updateReservationStatusAccept(this.promenaStatusa).then(response => {
        //             alert('Uspešno ste prihvatili rezervaciju!');
        //             this.getAllReservation();
        //         });
        // },
        exceptReserv(id){
            if(confirm("Da li želite da potvrdite ovu rezervaciju?")){
                this.promenaStatusa.rezervacijaId = id;
                this.promenaStatusa.statusRezervacije = 'RESERVED';
                userDataService.updateReservationStatusAccept(this.promenaStatusa).then(response => {
                    alert('Uspešno ste prihvatili rezervaciju!');
                    this.getAllReservation();
                }).catch(error => {
                    if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokušajte ponovo kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
        },
        rejectReserv(id){
            if(confirm("Da li želite da odbijete ovu rezervaciju?")){
                this.promenaStatusa.rezervacijaId = id;
                this.promenaStatusa.statusRezervacije = 'CANCELED';
                userDataService.updateReservationStatusCancel(this.promenaStatusa).then(response => {
                    alert('Uspešno ste odbili rezervaciju!');
                    this.getAllReservation();
                }).catch(error => {
                    if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokusajte ponovo kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
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