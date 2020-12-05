<template>
    <div id="sifrarnik">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Šifri</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
        <!-- ❏ Održavanje šifrarnika (modeli automobila, klase, tip goriva….) -->
            <div id='codeType' class="row">
                <div class="col-md-2 col-sm-6 mb-4">
                    <h4>Marke</h4>
                    <button v-on:click='getMarkeTable()'><img src="../assets/carBrand2.jpg" alt=""></button>
                </div>

                <div class="col-md-2 col-sm-6 mb-4">
                    <h4>Modeli</h4>
                    <button v-on:click='getModelTable()'><img src="../assets/carModel3.png" alt=""></button>
                </div>

                <div class="col-md-3 col-sm-6 mb-4">
                    <h4>Klase</h4>
                    <button v-on:click='getKlaseTable()'><img src="../assets/carModel2.1.png" alt=""></button>
                </div>

                <div class="col-md-2 col-sm-6 mb-4">
                    <h4>Menjači</h4>
                    <button v-on:click='getMenjacTable()'><img src="../assets/carManual.png" alt=""></button>
                </div>

                <div class="col-md-2 col-sm-6 mb-4">
                    <h4>Goriva</h4>
                    <button v-on:click='getGorivaTable()'><img src="../assets/carGas.jpg" alt=""></button>
                </div>
            </div>

        <!--TABELE-->
            <table class="table" v-if='isMarka'>
                <thead>
                    <tr style='color:#35424a'><h2>Marka automobila </h2></tr>
                    <tr>
                        <th class="col-sm-8">Naziv marke</th>
                        <th class="col-sm-2">Promeni naziv</th>
                        <th class="col-sm-2">Obriši model</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='marka.id' v-for='marka in markaAut'>
                        <td>{{marka.nazivMarke}}</td>
                        
                        <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEditMarka(marka)'> izmeni </button></a></td>
                        <td><button class="btn btn-sm btn-danger" v-on:click='deleteMarka(marka.id)'> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>


            <table class="table" v-if='isModel'>
                <thead>
                    <tr style='color:#35424a'><h2>Model automobila</h2></tr>
                    <tr>
                        <th class="col-sm-8">Naziv modela</th>
                        <th class="col-sm-2">Promeni naziv</th>
                        <th class="col-sm-2">Obriši marku</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='model.id' v-for='model in modelAut'>
                        <td>{{model.nazivModela}}</td>
                        
                        <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEditModel(model)'> izmeni </button></a></td>
                        <td><button class="btn btn-sm btn-danger" v-on:click='deleteModel(model.id)'> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>

            <table class="table" v-if='isKlasa'>
                <thead>
                    <tr style='color:#35424a'><h2>Klasa automobila </h2></tr>
                    <tr>
                        <th class="col-sm-8">Naziv klase</th>
                        <th class="col-sm-2">Promeni naziv</th>
                        <th class="col-sm-2">Obriši klasu</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='klasa.id' v-for='klasa in klasaAut'>
                        <td>{{klasa.nazivKlase}}</td>
                        
                        <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEditKlasa(klasa)'> izmeni </button></a></td>
                    <td><button class="btn btn-sm btn-danger" v-on:click='deleteKlasa(klasa.id)'> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>

            <table class="table" v-if='isMenjac'>
                <thead>
                    <tr style='color:#35424a'><h2>Tip menjača</h2></tr>
                    <tr>
                        <th class="col-sm-8">Naziv tipa</th>
                        <th class="col-sm-2">Promeni naziv</th>
                        <th class="col-sm-2">Obriši menjač</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='menjac.id' v-for='menjac in tipMenjaca'>
                        <td>{{menjac.nazivMenjaca}}</td>
                        
                        <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEditMenjac(menjac)'> izmeni </button></a></td>
                        <td><button class="btn btn-sm btn-danger" v-on:click='deleteMenjac(menjac.id)'> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>

            <table class="table" v-if='isGorivo'>
                <thead>
                    <tr style='color:#35424a'><h2>Vrsta goriva</h2></tr>
                    <tr>
                        <th class="col-sm-8">Naziv vrste</th>
                        <th class="col-sm-2">Promeni naziv</th>
                        <th class="col-sm-2">Obriši gorivo</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-bind:key='gorivo.id' v-for='gorivo in tipGoriva'>
                        <td>{{gorivo.nazivTipa}}</td>
                        
                        <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEditGorivo(gorivo)'> izmeni </button></a></td>
                        <td><button class="btn btn-sm btn-danger" v-on:click='deleteGorivo(gorivo.id)'> ukloni </button>
                        </td>
                    </tr>
                </tbody>
            </table>

        <!-- DUGMAD -->
            <a href="#new-model" ><button  v-if='isMarka' v-on:click='showNewMarka()' class="btn btn-lg btn-dark"
                style='margin-top: 80px;'>Dodaj marku</button></a>

            <a href="#new-model" ><button  v-if='isModel' v-on:click='showNewModel()' class="btn btn-lg btn-dark"
                style='margin-top: 80px;'>Dodaj model</button></a>

            <a href="#new-model" ><button  v-if='isKlasa' v-on:click='showNewKlasa()' class="btn btn-lg btn-dark"
                style='margin-top: 80px;'>Dodaj klasu</button></a>

            <a href="#new-model" ><button  v-if='isMenjac' v-on:click='showNewMenjac()' class="btn btn-lg btn-dark"
                style='margin-top: 80px;'>Dodaj menjac</button></a>

            <a href="#new-model" ><button  v-if='isGorivo' v-on:click='showNewGorivo()' class="btn btn-lg btn-dark"
                style='margin-top: 80px;'>Dodaj gorivo</button></a>
            <hr>

    <!-- New i Edit -->
        <!--New i Edit Marka-->
            <div v-if='isAddNewMarka && isMarka' id="new-model">
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Nova <span id='titleEffect'>Marka</span>
                    </h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                </div>
                    <div>
                        <div v-if='messages.errorMarka' class="alert alert-danger" v-html="messages.errorMarka"></div>
                        <label >Naziv nove marke:</label>
                        <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                            placeholder="Unesite naziv marke..." v-model="newMarka.nazivMarke">                           
                        <button class="btn btn-success" v-on:click='sendNew(newMarka)'>Sačuvaj</button>
                    </div>
                </div>
            </div><!--New Marka-->

            <div v-if='isEditMarka && isMarka' id="edit-marka"> 
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Izmeni <span id='titleEffect'>Marku</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div v-if='messages.errorMarka' class="alert alert-danger" v-html="messages.errorMarka"></div>
                        <label>Naziv modela koji zelite izmeniti:</label>
                        <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                            v-model="updatedMarka.nazivMarke" placeholder="Unesite novi naziv marke...">

                    </div>
                    <button class="btn btn-success" v-on:click='sendUpdate(updatedMarka)'>Sačuvaj</button>
                    <button class="btn btn-danger" v-on:click='closeEditMarka()'>Zatvori</button>
                </div>
            </div> <!--Edit Marka-->
        <!--New i Edit Model--> 
            <div v-if='isAddNewModel  && isModel' id="new-model">
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Model</span>
                    </h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div>
                            <div v-if='messages.errorModel' class="alert alert-danger" v-html="messages.errorModel"></div>
                            <label >Naziv novog modela:</label>
                            <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                                placeholder="Unesite naziv modela..." v-model="newModel.nazivModela">                           
                            <button class="btn btn-success" v-on:click='sendNew(newModel)'>Sačuvaj</button>
                        </div>
                    </div>
                </div>
            </div><!--New Model-->

            <div v-if='isEditModel && isModel' id="edit-marka"> 
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Izmeni <span id='titleEffect'>Model</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div v-if='messages.errorModel' class="alert alert-danger" v-html="messages.errorModel"></div>
                        <label>Naziv modela koji zelite izmeniti:</label>
                        <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                            v-model="updatedModel.nazivModela" placeholder="Unesite novi naziv modela...">

                    </div>
                    <button class="btn btn-success" v-on:click='sendUpdate(updatedModel)'>Sačuvaj</button>
                    <button class="btn btn-danger" v-on:click='closeEditModel()'>Zatvori</button>
                </div>
            </div> <!--Edit Model-->

        <!--New i Edit Klase--> 
            <div v-if='isAddNewKlasa && isKlasa' id="new-klasa">
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Nova <span id='titleEffect'>Klasa</span>
                    </h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div>
                            <div v-if='messages.errorKlasa' class="alert alert-danger" v-html="messages.errorKlasa"></div>
                            <label>Naziv nove klase:</label>
                            <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                                placeholder="Unesite naziv klase..." v-model="newKlasa.nazivKlase">                           
                            <button class="btn btn-success" v-on:click='sendNew(newKlasa)'>Sačuvaj</button>
                        </div>
                    </div>
                </div>
            </div><!--New Klasa-->

            <div v-if='isEditKlasa && isKlasa' id="edit-marka"> 
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Izmeni <span id='titleEffect'>Klasu</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div v-if='messages.errorKlasa' class="alert alert-danger" v-html="messages.errorKlasa"></div>
                        <label>Naziv modela koji zelite izmeniti:</label>
                        <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                            v-model="updatedKlasa.nazivKlase" placeholder="Unesite novi naziv klase...">

                    </div>
                    <button class="btn btn-success" v-on:click='sendUpdate(updatedKlasa)'>Sačuvaj</button>
                    <button class="btn btn-danger" v-on:click='closeEditKlasa()'>Zatvori</button>
                </div>
            </div> <!--Edit  Klasa-->

        <!--New i Edit Menjac--> 
            <div v-if='isAddNewMenjac && isMenjac' id="new-menjac">
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Menjac</span>
                    </h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div>
                            <div v-if='messages.errorMenjac' class="alert alert-danger" v-html="messages.errorMenjac"></div>
                            <label>Naziv novog menjaca:</label>
                            <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                                placeholder="Unesite naziv menjaca..." v-model="newMenjac.nazivMenjaca">                           
                            <button class="btn btn-success" v-on:click='sendNew(newMenjac)'>Sačuvaj</button>
                        </div>
                    </div>
                </div>
            </div><!--New Menjac-->

            <div v-if='isEditMenjac && isMenjac' id="edit-marka"> 
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Izmeni <span id='titleEffect'>Menjac</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div v-if='messages.errorMenjaca' class="alert alert-danger" v-html="messages.errorMenjaca"></div>
                        <label>Naziv menjaca koji zelite izmeniti:</label>
                        <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                            v-model="updatedMenjac.nazivMenjaca" placeholder="Unesite novi naziv menjaca...">

                    </div>
                    <button class="btn btn-success" v-on:click='sendUpdate(updatedMenjac)'>Sačuvaj</button>
                    <button class="btn btn-danger" v-on:click='closeEditKlasa()'>Zatvori</button>
                </div>
            </div> <!--Edit  Menjac-->


        <!--New i Edit Gorivo--> 
            <div v-if='isAddNewGorivo && isGorivo' id="new-gorivo">
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Nova vrsta <span id='titleEffect'>Goriva</span>
                    </h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div>
                            <div v-if='messages.errorGorivo' class="alert alert-danger" v-html="messages.errorGorivo"></div>
                            <label>Naziv nove vrste goriva:</label>
                            <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                                placeholder="Unesite naziv goriva..." v-model="newGorivo.nazivTipa">                           
                            <button class="btn btn-success" v-on:click='sendNew(newGorivo)'>Sačuvaj</button>
                        </div>
                    </div>
                </div>
            </div><!--New Gorivo-->

            <div v-if='isEditGorivo && isGorivo' id="edit-gorivo"> 
                <div class="container" id='page-title'>
                    <h1 style="margin-top:10px;color:#35424a;">Izmeni vrstu <span id='titleEffect'>Goriva</span></h1>
                    <hr style='background:#35424a;height:1px;'>
                </div>
                <div class="container">
                    <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                    </div>
                    <div>
                        <div v-if='messages.errorGorivo' class="alert alert-danger" v-html="messages.errorGorivo"></div>
                        <label>Naziv goriva koji zelite izmeniti:</label>
                        <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                            v-model="updatedGorivo.nazivTipa" placeholder="Unesite novi naziv goriva...">

                    </div>
                    <button class="btn btn-success" v-on:click='sendUpdate(updatedGorivo)'>Sačuvaj</button>
                    <button class="btn btn-danger" v-on:click='closeEditGorivo()'>Zatvori</button>
                </div>
            </div> <!--Edit  Menjac-->
            <hr>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Sifrarnik',
    data:function(){
        return {
            isMarka:true,
            isModel:false,
            isKlasa:false,
            isMenjac:false,
            isGorivo:false,

            isAddNew: false,
            isEdit: false,

            isAddNewModel:false,
            isAddNewMarka:false,
            isAddNewKlasa:false,
            isAddNewMenjac:false,
            isAddNewGorivo:false,

            isEditModel:false,
            isEditMarka:false,
            isEditKlasa:false,
            isEditMenjac:false,
            isEditGorivo:false,

            messages: {
				errorMarka: '',
				errorModel: '',
				errorKlasa: '',
				errorGorivo: '',
				errorMenjac: '',
				errorBrojSedZaDec: '',
				errorCDW: '',
				errorImg: '',
				errorResponse: '',
				successResponse: '',
            },
        //Objekti za tabelu
            markaAut:[
                {
                    id:1,
                    nazivMarke:'BMW',
                },
                {
                    id:2,
                    nazivMarke:'Audi',
                },
                {
                    id:3,
                    nazivMarke:'Mercedes',
                },
                {
                    id:4,
                    nazivMarke:'Tesla',
                },
                {
                    id:5,
                    nazivMarke:'Fiat',
                },
            ],

            modelAut:[
                {
                    id:1,
                    nazivModela:'M5',
                },
                {
                    id:2,
                    nazivModela:'R8',
                },
                {
                    id:3,
                    nazivModela:'A6',
                },
                {
                    id:4,
                    nazivModela:'A8',
                },
                {
                    id:5,
                    nazivModela:'Punto',
                },
                {
                    id:6,
                    nazivModela:'500L',
                },
            ],
             
            klasaAut:[
                {
                    id:1,
                    nazivKlase:'SUV',
                },
                                {
                    id:2,
                    nazivKlase:'Old Tajmer',
                },
                                {
                    id:3,
                    nazivKlase:'Gradski auto',
                },
                                {
                    id:4,
                    nazivKlase:'Smart car',
                },
            ],

            tipGoriva:[
                {
                    id:1,
                    nazivTipa:'benzin',
                },
                {
                    id:2,
                    nazivTipa:'dizel',
                },
                {
                    id:3,
                    nazivTipa:'plin',
                },
                {
                    id:4,
                    nazivTipa:'vodonik',
                },
            ],

            tipMenjaca:[
                {
                    id:1,
                    nazivMenjaca:'manuelni',
                },
                {
                    id:2,
                    nazivMenjaca:'atomatik',
                },
            ],

        //New objects   
            newMarka:{
                nazivMarke:'',
            },

            newModel:{
                nazivModela:'',
            },

            newKlasa:{
                nazivKlase:'',
            },
            newMenjac:{
                nazivMenjaca:'',
            },
            newGorivo:{
                nazivTipa:'',
            },
        //Updated objects     
            updatedMarka: {
                id: '',
                nazivMarke: '',
            },
            updatedModel: {
                id: '',
                nazivModela: '',
            },
            updatedKlasa: {
                id: '',
                nazivKlase: '',
            },
            updatedMenjac: {
                id: '',
                nazivMenjaca: '',
            },
            updatedGorivo: {
                id: '',
                nazivTipa: '',
            },

            beckupName: '',

        }
    },
    methods:{  
    //Marka
        showNewMarka: function () {
            //Ako je otvoreno polje za edit zatvori se prvo
            // da bi se otvorilo polje za dodavanje novog sadrzaja.
            if (this.isEditMarka === true) {
                this.isEditMarka = false;

                //Ne cuva se novi naziv nego se vrati na naziv pre editovanja. 
                this.updatedMarka.nazivMarke = this.beckupName;
            }

            if (this.isAddNewMarka === true) {

                this.newMarka.nazivMarke = '';
            }
            this.isAddNewMarka = !this.isAddNewMarka;
        },

        showEditMarka: function (chosenMarka) {
            //Ako je otvoreno polje za dodavanje novog sadrzaja
            //zatvori se prvo da bi se otvorilo polje za edit.
            if (this.isAddNewMarka === true) {
                this.isAddNewMarka = false;
                this.newMarka.nazivMarke = '';
            }
            //Ako je vec otvoreno polje za edit
            //i odabere se neki drugi sadrzaj ostaje polje otvoreno,
            //a novi sadrzaj se edituje.
            if (this.isEditMarka === true) {
                this.isEditMarka = true;
                //ako promeni ime a ne sacuva nego skoci na sledeci sadrzaj
                //promenjeo ime se gubi i vraca na staro;
                this.updatedMarka.nazivMarke = this.beckupName

                this.updatedMarka = chosenMarka;
                this.beckupName = chosenMarka.nazivMarke;
            }
            else {
                this.isEditMarka = !this.isEditMarka;
                this.updatedMarka = chosenMarka;
                this.beckupName = chosenMarka.nazivMarke;  
                console.log('updatedEntitet.nazivModela: ' + this.updatedMarka.nazivMarke);
                console.log('ChosenEntitet.nazivModela: ' + chosenMarka.nazivMarke);              
            }
        },
        closeEditMarka() {
            //Ako je vec otvoreno polje za edit zatvori se.
            if (this.isEditMarka === true) {
                this.isEditMarka = !this.isEditMarka;
                //ako promeni ime a ne sacuva nego ugasi edit 
                //promenjeo ime se gubi i vraca na staro;
                this.updatedMarka.nazivMarke = this.beckupName
                // this.updatedAmenity = {};
            }
        },

    //Model
        showNewModel: function () {
            //Ako je otvoreno polje za edit zatvori se prvo
            // da bi se otvorilo polje za dodavanje novog sadrzaja.
            if (this.isEditModel === true) {
                this.isEditModel = false;

                //Ne cuva se novi naziv nego se vrati na naziv pre editovanja. 
                this.updatedModel.nazivModela = this.beckupName
            }

            if (this.isAddNewModel === true) {

                this.newModel.nazivModela = '';
            }
            this.isAddNewModel = !this.isAddNewModel
        },
        showEditModel: function(chosenModel) {
            //Ako je otvoreno polje za dodavanje novog sadrzaja
            //zatvori se prvo da bi se otvorilo polje za edit.
            if (this.isAddNewModel === true) {
                this.isAddNewModel = false;
                this.newModel.nazivModela = '';
            }
            //Ako je vec otvoreno polje za edit
            //i odabere se neki drugi sadrzaj ostaje polje otvoreno,
            //a novi sadrzaj se edituje.
            if (this.isEditModel === true) {
                this.isEditModel = true;
                //ako promeni ime a ne sacuva nego skoci na sledeci sadrzaj
                //promenjeo ime se gubi i vraca na staro;
                this.updatedModel.nazivModela = this.beckupName

                this.updatedModel = chosenModel;
                this.beckupName = chosenModel.nazivModela;
            }
            else {
                this.isEditModel = !this.isEditModel;
                this.updatedModel = chosenModel;
                this.beckupName = chosenModel.nazivModela;  
                console.log('updatedEntitet.nazivModela: ' + this.updatedModel.nazivModela);
                console.log('ChosenEntitet.nazivModela: ' + chosenModel.nazivModela);              
            }
        },
        closeEditModel() {
            //Ako je vec otvoreno polje za edit zatvori se.
            if (this.isEditModel === true) {
                this.isEditModel = !this.isEditModel;
                //ako promeni ime a ne sacuva nego ugasi edit 
                //promenjeo ime se gubi i vraca na staro;
                this.updatedModel.nazivModela = this.beckupName
                // this.updatedAmenity = {};
            }
        },


    //Klasa
        showNewKlasa: function () {
            //Ako je otvoreno polje za edit zatvori se prvo
            // da bi se otvorilo polje za dodavanje novog sadrzaja.
            if (this.isEditKlasa === true) {
                this.isEditKlasa = false;

                //Ne cuva se novi naziv nego se vrati na naziv pre editovanja. 
                this.updatedKlasa.nazivKlase = this.beckupName
            }

            if (this.isAddNewKlasa === true) {

                this.newKlasa.nazivKlase = '';
            }
            this.isAddNewKlasa = !this.isAddNewKlasa
        },
        showEditKlasa: function(chosenKlasa) {
            //Ako je otvoreno polje za dodavanje novog sadrzaja
            //zatvori se prvo da bi se otvorilo polje za edit.
            if (this.isAddNewKlasa === true) {
                this.isAddNewKlasa = false;
                this.newKlasa.nazivKlase = '';
            }
            //Ako je vec otvoreno polje za edit
            //i odabere se neki drugi sadrzaj ostaje polje otvoreno,
            //a novi sadrzaj se edituje.
            if (this.isEditKlasa === true) {
                this.isEditKlasa = true;
                //ako promeni ime a ne sacuva nego skoci na sledeci sadrzaj
                //promenjeo ime se gubi i vraca na staro;
                this.updatedKlasa.nazivKlase = this.beckupName

                this.updatedKlase = chosenKlasa;
                this.beckupName = chosenKlasa.nazivKlase;
            }
            else {
                this.isEditKlasa = !this.isEditKlasa;
                this.updatedKlasa = chosenKlasa;
                this.beckupName = chosenKlasa.nazivKlase;  
                console.log('updatedEntitet.nazivModela: ' + this.updatedKlasa.nazivKlase);
                console.log('ChosenEntitet.nazivModela: ' + chosenKlasa.nazivKlase);              
            }
        },
        closeEditKlasa() {
            //Ako je vec otvoreno polje za edit zatvori se.
            if (this.isEditKlasa === true) {
                this.isEditKlasa = !this.isEditKlasa;
                //ako promeni ime a ne sacuva nego ugasi edit 
                //promenjeo ime se gubi i vraca na staro;
                this.updatedKlasa.nazivKlase = this.beckupName
                // this.updatedAmenity = {};
            }
        },

    //Menjac
        showNewMenjac: function () {
            //Ako je otvoreno polje za edit zatvori se prvo
            // da bi se otvorilo polje za dodavanje novog sadrzaja.
            if (this.isEditMenjac === true) {
                this.isEditMenjac = false;

                //Ne cuva se novi naziv nego se vrati na naziv pre editovanja. 
                this.updatedMenjac.nazivMenjaca = this.beckupName;
            }

            if (this.isAddNewMenjac === true) {

                this.newMenjac.nazivMenjaca = '';
            }
            this.isAddNewMenjac = !this.isAddNewMenjac;
        },
        showEditMenjac: function(chosenMenjac) {
            //Ako je otvoreno polje za dodavanje novog sadrzaja
            //zatvori se prvo da bi se otvorilo polje za edit.
            if (this.isAddNewMenjac === true) {
                this.isAddNewMenjac = false;
                this.newMenjac.nazivMenjaca = '';
            }
            //Ako je vec otvoreno polje za edit
            //i odabere se neki drugi sadrzaj ostaje polje otvoreno,
            //a novi sadrzaj se edituje.
            if (this.isEditMenjac === true) {
                this.isEditMenjac = true;
                //ako promeni ime a ne sacuva nego skoci na sledeci sadrzaj
                //promenjeo ime se gubi i vraca na staro;
                this.updatedMenjac.nazivMenjaca = this.beckupName

                this.updatedMenjac = chosenMenjac;
                this.beckupName = chosenMenjac.nazivMenjaca;
            }
            else {
                this.isEditMenjac = !this.isEditMenjac;
                this.updatedMenjac = chosenMenjac;
                this.beckupName = chosenMenjac.nazivMenjaca;  
                console.log('updatedEntitet.nazivMenjaca: ' + this.updatedMenjac.nazivMenjaca);
                console.log('ChosenEntitet.nazivMenjaca: ' + chosenMenjac.nazivMenjaca);              
            }
        },
        closeEditMenjac() {
            //Ako je vec otvoreno polje za edit zatvori se.
            if (this.isEditMenjac === true) {
                this.isEditMenjac = !this.isEditMenjac;
                //ako promeni ime a ne sacuva nego ugasi edit 
                //promenjeo ime se gubi i vraca na staro;
                this.updatedMenjac.nazivMenjaca = this.beckupName
                // this.updatedAmenity = {};
            }
        },

    //Gorivo
        showNewGorivo: function () {
            //Ako je otvoreno polje za edit zatvori se prvo
            // da bi se otvorilo polje za dodavanje novog sadrzaja.
            if (this.isEditGorivo === true) {
                this.isEditGorivo = false;

                //Ne cuva se novi naziv nego se vrati na naziv pre editovanja. 
                this.updatedGorivo.nazivTipa = this.beckupName;
            }

            if (this.isAddNewGorivo === true) {

                this.newGorivo.nazivTipa = '';
            }
            this.isAddNewGorivo = !this.isAddNewGorivo;
        },
        showEditGorivo:function(chosenGorivo) {
            //Ako je otvoreno polje za dodavanje novog sadrzaja
            //zatvori se prvo da bi se otvorilo polje za edit.
            if (this.isAddNewGorivo === true) {
                this.isAddNewGorivo = false;
                this.newGorivo.nazivTipa = '';
            }
            //Ako je vec otvoreno polje za edit
            //i odabere se neki drugi sadrzaj ostaje polje otvoreno,
            //a novi sadrzaj se edituje.
            if (this.isEditGorivo === true) {
                this.isEditGorivo = true;
                //ako promeni ime a ne sacuva nego skoci na sledeci sadrzaj
                //promenjeo ime se gubi i vraca na staro;
                this.updatedGorivo.nazivTipa = this.beckupName

                this.updatedGorivo = chosenGorivo;
                this.beckupName = chosenGorivo.nazivTipa;
            }
            else {
                this.isEditGorivo = !this.isEditGorivo;
                this.updatedGorivo = chosenGorivo;
                this.beckupName = chosenGorivo.nazivTipa;  
                console.log('updatedEntitet.nazivTipa: ' + this.updatedGorivo.nazivTipa);
                console.log('ChosenEntitet.nazivTipa: ' + chosenGorivo.nazivTipa);              
            }
        },
        closeEditGorivo() {
            //Ako je vec otvoreno polje za edit zatvori se.
            if (this.isEditGorivo === true) {
                this.isEditGorivo = !this.isEditGorivo;
                //ako promeni ime a ne sacuva nego ugasi edit 
                //promenjeo ime se gubi i vraca na staro;
                this.updatedGorivo.nazivTipa = this.beckupName
                // this.updatedAmenity = {};
            }
        },


    //Other
        sendNew(newObject){
            if(this.isModel===true){
                alert('Salje se novi model: ' + newObject.nazivModela);
            }
            else if(this.isMarka===true){
                alert('Salje se nova marka: ' + newObject.nazivMarke);
            }
            else if(this.isKlasa===true){
                alert('Salje se nova klasa: ' + newObject.nazivKlase);
            }
            else if(this.isMenjac===true){
                alert('Salje se novi menjac: ' + newObject.nazivMenjaca);
            }
            else if(this.isGorivo===true){
                alert('Salje se novo gorivo: ' + newObject.nazivTipa);
            }
        },

        sendUpdate(updatedObject){
            if(this.isModel===true){
                alert('Salje se update modela: ' + updatedObject.nazivModela);
            }
            else if(this.isMarka===true){
                alert('Salje se update marke: ' + updatedObject.nazivMarke);
            }
            else if(this.isKlasa===true){
                alert('Salje se update klase: ' + updatedObject.nazivKlase);
            }
             else if(this.isMenjac===true){
                alert('Salje se update menjaca: ' + updatedObject.nazivMenjaca);
            }
             else if(this.isGorivo===true){
                alert('Salje se update goriva: ' + updatedObject.nazivTipa);
            }
        },

        getMarkeTable:function(){
            this.isMarka = true;
            this.isModel = false;
            this.isKlasa = false;
            this.isMenjac = false;
            this.isGorivo = false;

            // alert('Getuje se Marka automobila!');
        },
        getModelTable:function(){
            this.isMarka = false;
            this.isModel = true;
            this.isKlasa = false;
            this.isMenjac = false;
            this.isGorivo = false;

            // alert('Getuje se Model automobila!');
        },
        getKlaseTable:function(){
            this.isMarka = false;
            this.isModel = false;
            this.isKlasa = true;
            this.isMenjac = false;
            this.isGorivo = false;

            // alert('Getuje se Klasa automobila!');
        },
        getMenjacTable:function(){
            this.isMarka = false;
            this.isModel = false;
            this.isKlasa = false;
            this.isMenjac = true;
            this.isGorivo = false;

            // alert('Getuje se Menjac automobila!');
        },
        getGorivaTable:function(){
            this.isMarka = false;
            this.isModel = false;
            this.isKlasa = false;
            this.isMenjac = false;
            this.isGorivo = true;

            // alert('Getuje se Gorivo automobila!');
        },

        deleteModel:function(id){
            alert(`Bice obrisan model ${id}!`);
        },
        deleteMarka:function(id){
            alert(`Bice obrisana marka ${id}!`);
        },
        deleteKlasa:function(id){
            alert(`Bice obrisana klasa ${id}!`);
        },
        deleteMenjac:function(id){
            alert(`Bice obrisan menjac ${id}!`);
        },
        deleteGorivo:function(id){
            alert(`Bice obrisano gorivo ${id}!`);
        },
    }  
}
    
</script>

<style scoped>
#titleEffect{
  color:#00bcd4;
  font-weight: bold;
}

#sifrarnik label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}
</style>
