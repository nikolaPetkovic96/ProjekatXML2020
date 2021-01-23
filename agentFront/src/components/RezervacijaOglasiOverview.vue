<template>
    <div id="manual_reservation">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>Oglasa</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class='container ' id='main'>

            <!-- Page Heading -->
            <h1 class="my-4 theme-colr">
                <small >Vaši oglasi</small>
            </h1>

            <div id='sort'>
                <h5 class='theme-colr'><small> <b>Sortiraj:</b>  </small></h5>
                <button @click="sort('ocena')" class="arrow btn btn-lg btn-outline-primary"> Ocena
                    <img v-if='currentSortDir == "asc" && currentSort== "ocena"' src='../assets/up-arrow1.1.png'>
                    <img v-if='currentSortDir == "desc" && currentSort== "ocena" ' src='../assets/down-arrow1.1.png'>
                </button>
                <button @click="sort('cena')" class="arrow btn btn-lg btn-outline-primary"> Cena
                    <img v-if='currentSortDir == "asc"  && currentSort== "cena"' src='../assets/up-arrow1.1.png'>
                    <img v-if='currentSortDir == "desc"  && currentSort== "cena"' src='../assets/down-arrow1.1.png'>
                </button>
                <button @click="sort('predjenaKilometraza')" class="arrow btn btn-lg btn-outline-primary"> Kilometraza
                    <img v-if='currentSortDir == "asc"  && currentSort== "predjenaKilometraza"' src='../assets/up-arrow1.1.png'>
                    <img v-if='currentSortDir == "desc"  && currentSort== "predjenaKilometraza"' src='../assets/down-arrow1.1.png'>
                </button>
            </div>
            <br>
            <!-- Page Heading -->
            <div class="row" >
                <div class="col-lg-4 col-sm-6 mb-4" v-bind:key='oglas.id' v-for="oglas in sortedOglasi">
                <div class="card h-100">
                    <img id='overview-img' class="card-img-top" v-bind:src="oglas.automobil.slikeVozila.slika[0]" alt="">
                    
                    <div class="card-body">
                    <!-- <h4 class="card-title">
                        <a href="#">Project One</a>
                    </h4> -->
                        <div class="card-text">
                            <h4 class="theme-colr"><b>Automobil: </b>{{oglas.automobil.markaAut}} {{oglas.automobil.modelAut}}</h4> 
                            <h4 class="theme-colr"><b>Klasa: </b>{{oglas.automobil.klasaAut}}</h4>
                            <h5 class="theme-colr"><b>Ocena:</b>({{oglas.automobil.ukupnaOcena}})   
                                <star-rating
                                    inactive-color="#35424a"
                                    active-color="gold"
                                    v-bind:read-only= "true"
                                    v-bind:star-size="25"
                                    v-bind:show-rating="false"
                                    v-bind:rating="oglas.automobil.ukupnaOcena">
                                </star-rating> 
                            </h5>
                            <h5 class="theme-colr"><b>Cena po danu: </b>{{oglas.cenovnik.cenaPoDanu}} din</h5>
                            <h5><b>Kilometraža: </b>{{oglas.automobil.predjenaKilometraza}} km</h5>
                        </div>
                        <button class="btn btn-outline-primary margTop" v-on:click='showDetails(oglas.automobil.id)'> Detalji </button>
                        <button class="btn btn-outline-success margTop" v-on:click='makeReseravation(oglas.id)'> Reservisi </button>
                    </div>
                </div>
                </div>
            </div>
            <!-- /.row -->
        </div> <!-- /.container -->
    </div>
</template>

<script>
import Datepicker from 'vuejs-datepicker'
import StarRating from 'vue-star-rating'
import AgentDataService from '../services/AgentDataService'
export default{
    data(){
        return{
            //za prikaz kada su oglasi prazni (obrisati kasnije)
            oglasip:[],
            isAlreadySearched:false,
            //sortiranje:
            currentSort: 'cena',
            currentSortDir: 'asc',

            oglasi:[
                // {
                //     //oglas
                //     id:1,
                //     odDatuma:'25.5.2020',
                //     doDatuma:'25.6.2020',
                //     TAdresa:{
                //         mesto:'Novi Sad',
                //         ulica:'9. Marta',
                //         broj:'bb',
                //         postanskiBroj:'21000',
                //         longitude:'45',
                //         latitude:'54',
                //     },
                //     planiranaKilometraza:2000,
                //     agentId:1,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                //     korisnickoImeAgenta:'This host',  //u DTOu za korisnika koji je kreirao oglas.
                //     //automobil
                //     automobil:{
                //         id:'1',
                //         markaAut:'BMW ovaj za test',
                //         modelAut:'M5',
                //         klasaAut:'SUV',
                //         vrstaGoriva:'dizel',
                //         tipMenjaca:'manuelni',
                //         ukupnaOcena:5,
                //         brojSedistaZaDecu:1,
                //         predjenaKilometraza:5000,
                //         collisionDamageWaiver:true,
                //         images:['https://source.unsplash.com/RCAhiGJsUUE/1920x1080','https://source.unsplash.com/wfh8dDlNFOk/1920x1080','https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                    
                //     },
                //     //cena    
                //     cenovnik:{
                //         id:'1',
                //         cenaPoDanu:100,
                //         nazivCenovnika:'Cenovnik 1',
                //         popustZaPreko30Dana:'10%',
                //         cenaCollisionDamageWaiver:1000,
                //         cenaPoKilometru:10
                        
                //     },
                // },
              
            ],

            //sortiranje:
            currentSort: 'cena',
            currentSortDir: 'asc',

           
        }
    },
    methods:{

   
        getAllOglasiDetailsImg:function(){
            AgentDataService.getAllOglasiDetailsImg().then(response => {
                this.oglasi = response.data;
            });
        },

        makeReseravation:function(id){
            //alert(`Za automobil id ${id} ce biti napravljena rezervacija!`);
            this.$router.push(`/cars/${id}/reservation`);
        }, 
        showDetails:function(id){
            this.$router.push(`/cars/${id}/details`);
        },     
     

        // metoda za sortiranje 
        //Kada se klikne na naslov kolone kako bi se sortirala ta kolona prosledi se 
        //jedna od vrednosti 'ocena', 'cena' ili 'predjenaKilometraza'
        //Ova fukncija prvo proveri da li je kliknuto vise puta na istu kolonu, pa ako jeste promeni smer sortriranja
        //Ako je bio rastuci postaje opadajuci... Ako nije ista kolona vec se kliknulo na neku drugu on dodeli vrednost te kolone 
        //da je currentSort tj. da je ona nova kolona po kojoj se vrsi sortiranje... Ta nova kolona ce biti po default sortirana po rastucoj vrednosti jer je to 
        // default vrednost this.currentSortDir atributa;
         
        sort: function (s) {
            //if s == current sort, reverse
            if (s === this.currentSort) {
                this.currentSortDir = this.currentSortDir === 'asc' ? 'desc' : 'asc';
            }
            this.currentSort = s;
        },
    },
    computed: {
        //Ova metoda staloni vrsi poredjenje izmedju oglasa po kriterijumu koji se prosledi klikom na kolonu;
        //Prvo se proveri da li je smer sortiranja rastuci ili opadajuci za this.currentSortDir i onda se poredi svaki oglas po prosledjenom 
        //kriterijumu tj po this.currentSort
        sortedOglasi: function () {
            return this.oglasi.sort((oglas1, oglas2) => {
                let modifier = 1;
                if (this.currentSortDir === 'desc') modifier = -1;
                if(this.currentSort == 'cena'){
                    if (oglas1.cenovnik.cenaPoDanu < oglas2.cenovnik.cenaPoDanu) return -1 * modifier;
                    if (oglas1.cenovnik.cenaPoDanu > oglas2.cenovnik.cenaPoDanu) return 1 * modifier;
                    return 0;
                }
                if(this.currentSort == 'ocena'){
                    if (oglas1.automobil.ukupnaOcena < oglas2.automobil.ukupnaOcena) return -1 * modifier;
                    if (oglas1.automobil.ukupnaOcena > oglas2.automobil.ukupnaOcena) return 1 * modifier;
                    return 0;
                }
                if(this.currentSort == 'predjenaKilometraza'){
                    if (oglas1.automobil.predjenaKilometraza < oglas2.automobil.predjenaKilometraza) return -1 * modifier;
                    if (oglas1.automobil.predjenaKilometraza > oglas2.automobil.predjenaKilometraza) return 1 * modifier;
                    return 0;
                }
    
            });
        },
    },
    components: {
        vuejsDatepicker:Datepicker,
        'star-rating':StarRating
    },
    created(){
         // Ako je prazan token znaci da user nije ulogovan pa se preusmerava na login stranicu.
        //getuju se svi oglasi koji pripadaju tom agentu...
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.getAllOglasiDetailsImg();
        }
    },
}
        
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}

#second_raw{
    margin-top:5px;
}

#third_raw{
    margin-top:5px;
}

#fourth_raw{
    margin-top:5px;
}

.span_search{
    /* padding:5px; */
    padding-top:5px;
    padding-left:5px;
    padding-right:5px;
    color:#35424a;
    font-weight: bold;
}
#search_icon:hover{
    cursor: pointer;
    
}

.arrow:hover{
    cursor: pointer;
}

.classButton{
  margin-left: 5px;
  color:#fff;
  background-color:#35424a;
  padding:10px;
}

.classButton:hover{
  margin-left: 5px;
  color:#fff;
  background-color:gold;
  font-weight: bold;
  padding:10px;
}

.marg-top{
    margin-top: 25px;
}

.marg-right{
    margin-right: 10px;
    padding:5px;
}
.btn-clear{
    margin-right: 2px;
    
}
.theme-colr{
    color:#141616;
} 

#overview-img{
    width: 349px;
    height: 200px;
}

#cart{
    float:right;
    margin:5px;
}

#searcIcon img:hover{
    width:45px;
    padding-bottom:3px;
    cursor: pointer;
}

</style>
