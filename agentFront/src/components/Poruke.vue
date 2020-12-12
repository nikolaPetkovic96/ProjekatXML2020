<template>
    <div id="messages">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista rezervacija sa statusom <span id='titleEffect'>RESERVED</span></h1>
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
                        <th>Detalji</th>
                        <th>Poruke</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="rezervacija.id" v-for='rezervacija in rezervacije'>
                    <td>{{rezervacija.username}}</td>
                    <td>{{rezervacija.odDatuma}}</td>
                    <td>{{rezervacija.doDatuma}}</td>
                    <td>{{rezervacija.ukupnaCena}}</td>
                    <td>{{rezervacija.bundle}}</td>
                    <td>{{rezervacija.statusRezervacije}}</td>
                    <td>
                        <button v-on:click='showDetails(rezervacija.id)' class="btn-outline-primary"> detalji </button>
                    </td>
                    <td>
                        <button v-on:click='openMessage(rezervacija.id)'  class="btn-outline-primary"> Poruke </button>
                    </td>
                </tr>
                </tbody>
            </table>
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
            //Isti DTO iskoristiti i u IzvestaijiIStatistike.vue
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
        }
    },
    methods:{
        openMessage:function(id){
           this.$router.push(`/messages/${id}/overview`);
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

</style>