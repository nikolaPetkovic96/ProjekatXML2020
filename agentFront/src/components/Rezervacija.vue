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
                        <th></th>
                        <th>Od</th>
                        <th>Do</th>
                        <th>Night</th>
                        <th @click="sort('price')">Price <img v-if='currentSortDir == "asc"'
                                src='img/up-arrow1.1.png'><img v-if='currentSortDir == "desc"'
                                src='img/down-arrow1.1.png'></th>
                        <th>Confirmation</th>
                        <th>Status</th>
                        <th v-if='isHost'>Status</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="cenovnik.id" v-for='cenovnik in cenovnici'>
                    <td>{{cenovnik.nazivCenovnika}}</td>
                    <td>{{cenovnik.cenaPoDanu}}</td>
                    <td>{{cenovnik.cenaPoKilometru}}</td>
                    <td>{{cenovnik.cenaCollisionDamageWaiver}}</td>
                    <td>{{cenovnik.popustZaPreko30Dana}}</td>
                    <td><button v-on:click='openEdit(cenovnik.id)'  class="btn-primary"> edit </button></td>
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

            reservation:{
                beginning: null,
                ending: null,
                planned_distance: 0,
                message:''
            }
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