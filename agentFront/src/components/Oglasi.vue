<template>
    <div id="ads">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Oglasa</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <div id='main' class='container'>
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
                        <td>{{oglas.markaAut}} {{oglas.modelAut}} ({{oglas.klasaAut}})</td>
                        <td>{{oglas.odDatuma}}</td>
                        <td>{{oglas.doDatuma}}</td>
                        <td>{{oglas.lokacija}}</td>
                        <td>{{oglas.planiranaKilometraza}}</td>
                        <td>{{oglas.nazivCenovnika}}</td>
                        <td>{{oglas.cenaPoDanu}}</td>
                        <td>{{oglas.cenaPoKilometru}}</td>
                        <td>
                            <button v-on:click='deleteAds(oglas.id)' class="btn-danger"> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <router-link to="/ads/new"> <button class=' btn btn-success shadow'>Kreiraj oglas</button></router-link>
        </div> <!--main-->
    </div>
   
</template>

<script>
export default {
    name: 'ads',
    data:function(){
        return {
            oglasi:[
                {
                    //oglas
                    id:1,
                    odDatuma:'25.5.2020',
                    doDatuma:'25.6.2020',
                    lokacija:'9. Marta bb Novi Sad',
                    planiranaKilometraza:2000,
                    //automobil
                    markaAut:'BMW',
                    modelAut:'M5',
                    klasaAut:'Gradski',
                    //cena    
                    nazivCenovnika:'Dnevni cenovnik',
                    cenaPoKilometru:2500, //Ako je ima
                    cenaPoDanu:1500,
                    //commonData ?
                },
                {
                    //oglas
                    id:2,
                    odDatuma:'18.6.2020',
                    doDatuma:'25.7.2020',
                    lokacija:'Ne znanog i znanog junaka bb Beograd',
                    planiranaKilometraza:2500,
                    //automobil
                    markaAut:'Audi',
                    modelAut:'A6',
                    klasaAut:'Gradski',
                    //cena    
                    nazivCenovnika:'Cenovnik2',
                    cenaPoKilometru:2750, //Ako je ima
                    cenaPoDanu:200,
                    //commonData ?
                },
                {
                    //oglas
                    id:3,
                    odDatuma:'25.5.2020',
                    doDatuma:'15.6.2020',
                    lokacija:'19. Juna bb Novi Sad',
                    planiranaKilometraza:3000,
                    //automobil
                    markaAut:'Fiat',
                    modelAut:'500L',
                    klasaAut:'Gradski',
                    //cena    
                    nazivCenovnika:'Cenovnik2',
                    cenaPoKilometru:3500, //Ako je ima
                    cenaPoDanu:1200,
                    //commonData ?
                }
            ]
        }
    },
    methods:{
      deleteAds:function(id){
          alert(`Oglas ${id} ce biti obrisan `);
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

/*
oglasi:[
    {
        id:1,
        odDatuma:'25.5.2020',
        doDatuma:'25.6.2020',
        automobil:{
            id:'1',
            markaAut:'BMW',
            modelAut:'M5',
            klasaAut:'SUV',
            ocena:5,
            cena:2500,
        predjenaKilometraza:500,
        },
        cenovnik:{
            id:1,
            cenaPoDanu:1500,
            nazivCenovnika:'Dnevni cenovnik',
            cenaPoKilometru:2500, //Ako je ima
        }
    }
]*/ 