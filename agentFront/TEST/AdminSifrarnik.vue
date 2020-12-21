<template>
    <div id="sifrarnik">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Sifri</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
            <div id='codeType' class="row">
					<div class="col-md-2 col-sm-6 mb-4">
                        <h4>Marke</h4>
						<button v-on:click='getMarkeTable()'><img src="../assets/messageSign.jpg" alt=""></button>
					</div>

					<div class="col-md-2 col-sm-6 mb-4">
                        <h4>Modeli</h4>
						<button v-on:click='getModelTable()'><img src="../assets/kmSign2.jpg" alt=""></button>
					</div>

					<div class="col-md-3 col-sm-6 mb-4">
						<h4>Klase</h4>
						<button v-on:click='getKlaseTable()'><img src="../assets/ratingSign2.jpg" alt=""></button>
					</div>

                    <div class="col-md-2 col-sm-6 mb-4">
                        <h4>Menjaci</h4>
						<button v-on:click='getMenjacTable()'><img src="../assets/messageSign.jpg" alt=""></button>
					</div>

					<div class="col-md-2 col-sm-6 mb-4">
                        <h4>Goriva</h4>
						<button v-on:click='getGorivaTable()'><img src="../assets/kmSign2.jpg" alt=""></button>
					</div>
            </div>
                <table class="table" v-if='isMarka'>
                    <thead>
                        <tr style='color:#35424a'><h2>Marka automobila </h2></tr>
                        <tr>
                            <th class="col-sm-8">Naziv marke</th>
                            <th class="col-sm-2">Promeni naziv</th>
                            <th class="col-sm-2">Obrisi marku</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-bind:key='marka.id' v-for='marka in markaAut'>
                            <td>{{marka.nazivMarke}}</td>
                            
                            <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEdit(marka)'> izmeni </button></a></td>
                            <td><button class="btn btn-sm btn-danger" v-on:click='deleteMarka(marka.id)'> ukloni </button>
                            </td>
                        </tr>
                    </tbody>
                </table>


                 <table class="table" v-if='isModel'>
                    <thead>
                        <tr style='color:#35424a'><h2>Model automobila </h2></tr>
                        <tr>
                            <th class="col-sm-8">Naziv modela</th>
                            <th class="col-sm-2">Promeni naziv</th>
                            <th class="col-sm-2">Obrisi marku</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-bind:key='model.id' v-for='model in modelAut'>
                            <td>{{model.nazivModela}}</td>
                            
                            <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEdit(model)'> izmeni </button></a></td>
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
                            <th class="col-sm-2">Obrisi marku</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-bind:key='klasa.id' v-for='klasa in klasaAut'>
                            <td>{{klasa.nazivKlase}}</td>
                            
                            <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEdit(klasa)'> izmeni </button></a></td>
                            <td><button class="btn btn-sm btn-danger" v-on:click='deleteKlasa(klasa.id)'> ukloni </button>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <table class="table" v-if='isMenjac'>
                    <thead>
                        <tr style='color:#35424a'><h2>Tip menjaca</h2></tr>
                        <tr>
                            <th class="col-sm-8">Naziv tipa</th>
                            <th class="col-sm-2">Promeni naziv</th>
                            <th class="col-sm-2">Obrisi marku</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-bind:key='menjac.id' v-for='menjac in tipMenjaca'>
                            <td>{{menjac.nazivMenjaca}}</td>
                            
                            <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEdit(menjac)'> izmeni </button></a></td>
                            <td><button class="btn btn-sm btn-danger" v-on:click='deleteMenjac(menjac.id)'> ukloni </button>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <table class="table" v-if='isGorivo'>
                    <thead>
                        <tr style='color:#35424a'><h2>Vrsta goriva </h2></tr>
                        <tr>
                            <th class="col-sm-8">Naziv vrste</th>
                            <th class="col-sm-2">Promeni naziv</th>
                            <th class="col-sm-2">Obrisi marku</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-bind:key='gorivo.id' v-for='gorivo in tipGoriva'>
                            <td>{{gorivo.nazivTipa}}</td>
                            
                            <td><a href="#edit-amenity"><button  class=" btn-sm btn-outline-primary" v-on:click='showEdit(gorivo)'> izmeni </button></a></td>
                            <td><button class="btn btn-sm btn-danger" v-on:click='deleteGorivo(gorivo.id)'> ukloni </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
  
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

                <div v-if='isAddNew' id="new-marka">
                    <div class="container" id='page-title'>
                        <h1 v-if='isAddNew' style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Model</span>
                        </h1>
                        <hr style='background:#35424a;height:1px;'>
                    </div>
                    <div class="container">
                        <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                        <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                        </div>
                        <div>
                            <div v-if='messages.errorModel' class="alert alert-danger" v-html="messages.errorModel"></div>
                            <label>Naziv novog modela:</label>
                            <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                                placeholder="Unesite naziv modela..." v-model="newModel.nazivModela">                           
                            <button class="btn btn-success" v-on:click='sendNew(newModel)'>Save</button>
                        </div>
                    </div>
                </div>
                <!--New Model-->
                <div v-if='isEdit' id="edit-marka"> 
                    <div class="container" id='page-title'>
                        <h1 style="margin-top:10px;color:#35424a;">Edit <span id='titleEffect'>Model</span></h1>
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
                        <button class="btn btn-success" v-on:click='editAmenity()'>Save</button>
                        <button class="btn btn-danger" v-on:click='closeEdit()'>Close</button>
                    </div>
                </div>
                <!--Edit Model-->


                <div v-if='isAddNew' id="new-model">
                    <div class="container" id='page-title'>
                        <h1 v-if='isAddNew' style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Model</span>
                        </h1>
                        <hr style='background:#35424a;height:1px;'>
                    </div>
                    <div class="container">
                        <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                        <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse">
                        </div>
                        <div>
                            <div v-if='messages.errorModel' class="alert alert-danger" v-html="messages.errorModel"></div>
                            <label>Naziv novog modela:</label>
                            <input style="width:100%; padding:10px; margin-bottom:25px" type="text"
                                placeholder="Unesite naziv modela..." v-model="newModel.nazivModela">                           
                            <button class="btn btn-success" v-on:click='sendNew(newModel)'>Save</button>
                        </div>
                    </div>
                </div>
                <!--New Model-->
                <div v-if='isEdit' id="edit-model"> 
                    <div class="container" id='page-title'>
                        <h1 style="margin-top:10px;color:#35424a;">Edit <span id='titleEffect'>Model</span></h1>
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
                        <button class="btn btn-success" v-on:click='editAmenity()'>Save</button>
                        <button class="btn btn-danger" v-on:click='closeEdit()'>Close</button>
                    </div>
                </div>
            <!--Edit Model-->
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

            novaMarka:{
                nazivMarke:'',
            },
            noviModel:{
                nazivModela:'',
            },
            novaKlasa:{
                nazivKlase:'',
            },
            noviMenjac:{
                nazivMenjaca:'',
            },
            novoGorivo:{
                nazivTipa:'',
            },
        
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

            newModel:{
                nazivModela:'',
            },
            
            updatedModel: {
                id: '',
                nazivModela: '',
            },
            beckupName: '',
        }
    },
    methods:{   
        showNew: function () {
            //Ako je otvoreno polje za edit zatvori se prvo
            // da bi se otvorilo polje za dodavanje novog sadrzaja.
            if (this.isEdit === true) {
                this.isEdit = false;

                //Ne cuva se novi naziv nego se vrati na naziv pre editovanja. 
                this.updatedModel.nazivModela = this.beckupName
            }

            if (this.isAddNew === true) {

                this.newModel.nazivModela = '';
            }
            this.isAddNew = !this.isAddNew
        },

        showEdit: function (chosenModel) {
            //Ako je otvoreno polje za dodavanje novog sadrzaja
            //zatvori se prvo da bi se otvorilo polje za edit.
            if (this.isAddNew === true) {
                this.isAddNew = false;
            }
            //Ako je vec otvoreno polje za edit
            //i odabere se neki drugi sadrzaj ostaje polje otvoreno,
            //a novi sadrzaj se edituje.
            if (this.isEdit === true) {
                this.isEdit = true;
                //ako promeni ime a ne sacuva nego skoci na sledeci sadrzaj
                //promenjeo ime se gubi i vraca na staro;
                this.updatedModel.nazivModela = this.beckupName

                this.updatedModel = chosenModel;
                this.beckupName = chosenModel.nazivModela;
            }
            else {
                this.isEdit = !this.isEdit;
                this.updatedModel = chosenModel;
                this.beckupName = chosenModel.nazivModela;                
            }
        },
        closeEdit() {
            //Ako je vec otvoreno polje za edit zatvori se.
            if (this.isEdit === true) {
                this.isEdit = !this.isEdit;
                //ako promeni ime a ne sacuva nego ugasi edit 
                //promenjeo ime se gubi i vraca na staro;
                this.updatedModel.nazivModela = this.beckupName
                // this.updatedAmenity = {};
            }
        },

        sendNew(newObject){
            if(isModel===true){
                alert('Salje se novi model: ' + newObject.nazivModela);
            }
            else if(isMarka===true){
                alert('Salje se nova marka: ' + newObject.nazivMarke);
            }
        },

        sendUpdate(updatedObject){

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
  color:gold;
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
