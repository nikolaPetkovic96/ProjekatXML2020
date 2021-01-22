<template>
    <div id="cenovnik-edit">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Izmeni <span id='titleEffect'>Cenovnik</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container">

            <div v-if='messages.errorNaziv' class="alert alert-danger" v-html="messages.errorNaziv"></div>       
            <label class='label'>Novi naziv cenovnika :</label>
            <input class='full-size' type="text" placeholder="Unestite naziv..." v-model="updatedCenovnik.nazivCenovnika">
    
            <div v-if='messages.errorCenaPoDanu' class="alert alert-danger" v-html="messages.errorCenaPoDanu"></div>       
            <label class='label'>Nova cena po danu :</label>
            <input class='full-size' type="text" placeholder="Unesite dnevnu cenu..." v-model="updatedCenovnik.cenaPoDanu">

            <div v-if='messages.errorCenaPoKilometru' class="alert alert-danger" v-html="messages.errorCenaPoKilometru"></div>       
            <label class='label'>Nova cena po kilometru :</label>
            <input class='full-size' type="text" placeholder="Unesite kilometarsku cenu..." v-model="updatedCenovnik.cenaPoKilometru">
        
            <div v-if='messages.errorCenaCDW' class="alert alert-danger" v-html="messages.errorCenaCDW"></div>       
            <label class='label'>Nova cena za Collision Damage Waiver :</label>
            <input class='full-size' type="text" placeholder="Unesite CDW..." v-model="updatedCenovnik.cenaCollisionDamageWaiver">
           
    <!--          <div v-if='messages.errorCena30Dana' class="alert alert-danger" v-html="messages.errorCena30Dana"></div>       
            <label class='label'>Novi popust za preko 30 dana (u %):</label>
            <input class='full-size' type="text" placeholder="Unesite popust..." v-model="updatedCenovnik.popustZaPreko30Dana"> -->
              
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
            <button :disabled='btnEnabled' class="btn btn-success" v-on:click='editPrice()'>Potvrdi</button>
            <button :disabled='btnEnabled' class="btn btn-danger" v-on:click='closeEdit()'>Odustani</button>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
export default {
    name: 'cenovnik-edit',
    data(){
        return{
            updatedCenovnik:{
                id:'',
                nazivCenovnika:'',
                cenaPoDanu: '',
                // popustZaPreko30Dana:'',
                cenaCollisionDamageWaiver:'',
                cenaPoKilometru:''
            },
            permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
            },
            btnEnabled:false,
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
        editPrice:function(){
            console.log('Edit price!');
            if(this.updatedCenovnik.nazivCenovnika == ''){
                this.messages.errorNaziv =  `<h4>Naziv cenovnika ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorNaziv='',3000);
            }
            else if(this.updatedCenovnik.cenaPoDanu == ''){
                this.messages.errorCenaPoDanu =  `<h4>Cena po danu ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoDanu = '' ,3000);
            }
            else if (this.isNumeric(this.updatedCenovnik.cenaPoDanu)) {
                this.messages.errorCenaPoDanu = `<h4>Cena po danu mora biti broj!</h4>`;
                setTimeout(() => this.messages.errorCenaPoDanu = '', 5000);
            }
            else if(this.updatedCenovnik.cenaPoKilometru == ''){
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru ne sme biti prazno polje!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoKilometru = '' ,3000);
            }
            else if(this.isNumeric(this.updatedCenovnik.cenaPoKilometru)){
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru mora biti broj!</h4>`;
                setTimeout(()=>this.messages.errorCenaPoKilometru = '' , 3000);
            }
            
            else if(this.isNumeric(this.updatedCenovnik.cenaCollisionDamageWaiver)){
                this.messages.errorCenaCDW =  `<h4>CDW mora biti broj!</h4>`;
                setTimeout(()=>this.messages.errorCenaCDW = '' , 3000);
            }

            // else if(this.isNumeric(this.updatedCenovnik.popustZaPreko30Dana)){
            //     this.messages.errorCena30Dana =  `<h4>Popust mora biti broj!</h4>`;
            //     setTimeout(()=>this.messages.errorCena30Dana = '' , 3000); 
            // }

            // else if(this.updatedCenovnik.popustZaPreko30Dana < 0 || this.updatedCenovnik.popustZaPreko30Dana > 100 ){
            //     this.messages.errorCena30Dana =  `<h4>Popust mora biti broj u intervalu od 0 do 100!</h4>`;
            //     setTimeout(()=>this.messages.errorCena30Dana = '' , 5000); 
            // }
            
            else if(this.updatedCenovnik.nazivCenovnika == '' && this.updatedCenovnik.cenaPoDanu == '' &&  this.updatedCenovnik.CenaPoKilometru == ''){
                this.messages.errorNaziv =  `<h4>Naziv cenovnika ne sme biti prazno polje!</h4>`;
                this.messages.errorCenaPoDanu =  `<h4>Cena po danu ne sme biti prazno polje!</h4>`;
                this.messages.errorCenaPoKilometru =  `<h4>Cena po kilometru ne sme biti prazno polje!</h4>`;
                setTimeout(()=> this.messages.errorNaziv='', 3000);
                setTimeout(()=> this.messages.errorCenaPoDanu='', 3000); 
                setTimeout(()=> this.messages.errorCenaPoKilometru='', 3000); 
            }
            else{
                UserDataService.updateCenovnik(this.updatedCenovnik).then(Response => {
                    this.messages.successResponse = `<h4>Uspešno ste izmenili cenovnik!</h4>`;
                    setTimeout(() => this.messages.successResponse = '', 3000);

                    // this.getUserProfile();
                    this.updatedCenovnik = Response.data;
                })
                .catch(error => {
                    if(error.response.status === 500 || error.response.status === 404){
                        this.messages.errorResponse= `<h4>Imamo nekih problema na serveru, molimo vas pokušajte kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse='', 5000);
                    }
                });
            }
        },
        getAllPermissions:function(){
            UserDataService.getAllPermissions().then(response => {
                this.permissions = response.data;
                if(this.permissions.status != "aktivan"){
                    this.btnEnabled = true
                }
                console.log(JSON.stringify(this.permissions));
            });
        },
        closeEdit:function(){
            this.$router.push('/price');
        },

        getPrice:function(){
            UserDataService.getCenovnik(this.id)
            .then(response => {
                this.updatedCenovnik = response.data;
            })
        },
        isNumeric(num) {
            //isNaN(num) returns true if the variable does NOT contain a valid number
            return isNaN(num);
        },
    },
    computed:{
        id() {
            return this.$route.params.id; //preuzimam id usera na cijoj sam stranici za prikaz komentara
        }
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.getPrice();
            this.getAllPermissions();
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
    .full-size{
        width:100%;
        padding:10px;
        margin-bottom:25px;
        font-size:18px;
    }

</style>
