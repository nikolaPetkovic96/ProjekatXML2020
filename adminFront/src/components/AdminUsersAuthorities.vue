<template>  
    <div id='korisnici'>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Korisnika</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <!-- ❏ Blokirati, aktivirati i uklanjati iz sistema obične korisnike.
        ❏ Definisati permisije za svakog korisnika pojedinačno (npr. administrator može
        onemogućiti kreiranje rezervacija od strane nekog korisnika koji je mnogo puta
        otkazivao). -->
        <div class="container" id='main'>
            <table class="table">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Pol</th>
                        <th>Adresa</th>
                        <th>Status</th>
                        <th>Promeni status</th>
                        <th>Permisije</th>
                        <th>Obrisi</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='korisnik.id' v-for='korisnik in korisnici'>
                        <td>{{korisnik.korisnickoIme}}</td>
                        <td>{{korisnik.ime}}</td>
                        <td>{{korisnik.prezime}}</td>
                        <td>{{korisnik.pol}}</td>
                        <td>{{korisnik.tadresa.mesto}} {{korisnik.tadresa.ulica}} {{korisnik.tadresa.broj}}</td>
                        <td>{{korisnik.status}}</td>
                        <td>
                            <a href="#edit-amenity"><button v-if='korisnik.status=="neaktivan"'  class=" btn-sm btn-outline-primary" v-on:click='activateUser(korisnik.id)'> aktiviraj </button></a>
                            <a href="#edit-amenity"><button v-if='korisnik.status=="aktivan"' class=" btn-sm btn-outline-primary" v-on:click='blockUser(korisnik.id)'> blokiraj </button></a>
                        </td>
                         <td><a href="#change-permision"><button class="btn-sm btn-outline-primary" v-on:click='checkPermission(korisnik)'> permisije </button></a>
                        <td><button class="btn-sm btn-danger" v-on:click='deleteUser(korisnik.id)'> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
            <div v-if='isChangePermision' id="change-permision">
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Permisija</span>
                    </h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div class="card-header">
                        <h4><b>Username:</b> {{showUser.korisnickoIme}} </h4>
                        <h4><b>Ime i prezime:</b> {{showUser.ime}} {{showUser.prezime}}</h4>
                    </div>
               
                    <div id='codeType' class="row">
                        <div class="col-md-4 col-sm-6 mb-4">
                            <label>Ostavljanje komentara i ocena:</label>
                            <div id="comments">
                                <span for="one">Dozvoljeno</span>
                                <input type="radio" id="one" value="true" v-model='permisije.komentari'>

                                <span for="two">Zabranjeno</span>
                                <input type="radio" id="two" value="false" v-model='permisije.komentari'>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 mb-4">
                            <label>Slanje poruka:</label>
                            <div id="comments">
                                <span for="one">Dozvoljeno</span>
                                <input type="radio" id="one" value="true" v-model='permisije.poruke'>

                                <span for="two">Zabranjeno</span>
                                <input type="radio" id="two" value="false" v-model='permisije.poruke'>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 mb-4">  
                            <label>Iznajmljivanje automobila:</label>
                            <div id="comments">
                                <span for="one">Dozvoljeno</span>
                                <input type="radio" id="one" value="true" v-model='permisije.rezervacija'>

                                <span for="two">Zabranjeno</span>
                                <input type="radio" id="two" value="false" v-model='permisije.rezervacija'>
                            </div>
                        </div>
                    </div> <!--row--> <!--Ili show user prosledjume u sendPermission ako je -->
                    <button class="btn btn-top btn-success" v-on:click='sendPermission()'>Potvrdi</button>
                    <button class="btn btn-danger" v-on:click='closePermission()'>Odustani</button>
                </div> <!--Container-->
            </div>
        </div>
    </div> 
</template>

<script>
import adminDataService from '../services/AdminDataService'
export default {
    name:'Korisnici',
    data:function(){
        return{
            showUser:{
                korisnickoIme:'',
                ime:'',
                prezime:'',
            },
            isChangePermision:false,
            //Ovo dodati u User klasu
            permisije:{
                id:null,
                komentari:false,
                poruke:true,
                rezervacija:true,
            },
            beckupPermisije:{
                id:null,
                komentari:null,
                poruke:null,
                rezervacija:null,
            },
            korisnici:[],
            messages: {
                errorResponse: '',
                successResponse: '',
            }
        }
    },
    methods:{
        getAllUsers:function(){
            adminDataService.getAllUsers().then(response => {
                console.log("response: " + response.data);
                this.korisnici = response.data;
                console.log(JSON.stringify(this.korisnici));
            });
        },
        activateUser:function(id){
            if(confirm("Da li ste sigurni da želite aktivirati korisnika?")){
                adminDataService.changeUsersStatus(id).then(response => {
                    this.getAllUsers();
                });
            }
        },
        blockUser:function(id){
            if(confirm("Da li ste sigurni da želite blokirati korisnika?")){
                adminDataService.changeUsersStatus(id).then(response => {
                    this.getAllUsers();
                });
            }
        },
        checkPermission:function(chosenUser){
            if(this.isChangePermision === false){
                this.isChangePermision = true;
                this.showUser = chosenUser;

                this.permisije.id = chosenUser.id ,
                this.permisije.komentari = chosenUser.allowedToCommend;
                this.permisije.poruke = chosenUser.allowedToMessage;
                this.permisije.rezervacija = chosenUser.allowedToMakeReservation;
            }
            else if(this.isChangePermision === true){
                this.showUser = chosenUser;

                this.permisije.id = chosenUser.id ,
                this.permisije.komentari = chosenUser.allowedToCommend;
                this.permisije.poruke = chosenUser.allowedToMessage;
                this.permisije.rezervacija = chosenUser.allowedToMakeReservation;
            }
            //kada se udje u prikaz i izmenu permisija
            //trenutne permisije se bekapuju ukoliko korisnik izmeni permisije
            //ali ih ne sacuva nego cancel uradi kako bi se sacuvale stare permisije...
            this.beckupPermisije.id = this.permisije.id,
            this.beckupPermisije.komentari = this.permisije.komentari;
            this.beckupPermisije.poruke = this.permisije.poruke;
            this.beckupPermisije.rezervacija = this.permisije.rezervacija;
        },
        deleteUser:function(id){
            if(confirm("Da li ste sigurni da želite obrisati korisnika?")){
                adminDataService.deleteUser(id).then(response => {
                    this.getAllUsers();
                });
            }
        },
        sendPermission:function(){
            let request = "?";
            request += `id=${this.permisije.id}`;
            request += `&comment=${ this.permisije.komentari}`;
            request += `&reservation=${this.permisije.rezervacija}`;
            request += `&message=${this.permisije.poruke}`;
            
            adminDataService.changePermission(request).then(response => {
                this.messages.successResponse = `<h4>Uspešno ste izmenili permisije korisnika!</h4>`;
                setTimeout(() => this.messages.successResponse = '', 3000);
                this.isChangePermision = false;
                this.getAllUsers();
            }).catch(error => {
                // && error.response.data.message === "Wrong password!"
                if (error.response.status === 500 || error.response.status === 404) {
                    this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokušajte ponovo kasnije!</h4>`;
                    this.isChangePermision = false;
                    setTimeout(() => this.messages.errorResponse = '', 3000);
                }
            
            });
        },
        closePermission:function(){
            this.isChangePermision = false;
            //ovo preurediti prilikom povezivanja fronta i beka
            //Mozda prilikom cancela samo da se refreshuje stranica, tako bi se vratile stare permisije...
            this.permisije.id = this.beckupPermisije.id ,
            this.permisije.komentari = this.beckupPermisije.komentari;
            this.permisije.poruke = this.beckupPermisije.poruke;
            this.permisije.rezervacija = this.beckupPermisije.rezervacija;
        },
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }
        else{
            this.getAllUsers();
        }
    }
}
</script>

<style scoped>

#titleEffect {
  color:#00bcd4;
  font-weight: bold;
}

#korisnici label {
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

#korisnici btn-top{
    margin-top:20px;
}
</style>