<template>
    <div id="messages">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista rezervacija sa statusom <span id='titleEffect'>PAID</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <br>
        <div id='main' class='container'>
             <div class='container' style='background-color:#35424a;text-align:center;padding:15px;color:#FF8C00'>
           <h1> NAPRAVLJENE REZERVACIJE </h1>   
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Rezervisan od</th> 
                        <th>Ukupna cena</th>
                        <th>Bundle</th>
                        <th>Status</th>
                        <th>Detalji</th>
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
                        <button v-on:click='showDetails(rezervacija.id)' class="btn-outline-primary"> detalji </button>
                    </td>
                    <td>
                        <button v-on:click='openMessage(rezervacija.id)'  class="btn-outline-primary"> Poruke </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<!-- Isti get koji se radi i u Rezervacija.vue. Vrati sve rezervacije koje su napravljene
za oglase koje je kreirao ulogovani agent i kojima je status="accepted" -->

<script>
export default {
    name: 'Messages',
    data:function(){
        return {
            //Ovde moze i samo deo sa rezervacijom bez ostalih objekata
            //Isti DTO iskoristiti i u IzvestaijiIStatistike.vue
            pogled:'user',
            rezervacije:[
                {
                    id:1,
                    ukupnaCena:6500,
                    statusRezervacije:'PAID',
                    username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    bundle:true,
                    
                },
                {
                    id:2,
                    ukupnaCena:8500,
                    statusRezervacije:'PAID',
                    username:'Happy User 3', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    bundle:true,
                },
                
            ],
        }
    },
    methods:{
        openMessage:function(id){
           this.$router.push(`/messages/${id}/overview`);
        },
        showDetails(id){
            this.$router.push(`/reservation/${id}/details`);
        }
    }
}
</script>

<style scoped>

#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}

label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

</style>