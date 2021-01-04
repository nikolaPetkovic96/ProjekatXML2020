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
                        <th>Izmeni</th>
                        <th>Obriši</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="cenovnik.id" v-for='cenovnik in cenovnici'>
                    <td>{{cenovnik.nazivCenovnika}}</td>
                    <td>{{cenovnik.cenaPoDanu}} din</td>
                    <td>{{cenovnik.cenaPoKilometru}} din</td>
                    <td>{{cenovnik.cenaCollisionDamageWaiver}} din</td>
                    <td>{{cenovnik.popustZaPreko30Dana}} %</td>
                    <td><button v-on:click='openEdit(cenovnik.id)'  class="btn-sm btn-outline-primary"> Izmeni </button></td>
                    <td><button v-on:click='deletePrice(cenovnik.id)'  class="btn btn-sm btn-danger"> Ukloni </button></td>
                </tr>
                </tbody>
            </table>
            <button  v-on:click='openNew()' class="btn  btn-success" style='padding-left: 5px;'>Dodaj cenovnik</button>
        </div>
    </div>
</template>

<script>
import agentDataService from '../services/AgentDataService'
export default {
 
  name: 'Cenonvik',
   data(){
        return{
            user: {
                username: '',
                role: ''
            },

            cenovnici:[],

        }
   },
   methods: {
        showAllPrices:function(){
            agentDataService.getAllCenovnik()
            .then(response => {
                this.cenovnici = response.data;
            })
        },
        deletePrice(id){
            if (confirm('Da li ste sigurni da želite obrisati ovaj cenovnik?')) {
               agentDataService.deleteCenovnik(id)
                .then(response => {
                    this. showAllPrices();
                })
            }
        },
        openNew:function(){
            this.$router.push('/price/new');
        },
        openEdit:function(id){
            this.$router.push(`/price/${id}/edit`);
        }
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.showAllPrices();
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

