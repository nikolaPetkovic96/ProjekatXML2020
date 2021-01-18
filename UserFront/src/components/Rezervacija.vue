<template>
    <div id="reservation">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>Rezervacija</span></h1>
            <h3 style="margin-top:10px;color:#35424a;">Koje ste Vi <span id='titleEffect'>napravili</span> </h3>
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
                        <th>Komentar</th>
                        <th>Odusta/Plati</th>
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
                        <button v-on:click='openMessage(rezervacija.id)'  :disabled='statusMessage(rezervacija.statusRezervacije)' class=" btn-outline-dark"> komentar </button>
                    </td>
                    <td>
                        <button v-on:click='rejectReserv(rezervacija.id)' :disabled='statusCancel(rezervacija.statusRezervacije)' class="btn-outline-success"> otkaži </button>
                        <button v-on:click='payReserv(rezervacija.id)' :disabled='statusMessage(rezervacija.statusRezervacije)' class="btn-outline-danger"> plati </button>
                        <!-- <button v-on:click='testStat(rezervacija.id)'  class="btn-outline-primary"> test </button> -->
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
            UserDataService.getAllRezervOsnovnoUser().then(response => {
               this.rezervacije = response.data;
            });
        },

        statusCancel:function (status){
            if (status === "PENDING" || status === "RESERVED") {
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
        // testStat(id){
        //     this.promenaStatusa.rezervacijaId = id;
        //     this.promenaStatusa.statusRezervacije = 'PENDING';
        //     UserDataService.updateReservationStatusAccept(this.promenaStatusa).then(response => {
        //         alert('Uspešno ste prihvatili rezervaciju!');
        //         this.getAllReservation();
        //     });
        // },
        payReserv(id){
            if(confirm("Da li želite da potvrdite plaćanje za ovu rezervaciju?")){
                this.promenaStatusa.rezervacijaId = id;
                this.promenaStatusa.statusRezervacije = 'PAID';
                UserDataService.updateReservationStatusPaid(this.promenaStatusa).then(response => {
                    alert('Uspešno ste platili rezervaciju!');
                    this.getAllReservation();
                }).catch(error => {
                    if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokusajte ponovo kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
        },
        rejectReserv(id){
            if(confirm("Da li želite da otkažete ovu rezervaciju?")){
                this.promenaStatusa.rezervacijaId = id;
                this.promenaStatusa.statusRezervacije = 'CANCELED';
                UserDataService.updateReservationStatusCancel(this.promenaStatusa).then(response => {
                    alert('Uspešno ste otkazali rezervaciju!');
                    this.getAllReservation();
                }).catch(error => {
                    if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokusajte ponovo kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
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