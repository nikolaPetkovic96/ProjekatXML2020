<template>
    <div id="cenovnik-edit">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Izmeni <span id='titleEffect'>Cenovnik</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container">
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>

            <div v-if='messages.errorNaziv' class="alert alert-danger" v-html="messages.errorNaziv"></div>       
            <label class='label'>Novi naziv cenovnika :</label>
            <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unestite naziv..." v-model="updatedCenovnik.nazivCenovnika">
    
            <div v-if='messages.errorCenaPoDanu' class="alert alert-danger" v-html="messages.errorCenaPoDanu"></div>       
            <label class='label'>Nova cena po danu :</label>
            <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unesite dnevnu cenu..." v-model="updatedCenovnik.cenaPoDanu">

            <div v-if='messages.errorCenaPoKilometru' class="alert alert-danger" v-html="messages.errorCenaPoKilometru"></div>       
            <label class='label'>Nova cena po kilometru :</label>
            <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unesite kilometarsku cenu..." v-model="updatedCenovnik.cenaPoKilometru">
        
            <!-- <div v-if='messages.errorCenaCDW' class="alert alert-danger" v-html="messages.errorCenaCDW"></div>        -->
            <label class='label'>Nova cena za Collision Damage Waiver :</label>
            <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unesite CDW..." v-model="updatedCenovnik.cenaCollisionDamageWaiver">
            
            <!-- <div v-if='messages.errorCena30Dana' class="alert alert-danger" v-html="messages.errorCena30Dana"></div>        -->
            <label class='label'>Novi popust za preko 30 dana :</label>
            <input style="width:100%; padding:10px; margin-bottom:25px" type="text" placeholder="Unesite popust..." v-model="updatedCenovnik.popustZaPreko30Dana">
              
            
            <button class="btn btn-success" v-on:click='editPrice()'>Save</button>
            <button class="btn btn-danger" v-on:click='closeEdit()'>Close</button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'cenovnik-edit',
    data(){
        return{
            updatedCenovnik:{
                id:'1',
                cenaPoDanu:100,
                nazivCenovnika:'Cenovnik 1',
                popustZaPreko30Dana:'10%',
                cenaCollisionDamageWaiver:1000,
                cenaPoKilometru:10
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
        editPrice:function(){
            if(this.updatedCenovnik.nazivCenovnika == ''){
                this.messages.errorNaziv =  `<h4>Naziv cenovnika ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorNaziv='',3000);
            }
            else if(this.updatedCenovnik.cenaPoDanu == ''){
                this.messages.errorCenaPoDanu =  `<h4>Cena po danu ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoDanu = '' ,3000);
            }
            else if(this.updatedCenovnik.cenaPoKilometru == ''){
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoKilometru = '' ,3000);
            }
            
            else if(this.updatedCenovnik.nazivCenovnika== '' && this.updatedCenovnik.cenaPoDanu == '' &&  this.updatedCenovnik.CenaPoKilometru == ''){
                this.messages.errorNaziv =  `<h4>Naziv cenovnika ne sme biti prazno polje!</h4>`;
                this.messages.errorCenaPoDanu =  `<h4>Cena po danu ne sme biti prazno polje!</h4>`;
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru ne sme biti prazno polje!</h4>`;
                setTimeout(()=> this.messages.errorNaziv='', 3000);
                setTimeout(()=> this.messages.errorCenaPoDanu='', 3000); 
                setTimeout(()=> this.messages.errorCenaPoKilometru='', 3000); 
            }
            else{
                alert(`
                    ${this.updatedCenovnik.nazivCenovnika}
                    ${this.updatedCenovnik.cenaPoDanu}
                    ${this.updatedCenovnik.cenaPoKilometru}
                    ${this.updatedCenovnik.popustZaPreko30Dana}
                    ${this.updatedCenovnik.cenaCollisionDamageWaiver}
                `);
                // axios
                // .put(`rest/amenities/${this.updatedAmenity.id}`, this.updatedAmenity)
                // .then(response => {
                //     this.messages.successResponse = `<h4>Amenity was updated successfuly!</h4>`;
                //     this.updatedAmenity.name='';
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
        closeEdit:function(){
            this.$router.push('/price');
        }
    },
    computed:{
        id() {
            return this.$route.params.id; //preuzimam id usera na cijoj sam stranici za prikaz komentara
        }
    }
}

</script>

<style scoped>
    #titleEffect{
        color:gold;
        font-weight: bold;
    }

    .one-third{
        width:33%;
        padding:10px;
        margin-bottom:25px;
    }

    .label{
        color:#35424a;
        display: block;
        margin: 10px 0 10px;
        font-size: 20px;
        font-weight: bold;
    }

</style>
