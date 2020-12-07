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
                    <div style='display:inline;'>
                        <div id='first-row' class="row">

                            <span class="span_search">Od</span>
                            <!-- <vuejsDatepicker placeholder="Select Start Date"
                                v-model="searchedCar.od" :highlighted="searchedCar" :disabled-dates="disabledDates">
                            </vuejsDatepicker> -->
                            <input type="date" v-model="searchedCar.od">

                            <span class="span_search"> - Do</span>
                            <!-- <vuejsDatepicker placeholder="Select End Date"
                                v-model="searchedCar.do" :highlighted="searchedCar" :disabled-dates="disabledDates">
                            </vuejsDatepicker> -->
                            <input type="date" v-model="searchedCar.do">

                            <span class="span_search">Lokacija</span>
                            <input class="form-control mr-sm-2" type="text" placeholder="lokacija" aria-label="Search" v-model="searchedCar.lokacija">
                            <button style="margin-left: 5px;" class="btn btn-outline-success my-2 my-sm-0" type="button" v-on:click.prevent='searchCar()'>Search</button>
                        </div>

                    </div>
                    <div style="margin-right: 20px;" id='search_icon'>
                        <span style='display:inline; margin: 15px;'>
                            <img v-on:click='isSearch = !isSearch' src='../assets/searchIcon1.png' style="display:inline;">
                        </span>
                    </div>

                    <div style='display:inline;' v-show='isSearch' id="advanced_search">
                        <div id='second-row' class="row" style="margin-top:5px;">
                            <span class="span_search">Cena</span>
                            <input class="form-control mr-sm-2" type="text" placeholder="min cena" aria-label="Search" v-model="searchedCar.cenaMin">
                            <span style="padding-right:6px;" class="span_search"> - </span>
                            <input class="form-control mr-sm-2" type="text" placeholder="max cena" aria-label="Search" v-model="searchedCar.cenaMax">
                         
                            
                            <span class="span_search">Marka</span>
                            <select style="padding:5px;" v-model="searchedCar.markaAut">
                                <option disabled value="">Marka automobila</option>
                                <option v-bind:key="marka" v-for="marka in markaAut">{{marka}}</option>
                            </select>

                            <span class="span_search">Model</span>
                            <select style="padding:5px;" v-model="searchedCar.modelAut">
                                <option disabled value="">Model automobila</option>
                                <option v-bind:key="model" v-for="model in modelAut">{{model}}</option>
                            </select>

                            <div style='display:inline;' id='third_raw'>
                                <span class="span_search">Klasa</span>
                                <select style="padding:5px;" v-model="searchedCar.klasaAut">
                                    <option disabled value="">Klasa automobila</option>
                                    <option v-bind:key="klasa" v-for="klasa in klasaAut">{{klasa}}</option>
                                </select>
                           
                                <span class="span_search">Tip menjaca</span>
                                <select style="padding:5px;" v-model="searchedCar.tipMenjaca">
                                    <option disabled value="">Tip menajca</option>
                                    <option v-bind:key="menjac" v-for="menjac in tipMenjaca">{{menjac}}</option>
                                </select>

                                <span class="span_search">Tip goriva</span>
                                <select style="padding:5px;" v-model="searchedCar.tipGoriva">
                                    <option disabled value="">Tip goriva</option>
                                    <option v-bind:key="gorivo" v-for="gorivo in tipGoriva">{{gorivo}}</option>
                                </select>
                                
                                <div id='fourth_raw'>
                                    <span class="span_search">Decija sedista</span>
                                    <select style="padding:5px;" v-model="searchedCar.brojSedZaDec">
                                        <option disabled value="">Br. sed. za decu</option>
                                        <option v-bind:key="bszd" v-for="bszd in brojSedZaDec">{{bszd}}</option>
                                    </select>      

                                    <span class="span_search">Predjena km</span>
                                    <input class="form-control mr-sm-2" type="text" placeholder="Kilometraza" aria-label="Search" v-model="searchedCar.predjenaKilometraza">  
                                    
                                    <span>
                                        <span class="span_search">Coll Ddmg Waiver</span>
                                        <input type="radio" v-model="searchedCar.ColDmgWaiv" required value="true"> True
                                        <input type="radio" v-model="searchedCar.ColDmgWaiv" required value="false"> False
                                    </span>
                              
                                </div> <!--/fourth_row-->
                            </div> <!--/third_row-->
                        </div><!--/second_row-->
                    </div><!--/advanced_search-->
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
                        <th @click="sort('ocena')" class="arrow"> Ocena
                            <img v-if='currentSortDir == "asc" && currentSort== "ocena"' src='../assets/up-arrow1.1.png'>
                            <img v-if='currentSortDir == "desc" && currentSort== "ocena" ' src='../assets/down-arrow1.1.png'>
                        </th>
                        <th @click="sort('cena')" class="arrow"> Cena
                            <img v-if='currentSortDir == "asc"  && currentSort== "cena"' src='../assets/up-arrow1.1.png'>
                            <img v-if='currentSortDir == "desc"  && currentSort== "cena"' src='../assets/down-arrow1.1.png'>
                        </th>
                         <th @click="sort('predjenaKilometraza')" class="arrow"> Kilometraza
                            <img v-if='currentSortDir == "asc"  && currentSort== "predjenaKilometraza"' src='../assets/up-arrow1.1.png'>
                            <img v-if='currentSortDir == "desc"  && currentSort== "predjenaKilometraza"' src='../assets/down-arrow1.1.png'>
                        </th>
                        <th>Detalji</th>
                        <th>Reservisi</th>
                        <th>Oglas</th>
                        <th>Uredi</th>
                        <th>Ukloni</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='car.id' v-for="car in sortedCars">
                        <td>{{car.markaAut}}</td>
                        <td>{{car.modelAut}}</td>
                        <td>{{car.klasaAut}}</td>
                        <td>{{car.ocena}}</td>
                        <td>{{car.cena}}</td>
                        <td>{{car.predjenaKilometraza }}</td>
                        <td><button class=" btn-sm btn-outline-primary" v-on:click='showDetails(car.id)'> Detalji </button></td>
                        <td><button class=" btn-sm btn-outline-primary" v-on:click='makeReseravation(car.id)'> Reservisi </button></td>
                        <td><button class=" btn-sm btn-outline-primary" v-on:click='makeAd(car.id)'> Oglas </button></td>
                        <td><button class="btn-sm btn-outline-primary" v-on:click='editCar(car.id)'> Uredi </button></td><!--Delete mozda moze i preko edita da na toj str. bude jedno dugme-->
                        <td> <button class="btn btn-sm btn-danger" v-on:click='deleteCar(car.id)'> Ukloni </button></td>
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
    name: 'Footer',
    data:function(){
        return {
            //sortiranje:
            currentSort: 'price',
            currentSortDir: 'asc',
            isSearch: true,
            searchedQuery: '?',
            searchedCar: {
                //Prilikom povezivanja preimenovati da odgovara nazivima atributa sa beka
                lokacija: "",
                od: null,
                do: null,
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

            cars: [
                {
                    id:'1',
                    markaAut:'BMW',
                    modelAut:'M5',
                    klasaAut:'SUV',
                    ocena:5,
                    cena:2500,
                    // cenovnik:{ //umesto cene
                    //     id:1,
                    //     cenaPoDanu:2500
                    // }
                    predjenaKilometraza:500,
                },
                {
                    id:'2',
                    markaAut:'Mercedes',
                    modelAut:'R8',
                    klasaAut:'Old Tajmer',
                    ocena:3,
                    cena:1200,
                    predjenaKilometraza:800,
                },
                 {
                    id:'3',
                    markaAut:'Audi',
                    modelAut:'A6',
                    klasaAut:'Gradski auto',
                    ocena:4,
                    cena:1800,
                    predjenaKilometraza:650,
                },
            ],

            //sortiranje:
            currentSort: 'cena',
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

        
        makeReseravation:function(id){
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
            lokacija: ${this.searchedCar.lokacija}
            od: ${this.searchedCar.od}
            do: ${this.searchedCar.do}
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
            if (this.searchedCar.lokacija !== null) {
                this.searchedQuery += 'lokacija=' + this.searchedCar.lokacija;
            }
            if (this.searchedCar.od != null) {
                // let od_datuma = this.searchedCar.od.getTime();
                let od_datuma = this.searchedCar.od;
                this.searchedQuery += '&od=' + od_datuma;
            }
            if (this.searchedCar.do != null) {
                // let do_datuma = this.searchedCar.do.getTime();
                let do_datuma = this.searchedCar.do;
                this.searchedQuery += '&do=' + do_datuma;
            }


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
        sortedCars: function () {
            return this.cars.sort((a, b) => {
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

</style>