<template>
    <div id="cenonvik-new">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>cenovnik</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container">
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
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

                <div v-if='messages.errorCena30Dana' class="alert alert-danger" v-html="messages.errorCena30Dana"></div>       
                <label class='label'>Popust za preko 30 dana :</label>
                <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unesite popust..." v-model="noviCenovnik.popustZaPreko30Dana">
                
                <button class="btn btn-success" v-on:click='addPrice()'>Save</button>
                <button class="btn btn-danger" v-on:click='closeNew()'>Close</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'cenovnik-new',
    data(){
        return{
            noviCenovnik:{
                id:'',
                cenaPoDanu:'',
                nazivCenovnika:'',
                popustZaPreko30Dana:'',
                cenaCollisionDamageWaiver:'',
                cenaPoKilometru:''
            },
            messages:{
                errorNaziv:'',
                errorCenaPoDanu:'',
                errorCenaPoKilometru:'',
                errorCenaCDW:'',
                errorCena30Dana:'',
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
            else if(this.noviCenovnik.cenaPoKilometru == ''){
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoKilometru = '' ,3000);
            }
            
            else if(this.noviCenovnik.nazivCenovnika== '' && this.noviCenovnik.cenaPoDanu == '' &&  this.noviCenovnik.CenaPoKilometru == ''){
                this.messages.errorNaziv =  `<h4>Naziv cenovnika ne sme biti prazno polje!</h4>`;
                this.messages.errorCenaPoDanu =  `<h4>Cena po danu ne sme biti prazno polje!</h4>`;
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru ne sme biti prazno polje!</h4>`;
                setTimeout(()=> this.messages.errorNaziv = '', 3000);
                setTimeout(()=> this.messages.errorCenaPoDanu = '', 3000); 
                setTimeout(()=> this.messages.errorCenaPoKilometru = '', 3000); 
            }
            else{
                alert(`
                    ${this.noviCenovnik.nazivCenovnika}
                    ${this.noviCenovnik.cenaPoDanu}
                    ${this.noviCenovnik.cenaPoKilometru}
                    ${this.noviCenovnik.popustZaPreko30Dana}
                    ${this.noviCenovnik.cenaCollisionDamageWaiver}
                `);
                // cenovnici.add(this.noviCenovnik);
                // axios
                // .post('rest/amenities/', this.newAmenity)
                // .then(response => {
                //     this.messages.successResponse = `<h4>Amenity was added successfuly!</h4>`;
                //     this.newAmenity.name='';
                //     this.newAmenity.type='';
                //     this.showAllAmenities();
                //     setTimeout(() => this.messages.successResponse='', 5000);

                // })
                // .catch(error => {
                //     if(error.response.status === 500 || error.response.status === 404){
                //         this.messages.errorResponse= `<h4>We had some server errors, please try again later!</h4>`;
                //         setTimeout(() => this.messages.errorResponse='', 5000);
                //     }
                // });
            }
        },
        closeNew:function(){
            this.$router.push('/price');
        }
    },
    created(){
     
    },
}
</script>

<style scoped>
#titleEffect{
  color:gold;
}

.label{
  color:#35424a;
  display: block;
  margin: 10px 0 10px;
  font-size: 20px;
  font-weight: bold;
}

</style>

               

 