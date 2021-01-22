<template>  
    <div id='agent-registration'>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Registrovanje <span id='titleEffect'>Administratora</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        
        <div class='container'>
            <div id='admin-form'>  
                <div v-if='messages.errorIme' id='testError' class="alert alert-danger" v-html="messages.errorIme"></div>
                <div class="form-group half-size">
                    <label>Ime admina</label>
                    <input type="text" placeholder="Unesite ime..." class="form-control" v-model="noviAdmin.ime"/>
                </div>

                <div v-if='messages.errorPrezime' class="alert alert-danger" v-html="messages.errorPrezime"></div>
                <div class="form-group half-size">
                    <label>Prezime admina</label>
                    <input type="text" placeholder="Unesite prezime..." class="form-control" v-model="noviAdmin.prezime"/>
                </div>

                <div style="margin-top:20px" v-if='messages.errorJMBG' class="alert alert-danger" v-html="messages.errorJMBG"></div>
                <div class="form-group half-size">
                    <label>JMBG admina</label>
                    <input type="text" placeholder="Unesite JMBG..." class="form-control" v-model="noviAdmin.jmbg"/>
                </div>
            </div>

            <div style="margin-top:20px" v-if='messages.errorEmail' class="alert alert-danger" v-html="messages.errorEmail"></div>
            <div class="form-group half-size">  
                <label>Email admina</label>
                <input type="email" placeholder="Unesite email..." class="form-control" v-model="noviAdmin.email"/>
            </div>

            <div style="margin-top:20px" v-if='messages.errorPol' class="alert alert-danger" v-html="messages.errorPol"></div>
            <div class="form-group">
                <label>Pol admina</label>
                <br>
                <input type="radio" v-model="noviAdmin.pol" required value="muski"> Muski
                <input type="radio" v-model="noviAdmin.pol" required value="zenski"> Zenski
                <input type="radio" v-model="noviAdmin.pol" required value="drugo"> Drugo
            </div>

            <div style="margin-top:20px" v-if='messages.errorAdresa' class="alert alert-danger" v-html="messages.errorAdresa"></div>
            <label>Adresa admina</label>
            <div>
              <input class="one-forth" placeholder="Unesite grad..." v-model='noviAdmin.tadresa.mesto'>
              <input class="one-forth" placeholder="Unesite ulicu..." v-model='noviAdmin.tadresa.ulica'>
              <input class="one-forth" placeholder="Unesite broj..." v-model='noviAdmin.tadresa.broj'>
              <input class="one-forth" placeholder="Unesite postanski broj..." v-model='noviAdmin.tadresa.postanskiBroj'>
            </div>

             <div v-if='messages.error' id='testError' class="alert alert-danger half-size" v-html="messages.error"></div>
            <button type="button" class="btn btn-lg btn-success" v-on:click='addAdmin()'> Potvrdi </button>
            <hr>
        </div><!--container-->
    </div> 
</template>

<script>
import adminDataService from '../services/AdminDataService'
export default {
    name:'Admin-registration',
    data:function(){
        return{
            noviAdmin:{
                //Osoba
                ime:'',
                prezime:'',
                jmbg:'',
                pol:'',
                //user
                korisnickoIme:'',
                email:'',
                status:'neaktivan',
                tadresa:{
                    mesto:'',
                    ulica:'',
                    broj:'',
                    postanskiBroj:'',
                },
            },
            messages: {
                errorIme: '',
                errorPrezime: '',
                errorJMBG: '',
                errorPol: '',
                errorKorisnickoIme: '',
                errorEmail: '',
                errorAdresa: '',
                errorResponse: '',
                successResponse: '',
                error:'',
            }
        }
    },
    methods:{
        addAdmin:function(){
        //OSOBA
            if (this.noviAdmin.ime == '') {
                this.messages.errorIme = `<h4> Ime admina ne moze biti prazno polje!</h4>`;
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.errorIme = '', 5000);
                setTimeout(() => this.messages.error = '', 3000);
            }
            else if (this.noviAdmin.prezime == '' ) {
                this.messages.errorPrezime = `<h4> Prezime admina ne moze biti prazno polje!</h4>`;
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.errorPrezime = '', 5000);
                setTimeout(() => this.messages.error = '', 3000);
            }
            else if (this.noviAdmin.jmbg == '' ) {
                this.messages.errorJMBG = `<h4> JMBG admina ne moze biti prazno polje!</h4>`;
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.errorJMBG = '', 5000);     
                setTimeout(() => this.messages.error = '', 3000);
            }

            //Provera da li je jmbg broj
            else if(this.isNumeric(this.noviAdmin.jmbg)){
                this.messages.errorJMBG = `<h4>Vrednost JMBG admina mora biti broj!</h4>`;
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.errorJMBG = '', 5000);
                setTimeout(() => this.messages.error = '', 3000);
            }
        //USER
            else if (this.noviAdmin.email == '') {
                this.messages.errorEmail = `<h4> Email admina ne moze biti prazno polje!</h4>`;
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.errorEmail = '', 5000);
                setTimeout(() => this.messages.error = '', 3000);
            }
            else if (this.noviAdmin.pol == '') {
                this.messages.errorPol = `<h4> Pol admina ne moze biti prazno polje!</h4>`;
                setTimeout(() => this.messages.errorPol = '', 5000);
            }
            //Adresa
            else if (this.noviAdmin.tadresa.mesto == '') {
                this.messages.errorAdresa = `<h4> Polje mesto u adresi admina ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
                
            }
            else if (this.noviAdmin.tadresa.ulica == '') {
                this.messages.errorAdresa = `<h4> Polje ulica u adresi admina ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
     
            }
            else if (this.noviAdmin.tadresa.broj == '') {
                this.messages.errorAdresa = `<h4> Polje broj u adresi admina ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
               
            }
            else if (this.noviAdmin.tadresa.postanskiBroj == '') {
                this.messages.errorAdresa = `<h4> Polje poštanski broj u adresi admina ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
            }
            else if(this.isNumeric(this.noviAdmin.tadresa.postanskiBroj)){
                this.messages.errorAdresa = `<h4>Vrednost poštanskog broj mora biti broj!</h4>`;
                setTimeout(() => this.messages.errorAdresa = '', 5000);
            }
            else {
                console.log('Admin: ' + JSON.stringify(this.noviAdmin));
                adminDataService.addAdmin(this.noviAdmin).then(response => {
                    alert("Uspešno ste dodali novog administratora!")
                    this.$router.push("/home");   
                }).catch(error => {
                    if (error.response.status === 500 || error.response.status === 404 || error.response.status === 504) {
                        this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru,  molimo Vas pokusajte ponovo kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });    
            }
        },

        isNumeric(num) {
            //isNaN(num) returns true if the variable does NOT contain a valid number
            return isNaN(num);
        }
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }
    }
}
</script>

<style scoped>

#titleEffect {
    color:#00bcd4;
    font-weight: bold;
}

#agent-registration label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

#agent-registration .btn{
    margin-top:30px;
}

#agent-registration .half-size{
    width:49%;
    padding:10px;
    margin-bottom:15px
}

#agent-registration .one-forth{
    width:24%;
    padding:10px;
    margin-bottom:15px
}

</style>