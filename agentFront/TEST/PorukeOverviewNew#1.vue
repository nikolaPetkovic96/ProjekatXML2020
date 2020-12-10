<template>
    <div id="car-message">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>Poruka</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <div id='main' class='container'>
            <div id='reservInfo'>
                <div class="card-header">
                    <h4><b>Rezervisan od:{{rezervacija.username}}</b></h4>
                    <h4><b>Termin rezervacije:</b> {{rezervacija.odDatuma}} - {{rezervacija.doDatuma}}</h4>
                    <h4><b>Bundle:</b> {{rezervacija.bundle}}</h4>
                    <h4><b>Automobil:</b> {{rezervacija.markaAut}} {{rezervacija.modelAut}} (marka/model)</h4>
                    <h4><b>Klasa automobila:</b> {{rezervacija.klasaAut}}</h4>
                </div>
            </div>
            <div v-show='isThereMessages(rezervacija)' class="card-body">
                <h3>Nema poruke za ovu rezervaciju...</h3>
            </div>
            <div id='all-messages' v-bind:key="poruka.id" v-for='poruka in rezervacija.poruke'>
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
            
            <button class="btn btn-lg btn-dark marg" v-on:click='newMessage = !newMessage'>Nova poruka</button>
            
            <hr style='background:lightgray;height:1px;'>
            
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
                username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                statusRezervacije:'RESERVED',
                //Oglas
                TAdresa:{
                    mesto:'',
                    ulica:'',
                    broj:'',
                    postanskiBroj:'',
                    longitude:'',
                    latitude:'',
                },
                //Oglas/Automobil
                markaAut:'Audi',
                modelAut:'A6',
                klasaAut:'Gradski',
                planiranaKilometraza:2500,
                //Oglas/Cenovnik    
                nazivCenovnika:'Cenovnik2',
                cenaPoKilometru:2750, //Ako je ima
                cenaPoDanu:200,
                //commonData ?
                poruke:[
                    {
                        id:1,
                        tekstPoruke:'Da li imate automobil u crvenoj boji? Asdasd dasdsad dsad dsa da das . Asdasd dasdsad dsad dsa da das . Asdasd dasdsad dsad dsa da das . Asdasd dasdsad dsad dsa da das .',
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
                        {
                        id:5,
                        tekstPoruke:'Nista... Hvala na brzom odgovoru!',
                        rezervacijaId:1,
                        automobilId:1,
                        commonData:{
                            userId:1,
                            datumKreiranja:'17.6.2020',
                        }
                    },
                    {
                        id:6,
                        tekstPoruke:'Nema na cemu!',
                        rezervacijaId:1,
                        automobilId:1,
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
        isThereMessages:function(rezervacija){     
            if(rezervacija.poruke === undefined || rezervacija.poruke.length === 0){
              // console.log('this.apartment.reviews.length = 0 ');
              return true;
            }
            else {
                return false;
            }
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
    background-color: ghostwhite;
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