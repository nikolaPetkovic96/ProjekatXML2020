<template>
    <div id="car-new">
        <div class="container">
            <h1 style="margin-top:10px;color:#35424a;">Dodaj <span id='titleEffect'>automobil</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <!-- Page Content -->
        <div class="container">
            <img src="../assets/showcase4.jpg" alt="">
            <div style="margin-top:20px" v-if='messages.errorMarka' class="alert alert-danger" v-html="messages.errorMarka"></div>
            <div style="margin-top:20px" v-if='messages.errorModel' class="alert alert-danger" v-html="messages.errorModel"></div>
            <div style="margin-top:20px" v-if='messages.errorKlasa' class="alert alert-danger" v-html="messages.errorKlasa"></div>
            <div style="margin-top:20px" v-if='messages.errorMenjac' class="alert alert-danger" v-html="messages.errorMenjac"></div>
            <div style="margin-top:20px" v-if='messages.errorGorivo' class="alert alert-danger" v-html="messages.errorGorivo"></div>
            <div style="margin-top:20px" v-if='messages.errorBrojSedZaDec' class="alert alert-danger" v-html="messages.errorBrojSedZaDec"></div>
            <div style="margin-top:20px" v-if='messages.errorCDW' class="alert alert-danger" v-html="messages.errorCDW"></div>
            <div style="margin-top:20px" v-if='messages.errorImg' class="alert alert-danger" v-html="messages.errorImg"></div>
            <div class="row">
                <!-- Cars -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Marka automobila</label>
                        <select v-model='AutomobilNew.markaAut'>
                            <option disabled value="">Marka</option>
                            <option v-bind:key="marka" v-for="marka in markaAut">{{marka}}</option> 
                        </select>
                    </div>
                </div>
                        
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Model automobila</label>
                        <select v-model='AutomobilNew.modelAut'>
                            <option disabled value="">Model</option>
                            <option style="padding-bottom:5px;" v-bind:key="model" v-for="model in modelAut">{{model}}</option> 
                        </select>
                    </div>
                </div>    
                                    
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Klasa automobila</label>
                        <select v-model='AutomobilNew.klasaAut'>
                            <option disabled value="">Klasa</option>
                            <option v-bind:key="klasa" v-for="klasa in klasaAut">{{klasa}}</option>
                        </select>
                    </div>
                </div> 
                                    
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Tip menjaca</label>
                        <select v-model='AutomobilNew.tipMenjaca'>
                            <option disabled value="">Tip menjaca</option>
                            <option v-bind:key="menjac" v-for="menjac in tipMenjaca">{{menjac}}</option>
                        </select>
                    </div>
                </div> 
                
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Vrsta goriva</label>
                        <select v-model='AutomobilNew.vrstaGoriva'>
                            <option disabled value="">Vrsta goriva</option>
                            <option v-bind:key="gorivo" v-for="gorivo in vrstaGoriva">{{gorivo}}</option> 
                        </select>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Decija sedista</label>
                        <select v-model='AutomobilNew.brojSedistaZaDecu'>
                            <option disabled value="">Br. sed. za decu</option>
                            <option v-bind:key="bszd" v-for="bszd in brojSedZaDec">{{bszd}}</option>
                        </select>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <span>
                            <label>Coll Ddmg Waiver</label>
                            <input type="radio" required value="true" v-model='AutomobilNew.collisionDamageWaiver'> True
                            <input type="radio" required value="false" v-model='AutomobilNew.collisionDamageWaiver'> False
                        </span>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <span>
                            <label>Images</label>
                            <input type="file"  required value="true" >
                        </span>
                    </div>
                </div>
            <br>
            </div>
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
		    <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>  
            <button class="btn btn-success shadow" v-on:click='addCar()'>Save</button>
            <button class="btn btn-danger shadow" v-on:click='closeNew()'>Close</button>
           
        </div> <!--container-->
    </div> <!--Automobil-new-->
</template>

<script>
export default {
    name: 'Car-new',
    data:function(){
        return {
            //sve treba da se getuje sa beka sa getAllMarka, GetAllModel... i smesti u ove promenljive
            markaAut:['BMW','Audi','Mercedes','Tesla','Fiat'],
            modelAut:['M5','R8','A6','A8','Punto','500L'],
            klasaAut:['SUV','Old Tajmer','Gradski auto'],
            vrstaGoriva:['benzin','dizel','plin','vodonik'], 
            tipMenjaca:['manuelni','automatksi','poluautomatski'],
            brojSedZaDec:null,

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

            AutomobilNew:{
                markaAut:null,
                modelAut:null,
                klasaAut:null,
                vrstaGoriva:null,
                tipMenjaca:null,
                ukupnaOcena:0,
                brojSedistaZaDecu:null,
                predjenaKilometraza:0,
                collisionDamageWaiver:null,
                images:[],
            }
        }
    },
    methods:{
        addCar:function () {
			if (this.AutomobilNew.markaAut == null) {
				this.messages.errorMarka = `<h4>Polje marka automobila ne moze biti prazno!</h4>`;
				setTimeout(() => this.messages.errorMarka = '', 3000);
            }
			else if (this.AutomobilNew.modelAut == null) {
				this.messages.errorModel = `<h4>Polje model automobila ne moze biti prazno!</h4>`;
				setTimeout(() => this.messages.errorModel = '', 3000);
			}
			else if (this.AutomobilNew.klasaAut == null) {
				this.messages.errorKlasa= `<h4>Polje klasa automobila ne moze biti prazno!</h4>`;
				setTimeout(() => this.messages.errorKlasa = '', 3000);
			}
			else if (this.AutomobilNew.tipMenjaca == null) {
				this.messages.errorMenjac = `<h4>Polje tip menjaca ne moze biti prazno!</h4>`;
				setTimeout(() => this.messages.errorMenjac = '', 3000);
            }
            else if (this.AutomobilNew.vrstaGoriva == null) {
				this.messages.errorGorivo = `<h4>Polje vrsta goriva ne moze biti prazno!</h4>`;
				setTimeout(() => this.messages.errorGorivo = '', 3000);
			}
			else if (this.AutomobilNew.brojSedistaZaDecu == null) {
				this.messages.errorBrojSedZaDec = `<h4>Polje broj sedista za decu ne moze biti prazno!</h4>`;
				setTimeout(() => this.messages.errorBrojSedZaDec = '', 3000);
			}
			else if (this.AutomobilNew.collisionDamageWaiver == null) {
				this.messages.errorCDW = `<h4>Polje Collision Damage Waiver automobila ne moze biti prazno!</h4>`;
				setTimeout(() => this.messages.errorCDW = '', 3000);
            }
            else if (this.AutomobilNew.images.length == 0) {
				this.messages.errorImg = `<h4>Morate odabrati sliku/slike automobila!</h4>`;
				setTimeout(() => this.messages.errorImg = '', 3000);
            }
			else {
                console.log('Marka: ' + this.AutomobilNew.markaAut);
                console.log('Model: ' + this.AutomobilNew.modelAut); 
                console.log('Klasa: ' + this.AutomobilNew.klasaAut);
                console.log('Menjac: ' + this.AutomobilNew.tipMenjaca);
                console.log('Gorivo: ' + this.AutomobilNew.vrstaGoriva);
                console.log('BrSed: ' + this.AutomobilNew.brojSedistaZaDecu);
                console.log('BrCDW: ' + this.AutomobilNew.collisionDamageWaiver);
            }
        },

        closeNew:function(){
            this.$router.push('/cars');
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
    created() {
        if(JSON.parse(localStorage.getItem('token')) == null){
           this.$router.push(`/login`);
        }
        else{
            //prilikom kreiranja stranice opcija za broj sedista za decu se postavi na od 1 - 5;
            this.brojSedZaDec = this.range(0, 5);
        }
        
    }
}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}

#car-new label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

</style>