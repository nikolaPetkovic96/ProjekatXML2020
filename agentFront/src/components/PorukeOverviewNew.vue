<template>
    <div id="car-message">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>Poruka</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

    <!--PRIKAZ PORUKA-->
        <div id='main' class='container'>
            <div id='reservInfo'>
                <div class="card-header">
                    <h4><b>Rezervisan od:{{rezervacija.username}}</b></h4>
                    <h4><b>Termin rezervacije:</b> {{rezervacija.odDatuma}} - {{rezervacija.doDatuma}}</h4>
                    <h4><b>Bundle:</b> {{rezervacija.bundle}}</h4>
                    <button v-if='!toShowMessage' class="btn btn-lg btn-outline-dark marg" v-on:click='toShowMessage = !toShowMessage'>Prikazi poruke</button>
                    <button v-if='toShowMessage' class="btn  btn-lg btn-outline-dark marg" v-on:click='toShowMessage = !toShowMessage'>Sakrij poruke</button>
                </div>
            </div>
            <div v-show='isThereMessages(rezervacija)' class="card-body">
                <h3>Nema poruke za ovu rezervaciju...</h3>
            </div>
            <div v-bind:key="oglas.id" v-for='oglas in rezervacija.oglasi'>
                <div class="card-header">
                    <h4><b>Automobil:</b> {{oglas.automobil.markaAut}} {{oglas.automobil.modelAut}} (marka/model)</h4>
                    <h4><b>Klasa automobila:</b> {{oglas.automobil.klasaAut}}</h4>
                   
                </div>
                
                <div id='all-messages' v-show='toShowMessage' v-bind:key="poruka.id" v-for='poruka in filtriranePoruke(oglas.automobil)'>   
                    <!--v-bind:class dinamcki dodeljuje klasu spram nekog uslova-->
                    <div class='shadow btn-lg' v-bind:class="{myMessage:isMyMessage(poruka), customerMessage:isCustomerMessage(poruka)}">
                        <div id='message-text'>
                            {{poruka.tekstPoruke}}
                        </div>
                        <div class='message-date'>
                            {{poruka.commonData.datumKreiranja}}  
                        </div>
                    </div>
                </div>
                 <a href="#car-new-message"><button class="btn btn-lg btn-outline-success marg" v-on:click='newMessage = !newMessage'>Nova poruka</button></a>
            </div>
            
            
            <hr style='background:lightgray;height:1px;'>
            
        <!-- NOVA PORUKA -->
            <div v-if='newMessage' id='car-new-message'>
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Nova <span id='titleEffect'>Poruka</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <!-- <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div> -->
                    <div>
                        <label for="">Tekst poruke</label>
                        <!-- <div v-if='messages.errorText' class="alert alert-danger" v-html="messages.errorText"></div> -->
                        <textarea v-model='novaPoruka.tekstPoruke' placeholder="Unesite tekst..."></textarea>
                        <button class="btn btn-success marg" v-on:click='addMessage(car.id)'>Potvrdi</button>
                        <button class="btn btn-danger marg" v-on:click='closeNewMessage()'>Odustani</button>
                        <hr style='background:lightgray;height:1px;'>
                    </div>
                    
                </div>
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
            toShowMessage: false,
            newMessage: false,
            novaPoruka:{
                tekstPoruke:'',
                rezervacijaId:null,
                automobilId:null, //Kako ako ih je vise u rezerv. tj. ako je rezerv bundle?
                commonData:{
                    userId:null,
                    datumKreiranja:'',
                }
            },
            //Iskoristiti ovo u rezervacijama!!!!!
            rezervacija:
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
                            // ...
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
        }
    },
    methods:{
        openMessage:function(id){
            this.$router.push(`/carComments/${id}/newComment`);
        },
        //Metoda koja proverava da li ima 
        isThereMessages:function(rezervacija){   
            // console.log('asdsad rezervacija.poruke.length: ' + rezervacija.poruke.length);  
            if(rezervacija.poruke === undefined || rezervacija.poruke.length === 0){
              
              return true;
            }
            else {
                return false;
            }
        },
        filtriranePoruke:function(automobil){
            let filtriranePoruke = [];
            for(let i = 0; i < this.rezervacija.poruke.length; i++){
                if(this.rezervacija.poruke[i].automobilId == automobil.id){
                    console.log('this.rezervacija.poruke[i].automobilId: ' + this.rezervacija.poruke[i].automobilId);
                    filtriranePoruke.push(this.rezervacija.poruke[i]);
                }
            }
            return filtriranePoruke;
        },

        //metoda koja sluzi za proveru da li poruka koja je 
        //trenutno u for petlji ima isti id trenutnog usera, sa idjem onoga ko ju je ostavio
        //Ako ima dodeli poruci klasu myMessage u suprotnom customerMessage...
        // isMyMessage:false,
        isMyMessage:function(poruka){
            //prepraviti da proverava id onoga ko je napisao poruku sa id agenta koji je ulogovan u sesiju.
           if(poruka.commonData.userId === 2){
               return true;
           }
           else {
                return false; 
           }
           
        },
        isCustomerMessage:function(poruka){
           if(poruka.commonData.userId === 1){
               return true;
           }
           else {
                return false; 
           }
        },
    }
}
</script>

<style scoped>

#titleEffect{
    color:gold;
    font-weight: bold;
}

#car-message #reservInfo h3{
    color:#35424a;
    font-weight: bold;
    font-size: 30px; 
    padding: 30px 0 0 25px;
}

#car-message #all-messages {
    color:#fff;
    position: relative;
    padding:12%;
    /* width:75%; */
    margin:auto;
    height: max-content;
}

#car-message #all-messages .myMessage{
    position: absolute;
    right:35px;
    width:40%;
    padding:10px 0 10px 25px;
    background-color:crimson;
    color:#fff;
    overflow: auto;
}

#car-message #all-messages .customerMessage{
    position: absolute;
    left:35px;
    width:40%;
    padding:10px 0 10px 25px;
    background-color:cadetblue;
    color:#fff;
    overflow: auto;
}

#car-message #all-messages .singleMessage{
    font-size:25px;
    width:25%;
    padding:10px;
    background-color:cadetblue;
    max-height: max-content;
    
    
}

#car-message #all-messages .message-date{
    margin:2px 0px;
    font-size: 12px;
}

#car-message .marg{
    margin-top:5px;
    margin-bottom: 15px;
} 


/* Novi komentar */
#car-new-message label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

#car-new-message textarea{
    display: block;
    width: 100%;
    height: 200px;
    padding:8px;
}

</style>