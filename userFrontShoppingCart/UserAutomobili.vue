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
                                <img v-on:click='isSearch = !isSearch' src='../../assets/searchIcon1.png' style="display:inline;">
                            </span>
                        </div>
                    </div>
                    <div style='display:inline; margin-top:5px;' v-show='isSearch' id="advanced_search">
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

                        <div style='display:inline; margin-top:15px;' id='third_raw' >
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

                            <div id='fourth_raw' style='display:inline; margin-top:5px;'>
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

                <div id='cartbs' v-if='cartIsNotEmpty && !isAlreadySearched' >
                        <img src="../../assets/cartIcon2.png" alt="">
                        <router-link to="/userTest/shopping_cart"><button class="arrow btn btn-lg btn-outline-dark">
                            Korpa
                        </button></router-link>
                </div>
            </div>

            <!-- Page Heading -->
            <h1 v-if='isAlreadySearched==true' class="my-4 theme-colr">
                <small >Rezultat pretrage</small>
            </h1>

            <div  v-if='isAlreadySearched==true' id='sort'>
                <h5 class='theme-colr'><small> <b>Sortiraj:</b>  </small></h5>
                <button @click="sort('ocena')" class="arrow btn btn-lg btn-outline-primary"> Ocena
                    <img v-if='currentSortDir == "asc" && currentSort== "ocena"' src='../../assets/up-arrow1.1.png'>
                    <img v-if='currentSortDir == "desc" && currentSort== "ocena" ' src='../../assets/down-arrow1.1.png'>
                </button>
                <button @click="sort('cena')" class="arrow btn btn-lg btn-outline-primary"> Cena
                    <img v-if='currentSortDir == "asc"  && currentSort== "cena"' src='../../assets/up-arrow1.1.png'>
                    <img v-if='currentSortDir == "desc"  && currentSort== "cena"' src='../../assets/down-arrow1.1.png'>
                </button>
                <button @click="sort('predjenaKilometraza')" class="arrow btn btn-lg btn-outline-primary"> Kilometraza
                    <img v-if='currentSortDir == "asc"  && currentSort== "predjenaKilometraza"' src='../../assets/up-arrow1.1.png'>
                    <img v-if='currentSortDir == "desc"  && currentSort== "predjenaKilometraza"' src='../../assets/down-arrow1.1.png'>
                </button>
                
                <div id='cart'>
                    <img src="../../assets/cartIcon2.png" alt="">
                    <router-link to="/userTest/shopping_cart"><button class="arrow btn btn-lg btn-outline-dark">
                        Korpa
                    </button></router-link>
                </div>
            </div>
            <br>
            <!-- Page Heading -->
            <div class="row" >
                <div class="col-lg-4 col-sm-6 mb-4" v-bind:key='oglas.id' v-for="oglas in sortedOglasi">
                <div class="card h-100">
                    <img id='overview-img' class="card-img-top" v-bind:src="oglas.automobil.images[0]" alt="">
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

            <!-- Pagination ?????-->
            <!-- <ul class="pagination justify-content-center">
                <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
                <li class="page-item">
                <a class="page-link" href="#">1</a>
                </li>
                <li class="page-item">
                <a class="page-link" href="#">2</a>
                </li>
                <li class="page-item">
                <a class="page-link" href="#">3</a>
                </li>
                <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul> -->

        </div> <!-- /.container -->
    </div>
</template>

<script>
import Datepicker from 'vuejs-datepicker'
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
                markaAut:null,
                modelAut:null,
                klasaAut:null,
                tipGoriva:null,
                tipMenjaca:null,
                brojSedZaDec:null,
                ColDmgWaiv:false,
                predjenaKilometraza:null
            },

            oglasi:[
                {
                    //oglas
                    id:1,
                    odDatuma:'25.5.2020',
                    doDatuma:'25.6.2020',
                    TAdresa:{
                        mesto:'Novi Sad',
                        ulica:'9. Marta',
                        broj:'bb',
                        postanskiBroj:'21000',
                    },
                    planiranaKilometraza:2000,
                    agentId:1,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                    korisnickoIme:'This host',  //u DTOu za korisnika koji je kreirao oglas.
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
                        images:['https://source.unsplash.com/RCAhiGJsUUE/1920x1080','https://source.unsplash.com/wfh8dDlNFOk/1920x1080','https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                    
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
                    TAdresa:{
                        mesto:'Beograd',
                        ulica:'Ne znanog i znanog junaka',
                        broj:'bb',
                        postanskiBroj:'11000',
                        longitude:'21.23',
                        latitude:'34.14',
                    },
                    planiranaKilometraza:2500,
                    agentId:2,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                    korisnickoIme:'Other host', //u DTOu za korisnika koji je kreirao oglas.
                    //Oglas/Automobil
                    automobil:{
                        id:1,
                        markaAut:'Audi',
                        modelAut:'A6',
                        klasaAut:'Gradski',
                        vrstaGoriva:'dizel',
                        tipMenjaca:'manuelni',
                        predjenaKilometraza:4500,
                        ukupnaOcena:4.25,
                        collisionDamageWaiver:true,
                        brojSedistaZaDecu:1,
                        images:['https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                    },
                    //Oglas/Cenovnik
                    cenovnik:{ 
                        id:'2',
                        cenaPoDanu:500,
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
                    TAdresa:{
                        mesto:'Novi Sad',
                        ulica:'19. Juna',
                        broj:'45',
                        postanskiBroj:'11000',
                        longitude:'12',
                        latitude:'21',
                    },
                    planiranaKilometraza:3000,
                    agentId:1,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                    korisnickoIme:'This host',  //u DTOu za korisnika koji je kreirao oglas.
                    //automobil
                    automobil:{
                        id:'3',
                        markaAut:'Audi',
                        modelAut:'A6',
                        klasaAut:'Gradski auto',
                        vrstaGoriva:'dizel',
                        tipMenjaca:'manuelni',
                        ukupnaOcena:3.12,
                        brojSedistaZaDecu:2,
                        predjenaKilometraza:12500,
                        collisionDamageWaiver:false,
                        images:['https://source.unsplash.com/wfh8dDlNFOk/1920x1080','https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                    },
                    cenovnik:{
                        id:'3',
                        cenaPoDanu:300,
                        nazivCenovnika:'Cenovnik 3',
                        popustZaPreko30Dana:null,
                        cenaCollisionDamageWaiver:3000,
                        cenaPoKilometru:30
                    },
                },
                {
                    //oglas
                    id:4,
                    odDatuma:'25.5.2020',
                    doDatuma:'25.6.2020',
                    TAdresa:{
                        mesto:'Novi Sad',
                        ulica:'9. Marta',
                        broj:'bb',
                        postanskiBroj:'21000',
                        longitude:'45',
                        latitude:'54',
                    },
                    planiranaKilometraza:2000,
                    agentId:2,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                    korisnickoIme:'Other host', //u DTOu za korisnika koji je kreirao oglas.
                    //automobil
                    automobil:{
                        id:'1',
                        markaAut:'BMW',
                        modelAut:'M5',
                        klasaAut:'SUV',
                        vrstaGoriva:'dizel',
                        tipMenjaca:'manuelni',
                        ukupnaOcena:2,
                        brojSedistaZaDecu:1,
                        predjenaKilometraza:12000,
                        collisionDamageWaiver:true,
                        images:['https://source.unsplash.com/RCAhiGJsUUE/1920x1080','https://source.unsplash.com/wfh8dDlNFOk/1920x1080','https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                    },
                    //cena    
                    cenovnik:{
                        id:'1',
                        cenaPoDanu:80,
                        nazivCenovnika:'Cenovnik 1',
                        popustZaPreko30Dana:'10%',
                        cenaCollisionDamageWaiver:1000,
                        cenaPoKilometru:10
                        
                    },
                },
                {
                    //oglas
                    id:5,
                    odDatuma:'18.6.2020',
                    doDatuma:'25.7.2020',
                    TAdresa:{
                        mesto:'Beograd',
                        ulica:'Ne znanog i znanog junaka',
                        broj:'bb',
                        postanskiBroj:'11000',
                        longitude:'21.23',
                        latitude:'34.14',
                    },
                    planiranaKilometraza:2500,
                    agentId:3,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                    korisnickoIme:'Some totlay other host', //u DTOu za korisnika koji je kreirao oglas.
                    //Oglas/Automobil
                    automobil:{
                        id:1,
                        markaAut:'Fiat',
                        modelAut:'Punot',
                        klasaAut:'Gradski',
                        vrstaGoriva:'Benzin',
                        tipMenjaca:'manuelni',
                        predjenaKilometraza:4800,
                        ukupnaOcena:3.2,
                        collisionDamageWaiver:true,
                        brojSedistaZaDecu:1,
                        images:['https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                    },
                    //Oglas/Cenovnik
                    cenovnik:{ 
                        id:'2',
                        cenaPoDanu:1200,
                        nazivCenovnika:'Cenovnik 2',
                        popustZaPreko30Dana:'20%',
                        cenaCollisionDamageWaiver:null,
                        cenaPoKilometru:20
                    },
                },
                {
                    //oglas
                    id:6,
                    odDatuma:'25.5.2020',
                    doDatuma:'15.6.2020',
                    TAdresa:{
                        mesto:'Novi Sad',
                        ulica:'19. Juna',
                        broj:'45',
                        postanskiBroj:'11000',
                        longitude:'12',
                        latitude:'21',
                    },
                    planiranaKilometraza:3000,
                    agentId:3,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                    korisnickoIme:'Some totlay other host', //u DTOu za korisnika koji je kreirao oglas.
                    //automobil
                    automobil:{
                        id:'3',
                        markaAut:'Fiat',
                        modelAut:'500L',
                        klasaAut:'Gradski auto',
                        vrstaGoriva:'dizel',
                        tipMenjaca:'manuelni',
                        ukupnaOcena:1.5,
                        brojSedistaZaDecu:2,
                        predjenaKilometraza:6500,
                        collisionDamageWaiver:false,
                        images:['https://source.unsplash.com/wfh8dDlNFOk/1920x1080','https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                    },
                    cenovnik:{
                        id:'3',
                        cenaPoDanu:450,
                        nazivCenovnika:'Cenovnik 3',
                        popustZaPreko30Dana:null,
                        cenaCollisionDamageWaiver:3000,
                        cenaPoKilometru:30
                    },
                }
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
           
        }
    },
    methods:{        
        resetFilter:function(){
            this.searchedCar.lokacija = "";
            this.searchedCar.od =  null;
            this.searchedCar.do =  null;
            this.searchedCar.cenaMin =  null;
            this.searchedCar.cenaMax =  null;
            this.searchedCar.markaAut =  null;
            this.searchedCar.modelAutv =  null;
            this.searchedCar.klasaAut =  null;
            this.searchedCar.tipGoriva =  null;
            this.searchedCar.tipMenjaca =  null;
            this.searchedCar.brojSedZaDec =  null;
            this.searchedCar.ColDmgWaiv =  null;
            this.searchedCar.predjenaKilometraza =  null;
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
                userId: null,//idUSera koji je trenutno dodao oglas u korpu...
                odDatuma:this.odabraniDatum.od,
                doDatuma:this.odabraniDatum.do,
                //dodatno svi oni podaci koji mi trebaju da prikazem oglas onako kako je u korpi... vrv samo oglasId je dovoljno pa ga getujemo u created u korpi
            }

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

                console.log(`Trazite automobil:
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

                // axios
                //     .get('rest/apartment/search' + this.searchedQuery)
                //     .then(response => {
                //         this.apartments = response.data;
                //         this.searchedQuery = '?';
                //     });
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
    created() {
        //prilikom kreiranja stranice opcija za broj sedista za decu se postavi na od 1 - 5;
        this.brojSedZaDec = this.range(0, 5);

        // Preuzimanje objekta korpa iz localStorage
        
        if(JSON.parse(localStorage.getItem('cart'))!= null){
            this.cartIsNotEmpty = true;
        }
    },
    mounted() {
        let to = new Date();
        to.setDate(to.getDate() - 1)

        this.disabledDates.to = to;
    },
    components: {
        vuejsDatepicker:Datepicker,
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

</style>

