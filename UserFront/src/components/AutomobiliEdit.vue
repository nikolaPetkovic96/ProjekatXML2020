<template>
    <div id="car-edit">
        <div class="container">
            <h1 style="margin-top:10px;color:#35424a;">Izmeni <span id='titleEffect'>automobil</span>!</h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <!-- Page Content -->
        <div class="container">
            <img src="../assets/showcase3.jpg" alt="">
            <div class="row">
                <!-- Cars -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Marka automobila</label>
                        <select disabled v-model='automobil.markaAut'>
                            <option disabled value="">Marka</option>
                                <!-- <option v-for="type in types" v-on:click="checkApartment">{{type}}</option>  -->
                            <!-- <option v-bind:key="marka" v-for="marka in markaAut">{{marka}}</option>  -->
                             <option  v-bind:key="marka.id" v-on:click='addChoosenMarka(marka.id)' v-for="marka in markaAut">{{marka.nazivMarke}}</option> 
                        </select>
                    </div>
                </div>
                        
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Model automobila</label>
                        <select disabled v-model='automobil.modelAut'>
                            <option disabled value="">Model</option>
                            <!-- <option style="padding-bottom:5px;" v-bind:key="model" v-for="model in modelAut">{{model}}</option>  -->
                            <option v-bind:key="model.id" v-on:click='addChoosenModel(model.id)' v-for="model in modelAut">{{model.nazivModela}}</option>
                        </select>
                    </div>
                </div>    
                                    
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Klasa automobila</label>
                        <select v-model='automobil.klasaAut'>
                            <option disabled value="">Klasa</option>
                            <!-- <option v-bind:key="klasa" v-for="klasa in klasaAut">{{klasa}}</option> -->
                            <option v-bind:key="klasa.id" v-on:click='addChoosenKlasa(klasa.id)' v-for="klasa in klasaAut">{{klasa.nazivKlase}}</option>
                        </select>
                    </div>
                </div>
                                    
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Tip menjaca</label>
                        <select v-model='automobil.tipMenjaca'>
                            <option disabled value="">Tip menjaca</option>
                            <!-- <option v-bind:key="menjac" v-for="menjac in tipMenjaca">{{menjac}}</option> -->
                            <option v-bind:key="menjac.id" v-on:click='addChoosenMenjac(menjac.id)'  v-for="menjac in tipMenjaca">{{menjac.nazivMenjaca}}</option>
                        </select>
                    </div>
                </div> 

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Tip goriva</label>
                        <select v-model='automobil.tipGoriva'>
                            <option disabled value="">Tip goriva</option>
                            <!-- <option v-bind:key="gorivo" v-for="gorivo in vrstaGoriva">{{gorivo}}</option>  -->
                            <option v-bind:key="gorivo.id" v-on:click='addChoosenGorivo(gorivo.id)' v-for="gorivo in tipGoriva">{{gorivo.nazivTipa}}</option> 
                        </select>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Decija sedista</label>
                        <select v-model='automobil.brojSedistaZaDecu'>
                            <option disabled value="">Br. sed. za decu</option>
                            <option v-bind:key="bszd" v-for="bszd in brojSedZaDec">{{bszd}}</option>
                        </select>
                    </div>
                </div>

             <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <span>
                            <label>Coll Ddmg Waiver</label>
                            <input type="radio"  required value="true" v-model='automobil.collisionDamageWaiver'> True
                            <input type="radio"  required value="false" v-model='automobil.collisionDamageWaiver'> False
                        </span>
                    </div>
            </div>
            <br>
            </div>
            <!-- id: {{automobil.id}}<br>
            marka: {{automobil.markaAut}} <br> 
            model: {{automobil.modelAut}}<br> 
            klasa: {{automobil.klasaAut}}<br> 
            tipGoriva: {{automobil.tipGoriva}}<br> 
            tipMenjaca: {{automobil.tipMenjaca}}<br> 
            ukupnaOcena : {{automobil.ukupnaOcena}}<br>
            predjenaKilometraza : {{automobil.predjenaKilometraza}}<br>
            collisionDamageWaiver : {{automobil.collisionDamageWaiver}}<br>
            brojSedistaZaDecu : {{automobil.brojSedistaZaDecu}}<br>  
            <br>    
            id: {{this.AutomobilEdit.id}} <br> 
            markaId: {{AutomobilEdit.markaAutomobilaId}} <br> 
            modelId: {{AutomobilEdit.modelAutomobilaId}}<br> 
            klasaId: {{AutomobilEdit.klasaAutomobilaId}}<br> 
            tipGorivaId: {{AutomobilEdit.tipGorivaId}}<br> 
            tipMenjacaId: {{AutomobilEdit.tipMenjacaId}}<br> 
            ukupnaOcena : {{AutomobilEdit.ukupnaOcena}} <br> 
            predjenaKilometraza : {{AutomobilEdit.predjenaKilometraza }} <br> 
            collisionDamageWaiver : {{AutomobilEdit.collisionDamageWaiver }} <br> 
            brojSedistaZaDecu : {{AutomobilEdit.brojSedistaZaDecu}} <br>    -->

     
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
		    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>  
            <button class="btn btn-success shadow" v-on:click='editCar()'>Save</button>
            <button class="btn btn-danger shadow" v-on:click='closeEdit()'>Close</button>
           
        </div> <!--container-->
    </div> <!--Automobil-new-->
</template>

<script>
import UserDataService from '../services/UserDataService'
export default {
    name: 'Car-edit',
    data:function(){
        return {
            //sve treba da se getuje sa beka sa getAllMarka, GetAllModel... i smesti u ove promenljive
            markaAut:[],
            modelAut:[],
            modelAutFilt:[], //filtrirani prikaz modela spram odabrane marke
            klasaAut:[],
            tipGoriva:[], 
            tipMenjaca:[],
            brojSedZaDec:null,

            odabranaKompon:{
                markaAutomobila:null,
                modelAutomobila:null,
                klasaAutomobila:null,
                tipGoriva:null,
                tipMenjaca:null,
            },

             automobil:{
                id:'',
                markaAut:'',
                modelAut:'',
                klasaAut:'',
                tipGoriva:'',
                tipMenjaca:'',
                ukupnaOcena:null,
                brojSedistaZaDecu:null,
                predjenaKilometraza:null,
                collisionDamageWaiver:null,
            },

            AutomobilEdit:{
                id:null,
                markaAutomobilaId:null,
                modelAutomobilaId:null,
                klasaAutomobilaId:null,
                tipGorivaId:null,
                tipMenjacaId:null,
                ukupnaOcena:0,
                predjenaKilometraza:0,
                collisionDamageWaiver:null,
                brojSedistaZaDecu:null,   
            },

              messages: {
				errorResponse: '',
				successResponse: '',
			},

        }
    },
    methods:{
        fillEditData:function(automobil){
            console.log('Usao u fillEditData')
            for(let i = 0; i < this.markaAut.length; i++){
                if(automobil.markaAut == this.markaAut[i].nazivMarke){
                    this.AutomobilEdit.markaAutomobilaId = this.markaAut[i].id;
                }
            }
            for(let i = 0; i < this.modelAut.length; i++){
                if(automobil.modelAut == this.modelAut[i].nazivModela){
                    this.AutomobilEdit.modelAutomobilaId = this.modelAut[i].id;
                }
            }
            for(let i = 0; i < this.klasaAut.length; i++){
                if(automobil.klasaAut == this.klasaAut[i].nazivKlase){
                    this.AutomobilEdit.klasaAutomobilaId = this.klasaAut[i].id;
                }
            }
            for(let i = 0; i < this.tipGoriva.length; i++){
                if(automobil.tipGoriva == this.tipGoriva[i].nazivTipa){
                    this.AutomobilEdit.tipGorivaId = this.tipGoriva[i].id;
                }
            }
            for(let i = 0; i < this.tipMenjaca.length; i++){
                if(automobil.tipMenjaca == this.tipMenjaca[i].nazivMenjaca){
                    this.AutomobilEdit.tipMenjacaId = this.tipMenjaca[i].id;
                }
            }
            this.AutomobilEdit.id = automobil.id;
            this.AutomobilEdit.ukupnaOcena = automobil.ukupnaOcena;
            this.AutomobilEdit.predjenaKilometraza = automobil.predjenaKilometraza;
            this.AutomobilEdit.collisionDamageWaiver = automobil.collisionDamageWaiver;
            this.AutomobilEdit.brojSedistaZaDecu = automobil.brojSedistaZaDecu;   
            
        },
        editCar:function(){
            this.fillEditData(this.automobil);
            UserDataService.updateAutomobil(this.AutomobilEdit).then(response => {
                alert('Vaš automobil je uspešno izmenjen!');
                this.$router.push('/cars');
            }).catch(error  => {
                if (error.response.status === 500 || error.response.status === 404) {
                    this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokusajte ponovo kasnije!</h4>`;
                    setTimeout(() => this.messages.errorResponse = '', 5000);
                }
            });
        },

        getAutomobil:function(){
            UserDataService.getAutomobil(this.id).then(response => {
                this.automobil = response.data;
            });

        },
        closeEdit:function(){
            this.$router.push('/cars');
        },
        addChoosenMarka:function(id){
            this.AutomobilEdit.markaAutomobilaId = id;
            this.modelAutFilt = [];
            for(let i = 0; i < this.modelAut.length; i++){
                if(this.modelAut[i].markaAutomobilaId == id){
                    console.log('nasao poklapanje');
                    console.log('id: ' + id);
                    console.log('model.markaAutomobilaId: ' + this.modelAut[i].markaAutomobilaId);
                    this.modelAutFilt.push(this.modelAut[i]);
                }
            }
        },
        addChoosenModel:function(id){
            this.AutomobilEdit.modelAutomobilaId = id;
        },
        addChoosenKlasa:function(id){
            this.AutomobilEdit.klasaAutomobilaId = id;
        },
        addChoosenMenjac:function(id){
            this.AutomobilEdit.tipMenjacaId = id;
        },
        addChoosenGorivo:function(id){
            this.AutomobilEdit.tipGorivaId = id;
        },

        getAllOptions:function(){
            UserDataService.getAllMarkaAut().then(response => {
                this.markaAut = response.data;
            });
            UserDataService.getAllModelAut().then(response => {
                this.modelAut = response.data;
                // console.log(JSON.stringify(this.modelAut));
            });
            UserDataService.getAllKlasaAut().then(response => {
                this.klasaAut = response.data;
            });
            UserDataService.getAllTipMenjaca().then(response => {
                this.tipMenjaca = response.data;
            });
            UserDataService.getAllTipGoriva().then(response => {
                this.tipGoriva = response.data;
            });
        },

        // pomocna metoda za ogranicen odabir broja sedista za decu:
        range(start = 1, end) {
            var ans = [];
            for (let i = start; i <= end; i++) {
                ans.push(i);
            }
            return ans;
        },
    },
    computed: {
        id() {
            if(JSON.parse(localStorage.getItem('token')) == null){
                this.$router.push(`/login`);
            }else{
                return this.$route.params.id; //preuzimam id automobila na cijoj sam stranici za prikaz detalja
            }
        },
    },
    created() {
        if(JSON.parse(localStorage.getItem('token')) == null){
           this.$router.push(`/login`);
        }else{
            //prilikom kreiranja stranice opcija za broj sedista za decu se postavi na od 1 - 5;
            this.brojSedZaDec = this.range(0, 5);
            this.getAllOptions();
            this.getAutomobil();
        }
        
    },

}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}

#car-edit label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

</style>