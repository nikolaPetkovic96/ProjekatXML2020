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
                        <th>Automobil</th> <!--Marka + model-->
                        <th>Od</th>
                        <th>Do</th>
                        <th>Cena</th>
                        <!-- <th @click="sort('price')">Cena <img v-if='currentSortDir == "asc"'
                                src='img/up-arrow1.1.png'><img v-if='currentSortDir == "desc"'
                                src='img/down-arrow1.1.png'></th> -->
                        <th>Bundle</th>
                        <th>Status</th>
                        <th>Promena statusa</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="rezervacija.id" v-for='rezervacija in rezervacije'>
                    <td>{{rezervacija.user.username}}</td>
                    <td>{{rezervacija.car.markaAut}} {{rezervacija.car.modelAut}} ({{rezervacija.car.klasaAut}})</td>
                    <td>{{rezervacija.odDatuma}}</td>
                    <td>{{rezervacija.doDatuma}}</td>
                    <td>{{rezervacija.ukupnaCena}}</td>
                    <td>{{rezervacija.bundle}}</td>
                    <td>{{rezervacija.statusRezervacije}}</td>
                    <td>
                        <button v-on:click='openEdit(rezervacija.id)'  class="btn-outline-primary"> neaktivan </button>
                        <button v-on:click='openEdit(rezervacija.id)'  class="btn-outline-primary"> potvrdi </button>
                    </td>
                </tr>
                </tbody>
            </table>
            <button  v-on:click='openNew()' class="btn  btn-success" style='padding-left: 5px;'>Dodaj cenovnik</button>
        
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

            rezervacije:[
                {
                    id:1,
                    // user.username
                    user:{
                        username:'HappyUser',
                        ime: 'Nikola',
                        prezime:'Nikolic'
                    },
                    car:{
                        id:'2',
                        markaAut:'Mercedes',
                        modelAut:'R8',
                        klasaAut:'Old Tajmer',
                        ocena:3,
                        cena:1200,
                        kilometraza:800,
                    },
                    odDatuma:'22.10.2020',
                    doDatuma:'30.10.2020',
                    ukupnaCena:9600,
                    bundle:false,
                    statusRezervacije:'aktivan'
                },
                {
                    id:2,
                    // user.username
                    user:{
                        username:'HappyUser2',
                        ime: 'Darko',
                        prezime:'Darkovic'
                    },
                    car:{
                        id:'1',
                        markaAut:'BMW',
                        modelAut:'M5',
                        klasaAut:'SUV',
                        ocena:5,
                        cena:2500,
                        kilometraza:500,
                    },
                    odDatuma:'18.10.2020',
                    doDatuma:'20.10.2020',
                    ukupnaCena:5000,
                    bundle:false,
                    statusRezervacije:'aktivan'
                },
            ]
        }
    },
    methods:{
        makeReservation(id){
            console.log('SLANJE ZAHTEVA ZA REGISTRACIJU NA SERVER');
            KlijentDataService.vehReservation(id).then(response =>{

            }).catch(error =>{

            });
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