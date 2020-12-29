<template>  
    <div id='agent-registration'>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Registrovanje Agenta<span id='titleEffect'>/Firme</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
          <!-- Registrovati agente/firme pri cemu se registruju sledeci podaci:
            . Ime i prezime ili naziv firme
            . Adresa
            . Poslovni maticni broj -->
        <div class='container'>
            <div class="form-group">
                <label>Tip agenta</label>
                <br>
                <input type="radio" v-model="agentType" required value="osoba" v-on:click='agentTypeChange'> Osoba
                <input type="radio" v-model="agentType" required value="firma" v-on:click='agentTypeChange'> Firma
                <br>
            </div>
            <div id='agent-osoba' v-if='agentType == "osoba"'>  
                <div v-if='messages.errorIme' id='testError' class="alert alert-danger" v-html="messages.errorIme"></div>
                <div class="form-group half-size">
                    <label>Ime</label>
                    <input type="text" placeholder="Unesite ime..." class="form-control" v-model="noviAgent.ime"/>
                </div>

                <div v-if='messages.errorPrezime' class="alert alert-danger" v-html="messages.errorPrezime"></div>
                <div class="form-group half-size">
                    <label>Prezime</label>
                    <input type="text" placeholder="Unesite prezime..." class="form-control" v-model="noviAgent.prezime"/>
                </div>

                <div style="margin-top:20px" v-if='messages.errorJMBG' class="alert alert-danger" v-html="messages.errorJMBG"></div>
                <div class="form-group half-size">
                    <label>JMBG</label>
                    <input type="text" placeholder="Unesite JMBG..." class="form-control" v-model="noviAgent.jmbg"/>
                </div>
            </div>

            <div style="margin-top:20px" v-if='messages.errorNaziv' class="alert alert-danger" v-html="messages.errorNaziv"></div>
            <div id='agent-firma'  v-if='agentType == "firma"'>
                <div class="form-group half-size">
                    <label>Naziv firme</label>
                    <input type="text" placeholder="Unesite naziv firme..." class="form-control" v-model="noviAgent.nazivFirme"/>
                </div>

                <div style="margin-top:20px" v-if='messages.errorPoslovniMaticniBroj' class="alert alert-danger" v-html="messages.errorPoslovniMaticniBroj"></div>
                <div class="form-group half-size">
                    <label>Poslovni matični broj</label>
                    <input type="text" placeholder="Unesite poslovni matični broj..." class="form-control" v-model="noviAgent.poslovniMaticniBroj"/>
                </div>
            </div>

            <div style="margin-top:20px" v-if='messages.errorEmail' class="alert alert-danger" v-html="messages.errorEmail"></div>
            <div class="form-group half-size">  
                <label>Email</label>
                <input type="email" placeholder="Unesite email..." class="form-control" v-model="noviAgent.email"/>
            </div>

            <div style="margin-top:20px" v-if='messages.errorPol' class="alert alert-danger" v-html="messages.errorPol"></div>
            <div class="form-group" v-if='agentType == "osoba"'>
                <label>Pol</label>
                <br>
                <input type="radio" v-model="noviAgent.pol" required value="muski"> Muski
                <input type="radio" v-model="noviAgent.pol" required value="zenski"> Zenski
                <input type="radio" v-model="noviAgent.pol" required value="drugo"> Drugo
            </div>

            <div style="margin-top:20px" v-if='messages.errorAdresa' class="alert alert-danger" v-html="messages.errorAdresa"></div>
            <label>Adresa</label>
            <div>
              <input class="one-forth" placeholder="Unesite grad..." v-model='noviAgent.tadresa.mesto'>
              <input class="one-forth" placeholder="Unesite ulicu..." v-model='noviAgent.tadresa.ulica'>
              <input class="one-forth" placeholder="Unesite broj..." v-model='noviAgent.tadresa.broj'>
              <input class="one-forth" placeholder="Unesite postanski broj..." v-model='noviAgent.tadresa.postanskiBroj'>
            </div>

            <div v-if='messages.error' id='testError' class="alert alert-danger half-size" v-html="messages.error"></div>
            <button type="button" class="btn btn-lg btn-success" v-on:click='addAgent()'> Potvrdi </button>
            <hr>
        </div><!--container-->
    </div> 
</template>

<script>
import adminDataService from '../services/AdminDataService'
export default {
    name:'Agent-registration',
    data:function(){
        return{
            agentType:'osoba',
            noviAgent:{
                //Osoba
                ime:'',
                prezime:'',
                jmbg:'',
                pol:'',
                //firma
                nazivFirme:'',
                poslovniMaticniBroj:'',
                //user
                korisnickoIme:'',
                email:'',
                status:'neaktivan',
                tadresa:{
                    mesto:'',
                    ulica:'',
                    broj:'',
                    postanskiBroj:'',
                    longitude:'',
                    latitude:'',
                },
            },
            messages: {
                errorIme: '',
                errorPrezime: '',
                errorJMBG: '',
                errorPol: '',
                errorNaziv: '',
                errorPoslovniMaticniBroj: '',
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
        agentTypeChange:function(){
            this.noviAgent.ime = '';
            this.noviAgent.prezime = '';
            this.noviAgent.jmbg = '';
            this.noviAgent.pol = '';
            //firma
            this.noviAgent.nazivFirme = '';
            this.noviAgent.poslovniMaticniBroj = '';
            //user
            this.noviAgent.korisnickoIme = '';
            this.noviAgent.email = '';
            this.noviAgent.status = 'neaktivan';
            this.noviAgent.tadresa.mesto = '';
            this.noviAgent.tadresa.ulica = '';
            this.noviAgent.tadresa.broj = '';
            this.noviAgent.tadresa.postanskiBroj = '';
        },
        showComments:function(id){
            this.$router.push(`/adminTest/${id}/comments`);
        },
        addAgent:function(){
        //OSOBA
        
            if (this.noviAgent.ime == '' && this.agentType == 'osoba') {
                this.messages.errorIme = `<h4> Ime agenta ne moze biti prazno polje!</h4>`;
                setTimeout(() => this.messages.errorIme = '', 5000);
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.error = '', 3000);
            }
            else if (this.noviAgent.prezime == '' && this.agentType == 'osoba') {
                this.messages.errorPrezime = `<h4> Prezime agenta ne moze biti prazno polje!</h4>`;
                setTimeout(() => this.messages.errorPrezime = '', 5000);
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.error = '', 3000);
            }
            else if (this.noviAgent.jmbg == '' && this.agentType == 'osoba') {
                this.messages.errorJMBG = `<h4> JMBG agenta ne moze biti prazno polje!</h4>`;
                setTimeout(() => this.messages.errorJMBG = '', 5000);
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.error = '', 3000);
            }
              //Provera da li je jmbg broj
            else if(this.isNumeric(this.noviAgent.jmbg)){
                this.messages.errorJMBG = `<h4>Vrednost JMBG admina mora biti broj!</h4>`;
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.errorJMBG = '', 5000);
                setTimeout(() => this.messages.error = '', 3000);
              
            }
            else if (this.noviAgent.pol == '' && this.agentType == 'osoba') {
                this.messages.errorPol = `<h4> Pol agenta ne moze biti prazno polje!</h4>`;
                setTimeout(() => this.messages.errorPol = '', 5000);
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.error = '', 3000);
            }
        //FIRMA
            else if (this.noviAgent.nazivFirme == '' && this.agentType == 'firma') {
                this.messages.errorNaziv = `<h4> Naziv agentske firme ne moze biti prazno polje!</h4>`;
                setTimeout(() => this.messages.errorNaziv = '', 5000);
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.error = '', 3000);
            }
            else if (this.noviAgent.poslovniMaticniBroj == '' && this.agentType == 'firma') {
                this.messages.errorPoslovniMaticniBroj = `<h4> PMB agenta ne moze biti prazno polje!</h4>`;
                setTimeout(() => this.messages.errorPoslovniMaticniBroj = '', 5000);
                this.messages.error = `<h4>Greska pri unosu!</h4>`;
                setTimeout(() => this.messages.error = '', 3000);
            }
        //USER
            // else if (this.noviAgent.korisnickoIme == '') {
            //     this.messages.korisnickoIme = `<h4> Korisnicko ime ne moze biti prazno polje!</h4>`;
            //     setTimeout(() => this.messages.korisnickoIme = '', 5000);
            // }
            else if (this.noviAgent.email == '') {
                this.messages.errorEmail = `<h4> Email agenta ne moze biti prazno polje!</h4>`;
                setTimeout(() => this.errorEmail = '', 5000);
            }
            //Adresa
            else if (this.noviAgent.tadresa.mesto == '') {
                this.messages.errorAdresa = `<h4> Polje mesto u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
            }
            else if (this.noviAgent.tadresa.ulica == '') {
                this.messages.errorAdresa = `<h4> Polje ulica u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
            }
            else if (this.noviAgent.tadresa.broj == '') {
                this.messages.errorAdresa = `<h4> Polje broj u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
            }
            else if (this.noviAgent.tadresa.postanskiBroj == '') {
                this.messages.errorAdresa = `<h4> Polje postanski broj u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
            }
            else if(this.isNumeric(this.noviAgent.tadresa.postanskiBroj)){
                this.messages.errorJMBG = `<h4>Vrednost poštanskog broj mora biti broj!</h4>`;
                setTimeout(() => this.messages.errorJMBG = '', 5000);
            }
            else {
                console.log('Agent: ' + JSON.stringify(this.noviAgent));
                adminDataService.addAgent(this.noviAgent).then(response => {
                    alert("Uspešno ste dodali novog agenta!")
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