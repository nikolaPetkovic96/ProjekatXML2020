<template>
    <div id="reservation">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>Rezervacija</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <div id='main' class='container'>
         
            <table class="table">
                <thead>
                    <tr>
                        <th>Rezervisan od</th> <!--Korisnik koji ga rezervise-->
                        <th>Cena</th>
                        <th>Bundle</th>
                        <th>Status</th>
                        <th>Details</th>
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
                        <button v-on:click='showDetails(rezervacija.id)' class="btn-outline-primary"> detalji </button>
                    </td>
                    <td>
                        <button v-on:click='exceptReserv(rezervacija.id)'  class="btn-outline-primary"> prihvati </button>
                        <button v-on:click='rejectReserv(rezervacija.id)'  class="btn-outline-primary"> odbij </button>
                    </td>      
                </tr>
                </tbody>
            </table>
            <button  v-on:click='newManualReservation()' class="btn  btn-success" style='padding-left: 5px;'>Dodaj rezervaciju</button>
        
        </div> <!--main-->
    </div>
</template>

<script>
// import KlijentDataService from './components/KlijentDataService'
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

            //Ovde moze i samo deo sa rezervacijom bez ostalih objekata
            //Isti DTO iskoristiti i u Poruke.vue
            rezervacije:[
                {
                    id:1,
                    ukupnaCena:6500,
                    statusRezervacije:'RESERVED',
                    username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    bundle:true,

                },
                {
                    id:2,
                    ukupnaCena:8500,
                    statusRezervacije:'RESERVED',
                    username:'Happy User 3', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    bundle:true,

                },
            ],
        }
    },
    methods:{
        newManualReservation:function(){
            this.$router.push(`/reservation/ads_overview`);
        },
        showDetails(id){
            this.$router.push(`/reservation/${id}/details`);
        },
        exceptReserv(id){
            console.log(`Prihvacena rezervacija ${id}`);
            // KlijentDataService.vehReservation(id).then(response =>{

            // }).catch(error =>{

            // });
        },
        rejsctReserv(id){
            console.log(`Odbijena rezervacija ${id}`);
            // KlijentDataService.vehReservation(id).then(response =>{

            // }).catch(error =>{

            // });
        }
    },
    created() {

    }
}
</script>

<style>

#titleEffect{
  color:gold;
  font-weight: bold;
}

</style>