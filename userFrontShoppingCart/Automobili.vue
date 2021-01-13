<template>
    <div id="automobili-overview">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Automobila</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        
        <div class='container ' id='search'>
            <nav class="navbar navbar-light bg-light justify-content-between">
                <a style='font-weight:bold;margin-top:10px;color:#35424a;' class="navbar-brand">Search</a>
                <form class="form-inline">
                    <div style='display:inline;'>
                        <div style="margin-top:20px" v-if='messages.errorDates' class="alert alert-danger" v-html="messages.errorDates"></div> 
                        <div id='first-row'  class="row">
                            <span class="col-xl-2 col-md-6 mb-3 marg-top">
                                <button style='margin-left:45px;margin-right:5px;' class='btn btn-outline-primary btn-clear' v-on:click="resetFilter()">Reset all</button>
                            </span>
                           
                            <span class="col-xl-2 col-md-6 marg-right">
                                <span class="span_search">Od</span>
                                <vuejsDatepicker  placeholder="Select Start Date"
                                    v-model="searchedCar.od" :highlighted="searchedCar" :disabled-dates="disabledDates">
                                </vuejsDatepicker>
                            </span>
                            <span class="col-xl-2 col-md-6 marg-right" >
                                <span class="span_search">Do</span>
                                <vuejsDatepicker  placeholder="Select End Date"
                                    v-model="searchedCar.do" :highlighted="searchedCar" :disabled-dates="disabledDates">
                                </vuejsDatepicker>
                            </span>

                            <span class="col-xl-2 col-md-6 mb-3">
                                <span class="span_search">Lokacija</span>
                                <input class="form-control mr-sm-2" type="text" placeholder="lokacija" aria-label="Search" v-model="searchedCar.lokacija">
                            </span>
                            <span class="col-xl-2 col-md-6 mb-3 marg-top" >
                                <button style="margin-left:90px;margin-top:150px" class="btn btn-outline-success my-2 my-sm-0" type="button" v-on:click.prevent='searchCar()'>Search</button>
                            </span>
                            <span id='searcIcon' class="col-xl-1 marg-top" style='margin-left:45px;'>
                                <img v-on:click='isSearch = !isSearch' src='../assets/searchIcon1.png' style="display:inline;">
                            </span>
                        </div>
                    </div>
                    <div style='display:inline; margin-top:5px;' v-show='isSearch' id="advanced_search">
                        <span style='margin-left:8%;margin-bottom:5%;'>
                            <span class="span_search">Marka</span>
                            <select style="padding:5px;" v-model="searchedCarShow.markaAut">
                                <option disabled value="">Marka automobila</option>
                                <!-- <option v-bind:key="marka" v-for="marka in markaAut">{{marka}}</option> -->
                                <option  v-bind:key="marka.id" v-on:click='addChoosenMarka(marka.id)' v-for="marka in markaAut">{{marka.nazivMarke}}</option> 
                            </select>
                        </span>

                        <div style='display:inline; margin-top:15px;' id='third_raw' >
                            <span style='margin-left:5%;margin-bottom:5%;'>
                                <span class="span_search">Model</span>
                                <select style="padding:5px;" v-model="searchedCarShow.modelAut">
                                    <option disabled value="">Model automobila</option>
                                    <!-- <option v-bind:key="model" v-for="model in modelAut">{{model}}</option> -->
                                    <option v-bind:key="model.id" v-on:click='addChoosenModel(model.id)' v-for="model in modelAutFilt">{{model.nazivModela}}</option>
                                </select>
                                   <small v-show='modelAutFilt.length == 0' style="color:red;">* prvo odaberite marku</small>
                                   <small v-show='modelAutFilt.length != 0' style="color:#fff;">* prvo odaberite marku</small>
                            </span>
                            
                            <span style='margin-left:2%;margin-bottom:5%;'>
                                <span class="span_search">Klasa</span>
                                <select style="padding:5px;" v-model="searchedCarShow.klasaAut">
                                    <option disabled value="">Klasa automobila</option>
                                    <!-- <option v-bind:key="klasa" v-for="klasa in klasaAut">{{klasa}}</option> -->
                                        <option v-bind:key="klasa.id" v-on:click='addChoosenKlasa(klasa.id)' v-for="klasa in klasaAut">{{klasa.nazivKlase}}</option>
                                </select>
                            </span>
                            <span style='margin-left:8%;margin-bottom:5%;'>
                                <span class="span_search">Tip menjaca</span>
                                <select style="margin-top:5px;padding:5px;" v-model="searchedCarShow.tipMenjaca">
                                    <option disabled value="">Tip menajca</option>
                                    <!-- <option v-bind:key="menjac" v-for="menjac in tipMenjaca">{{menjac}}</option> -->
                                    <option v-bind:key="menjac.id" v-on:click='addChoosenMenjac(menjac.id)'  v-for="menjac in tipMenjaca">{{menjac.nazivMenjaca}}</option>
                                </select>
                            </span>
                            <span style='margin-left:5%;margin-bottom:5%;'>
                                <span class="span_search">Tip goriva</span>
                                <select style="padding:5px;" v-model="searchedCarShow.tipGoriva">
                                    <option disabled value="">Tip goriva</option>
                                    <!-- <option v-bind:key="gorivo" v-for="gorivo in tipGoriva">{{gorivo}}</option> -->
                                    <option v-bind:key="gorivo.id" v-on:click='addChoosenGorivo(gorivo.id)' v-for="gorivo in tipGoriva">{{gorivo.nazivTipa}}</option> 
                                </select>
                            </span>
                            <span style='margin-left:2%;margin-bottom:5%;'>
                                <span class="span_search">Cena</span>
                                <input class="form-control mr-sm-2" type="text" placeholder="min cena" aria-label="Search" v-model="searchedCar.cenaMin">
                                <span style="padding-right:6px;" class="span_search"> - </span>
                                <input class="form-control mr-sm-2" type="text" placeholder="max cena" aria-label="Search" v-model="searchedCar.cenaMax">
                            </span>
                            <div id='fourth_raw' style='display:inline; margin-top:5px;'>
                                <span style='margin-left:8%;margin-bottom:5%;'>
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
                            </div><!--/fourth row-->
                        </div><!--/third row-->
                    </div><!--/advanced_search-->
                </form>
            </nav>
        </div>

        <!-- Page Content -->
        <div class="container" id='search-result'>
            <br>
            <div id='before_search' v-bind:class="{'marg-bot':!isAlreadySearched}">           
                <div id='textbs' v-if='!isAlreadySearched' > 
                    <h3><b>Pretraga automobila</b></h3>
                    <h4>Unesite <b>interval</b> u kojem želite da iznajmite automobil kao i željene karakteristike </h4>
                    <h4>i iznajmite <b>automobil</b> vaših snova...</h4>
                </div>

                <!-- <div id='cartbs' v-if='cartIsNotEmpty && !isAlreadySearched' >
                    <router-link to="/shoppingCart"><button class="arrow btn btn-lg btn-outline-dark">
                        Korpa
                    </button></router-link>
                </div> -->
            </div>

            <!-- Page Heading  v-if='isAlreadySearched==true'-->
            <h1 v-if='isAlreadySearched==true' class="my-4 theme-colr">
                <small >Rezultat pretrage</small>
            </h1>

            <div   id='sort'>
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
                
                <div id='cart'>
                    <img src="../assets/cartIcon2.png" alt="">
                    <router-link to="/shoppingCart"><button class="arrow btn btn-lg btn-outline-dark">
                        Korpa
                    </button></router-link>
                </div>
            </div>
            <br>
            <!-- Page Heading -->
            <div class="row" >
                <div class="col-lg-4 col-sm-6 mb-4" v-bind:key='oglas.id' v-for="oglas in sortedOglasi">
                <div class="card h-100">
                    <img id='overview-img' class="card-img-top" v-bind:src="oglas.automobil.slikeVozila.slika[0]" alt="" v-on:click='showDetails(oglas.automobil.id)'>
                    <div class="card-body">
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
                        <button v-if='isAlreadySearched==true' class="btn btn-outline-success margTop" v-on:click='addToCart(oglas)'> Dodaj u korpu </button>
                    </div>
                </div>
                </div>
            </div>
            <!-- /.row -->
        </div> <!-- /.container -->
    </div>
</template>

<script>
import StarRating from "vue-star-rating";
import Datepicker from 'vuejs-datepicker'
import UserDataService from '../services/UserDataService'
export default {
    name: 'UserAutomobil',
    data:function(){
        return {
            //za prikaz kada su oglasi prazni (obrisati kasnije)
            oglasip:[],
            isAlreadySearched:false,
            cartIsNotEmpty:false,
            //sortiranje:
            currentSort: 'cena',
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
                markaAutId:null,
                modelAutId:null,
                klasaAutId:null,
                tipGorivaId:null,
                tipMenjacaId:null,
                brojSedZaDec:null,
                ColDmgWaiv:null,
                predjenaKilometraza:null
            },
            oglasi:[        
            ],
            //sortiranje:
            currentSort: 'cena',
            currentSortDir: 'asc',
            //sve treba da se getuje sa beka sa getAllMarka, GetAllModel... i smesti u ove promenljive
            modelAutFilt:[], //filtrirani prikaz modela spram odabrane marke
            markaAut:[],
            modelAut:[],
            klasaAut:[],
            tipMenjaca:[],
            tipGoriva:[],

            //Pomocna promenljiva za prikaz naziva odabranih komponenti
            searchedCarShow:{
                markaAutId:null,
                modelAutId:null,
                klasaAutId:null,
                tipGorivaId:null,
                tipMenjacaId:null,
            },

            brojSedZaDec:null,

            messages: {
                errorAddress: '',
                errorPrice: '',
                errorPlannedCm: '',
                errorDates: '',
                errorResponse: '',
                successResponse: '',
            },
            odabraniDatum:{
                od: null,
                do: null
            },
            dates: {
                from: null,
                to: null
            },
            disabledDates: {
                to: null
            },
            korpa:[],
            userId:null,
           
        }
    },
    methods:{      
        getAllOglas:function(){
            UserDataService.getAllOglas().then(response => {
                this.oglasi = response.data;
                console.log(JSON.stringify(this.oglasi));
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

        resetFilter:function(){
            this.searchedCar.lokacija = "";
            this.searchedCar.od =  null;
            this.searchedCar.do =  null;
            this.searchedCar.cenaMin =  null;
            this.searchedCar.cenaMax =  null;
            this.searchedCar.markaAutId =  null;
            this.searchedCar.modelAutId =  null;
            this.searchedCar.klasaAutId =  null;
            this.searchedCar.tipGorivaId =  null;
            this.searchedCar.tipMenjacaId =  null;
            this.searchedCar.brojSedZaDec =  null;
            this.searchedCar.ColDmgWaiv =  null;
            this.searchedCar.predjenaKilometraza =  null;

            this.searchedCarShow.markaAut =  null;
            this.searchedCarShow.modelAut =  null;
            this.searchedCarShow.klasaAut =  null;
            this.searchedCarShow.tipGoriva =  null;
            this.searchedCarShow.tipMenjaca =  null;

            this.getAllOglas();
        },
        showDetails:function(id){
            this.$router.push(`/cars/${id}/details`);
        },
    
        // Pomocna metoda za ogranicen odabir broja sedista za decu:
        range(start = 1, end) {
            var ans = [];
            for (let i = start; i <= end; i++) {
                ans.push(i);
            }
            return ans;
        },
        
        // Metoda koja kreira objekat narudzbenice na osnovu prosledjenog oglasa 
        // i smesta je u korpu koja se zatim smesta u localStorage
        // kako bi se prikazala u korpi iz koje ce se proslediti na bek.
        addToCart(odabraniOglas){
            console.log('AddToCart');
            var narudzbenica = {
                oglasId:odabraniOglas.id,
                agentId:odabraniOglas.agentId,
                userId: this.userId,//idUSera koji je trenutno dodao oglas u korpu...
                odDatuma:this.odabraniDatum.od,
                doDatuma:this.odabraniDatum.do,
                //dodatno svi oni podaci koji mi trebaju da prikazem oglas onako kako je u korpi... vrv samo oglasId je dovoljno pa ga getujemo u created u korpi
            }
            console.log(JSON.stringify(narudzbenica));
            this.korpa.push(narudzbenica);
            // Put the object into storage
            localStorage.setItem('cart', JSON.stringify(this.korpa));
            alert('Dodali ste automobil u korpu!');
        },
        // Metoda za koja salje parametre za pretragu automobila i vraca listu automobila kao rezultat
         searchCar() {     
                    
            if (this.searchedCar.od == null) {
                this.messages.errorDates = `<h4>Morate odabrati početni termin oglasa!</h4>`;
                setTimeout(() => this.messages.errorDates = '', 5000);
            }
            else if (this.searchedCar.do == null) {
                this.messages.errorDates = `<h4>Morate odabrati krajnji termin oglasa!</h4>`;
                setTimeout(() => this.messages.errorDates = '', 5000);
            }
            else{
                // U slucaju da korisnik pritisne ResetAll Uklonio bi od i do iz this.searchedCar
                // Pa ako u tom momentu odluci da doda oglas u korpu prosledio bi prazne datume... 
                // Zato ih ovde cuvamo u odabraniDatum, da i nakon reseta budu dodati oglasi za zadnje unet interval.
                this.odabraniDatum.od = this.searchedCar.od;
                this.odabraniDatum.do = this.searchedCar.do;
                //Kada se jednom izvrsi pretraga, bila ona uspesna ili neuspesna uklanja se default prikaz stranice....
                this.isAlreadySearched = true;
  
                if (!!this.searchedCar.od) {
                    let od_datuma = this.searchedCar.od.getTime();
                    this.searchedQuery += 'od=' + od_datuma;
                }
                if (!!this.searchedCar.do) {
                    let do_datuma = this.searchedCar.do.getTime();
                    this.searchedQuery += '&do=' + do_datuma;
                }
                if (!!this.searchedCar.lokacija) {
                    this.searchedQuery += '&lokacija=' + this.searchedCar.lokacija;
                }
                if (!!this.searchedCar.cenaMin) {
                    this.searchedQuery += '&cenaMin=' + this.searchedCar.cenaMin;
                }
                if (!!this.searchedCar.cenaMax) {
                    this.searchedQuery += '&cenaMax=' + this.searchedCar.cenaMax;
                }
                if (!!this.searchedCar.markaAutId) {
                    this.searchedQuery += '&markaAut=' + this.searchedCar.markaAutId;
                }
                if (!!this.searchedCar.modelAutId) {
                    this.searchedQuery += '&modelAut=' + this.searchedCar.modelAutId;
                }
                if (!!this.searchedCar.klasaAutId) {
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
                
                UserDataService.searchOglas(this.searchedQuery).then(response => {
                    this.oglasi = response.data;
                    this.searchedQuery = '?';
                }).catch(error =>{
                    if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokusajte ponovo kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
            
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
        //Ova metoda stalno vrsi poredjenje izmedju oglasa po kriterijumu koji se prosledi klikom na kolonu;
        //Prvo se proveri da li je smer sortiranja rastuci ili opadajuci za this.currentSortDir i onda se poredi svaki oglas po prosledjenom 
        //kriterijumu tj po this.currentSort
        sortedOglasi: function () {
            console.log('Usao u sorted oglasi');
            console.log(JSON.stringify(this.oglasi));
            return this.oglasi.sort((oglas1, oglas2) => {
                let modifier = 1;
                if (this.currentSortDir === 'desc') modifier = -1;
                if(this.currentSort == 'cena'){
                    console.log('Usao u cena');
                    if (oglas1.cenovnik.cenaPoDanu < oglas2.cenovnik.cenaPoDanu) return -1 * modifier;
                    if (oglas1.cenovnik.cenaPoDanu > oglas2.cenovnik.cenaPoDanu) return 1 * modifier;
                    return 0;
                }
                if(this.currentSort == 'ocena'){
                    console.log('Usao u ocena');
                    if (oglas1.automobil.ukupnaOcena < oglas2.automobil.ukupnaOcena) return -1 * modifier;
                    if (oglas1.automobil.ukupnaOcena > oglas2.automobil.ukupnaOcena) return 1 * modifier;
                    return 0;
                }
                if(this.currentSort == 'predjenaKilometraza'){
                    console.log('Usao u pk');
                    if (oglas1.automobil.predjenaKilometraza < oglas2.automobil.predjenaKilometraza) return -1 * modifier;
                    if (oglas1.automobil.predjenaKilometraza > oglas2.automobil.predjenaKilometraza) return 1 * modifier;
                    return 0;
                }
       
            });
        },
    },
    created() {
        if(JSON.parse(localStorage.getItem('token')) == null){
           this.$router.push(`/login`);
        }
        else{        
            //prilikom kreiranja stranice opcija za broj sedista za decu se postavi na od 1 - 5;
            this.brojSedZaDec = this.range(0, 5);
            // Preuzimanje objekta korpa iz localStorage
            if(JSON.parse(localStorage.getItem('cart'))== null){
                this.korpa = [];
            }
            else{
                this.cartIsNotEmpty = true;
                this.korpa = JSON.parse(localStorage.getItem('cart'));
            }
            

            let parsToken =  JSON.parse(localStorage.getItem('parsToken'));
            this.userId = parsToken.jti;
            console.log('Ulogovani user: ' + this.userId);
            // dobavljanje svih sifrarnika
            this.getAllOptions();
            this.getAllOglas();
        }
    },
    mounted() {
        let to = new Date();
        to.setDate(to.getDate() - 1)
        this.disabledDates.to = to;
    },
    components: {
        vuejsDatepicker:Datepicker,
        "star-rating": StarRating,
    },
}
</script>

<style scoped>
#titleEffect{
  color:#FF8C00;;
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
  background-color:#FF8C00;;
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
.marg-bot{
    margin-bottom: 150px;
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
#before_search{
    position: relative;
}
#before_search #textbs{
    position: absolute;
    left:2px;
    width:80%;
    padding:5px;
}
#before_search #cartbs{
    position: absolute;
    right:2px;
    top:35px;
    width:15%;
    padding:5px;
}

.card-img-top:hover{
    cursor: pointer;
}
</style>