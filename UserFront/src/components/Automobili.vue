<template>
    <div id="automobili-overview">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Automobila</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        
        <div class='container ' id='search'>
            <nav class="navbar navbar-light bg-light justify-content-between">
                <a class="navbar-brand">Search</a>
                <form class="form-inline">                                            
                        <div style="margin-right: 20px;" id='search_icon'>
                            <span style='display:inline; margin: 15px;'>
                                <img v-on:click='isSearch = !isSearch' src='../assets/searchIcon1.png' style="display:inline;">
                            </span>
                        </div>
                       
                        <div style='display:inline;' v-show='isSearch' id="advanced_search">
                           
                            <div id='second-row' class="row"  style="margin-top:5px;">
                                <span class="col-xl-2 col-md-6 mb-1">
                                    <button style='margin-right:5px;' class='btn btn-outline-primary my-2 my-sm-0' v-on:click="resetFilter()">Reset all</button>
                                </span>
                                <span class="col-xl-6 col-md-6 mb-1">
                                    <span class="span_search">Cena</span>
                                    <input class="form-control mr-sm-2" type="text" placeholder="min cena" aria-label="Search" v-model="searchedCar.cenaMin">
                                    <span style="padding-right:6px;" class="span_search"> - </span>
                                    <input class="form-control mr-sm-2" type="text" placeholder="max cena" aria-label="Search" v-model="searchedCar.cenaMax">
                                </span>
                                <span class="col-xl-3 col-md-6 mb-1">
                                    <span class="span_search">Marka</span>
                                    <select style="padding:5px;" v-model="searchedCar.markaAut">
                                        <option disabled value="">Marka automobila</option>
                                        <option v-bind:key="marka" v-for="marka in markaAut">{{marka}}</option>
                                    </select>
                                </span>

                                <div style='display:inline;' id='third_raw'>
                                    <span class="col-xl-3 col-md-6 mb-3"> 
                                        <span class="span_search">Model</span>
                                        <select style="padding:5px;" v-model="searchedCar.modelAut">
                                            <option disabled value="">Model automobila</option>
                                            <option v-bind:key="model" v-for="model in modelAut">{{model}}</option>
                                        </select>
                                    </span>
                                    <span class="col-xl-3 col-md-6 mb-3">   
                                        <span class="span_search">Klasa</span>
                                        <select style="padding:5px;" v-model="searchedCar.klasaAut">
                                            <option disabled value="">Klasa automobila</option>
                                            <option v-bind:key="klasa" v-for="klasa in klasaAut">{{klasa}}</option>
                                        </select>
                                    </span>
                                    <span class="col-xl-3 col-md-6 mb-3">
                                        <span class="span_search">Tip menjaca</span>
                                        <select style="padding:5px;" v-model="searchedCar.tipMenjaca">
                                            <option disabled value="">Tip menajca</option>
                                            <option v-bind:key="menjac" v-for="menjac in tipMenjaca">{{menjac}}</option>
                                        </select>
                                    </span>
                                    <span class="col-xl-3 col-md-6 mb-3">
                                        <span class="span_search">Tip goriva</span>
                                        <select style="padding:5px;" v-model="searchedCar.tipGoriva">
                                            <option disabled value="">Tip goriva</option>
                                            <option v-bind:key="gorivo" v-for="gorivo in tipGoriva">{{gorivo}}</option>
                                        </select>
                                    </span>

                                    <div id='fourth_raw'>
                                        <span class="col-xl-3 col-md-6 mb-2"> 
                                            <span class="span_search">Decija sedista</span>
                                            <select style="padding:5px;" v-model="searchedCar.brojSedZaDec">
                                                <option disabled value="">Br. sed. za decu</option>
                                                <option v-bind:key="bszd" v-for="bszd in brojSedZaDec">{{bszd}}</option>
                                            </select> 
                                        </span>
                                        <span class="col-xl-3 col-md-6 mb-2"> 
                                            <span class="span_search">Predjena km</span>
                                            <input class="form-control mr-sm-2" type="text" placeholder="Kilometraza" aria-label="Search" v-model="searchedCar.predjenaKilometraza">  
                                        </span>
                                        <span class="col-xl-3 col-md-6 mb-2"> 
                                            <span>
                                                <span class="span_search">Coll Ddmg Waiver</span>
                                                <input type="radio" v-model="searchedCar.ColDmgWaiv" required value="true"> True
                                                <input type="radio" v-model="searchedCar.ColDmgWaiv" required value="false"> False
                                            </span>
                                        </span>
                                        <span class="col-xl-3 col-md-6 mb-2"> 
                                            <button style="margin-left: 5px;" class="btn btn-outline-success my-2 my-sm-0" type="button" v-on:click.prevent='searchCar()'>Search</button>
                                        </span>
                                    </div> <!--/fourth_row-->
                                </div> <!--/third_row-->
                            </div><!--/second_row-->
                        </div><!--/advanced_search-->
                    <!-- <div> -->
                </form>
            </nav>
        </div>

        <div class="container" id='main'>
            <table class="table">
                <thead>
                    <tr>
                        <th>Marka</th>
                        <th>Model</th>
                        <th>Klasa</th>
                        <th @click="sort('ukupnaOcena')" class="arrow"> Ocena
                            <img v-if='currentSortDir == "asc" && currentSort== "ukupnaOcena"' src='../assets/up-arrow1.1.png'>
                            <img v-if='currentSortDir == "desc" && currentSort== "ukupnaOcena" ' src='../assets/down-arrow1.1.png'>
                        </th>
                        <th @click="sort('predjenaKilometraza')" class="arrow"> Kilometraza
                            <img v-if='currentSortDir == "asc"  && currentSort== "predjenaKilometraza"' src='../assets/up-arrow1.1.png'>
                            <img v-if='currentSortDir == "desc"  && currentSort== "predjenaKilometraza"' src='../assets/down-arrow1.1.png'>
                        </th>
                        <th>Detalji</th>
                        <!-- <th>Rezervisi</th> -->
                        <th>Oglas</th>
                        <!--th>Uredi</th>
                        <th>Ukloni</th-->
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='automobil.id' v-for="automobil in sortiraniAutomobili">
                        <td>{{automobil.markaAut}}</td>
                        <td>{{automobil.modelAut}}</td>
                        <td>{{automobil.klasaAut}}</td>
                        <td>{{automobil.ukupnaOcena}}</td>
                        <td>{{automobil.predjenaKilometraza}}</td>
                        <td><button class=" btn-sm btn-outline-primary" v-on:click='showDetails(automobil.id)'> Detalji </button></td>
                        <td><button class=" btn-sm btn-outline-primary" v-on:click='makeReservation(automobil.id)'> Rezervisi </button></td>
                        <!--td><button class=" btn-sm btn-outline-primary" v-on:click='makeAd(automobil.id)'> Oglas </button></td-->
                        <!--td><button class="btn-sm btn-outline-primary" v-on:click='editCar(automobil.id)'> Uredi </button></td-->
                        <!--td> <button class="btn btn-sm btn-danger" v-on:click='deleteCar(automobil.id)'> Ukloni </button></td-->
                    </tr>
                </tbody>
            </table>

            <div id='options'>
                <router-link to="/cars/new"> <button class=' btn btn-lg classButton shadow'>+ Dodaj vozilo</button>
                </router-link>
                <router-link to="/carComments"> <button class='btn classButton shadow'>Komentari</button>
                </router-link>
                <router-link to="/reservations"> <button class='btn classButton shadow'>Rezervacije</button>
                </router-link>
            </div>
        
        </div>
    </div>
</template>

<script>
export default {
    data:function(){
        return {
            //sortiranje:
            currentSort: 'price',
            currentSortDir: 'asc',
            isSearch: true,
            searchedQuery: '?',
            searchedCar: {
                //Prilikom povezivanja preimenovati da odgovara nazivima atributa sa beka
                cenaMin:null,
                cenaMax:null,
                markaAut:null,
                modelAut:null,
                klasaAut:null,
                tipGoriva:null,
                tipMenjaca:null,
                brojSedZaDec:null,
                ColDmgWaiv:false,
                predjenaKilometraza:null
            },

            automobili:[
                {
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
                    images:[],
                },
                {
                    id:'2',
                    markaAut:'Mercedes',
                    modelAut:'R8',
                    klasaAut:'Old Tajmer',
                    vrstaGoriva:'dizel',
                    tipMenjaca:'manuelni',
                    ukupnaOcena:3,
                    brojSedistaZaDecu:2,
                    predjenaKilometraza:800,
                    collisionDamageWaiver:true,
                    images:[],
                },
                {
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
                    images:[],
                },
            ],

            //sortiranje:
            currentSort: 'ukupnaOcena',
            currentSortDir: 'asc',

            //sve treba da se getuje sa beka sa getAllMarka, GetAllModel... i smesti u ove promenljive
            markaAut:['BMW','Audi','Mercedes','Tesla','Fiat'],
            modelAut:['M5','R8','A6','A8','Punto','500L'],
            klasaAut:['SUV','Old Tajmer','Gradski auto'],
            tipGoriva:['benzin','dizel','plin','vodonik'], 
            tipMenjaca:['manuelni','automatksi','poluautomatski'],
            brojSedZaDec:null,
           
        }
    },
    methods:{        
        showDetails:function(id){
            this.$router.push(`/cars/${id}/details`);
        },

        editCar:function(id){
            this.$router.push(`/cars/${id}/edit`);
        },

        //obrisati
        makeReservation:function(id){
            // alert(`Za automobil id ${id} ce biti napravljena rezervacija!`);
            this.$router.push(`/cars/${id}/reservation`);
        },

        makeAd:function(id){
            // alert(`Za automobil id ${id} ce biti napravljena rezervacija!`);
            this.$router.push(`/ads/${id}/new`);
        },

        deleteCar:function(id){
            alert(`Automobils sa id ${id} ce biti obrisan!`);
        },

        // pomocna metoda za ogranicen odabir broja sedista za decu:
        range(start = 1, end) {
            var ans = [];
            for (let i = start; i <= end; i++) {
                ans.push(i);
            }
            return ans;
        },

        // metoda za koja salje parametre za pretragu automobila i vraca listu automobila kao rezultat
         searchCar() {
            console.log(`Trazite apartman:
            cenaMin: ${this.searchedCar.cenaMin}
            cenaMax: ${this.searchedCar.cenaMax}
            markaAut: ${this.searchedCar.markaAut}
            modelAut: ${this.searchedCar.modelAut}
            klasaAut: ${this.searchedCar.klasaAut}
            tipGoriva: ${this.searchedCar.tipGoriva}
            brojSedZaDec: ${this.searchedCar.brojSedZaDec}
            ColDmgWaiv: ${this.searchedCar.ColDmgWaiv}
            kilometraza: ${this.searchedCar.kilometraza}
            `);

            // console.log(this.dates);
            if (this.searchedCar.cenaMin !== null) {
                this.searchedQuery += '&cenaMin=' + this.searchedCar.cenaMin;
            }
            if (this.searchedCar.cenaMax !== null) {
                this.searchedQuery += '&cenaMax=' + this.searchedCar.cenaMax;
            }
            if (this.searchedCar.markaAut !== null) {
                this.searchedQuery += '&markaAut=' + this.searchedCar.markaAut;
            }
            if (this.searchedCar.modelAut !== null) {
                this.searchedQuery += '&modelAut=' + this.searchedCar.modelAut;
            }
            if (this.searchedCar.klasaAut) {
                this.searchedQuery += '&klasaAut=' + this.searchedCar.klasaAut;
            }
            if (this.searchedCar.tipGoriva !== null) {
                this.searchedQuery += '&tipGoriva=' + this.searchedCar.tipGoriva;
            }
            if (this.searchedCar.brojSedZaDec !== null) {
                this.searchedQuery += '&brojSedZaDec=' + this.searchedCar.brojSedZaDec;
            }
            if (this.searchedCar.ColDmgWaiv !== null) {
                this.searchedQuery += '&ColDmgWaiv=' + this.searchedCar.ColDmgWaiv;
            }
            if (this.searchedCar.kilometraza !== null) {
                this.searchedQuery += '&kilometraza=' + this.searchedCar.kilometraza;
            }

            //Ovo obrisati
            console.log(`SearchedQuery : ${this.searchedQuery}`);

            // axios
            //     .get('rest/apartment/search' + this.searchedQuery)
            //     .then(response => {
            //         this.apartments = response.data;
            //         this.searchedQuery = '?';
            //     });
        },

        // metoda za sortiranje 
        sort: function (s) {
            //if s == current sort, reverse
            if (s === this.currentSort) {
                this.currentSortDir = this.currentSortDir === 'asc' ? 'desc' : 'asc';
            }
            this.currentSort = s;
        },
    },
    computed: {
        sortiraniAutomobili: function () {
            return this.automobili.sort((a, b) => {
                let modifier = 1;
                if (this.currentSortDir === 'desc') modifier = -1;
                if (a[this.currentSort] < b[this.currentSort]) return -1 * modifier;
                if (a[this.currentSort] > b[this.currentSort]) return 1 * modifier;
                return 0;
            });
        },
    },
    created() {
        //prilikom kreiranja stranice opcija za broj sedista za decu se postavi na od 1 - 5;
        this.brojSedZaDec = this.range(0, 5);
    }
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

form{
    position: relative;
}

form #search_icon{
    position: absolute;
    right:15px;
    top:-15px;
}
</style>