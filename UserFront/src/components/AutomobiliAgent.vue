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
                                <span class="col-xl-3 col-md-6 mb-1">
                                    <span class="span_search">Marka</span>
                                    <select style="padding:5px;" v-model="searchedCarShow.markaAut">
                                        <option disabled value="">Marka automobila</option>
                                        <option  v-bind:key="marka.id" v-on:click='addChoosenMarka(marka.id)' v-for="marka in markaAut">{{marka.nazivMarke}}</option> 
                                    </select>
                                </span>
                                <span class="col-xl-3 col-md-6 mb-3"> 
                                    <span class="span_search">Model</span>
                                    <select style="padding:5px;" v-model="searchedCarShow.modelAut">
                                        <option disabled value="">Model automobila</option>
                                        <option v-bind:key="model.id" v-on:click='addChoosenModel(model.id)' v-for="model in modelAutFilt">{{model.nazivModela}}</option>
                                    </select>
                                </span>
                                <small v-if='modelAutFilt.length == 0' style="color:red;">* prvo odaberite marku</small>
                   
                                <div style='display:inline;' id='third_raw'>
                                    <span style='margin-left:7%;margin-bottom:5%;'>   
                                        <span class="span_search">Klasa</span>
                                        <select style="padding:5px;" v-model="searchedCarShow.klasaAut">
                                            <option disabled value="">Klasa automobila</option>
                                            <option v-bind:key="klasa.id" v-on:click='addChoosenKlasa(klasa.id)' v-for="klasa in klasaAut">{{klasa.nazivKlase}}</option>
                                        </select>
                                    </span>
                                    <span style='margin-left:8%;margin-right:8%;margin-bottom:5%;'>
                                        <span class="span_search">Tip menjaca</span>
                                        <select style="padding:5px;" v-model="searchedCarShow.tipMenjaca">
                                            <option disabled value="">Tip menajca</option>
                                            <option v-bind:key="menjac.id" v-on:click='addChoosenMenjac(menjac.id)'  v-for="menjac in tipMenjaca">{{menjac.nazivMenjaca}}</option>
                                        </select>
                                    </span>
                                    <span style='margin-right:8%;margin-bottom:5%;'>
                                        <span class="span_search">Tip goriva</span>
                                        <select style="padding:5px;" v-model="searchedCarShow.tipGoriva">
                                            <option disabled value="">Tip goriva</option>
                                            <option v-bind:key="gorivo.id" v-on:click='addChoosenGorivo(gorivo.id)' v-for="gorivo in tipGoriva">{{gorivo.nazivTipa}}</option> 
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
                        <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
		    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>  
                </form>
            </nav>
        </div>
        
        <div class="container" id='main'>
            <h2 v-if='NoOfAds()'>Broj Vaših oglasa je <span id='titleEffect'>{{this.noOfAds}}</span>! Ne možete napraviti novi oglas...</h2> 
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
                        <th>Oglas</th>
                        <th>Uredi</th>
                        <th>Ukloni</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='automobil.id' v-for="automobil in sortiraniAutomobili">
                        <td>{{automobil.markaAut}}</td>
                        <td>{{automobil.modelAut}}</td>
                        <td>{{automobil.klasaAut}}</td>
                        <td>{{automobil.ukupnaOcena}}</td>
                        <td>{{automobil.predjenaKilometraza}}</td>
                        <td><button class="btn-sm btn-outline-primary" v-on:click='showDetails(automobil.id)'> Detalji </button></td>
                        <td><button class="btn-sm btn-outline-primary" v-on:click='makeAd(automobil.id)' :disabled='NoOfAds()'> Oglas </button></td>
                        <td><button class="btn-sm btn-outline-primary" v-on:click='editCar(automobil.id)'> Izmeni </button></td><!--Delete mozda moze i preko edita da na toj str. bude jedno dugme-->
                        <td><button class="btn btn-sm btn-danger" v-on:click='deleteCar(automobil.id)'> Ukloni </button></td>
                    </tr>
                </tbody>
            </table>
            <div id='options'>
                <router-link to="/carsAgent/new"> <button :disabled='btnEnabled' class=' btn btn-lg classButton shadow'>+ Dodaj vozilo</button>
                </router-link>
                <router-link to="/carsAgent/comments"> <button class='btn classButton shadow'>Komentari</button>
                </router-link>
                <router-link to="/reservations"> <button class='btn classButton shadow'>Rezervacije</button>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
export default {
    name: 'AutomobiliAgent',
    data:function(){
        return {
            //sortiranje:
            currentSort: 'price',
            currentSortDir: 'asc',
            isSearch: true,
            searchedQuery: '?',
            searchedCar: {
                markaAutId:null,
                modelAutId:null,
                klasaAutId:null,
                tipGorivaId:null,
                tipMenjacaId:null,
                brojSedZaDec:null,
                ColDmgWaiv:null,
                predjenaKilometraza:null
            },

            //Pomocna promenljiva za prikaz naziva odabranih komponenti
            searchedCarShow:{
                markaAut:null,
                modelAut:null,
                klasaAut:null,
                tipGoriva:null,
                tipMenjaca:null,
            },
            messages: {
                errorResponse: '',
                successResponse: '',
            },
            automobili:[],

            //sortiranje:
            currentSort: 'ukupnaOcena',
            currentSortDir: 'asc',
            markaAut:[],
            modelAut:[],
            modelAutFilt:[], //filtrirani prikaz modela spram odabrane marke
            klasaAut:[],
            tipGoriva:[], 
            tipMenjaca:[],
            brojSedZaDec:null,

            noOfAds:null,
            permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
            },
            btnEnabled:false
        }
    },
    methods:{
        getAutomobiliList:function(){
            UserDataService.getAllAutomobiliAgent().then(response => {
                this.automobili = response.data;
            });
        },
        getAllOptions:function(){
            UserDataService.getAllMarkaAut().then(response => {
                this.markaAut = response.data;
            });
            UserDataService.getAllModelAut().then(response => {
                this.modelAut = response.data;
            });
            UserDataService.getAllKlasaAut().then(response => {
                this.klasaAut = response.data;
            });
            UserDataService.getAllTipMenjaca().then(response => {
                this.tipMenjaca = response.data;
            });
            UserDataService.getAllTipGoriva().then(response => {
                this.tipGoriva = response.data;
            });
        },

        getAllPermissions:function(){
            UserDataService.getAllPermissions().then(response => {
               this.permissions = response.data;
               //this.permissions.status = response.data[3]
               if(this.permissions.status != "aktivan"){
                   console.log("NALOG NIJE AKTIVAN")
                   this.btnEnabled = true
               }
               else{
                   console.log("Nalog je AKTIVAN")
               }
               console.log(JSON.stringify(this.permissions));
            });
        },

        getNoOfUsersAds:function(){
            UserDataService.getNoOfUsersAds().then(response => {
                this.noOfAds = response.data;
            });
        },

        addChoosenMarka:function(id){
            console.log("Usao u addChoosenMarka " + id);
            this.searchedCar.markaAutId = id;
            this.modelAutFilt = [];
            for(let i = 0; i < this.modelAut.length; i++){
                if(this.modelAut[i].markaAutomobilaId == id){
                    console.log('nasao poklapanje');
                    console.log('id: ' + id);
                    console.log('model.markaAutomobilaId: ' + this.modelAut[i].markaAutomobilaId);
                    this.modelAutFilt.push(this.modelAut[i]);
                }
            }
        },
        addChoosenModel:function(id){
            console.log("Usao u addChoosenModel " + id);
            this.searchedCar.modelAutId = id;
        },
        addChoosenKlasa:function(id){
            console.log("Usao u addChoosenMarka " + id);
            this.searchedCar.klasaAutId = id;
        },
        addChoosenMenjac:function(id){
            console.log("Usao u addChoosenMenjac " + id);
            this.searchedCar.tipMenjacaId = id;
        },
        addChoosenGorivo:function(id){
            console.log("Usao u addChoosenGorivo " + id);
            this.searchedCar.tipGorivaId = id;
        },
        
        showDetails:function(id){
            this.$router.push(`/cars/${id}/details`);
        },

        editCar:function(id){
            this.$router.push(`/cars/${id}/edit`);
        },

        //obrisati
        makeReseravation:function(id){
            // alert(`Za automobil id ${id} ce biti napravljena rezervacija!`);
            this.$router.push(`/cars/${id}/reservation`);
        },

        makeAd:function(id){
            // alert(`Za automobil id ${id} ce biti napravljena rezervacija!`);
            this.$router.push(`/ads/${id}/new`);
        },

        deleteCar:function(id){
            if(confirm("Da li ste sigurni da želite obrisati ovaj automobil?")){
                UserDataService.deleteAutomobil(id).then(response => {
                    this.getAutomobiliList();
                }).catch(error => {
                    if(error.response.data === 'There are ads connected to this car!'){
                        this.messages.errorResponse = `<h4>Ne možete obrisati ovaj automobil jer postoji oglas napravljen za njega!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
        },

        //Pomocna metoda za ogranicen odabir broja sedista za decu:
        range(start = 1, end) {
            var ans = [];
            for (let i = start; i <= end; i++) {
                ans.push(i);
            }
            return ans;
        },

        NoOfAds(){
            //Sme samo 3 oglasa da napravi zato je stavljen prag
            //da za jedan vise radi disabled 
            console.log('this.noOfAds: ' + this.noOfAds);
            if(this.noOfAds < 3){
                return false;
            }else{
                return true;
            }         
        },

        resetFilter:function(){
            this.searchedCar.markaAutId =  null;
            this.searchedCar.modelAutId =  null;
            this.searchedCar.klasaAutId =  null;
            this.searchedCar.tipGorivaId =  null;
            this.searchedCar.tipMenjacaId =  null;
            this.searchedCar.brojSedZaDec =  null;
            this.searchedCar.ColDmgWaiv =  null;
            this.searchedCar.predjenaKilometraza =  null;
            this.modelAutFilt = []
            this.searchedCarShow.markaAut =  null;
            this.searchedCarShow.modelAut =  null;
            this.searchedCarShow.klasaAut =  null;
            this.searchedCarShow.tipGoriva =  null;
            this.searchedCarShow.tipMenjaca =  null;
        
            this.getAutomobiliList();
        },

        //Metoda za koja salje parametre za pretragu automobila i vraca listu automobila kao rezultat
        searchCar() {
            console.log(`Trazite vozilo:
            markaAut: ${this.searchedCar.markaAutId}
            modelAut: ${this.searchedCar.modelAutId}
            klasaAut: ${this.searchedCar.klasaAutId}
            tipMenjac: ${this.searchedCar.tipMenjacaId}
            tipGoriva: ${this.searchedCar.tipGorivaId}
            brojSedZaDec: ${this.searchedCar.brojSedZaDec}
            ColDmgWaiv: ${this.searchedCar.ColDmgWaiv}
            kilometraza: ${this.searchedCar.predjenaKilometraza}
            `);

            if (!!this.searchedCar.markaAutId) {
                this.searchedQuery += 'markaAut=' + this.searchedCar.markaAutId;
            }
            if (!!this.searchedCar.modelAutId) {
                this.searchedQuery += '&modelAut=' + this.searchedCar.modelAutId;
            }
            if (!!this.searchedCar.klasaAutId) {
                console.log(this.searchedCar.klasaAut);
                this.searchedQuery += '&klasaAut=' + this.searchedCar.klasaAutId;
            }
            if (!!this.searchedCar.tipMenjacaId) {
                this.searchedQuery += '&tipMenjaca=' + this.searchedCar.tipMenjacaId;
            }
            if (!!this.searchedCar.tipGorivaId) {
                this.searchedQuery += '&tipGoriva=' + this.searchedCar.tipGorivaId;
            }
            if (!!this.searchedCar.brojSedZaDec) {
                this.searchedQuery += '&brojSedZaDec=' + this.searchedCar.brojSedZaDec;
            }
            if (!!this.searchedCar.ColDmgWaiv) {
                this.searchedQuery += '&ColDmgWaiv=' + this.searchedCar.ColDmgWaiv;
            }
            if (!!this.searchedCar.predjenaKilometraza) {
                this.searchedQuery += '&kilometraza=' + this.searchedCar.predjenaKilometraza;
            }

            //Ovo obrisati
            console.log(`SearchedQuery : ${this.searchedQuery}`);
            
            UserDataService.searchAgentModeCar(this.searchedQuery).then(response => {
                this.automobili = response.data;
                this.searchedQuery = '?';
            }).catch(error =>{
                if (error.response.status === 500 || error.response.status === 404) {
                    this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokusajte ponovo kasnije!</h4>`;
                    setTimeout(() => this.messages.errorResponse = '', 5000);
                }
            });
        },
        //Metoda za sortiranje 
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
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.brojSedZaDec = this.range(0, 5);
            this.getAutomobiliList();
            this.getAllOptions();
            this.getNoOfUsersAds();
            this.getAllPermissions();
        }
    }
}
</script>

<style scoped>

#titleEffect{
  color:#FF8C00;
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
  background-color:#FF8C00;
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