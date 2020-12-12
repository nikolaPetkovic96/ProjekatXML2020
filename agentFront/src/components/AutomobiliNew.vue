<template>
    <div id="car-new">
        <div class="container">
            <h1 style="margin-top:10px;color:#35424a;">Dodaj <span id='titleEffect'>automobil</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <!-- Page Content -->
        <div class="container">
            <img src="../assets/showcase4.jpg" alt="">
            <div class="row">
                <!-- Cars -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-0">
                        <label>Marka automobila</label>
                        <select v-model='AutomobilNew.markaAut'>
                            <option disabled value="">Marka</option>
                                <!-- <option v-for="type in types" v-on:click="checkApartment">{{type}}</option>  -->
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
                        <label>Tip goriva</label>
                        <select v-model='AutomobilNew.tipGoriva'>
                            <option disabled value="">Tip goriva</option>
                            <option v-bind:key="gorivo" v-for="gorivo in tipGoriva">{{gorivo}}</option> 
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
                            <input type="radio" required value="true" AutomobilNew.collisionDamageWaiver> True
                            <input type="radio" required value="false" AutomobilNew.collisionDamageWaiver> False
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
            tipGoriva:['benzin','dizel','plin','vodonik'], 
            tipMenjaca:['manuelni','automatksi','poluautomatski'],
            brojSedZaDec:null,

            AutomobilNew:{
                markaAut:'',
                modelAut:'',
                klasaAut:'',
                vrstaGoriva:'',
                tipMenjaca:'',
                ukupnaOcena:0,
                brojSedistaZaDecu:null,
                predjenaKilometraza:0,
                collisionDamageWaiver:null,
                images:[],
            }
        }
    },
    methods:{
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
        //prilikom kreiranja stranice opcija za broj sedista za decu se postavi na od 1 - 5;
        this.brojSedZaDec = this.range(0, 5);
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