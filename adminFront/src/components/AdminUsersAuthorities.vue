<template>  
    <div id='korisnici'>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Korisnika</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <!-- ❏ Blokirati, aktivirati i uklanjati iz sistema obične korisnike.
        ❏ Defisati permisije za svakog korisnika pojedinačno (npr. administrator može
        onemogućiti kreiranje rezervacija od strane nekog korisnika koji je mnogo puta
        otkazivao). -->
        <div class="container" id='main'>
            <table class="table">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Ime</th>
                        <th>Prezime</th>
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
                        <td>{{korisnik.TAdresa.Mesto}} {{korisnik.TAdresa.ulica}} {{korisnik.TAdresa.broj}}</td>
                        <td>{{korisnik.status}}</td>
                        <td>
                            <a href="#edit-amenity"><button v-if='korisnik.status=="aktivan"'  class=" btn-sm btn-outline-primary" v-on:click='activateUser(korisnik.id)'> blokiraj </button></a>
                            <a href="#edit-amenity"><button v-if='korisnik.status=="blokiran"' class=" btn-sm btn-outline-primary" v-on:click='blockUser(korisnik.id)'> aktiviraj </button></a>
                        </td>
                         <td><a href="#change-permision"><button class="btn-sm btn-outline-primary" v-on:click='checkPermission(korisnik)'> permisije </button></a>
                        <td><button class="btn-sm btn-danger" v-on:click='deleteUser(korisnik.id)'> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>

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
                    <!-- <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div> -->
                    <div id='codeType' class="row">
                        <!-- <div v-if='messages.errorMarka' class="alert alert-danger" v-html="messages.errorMarka"></div> -->
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
                    <button class="btn btn-top btn-success" v-on:click='sendPermission(permisije)'>Potvrdi</button>
                    <button class="btn btn-danger" v-on:click='closePermission()'>Odustani</button>
                </div> <!--Container-->
            </div>
        </div>
    </div> 
</template>

<script>
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
                komentari:false,
                poruke:true,
                rezervacija:true,
            },
            beckupPermisije:{
                komentari:null,
                poruke:null,
                rezervacija:null,
            },
            korisnici:[
                {
                    id:1,
                    korisnickoIme:'PeraMaXX',
                    ime:'Pera',
                    prezime:'Petrovic',
                    status:'aktivan',
                    TAdresa:{
                        mesto:'Ruma',
                        ulica:'8. Marta',
                        broj:'25',
                        postanskiBroj:'',
                    },
                },
                {
                    id:2,
                    korisnickoIme:'ZareMaXX',
                    ime:'Zarko',
                    prezime:'Zarkovic',
                    status:'aktivan',
                    TAdresa:{
                        mesto:'Novi Sad',
                        ulica:'Glavni bulevar',
                        broj:'bb',
                        postanskiBroj:'',
                    },
                },
                {
                    id:3,
                    korisnickoIme:'AnaCarica',
                    ime:'Ana',
                    prezime:'Anovic',
                    status:'aktivan',
                    TAdresa:{
                        mesto:'Beograd',
                        ulica:'9. Maja',
                        broj:'12',
                        postanskiBroj:'',
                    },
                },
                {
                    id:4,
                    korisnickoIme:'NeaktivnaCarica',
                    ime:'Neaktivna',
                    prezime:'Neaktivnovic',
                    status:'blokiran',
                    TAdresa:{
                        mesto:'Beograd',
                        ulica:'9. Maja',
                        broj:'12',
                        postanskiBroj:'',
                    },
                },
            ]
        }
    },
    methods:{
        activateUser:function(id){
            alert(`Status usera sa id:${id} ce biti postavljen na aktivan!`);
        },
        blockUser:function(id){
            alert(`Status usera sa id:${id} ce biti postavljen na blokiran!`);
        },
        checkPermission:function(chosenUser){
            if(this.isChangePermision === false){
                this.isChangePermision = true;
                this.showUser = chosenUser;
            }
            else if(this.isChangePermision === true){
                this.showUser = chosenUser;
            }
            //kada se udje u prikaz i izmenu permisija
            //trenutne permisije se bekapuju ukoliko korisnik izmeni permisije
            //ali ih ne sacuva nego cancel uradi kako bi se sacuvale stare permisije...
            this.beckupPermisije.komentari = this.permisije.komentari;
            this.beckupPermisije.poruke = this.permisije.poruke;
            this.beckupPermisije.rezervacija = this.permisije.rezervacija;
        },
        deleteUser:function(id){
            alert(`User sa id:${id} ce biti obrisan!`);
        },
        sendPermission:function(korisnik){

        },
        closePermission:function(){
            this.isChangePermision = false;
            //ovo preurediti prilikom povezivanja fronta i beka
            //Mozd prilikom cancela samo da se refreshuje stranica, tako bi se vratile stare permisije...
            this.permisije.komentari = this.beckupPermisije.komentari;
            this.permisije.poruke = this.beckupPermisije.poruke;
            this.permisije.rezervacija = this.beckupPermisije.rezervacija;
        },
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