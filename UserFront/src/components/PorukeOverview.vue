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
                    <h4><b>Ukupna cena:{{rezervacija.ukupnaCena}}</b></h4>
                    <h4><b>Bundle:</b> {{rezervacija.bundle}}</h4>
                    <button v-if='!toShowMessage' class="btn btn-lg btn-outline-dark marg" v-on:click='toShowMessage = !toShowMessage'>Prikazi poruke</button>
                    <button v-if='toShowMessage' class="btn  btn-lg btn-outline-dark marg" v-on:click='toShowMessage = !toShowMessage'>Sakrij poruke</button>
                </div>
            </div>
            <div v-show='isThereMessages(rezervacija)' class="card-body">
                <h3>Nema poruke za ovu rezervaciju...</h3>
            </div>
            <div v-bind:key="narudzbenica.id" v-for='narudzbenica in rezervacija.narudzbenice'>
                <div class="card-header">
                    <h4><b>Automobil:</b> {{narudzbenica.oglas.automobil.markaAut}} {{narudzbenica.oglas.automobil.modelAut}} (marka/model)</h4>
                    <h4><b>Klasa automobila:</b> {{narudzbenica.oglas.automobil.klasaAut}}</h4>
                    <h4><b>Termin rezervacije:</b> {{narudzbenica.odDatuma}} - {{narudzbenica.doDatuma}}</h4>
                </div>
                
                <div id='all-messages' v-show='toShowMessage' v-bind:key="poruka.id" v-for='poruka in filtriranePoruke(narudzbenica.oglas.automobil)'>   
                    <!--v-bind:class dinamcki dodeljuje klasu spram nekog uslova-->
                    <div class='shadow btn-lg' v-bind:class="{myMessage:isMyMessage(poruka), customerMessage:isCustomerMessage(poruka)}">
                        <div class='message-username'>
                            {{poruka.username}}
                        </div>
                        <hr>
                        <div id='message-text'>
                            {{poruka.tekstPoruke}}
                        </div>
                         <hr>
                        <div class='message-date'>
                            {{poruka.commonData.datumKreiranja}}  
                        </div>
                    </div>
                </div>
                 <a href="#car-new-message"><button class="btn btn-lg btn-outline-success marg" v-on:click='createMessage(narudzbenica.oglas.automobil)'>Nova poruka</button></a>
            </div>
            
            
            <hr style='background:lightgray;height:1px;'>
            
        <!-- NOVA PORUKA -->
            <div v-if='newMessage' id='car-new-message'>
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Nova <span id='titleEffect'>Poruka</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div class="card-header">
                        <h4><b>Za automobil:</b> {{this.automobilPoruka.markaAut}} {{this.automobilPoruka.modelAut}} - {{this.automobilPoruka.klasaAut}} (marka/model/klasa)</h4>
                    </div>
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
                    <div>
                        <label for="">Tekst poruke</label>
                        <div v-if='messages.errorText' class="alert alert-danger" v-html="messages.errorText"></div>
                        <textarea v-model='novaPoruka.tekstPoruke' placeholder="Unesite tekst..."></textarea>
                        <button class="btn btn-success marg" v-on:click='addMessage()'>Potvrdi</button>
                        <button class="btn btn-danger marg" v-on:click='closeCreateMessage()'>Odustani</button>
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
import UserDataService from '../services/UserDataService'
export default {
    name: 'Messages',
    data:function(){
        return {
            toShowMessage: false,
            newMessage: false,
            novaPoruka:{
                automobilId:null,
                rezervacijaId:null,
                tekstPoruke:'',
            },            
            rezervacija:{},
            //Za prikaz podataka o automobilu za koji se kreira poruka
            automobilPoruka:null,
            userId:null,

            messages: {
                errorText: '',
                errorResponse: '',
                successResponse: '',
            },
        }
    },
    methods:{
        getAllMessages:function(){
            UserDataService.getRezervacijaDetails(this.id).then(response =>{
                this.rezervacija = response.data;
            });
        },
        addMessage:function(){
            if (this.novaPoruka.tekstPoruke == '') {
                this.messages.errorText = `<h4>Tekst poruke ne moze biti prazan!</h4>`;
                setTimeout(() => this.messages.errorText = '', 3000);
            }
            else {
                alert(`Nova poruka: 
                automobilId: ${this.novaPoruka.automobilId},
                tekstPoruke: ${this.novaPoruka.tekstPoruke},
                rezervacijaId ${this.novaPoruka.rezervacijaId},`);

                UserDataService.addPoruka(this.novaPoruka).then(response => {
                    this.messages.successResponse = `<h4>Vas poruka je uspesno poslata!</h4>`;
                    setTimeout(() => this.messages.successResponse = '', 3000);

                    this.getAllMessages();
                })
                .catch(error => {
                    if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokušajte kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
        },
        createMessage:function(automobil){
            //ako je vec otvoren prozor za kreiranje nove poruke samo neka se doda drugi id
            if(this.newMessage === true){
                this.novaPoruka.automobilId = automobil.id;
                console.log('this.novaPoruka.automobilId:' + this.novaPoruka.automobilId);
            }
            //ako je zatvoren prozor klikom na dugme se prvo otvara prozor za kreiranje pa se dodaje i id auta.
            else{
                this.newMessage = !this.newMessage;
                this.novaPoruka.automobilId = automobil.id;
                console.log('this.novaPoruka.automobilId:' + this.novaPoruka.automobilId);
            }

            this.automobilPoruka = automobil;
        },
        //metoda koja izlazi iz kreiranja nove poruke i brise id automobila;
        closeCreateMessage:function(){
            this.newMessage = !this.newMessage;
            this.novaPoruka.automobilId = '';
            console.log('this.novaPoruka.automobilId:' + this.novaPoruka.automobilId);
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
                    // console.log('this.rezervacija.poruke[i].automobilId: ' + this.rezervacija.poruke[i].automobilId);
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
           if(poruka.commonData.userId === this.userId){
               return true;
           }
           else {
                return false; 
           }
        },
        isCustomerMessage:function(poruka){
           if(poruka.commonData.userId !== this.userId){
               return true;
           }
           else {
                return false; 
           }
        },
    },
    computed:{
        id() {
            return this.$route.params.id; //preuzimam id rezervacije na cijoj sam stranici za prikaz poruka
        },
    },
    created(){
        // 1. se getuje rezervacija ciji id je prosledjen u urlu;
        this.novaPoruka.rezervacijaId = this.id;
        const token = JSON.parse(localStorage.getItem('parsToken'));
        this.userId = token.id;

        this.getAllMessages();
    }
}
</script>

<style scoped>

#titleEffect{
    color:#FF8C00;
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
    /*width:75%;*/
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