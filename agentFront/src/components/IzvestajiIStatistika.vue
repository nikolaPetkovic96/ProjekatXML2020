<template>
    <div id="DataAndStatistic">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista zavrsenih <span id='titleEffect'>rezervacija</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div id='main' class='container'>
            <table class="table">
                <thead>
                    <tr>
                        <th>Rezervisan od</th> <!--Korisnik koji ga rezervise-->
                        <th>Od</th>
                        <th>Do</th>
                        <th>Cena</th>
                        <th>Bundle</th>
                        <th>Status</th>
                        <th>Detaljnije</th>
                        <th>Izvestaj</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="rezervacija.id" v-for='rezervacija in rezervacije'>
                    <td>{{rezervacija.username}}</td>
                    <!-- <td>{{rezervacija.oglasi.automobil.markaAut}} {{rezervacija.oglasi.automobil.modelAut}} ({{rezervacija.oglasi.automobil.klasaAut}})</td> -->
                    <td>{{rezervacija.odDatuma}}</td>
                    <td>{{rezervacija.doDatuma}}</td>
                    <td>{{rezervacija.ukupnaCena}}</td>
                    <td>{{rezervacija.bundle}}</td>
                    <td>{{rezervacija.statusRezervacije}}</td>
                    <td>
                        <button v-on:click='showDetails(rezervacija.id)' class="btn-outline-primary"> detalji </button>
                    </td>
                    <td>
                        <button v-on:click='writeReport(rezervacija.id)' class="btn-outline-primary"> izvestaj </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Statistika upotrebe <span id='titleEffect'>automobila</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div id='main' class='container'>
	        <div id='criterium' class="row">
					<div class="col-md-4 col-sm-6 mb-4">
                        <h4>Najvise komentara</h4>
						<button><img src="../assets/messageSign.jpg" alt=""></button>
					</div>

					<div class="col-md-4 col-sm-6 mb-4">
                        <h4>Najvise predjenih kilometara</h4>
						<button><img src="../assets/kmSign2.jpg" alt=""></button>
					</div>

					<div class="col-md-4 col-sm-6 mb-4">
						<h4>Najvisa ocena</h4>
						<button><img src="../assets/ratingSign2.jpg" alt=""></button>
					</div>
            </div>
            <div id='places'>                    
                <div id='first-place'>
                    <img  src="../assets/firstIcon2.png" alt="">
                    <div class="card-header">
                        <h2><b>Kilometraza:</b> {{automobili[1].predjenaKilometraza}}</h2>
                        <h4><b>Automobil:</b> {{automobili[1].markaAut}} {{automobili[1].modelAut}} (marka/model)</h4>
                        <h4><b>Klasa automobila:</b> {{automobili[1].klasaAut}}</h4>
                        <h5><b>Broj komentara:</b> {{automobili[1].broj_komentara}}</h5>
                        <h5><b>Ukupna_ocena:</b> {{automobili[1].ukupna_ocena}}</h5>
                    </div>
                </div><!-- </first-place> -->
                <br>
                <div id='second-place'>
                    <div class="card-header">
                        <h4><b>Kilometraza:</b> {{automobili[2].predjenaKilometraza}}</h4>
                        <h5><b>Automobil:</b> {{automobili[2].markaAut}} {{automobili[2].modelAut}} (marka/model)</h5>
                        <h5><b>Klasa automobila:</b> {{automobili[2].klasaAut}}</h5>
                        <h6><b>Broj komentara:</b> {{automobili[2].broj_komentara}}</h6>
                        <h6><b>Ukupna_ocena:</b> {{automobili[2].ukupna_ocena}}</h6>
                    </div>
                </div><!-- </second-place> -->
                <hr>
                <div id='third-place'>
                     <div class="card-header">
                        <h4><b>Kilometraza:</b> {{automobili[0].predjenaKilometraza}}</h4>
                        <h5><b>Automobil:</b> {{automobili[0].markaAut}} {{automobili[0].modelAut}} (marka/model)</h5>
                        <h5><b>Klasa automobila:</b> {{automobili[0].klasaAut}}</h5>
                        <h6><b>Broj komentara:</b> {{automobili[0].broj_komentara}}</h6>
                        <h6><b>Ukupna_ocena:</b> {{automobili[0].ukupna_ocena}}</h6>
                    </div>
                </div><!-- </second-place> -->
            </div>
        </div>
    </div>
</template>
<!-- Isti get koji se radi i u Rezervacija.vue. Vrati sve rezervacije koje su napravljene
za oglase koje je kreirao ulogovani agent i kojima je status="accepted" -->

<script>
export default {
    name: 'Messages',
    data:function(){
        return {
            //Ovde moze i samo deo sa rezervacijom bez ostalih objekata
            //Isti DTO iskoristiti i u Poruke.vue
            rezervacije:[
                {
                    id:1,
                    odDatuma:'18.6.2020',
                    doDatuma:'25.7.2020',
                    ukupnaCena:6500,
                    statusRezervacije:'RESERVED',
                    username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    bundle:true,
                    //Oglase vratiti kao array jer ih moze biti vise u bundleu
                    //iz svakog oglasa koji je vezan za rezervaciju izvlacimo automobil
                    //getAllAdsByReservId();
                    oglasi:[
                        {
                            //Oglas
                            id:1,
                            odDatuma:'25.5.2020',
                            doDatuma:'25.6.2020',
                            lokacija:'9. Marta bb Novi Sad',
                            TAdresa:{
                                mesto:'',
                                ulica:'',
                                broj:'',
                                postanskiBroj:'',
                                longitude:'',
                                latitude:'',
                            },
                            planiranaKilometraza:2000,
                            //Oglas/Automobil
                            automobil:{
                                id:1,
                                markaAut:'Audi',
                                modelAut:'A6',
                                klasaAut:'Gradski',
                            },
                            //Oglas/Cenovnik
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
                            //Oglas
                            id:2,
                            odDatuma:'18.6.2020',
                            doDatuma:'25.7.2020',
                            lokacija:'Ne znanog i znanog junaka bb Beograd',
                            TAdresa:{
                                mesto:'',
                                ulica:'',
                                broj:'',
                                postanskiBroj:'',
                                longitude:'',
                                latitude:'',
                            },
                            planiranaKilometraza:2500,
                        
                            //Oglas/Automobil
                            automobil:                
                            {
                                id:2,
                                markaAut:'BMW',
                                modelAut:'R5',
                                klasaAut:'Gradski',
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

                    ],
                    //getujemo poruke preko id rezervacije getAllMessagesByReservId();
                    poruke:[
                        //Za prvi automobil u bundleu
                        {
                            id:1,
                            tekstPoruke:'Da li imate automobil u crvenoj boji? Asdasd dasdsad dsad dsa da das . Asdasd dasdsad dsad dsa da das .',
                            rezervacijaId:1,
                            automobilId:1, //Kako ako ih je vise u rezerv. tj. ako je rezerv bundle?
                            commonData:{
                                userId:1,
                                datumKreiranja:'16.6.2020',
                            }
                        },
                        {
                            id:2,
                            tekstPoruke:'Nazalost nemamo.',
                            rezervacijaId:1,
                            automobilId:1,
                            commonData:{
                                userId:2,
                                datumKreiranja:'16.6.2020',
                            }
                        },
                        {
                            id:3,
                            tekstPoruke:'Nista... Hvala na brzom odgovoru!',
                            rezervacijaId:1,
                            automobilId:1,
                            commonData:{
                                userId:1,
                                datumKreiranja:'17.6.2020',
                            }
                        },
                        {
                            id:4,
                            tekstPoruke:'Nema na cemu!',
                            rezervacijaId:1,
                            automobilId:1,
                            commonData:{
                                userId:2,
                                datumKreiranja:'17.6.2020',
                            }
                        },
                        //Za drugi automobil u bundleu
                        {
                            id:5,
                            tekstPoruke:'A da li ovaj dolazi u plavoj boji?! Hvala unapred!',
                            rezervacijaId:1,
                            automobilId:2,
                            commonData:{
                                userId:1,
                                datumKreiranja:'17.6.2020',
                            }
                        },
                        {
                            id:6,
                            tekstPoruke:'Dolazi, nema na cemu!',
                            rezervacijaId:1,
                            automobilId:2,
                            commonData:{
                                userId:2,
                                datumKreiranja:'17.6.2020',
                            }
                        }
                    ]
                },
                {
                    id:2,
                    odDatuma:'18.6.2020',
                    doDatuma:'25.7.2020',
                    ukupnaCena:8500,
                    statusRezervacije:'RESERVED',
                    username:'Happy User 3', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    bundle:true,
                    //Oglase vratiti kao array jer ih moze biti vise u bundleu
                    //iz svakog oglasa koji je vezan za rezervaciju izvlacimo automobil
                    //getAllAdsByReservId();
                    oglasi:[
                        {
                            //Oglas
                            id:1,
                            odDatuma:'25.5.2020',
                            doDatuma:'25.6.2020',
                            lokacija:'9. Marta bb Novi Sad',
                            TAdresa:{
                                mesto:'',
                                ulica:'',
                                broj:'',
                                postanskiBroj:'',
                                longitude:'',
                                latitude:'',
                            },
                            planiranaKilometraza:2000,
                            //Oglas/Automobil
                            automobil:{
                                id:1,
                                markaAut:'Audi',
                                modelAut:'A6',
                                klasaAut:'Gradski',
                                vrstaGoriva:'',
                                tipMenjaca:'',
                            },
                            //Oglas/Cenovnik
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
                            //Oglas
                            id:2,
                            odDatuma:'18.6.2020',
                            doDatuma:'25.7.2020',
                            lokacija:'Ne znanog i znanog junaka bb Beograd',
                            TAdresa:{
                                mesto:'',
                                ulica:'',
                                broj:'',
                                postanskiBroj:'',
                                longitude:'',
                                latitude:'',
                            },
                            planiranaKilometraza:2500,
                        
                            //Oglas/Automobil
                            automobil:                
                            {
                                id:2,
                                markaAut:'BMW',
                                modelAut:'R5',
                                klasaAut:'Gradski',
                                vrstaGoriva:'',
                                tipMenjaca:'',
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

                    ],
                    //getujemo poruke preko id rezervacije getAllMessagesByReservId();
                    poruke:[
                        //Za prvi automobil u bundleu
                        {
                            id:1,
                            tekstPoruke:'Da li imate automobil u crvenoj boji? Asdasd dasdsad dsad dsa da das . Asdasd dasdsad dsad dsa da das .',
                            rezervacijaId:1,
                            automobilId:1, //Kako ako ih je vise u rezerv. tj. ako je rezerv bundle?
                            commonData:{
                                userId:1,
                                datumKreiranja:'16.6.2020',
                            }
                        },
                        {
                            id:2,
                            tekstPoruke:'Nazalost nemamo.',
                            rezervacijaId:1,
                            automobilId:1,
                            commonData:{
                                userId:2,
                                datumKreiranja:'16.6.2020',
                            }
                        },
                        {
                            id:3,
                            tekstPoruke:'Nista... Hvala na brzom odgovoru!',
                            rezervacijaId:1,
                            automobilId:1,
                            commonData:{
                                userId:1,
                                datumKreiranja:'17.6.2020',
                            }
                        },
                        {
                            id:4,
                            tekstPoruke:'Nema na cemu!',
                            rezervacijaId:1,
                            automobilId:1,
                            commonData:{
                                userId:2,
                                datumKreiranja:'17.6.2020',
                            }
                        },
                        //Za drugi automobil u bundleu
                        {
                            id:5,
                            tekstPoruke:'A da li ovaj dolazi u plavoj boji?! Hvala unapred!',
                            rezervacijaId:1,
                            automobilId:2,
                            commonData:{
                                userId:1,
                                datumKreiranja:'17.6.2020',
                            }
                        },
                        {
                            id:6,
                            tekstPoruke:'Dolazi, nema na cemu!',
                            rezervacijaId:1,
                            automobilId:2,
                            commonData:{
                                userId:2,
                                datumKreiranja:'17.6.2020',
                            }
                        }
                    ]
                },
                
            ],

            //Za statistiku:
            automobili:[
                {       
                    id:'1',
                    markaAut:'BMW',
                    modelAut:'M5',
                    klasaAut:'SUV',
                    tipGoriva:'Dizel',
                    tipMenjaca:'Automatik',
                    ukupna_ocena:5,
                    predjenaKilometraza:500,
                    brojDecMesta:2,
                    broj_komentara:5, //za ovaj dto
                },
                {
                    id:'2',
                    markaAut:'Mercedes',
                    modelAut:'R8',
                    klasaAut:'Old Tajmer',
                    tipGoriva:'Dizel',
                    tipMenjaca:'Automatik',
                    ukupna_ocena:3,
                    predjenaKilometraza:800,
                    brojDecMesta:3,
                    broj_komentara:2,
                },
                {
                    id:'3',
                    markaAut:'Audi',
                    modelAut:'A6',
                    klasaAut:'Gradski auto',
                    tipGoriva:'Dizel',
                    tipMenjaca:'Automatik',
                    ukupna_ocena:4,
                    predjenaKilometraza:650,
                    brojDecMesta:1,
                    broj_komentara:10,
                },
            ]
        }
    },
    methods:{
        writeReport:function(id){
            this.$router.push(`/statistics/${id}/report`);
        },
        showDetails(id){
            this.$router.push(`/reservation/${id}/details`);
        }

    }
}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}

#places{
    position: relative;
    margin-bottom:100px;
}
#first-place{
    border:solid 1px #35424a;
    padding:15px;
}
#first-place-img{
    position: absolute;
    left:15px;
    width:15%;
}
#first-place-info{
    position: absolute;
    right:65px;
    width:80%;
    background-color: red;
    height: fit-content;
    
}
#DataAndStatistic label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

#DataAndStatistic textarea{
    display: block;
    width: 100%;
    height: 200px;
    padding:8px;
}

</style>


// Jednostavnija verzija rezervacijaTabelaDTO
// rezervacije:[
//                 {
//                     id:1,
//                     odDatuma:'18.6.2020',
//                     doDatuma:'25.7.2020',
//                     ukupnaCena:6500,
//                     username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
//                     statusRezervacije:'RESERVED',
//                     isBundle:false,
//                     //Oglas
//                     TAdresa:{
//                         mesto:'',
//                         ulica:'',
//                         broj:'',
//                         postanskiBroj:'',
//                         longitude:'',
//                         latitude:'',
//                     },
//                     //Oglas/Automobil
//                     markaAut:'Audi',
//                     modelAut:'A6',
//                     klasaAut:'Gradski',
//                     planiranaKilometraza:2500,
//                     //Oglas/Cenovnik    
//                     nazivCenovnika:'Cenovnik2',
//                     cenaPoKilometru:2750, //Ako je ima
//                     cenaPoDanu:200,
//                     //commonData ?
//                 },
//                 {
//                     id:2,
//                     odDatuma:'18.6.2020',
//                     doDatuma:'25.7.2020',
//                     ukupnaCena:6500,
//                     username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
//                     statusRezervacije:'RESERVED',
//                     //Oglas
//                     TAdresa:{
//                         mesto:'',
//                         ulica:'',
//                         broj:'',
//                         postanskiBroj:'',
//                         longitude:'',
//                         latitude:'',
//                     },
//                     //Oglas/Automobil
//                     markaAut:'Audi',
//                     modelAut:'A6',
//                     klasaAut:'Gradski',
//                     planiranaKilometraza:2500,
//                     //Oglas/Cenovnik    
//                     nazivCenovnika:'Cenovnik2',
//                     cenaPoKilometru:2750, //Ako je ima
//                     cenaPoDanu:200,
//                     //commonData ?
//                 },
//             ]