<template>  
    <div id='users-message-overview'>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Komentara</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <!-- Objavljivanje ili odbijanje komentara korisnika. -->
         <div id='main' class='container'>
                <div class="comments" v-bind:key="automobil.id" v-for='automobil in automobili'>
                    <div id='carInfo'>
                        <div class="card-header">
                            <h4><b>Automobil:</b> {{automobil.markaAut}} {{automobil.modelAut}} (marka/model)</h4>
                            <h4><b>Klasa automobila:</b> {{automobil.klasaAut}}</h4>
                            <h4><b>Ocena:</b> {{automobil.ukupnaOcena}}</h4>
                        </div>
                    </div>
                    <div v-show='isThereReviews(automobil)' class="card-body">
                            <h3>Nema ocene niti komentara za ovaj automobil...</h3>
                    </div>
                    <div id='all-comments' v-bind:key="comment.id" v-for='comment in automobil.reviews'>
                        <div class="single-comment">
                            <div id='username'>{{comment.username}} </div>
                            <div id='star-rating'>
                                <star-rating
                                    inactive-color="#35424a"
                                    active-color="gold"
                                    v-bind:read-only= "true"
                                    v-bind:star-size="25"
                                    v-bind:show-rating="false"
                                    v-bind:rating="comment.star">
                                </star-rating>
                            </div>
                            <div id='comment'>
                                {{comment.text}}  
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-success marg" v-on:click='addComment(automobil.id)'>Ostavi komentar</button>
                </div> <!--comments-->
            </div>
    </div> 
</template>

<script>
export default {
    name:'Users-message-overview',
    data:function(){
        return{
            //lista rezervacija korisnika 
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
        showComments:function(id){
            this.$router.push(`/adminTest/${id}/comments`);;
        }
    },
    computed:{
        id(){
           return this.$route.params.id; //preuzimam id usera na cijoj sam stranici za prikaz komentara
        }
    },
    created(){
        //getujemo sve rezervacije koje je napravio user sa prezuetim id-jem.
    }
}
</script>

<style scoped>

#titleEffect {
  color:gold;
  font-weight: bold;
}

#users-message-overvie #carInfo h3{
  color:#35424a;
  font-weight: bold;
  font-size: 30px; 
  padding: 30px 0 0 25px;
}

#users-message-overvie .comments{
  margin:auto;
  width:70%;
}

#users-message-overvie .comments .single-comment{
  background-color: #f4f4f4;
  padding:20px;
  margin:20px 0;
  border: 1px solid #777;
  border-radius: 10px;
  color:#35424a;
}

#users-message-overvie .comments .single-comment #username{
  font-weight: bold;
  font-size:20px;
  margin:5px 0 5px 5px;
  border-bottom: 1px solid #777;
}

#users-message-overvie .comments .single-comment #star-rating{
  padding:5px 0 5px 5px;
}

#users-message-overvie .comments .single-comment #comment{
  /* font-weight: bold; */
  font-size:15px;
  margin:10px 0;
  padding:10px;
}


#cusers-message-overvie .comments .single-comment #comment-visibility{
  background-color: #f4f4f4;
  padding:15px;
}

#users-message-overvie .comments .single-comment #check-visibility{
  float: left;
  width: 5%;
}

#users-message-overvie .comments .single-comment #visibility-message{
  background-color: #f4f4f4;
  color:#777;
  float: right;
  width: 90%;
  text-align: center;
}

#users-message-overvie .marg{
    margin-top:5px;
    margin-bottom: 15px;
} 

</style>