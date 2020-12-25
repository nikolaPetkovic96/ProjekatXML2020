<template>
    <div id="cenovnik" class="container">
        <div class="container">
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>Cenovnika</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>

        <div class="container" id='main'>
            <table class="table">
                <thead>
                    <tr>
                        <th>Naziv cenovnika</th>
                        <th>Cena po danu</th>
                        <th>Cena po kilometru</th>
                        <th>CDW</th>
                        <th>Popust preko 30 dana</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="cenovnik.id" v-for='cenovnik in cenovnici'>
                    <td>{{cenovnik.nazivCenovnika}}</td>
                    <td>{{cenovnik.cenaPoDanu}}</td>
                    <td>{{cenovnik.cenaPoKilometru}}</td>
                    <td>{{cenovnik.cenaCollisionDamageWaiver}}</td>
                    <td>{{cenovnik.popustZaPreko30Dana}}</td>
                    <td><button v-on:click='openEdit(cenovnik.id)'  class="btn-primary"> edit </button></td>
                </tr>
                </tbody>
            </table>
            <button  v-on:click='openNew()' class="btn  btn-success" style='padding-left: 5px;'>Dodaj cenovnik</button>
        </div>
    </div>
</template>

<script>

export default {
  name: 'Cenonvik',
   data(){
        return{
            user: {
                username: '',
                role: ''
            },

            cenovnici:[
               {
                    id:'1',
                    cenaPoDanu:100,
                    nazivCenovnika:'Cenovnik 1',
                    popustZaPreko30Dana:'10%',
                    cenaCollisionDamageWaiver:1000,
                    cenaPoKilometru:10
                },
                {
                    id:'2',
                    cenaPoDanu:200,
                    nazivCenovnika:'Cenovnik 2',
                    popustZaPreko30Dana:'20%',
                    cenaCollisionDamageWaiver:null,
                    cenaPoKilometru:20
                },
                {
                    id:'3',
                    cenaPoDanu:300,
                    nazivCenovnika:'Cenovnik 3',
                    popustZaPreko30Dana:null,
                    cenaCollisionDamageWaiver:3000,
                    cenaPoKilometru:30
                },
                {
                    id:'4',
                    cenaPoDanu:400,
                    nazivCenovnika:'Cenovnik 4',
                    popustZaPreko30Dana:'20%',
                    cenaCollisionDamageWaiver:null,
                    cenaPoKilometru:40
                },
                {
                    id:'5',
                    cenaPoDanu:500,
                    nazivCenovnika:'Cenovnik 5',
                    popustZaPreko30Dana:null,
                    cenaCollisionDamageWaiver:5000,
                    cenaPoKilometru:50
                },
            ],

        }
   },
   methods: {
        showAllAmenities:function(){
            axios
            .get('rest/cenovnici/')
            .then(response => {
                this.cenovnici=response.data;
            })
        },
        
        openNew:function(){
            this.$router.push('/price/new');
        },
        openEdit:function(id){
            this.$router.push(`/price/${id}/edit`);
        }
    },
}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}

</style>

