<template>
    <div id="automobili-new">
        <div class="container">
            <h1 style="margin-top:10px;color:#35424a;">Dodaj <span id='titleEffect'>automobil</span>!</h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <!-- Page Content -->
        <div class="container">
            <div class="row">
              
                    <!-- Cars -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-0 shadow">
                            <label>Brend automobila</label>
                            <select>
                                <option disabled value="">Type</option>
                                <!-- <option v-for="type in types" v-on:click="checkApartment">{{type}}</option>  -->
                                <!-- <option v-for="type in types">{{type}}</option>  -->
                            </select>
                        </div>
                    </div>
                          
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-0 shadow">
                            <label>Model automobila</label>
                            <select>
                                <option disabled value="">Type</option>
                                <!-- <option v-for="type in types" v-on:click="checkApartment">{{type}}</option>  -->
                                <!-- <option v-for="type in types">{{type}}</option>  -->
                            </select>
                        </div>
                    </div>    
                                       
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-0 shadow">
                            <label>Tip automobila</label>
                            <select >
                                <option disabled value="">Type</option>
                                <!-- <option v-for="type in types" v-on:click="checkApartment">{{type}}</option>  -->
                                <!-- <option v-for="type in types">{{type}}</option>  -->
                            </select>
                        </div>
                    </div> 

                                       
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-0 shadow">
                            <label>Type of apartment</label>
                            <select >
                                <option disabled value="">Type</option>
                                <!-- <option v-for="type in types" v-on:click="checkApartment">{{type}}</option>  -->
                                <!-- <option v-for="type in types">{{type}}</option>  -->
                            </select>
                        </div>
                    </div> 
                                
                        
                    <button class="btn btn-success" v-on:click='addCar()'>Save</button>
                    <button class="btn btn-danger" v-on:click='closeNew()'>Close</button>
            </div>
        </div> <!--container-->
    </div> <!--Automobil-new-->
</template>

<script>
export default {
    name: 'Footer',
    data:function(){
        return {
        }
    },
    methods:{
        closeNew:function(){
            this.$router.push('/cars');
        }
    }
}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}

</style>