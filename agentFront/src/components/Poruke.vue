<template>
    <div id="messages">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista rezervacija sa statusom <span id='titleEffect'>RESERVED</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div id='main' class='container'>
            <table class="table">
                <thead>
                    <tr>
                        <th>Rezervisan od</th> <!--Korisnik koji ga rezervise-->
                        <th>Automobil</th> <!--Marka + model-->
                        <th>Od</th>
                        <th>Do</th>
                        <th>Cena</th>
                        <th>Bundle</th>
                        <th>Status</th>
                        <!-- <th>Details za bundle?</th> -->
                        <th>Poruke</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="rezervacija.id" v-for='rezervacija in rezervacije'>
                    <td>{{rezervacija.username}}</td>
                    <td>{{rezervacija.markaAut}} {{rezervacija.modelAut}} ({{rezervacija.klasaAut}})</td>
                    <td>{{rezervacija.odDatuma}}</td>
                    <td>{{rezervacija.doDatuma}}</td>
                    <td>{{rezervacija.ukupnaCena}}</td>
                    <td>{{rezervacija.bundle}}</td>
                    <td>{{rezervacija.statusRezervacije}}</td>
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
            //Iskoristiti ovo u rezervacijama!!!!!
            rezervacije:[
                {
                    id:1,
                    odDatuma:'18.6.2020',
                    doDatuma:'25.7.2020',
                    ukupnaCena:6500,
                    username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    statusRezervacije:'RESERVED',
                    isBundle:false,
                    //Oglas
                    TAdresa:{
                        mesto:'',
                        ulica:'',
                        broj:'',
                        postanskiBroj:'',
                        longitude:'',
                        latitude:'',
                    },
                    //Oglas/Automobil
                    markaAut:'Audi',
                    modelAut:'A6',
                    klasaAut:'Gradski',
                    planiranaKilometraza:2500,
                    //Oglas/Cenovnik    
                    nazivCenovnika:'Cenovnik2',
                    cenaPoKilometru:2750, //Ako je ima
                    cenaPoDanu:200,
                    //commonData ?
                },
                {
                    id:2,
                    odDatuma:'18.6.2020',
                    doDatuma:'25.7.2020',
                    ukupnaCena:6500,
                    username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    statusRezervacije:'RESERVED',
                    //Oglas
                    TAdresa:{
                        mesto:'',
                        ulica:'',
                        broj:'',
                        postanskiBroj:'',
                        longitude:'',
                        latitude:'',
                    },
                    //Oglas/Automobil
                    markaAut:'Audi',
                    modelAut:'A6',
                    klasaAut:'Gradski',
                    planiranaKilometraza:2500,
                    //Oglas/Cenovnik    
                    nazivCenovnika:'Cenovnik2',
                    cenaPoKilometru:2750, //Ako je ima
                    cenaPoDanu:200,
                    //commonData ?
                },
            ]
        }
    },
    methods:{
      openMessage:function(id){
           this.$router.push(`/messages/${id}/overview`);
      }
    }
}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}

</style>