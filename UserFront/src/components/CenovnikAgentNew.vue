<template>
    <div id="cenonvik-new">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>cenovnik</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container">
          
            <div>
                <div v-if='messages.errorNaziv' class="alert alert-danger" v-html="messages.errorNaziv"></div>       
                <label class='label'>Naziv cenovnika :</label>
                <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unestite naziv..."  v-model="noviCenovnik.nazivCenovnika">
                
                <div v-if='messages.errorCenaPoDanu' class="alert alert-danger" v-html="messages.errorCenaPoDanu"></div>       
                <label class='label'>Cena po danu :</label>
                <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unesite dnevnu cenu..." v-model="noviCenovnik.cenaPoDanu">
                
                <div v-if='messages.errorCenaPoKilometru' class="alert alert-danger" v-html="messages.errorCenaPoKilometru"></div>       
                <label class='label'>Cena po kilometru :</label>
                <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unesite kilometarsku cenu..."  v-model="noviCenovnik.cenaPoKilometru">

                <div v-if='messages.errorCenaCDW' class="alert alert-danger" v-html="messages.errorCenaCDW"></div>       
                <label class='label'>Cena za Collision Damage Waiver :</label>
                <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unesite CDW..." v-model="noviCenovnik.cenaCollisionDamageWaiver">
                
                <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
                <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
                <button class="btn btn-success" v-on:click='addPrice()'>Potvrdi</button>
                <button class="btn btn-danger" v-on:click='closeNew()'>Odustani</button>
            </div>
        </div>
    </div>
</template>

<script>
import userDataService from '../services/UserDataService'
export default {
    name: 'cenovnik-new',
    data(){
        return{
            noviCenovnik:{
                nazivCenovnika:'',
                cenaPoDanu: '',
                cenaCollisionDamageWaiver:'',
                cenaPoKilometru:''
            },
            messages:{
                errorNaziv:'',
                errorCenaPoDanu:'',
                errorCenaPoKilometru:'',
                errorCenaCDW:'',
                // errorCena30Dana:'',
                errorResponse:'',
                successResponse:'',
            }
        }
    },
    methods:{
        addPrice:function(){
            if(this.noviCenovnik.nazivCenovnika == ''){
                this.messages.errorNaziv =  `<h4>Naziv cenovnika ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorNaziv='',3000);
            }
            else if(this.noviCenovnik.cenaPoDanu == ''){
                this.messages.errorCenaPoDanu =  `<h4>Cena po danu ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoDanu = '' ,3000);
            }
            else if (this.isNumeric(this.noviCenovnik.cenaPoDanu)) {
                this.messages.errorCenaPoDanu = `<h4>Cena po danu mora biti broj!</h4>`;
                setTimeout(() => this.messages.errorCenaPoDanu = '', 5000);
            }
            else if(this.noviCenovnik.cenaPoKilometru == ''){
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoKilometru = '' ,5000);
            }
            else if(this.isNumeric(this.noviCenovnik.cenaPoKilometru)){
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru mora biti broj!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoKilometru = '' , 5000);
            }

            else if(this.isNumeric(this.noviCenovnik.cenaCollisionDamageWaiver)){
                this.messages.errorCenaCDW =  `<h4>CDW mora biti broj!</h4>`;
                setTimeout(()=>this.messages.errorCenaCDW = '' , 5000);
            }
            
            else if(this.noviCenovnik.nazivCenovnika == '' && this.noviCenovnik.cenaPoDanu == '' &&  this.noviCenovnik.CenaPoKilometru == ''){
                this.messages.errorNaziv =  `<h4>Naziv cenovnika ne sme biti prazno polje!</h4>`;
                this.messages.errorCenaPoDanu =  `<h4>Cena po danu ne sme biti prazno polje!</h4>`;
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru ne sme biti prazno polje!</h4>`;
                setTimeout(()=> this.messages.errorNaziv = '', 5000);
                setTimeout(()=> this.messages.errorCenaPoDanu = '', 5000); 
                setTimeout(()=> this.messages.errorCenaPoKilometru = '', 5000); 
            }
            else{
               userDataService.addCenovnik(this.noviCenovnik).then(Response => {
                    this.messages.successResponse = `<h4>Novi cenovnik je uspešno dodat!</h4>`;
                    this.resetFields();
                    setTimeout(() => this.messages.successResponse='', 5000);

                })
                .catch(error => {
                    if(error.response.status === 500 || error.response.status === 404){
                        this.messages.errorResponse= `<h4>We had some server errors, please try again later!</h4>`;
                        setTimeout(() => this.messages.errorResponse='', 5000);
                    }
                });
            }
        },
        closeNew:function(){
            this.$router.push('/price');
        },
        isNumeric(num) {
            //isNaN(num) returns true if the variable does NOT contain a valid number
            return isNaN(num);
        },
        resetFields(){
            this.noviCenovnik.id = '';
            this.noviCenovnik.nazivCenovnika= '';
            this.noviCenovnik.cenaPoDanu = '';
            this.noviCenovnik.cenaPoKilometru = '';
            this.noviCenovnik.cenaCollisionDamageWaiver = '';
        }
    },
    created(){
     
    },
}
</script>

<style scoped>
#titleEffect{
  color:#FF8C00;
}

.label{
  color:#35424a;
  display: block;
  margin: 10px 0 10px;
  font-size: 20px;
  font-weight: bold;
}

</style>