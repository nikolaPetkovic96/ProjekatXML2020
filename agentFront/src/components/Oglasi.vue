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
                        <td>{{oglas.automobil.markaAut}} {{oglas.automobil.modelAut}} ({{oglas.automobil.klasaAut}})</td>
                        <td>{{oglas.odDatuma}}</td>
                        <td>{{oglas.doDatuma}}</td>
                        <td>{{oglas.TAdresa.mesto}}</td>
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
                    TAdresa:{
                        mesto:'Novi Sad',
                        ulica:'9. Marta',
                        broj:'bb',
                        postanskiBroj:'21000',
                        longitude:'45',
                        latitude:'54',
                    },
                    planiranaKilometraza:2000,
                    username:'This host', //u DTOu za korisnika koji je kreirao oglas.
                    //automobil
                    automobil:{
                        id:'1',
                        markaAut:'BMW',
                        modelAut:'M5',
                        klasaAut:'SUV',
                        vrstaGoriva:'dizel',
                        tipMenjaca:'manuelni',
                        ukupnaOcena:5,
                        brojSedistaZaDecu:1,
                        predjenaKilometraza:5000,
                        collisionDamageWaiver:true,
                    
                    },
                    //cena    
                    cenovnik:{
                        id:'1',
                        cenaPoDanu:100,
                        nazivCenovnika:'Cenovnik 1',
                        popustZaPreko30Dana:'10%',
                        cenaCollisionDamageWaiver:1000,
                        cenaPoKilometru:10
                    },
                },
                {
                    //oglas
                    id:2,
                    odDatuma:'18.6.2020',
                    doDatuma:'25.7.2020',
                    lokacija:'Ne znanog i znanog junaka bb Beograd',
                    TAdresa:{
                        mesto:'Beograd',
                        ulica:'Ne znanog i znanog junaka',
                        broj:'bb',
                        postanskiBroj:'11000',
                        longitude:'21.23',
                        latitude:'34.14',
                    },
                    planiranaKilometraza:2500,
                    username:'This host', //u DTOu za korisnika koji je kreirao oglas.
                    //Oglas/Automobil
                    automobil:{
                        id:1,
                        markaAut:'Audi',
                        modelAut:'A6',
                        klasaAut:'Gradski',
                        vrstaGoriva:'dizel',
                        tipMenjaca:'manuelni',
                        predjenaKilometraza:5000,
                        ukupnaOcena:5,
                        collisionDamageWaiver:true,
                        brojSedistaZaDecu:1,
                    },
                    //Oglas/Cenovnik
                    cenovnik:{ 
                        id:'2',
                        cenaPoDanu:200,
                        nazivCenovnika:'Cenovnik 2',
                        popustZaPreko30Dana:'20%',
                        cenaCollisionDamageWaiver:null,
                        cenaPoKilometru:20
                    },
                },
                {
                    //oglas
                    id:3,
                    odDatuma:'25.5.2020',
                    doDatuma:'15.6.2020',
                    lokacija:'19. Juna 45 Novi Sad',
                    TAdresa:{
                        mesto:'Novi Sad',
                        ulica:'19. Juna',
                        broj:'45',
                        postanskiBroj:'11000',
                        longitude:'12',
                        latitude:'21',
                    },
                    planiranaKilometraza:3000,
                    username:'This host', //u DTOu za korisnika koji je kreirao oglas.
                    //automobil
                    automobil:{
                        id:'3',
                        markaAut:'Audi',
                        modelAut:'A6',
                        klasaAut:'Gradski auto',
                        vrstaGoriva:'dizel',
                        tipMenjaca:'manuelni',
                        ukupnaOcena:4,
                        brojSedistaZaDecu:2,
                        predjenaKilometraza:650,
                        collisionDamageWaiver:false,
                    },
                    cenovnik:{
                        id:'3',
                        cenaPoDanu:300,
                        nazivCenovnika:'Cenovnik 3',
                        popustZaPreko30Dana:null,
                        cenaCollisionDamageWaiver:3000,
                        cenaPoKilometru:30
                    },
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