<template>
	<div id="agent-profile-update">
		<div id='main'>
			<div class="container" id='page-title'>
				<h1 style="margin-top:10px;color:#35424a;">Izmena profila <span id='titleEffect'>Agenta</span></h1>
				<hr style='background:#35424a;height:1px;'>
			</div>
			<div class="container">
				<h4>Promena podataka</h4>
				<hr>
				<fieldset class="form-group" v-if='isAgentType == "osoba"'>
					<label>Korisnicko ime</label>
					<input type="text" class="form-control" v-model="profile.korisnickoIme" disabled />
				</fieldset>

				<div v-if='messages.errorFirstName' id='testError' class="alert alert-danger" v-html="messages.errorFirstName"></div>
				<fieldset class="form-group" v-if='isAgentType == "osoba"'>
					<label>Ime</label>
					<input type="text" class="form-control" v-model="profile.ime" />
				</fieldset>

				<div v-if='messages.errorLastName' class="alert alert-danger" v-html="messages.errorLastName"></div>
				<fieldset class="form-group" v-if='isAgentType == "osoba"'>
					<label>Prezime</label>
					<input type="text" class="form-control" v-model="profile.prezime" />
				</fieldset>

				<div class="form-label-group" v-if='isAgentType == "osoba"'>
					<label>Pol</label>
					<br>
					<input type="radio" v-model="profile.pol" required value="Muski"> Muski
					<input type="radio" v-model="profile.pol" required value="Zenski"> Zenski
					<input type="radio" v-model="profile.pol" required value="Drugo"> Drugo
					<br>
					<br>
				</div>

                <div v-if='messages.errorCompanyName' class="alert alert-danger" v-html="messages.errorCompanyName"></div>
				<fieldset class="form-group" v-if='isAgentType == "firma"'>
					<label>Naziv firme</label>
					<input type="text" class="form-control" v-model="profile.nazivFirme" />
				</fieldset>
            
                <div v-if='messages.errorPIB' class="alert alert-danger" v-html="messages.errorPIB"></div>
				<fieldset class="form-group" v-if='isAgentType == "firma"'>
					<label>Poslovni maticni broj</label>
					<input type="text" class="form-control" v-model="profile.poslovniMaticniBroj" />
				</fieldset>

                 <div style="margin-top:20px" v-if='messages.errorAddress' class="alert alert-danger" v-html="messages.errorAddress"></div>
                    <label>Adresa</label>
                    <div>
                    <input class="one-forth" placeholder="Unesite grad..." v-model='profile.TAdresa.mesto'>
                    <input class="one-forth" placeholder="Unesite ulicu..." v-model='profile.TAdresa.ulica'>
                    <input class="one-forth" placeholder="Unesite broj..." v-model='profile.TAdresa.broj'>
                    <input class="one-forth" placeholder="Unesite postanski broj..." v-model='profile.TAdresa.postanskiBroj'>
                </div>

				<hr>
				<h4>Promena lozinke</h4>
				<hr>
				<div v-if='messages.errorNotEqualOldPassword' class="alert alert-danger" v-html="messages.errorNotEqualOldPassword"></div>
				<div v-if='messages.errorOldPass' class="alert alert-danger" v-html="messages.errorOldPass"></div>
				<fieldset class="form-group">
					<label>Stara lozinka</label>
					<input type="password" class="form-control" v-model="changedPassword.oldPassword" placeholder="Unesite staru loznku..." />
				</fieldset>

				<div v-if='messages.errorNewPass' class="alert alert-danger" v-html="messages.errorNewPass"></div>
				<fieldset class="form-group">
					<label>Nova lozinka</label>
					<input type="password" class="form-control" v-model="changedPassword.newPassword" placeholder="Unesite novu loznku..." />
				</fieldset>

				<div v-if='messages.errorNotEqualNewPassword' class="alert alert-danger" v-html="messages.errorNotEqualNewPassword"></div>
				<div v-if='messages.errorRepNewPass' class="alert alert-danger" v-html="messages.errorRepNewPass"></div>
				<fieldset class="form-group">
					<label>Ponovite novu lozinku</label>
					<input type="password" class="form-control" v-model="changedPassword.newPasswordRepeat" placeholder="Ponovite novu loznku..."  />
				</fieldset>

				<button type="button" class="btn btn-lg btn-success" v-on:click='updateProfile'> Save </button>
				<hr>
				<div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
				<div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>

			</div>
		</div>
	</div>
</template>

<script>
import axios from 'axios'
export default {
    data(){
        return{
            // profile: {
            //     //Osoba
            //     id:'1',
            //     ime:'Agent',
            //     prezime:'Agentic',
            //     jmbg:'21321412412',
            //     pol:'Muski',
            //     //firma
            //     nazivFirme:'',
            //     poslovniMaticniBroj:'',
            //     //user
            //     korisnickoIme:'AgentX',
            //     email:'agent996@gmai.com',
            //     status:'aktivan',
            //     TAdresa:{
            //         mesto:'Beograd',
            //         ulica:'Bulevar Bulevara',
            //         broj:'bb',
            //         postanskiBroj:'11000',
            //     },
            // },
            // //kada je agent firma // otkomentarisati kod za test agent firma 
            profile: {
                //Osoba
                id:'1',
                ime:'',
                prezime:'',
                jmbg:'',
                pol:null,
                //firma
                nazivFirme:'AgentskaFirma',
                poslovniMaticniBroj:'21321515',
                //user
                korisnickoIme:'AgentX',
                email:'agent996@gmai.com',
                status:'aktivan',
                TAdresa:{
                    mesto:'Beograd',
                    ulica:'Bulevar Bulevara',
                    broj:'bb',
                    postanskiBroj:'11000',
                },
            },

			changedPassword: {
                oldPassword: '',
                newPassword: '',
                newPasswordRepeat: '',
            },
			
			messages: {
                errorFirstName: '',
                errorLastName: '',
                errorCompanyName:'',
                errorPIB:'',
                // errorEmail:'', ne menja email
                errorAddress:'',
                errorOldPass: '',
                errorNewPass: '',
                errorRepNewPass: '',
                errorNotEqualOldPassword: '',
                errorNotEqualNewPassword: '',
                errorResponse: '',
                successResponse: '',
            }
        }
    },
    methods:{
        updateProfile: function () {
        //OSOBA
            if  (this.isAgentType == "osoba" && this.profile.ime == '') {
                this.messages.errorFirstName = `<h4>Polje ime ne moze biti prazno!</h4>`;
                setTimeout(() => this.messages.errorFirstName = '', 5000);
            }
            else if (this.isAgentType == "osoba" && this.profile.prezime == '') {
                this.messages.errorLastName = `<h4>Polje prezime ne moze biti prazno!</h4>`;
                setTimeout(() => this.messages.errorLastName = '', 5000);
            }
        //FIRMA
            else if (this.isAgentType == "firma" && this.profile.nazivFirme == '') {
                this.messages.errorCompanyName = `<h4>Polje naziv kompanije ne moze biti prazno!</h4>`;
                setTimeout(() => this.messages.errorCompanyName = '', 5000);
            }
            else if (this.isAgentType == "firma" && this.profile.poslovniMaticniBroj == '') {
                this.messages.errorPIB = `<h4>Polje poslovni maticni broj kompanije ne moze biti prazno!</h4>`;
                setTimeout(() => this.messages.errorPIB = '', 5000);
            }
            else if (this.isAgentType == "firma" && this.isNumeric(this.profile.poslovniMaticniBroj)) {
                this.messages.errorCompanyName = `<h4>Poslovni maticni broj kompanije mora biti broj!</h4>`;
                setTimeout(() => this.messages.errorCompanyName = '', 5000);
            }
        //ZA SVE
        // //Email
        //     else if (this.profile.email == '') {
        //         this.messages.errorEmail = `<h4>Polje ime ne moze biti prazno!</h4>`;
        //         setTimeout(() => this.messages.errorEmail = '', 5000);
        //     }
        //Adresa
            else if (this.profile.TAdresa.mesto == '') {
                this.messages.errorAddress = `<h4> Polje mesto u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAddress = '', 5000);
            }
            else if (this.profile.TAdresa.ulica == '') {
                this.messages.errorAddress = `<h4> Polje ulica u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAddress = '', 5000);
            }
            else if (this.profile.TAdresa.broj == '') {
                this.messages.errorAddress = `<h4> Polje broj u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAddress = '', 5000);
            }
            else if (this.profile.TAdresa.postanskiBroj == '') {
                this.messages.errorAddress = `<h4> Polje postanski broj u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAddress = '', 5000);
            }
            else if (this.isNumeric(this.profile.TAdresa.postanskiBroj)) {
                this.messages.errorAddress = `<h4> Postanski broj u adresi agenta mora biti broj!</h4>`;
                setTimeout(() => this.errorAddress = '', 5000);
            }
        //Password check
            //Ako je unet old password, a nije uneto jedno od polja newPassword ili newPassword reapeat unosi se error
            else if (this.changedPassword.oldPassword !== '' && this.changedPassword.newPassword !== '' && this.changedPassword.newPasswordRepeat === '') {
                this.messages.errorRepNewPass = `<h4>Morate ponoviti Vasu novu sifru!</h4>`;
                setTimeout(() => this.messages.errorRepNewPass = '', 55000);
            }

            //Ako je unet old password, a nije uneto jedno od polja newPassword ili newPassword reapeat unosi se error
            else if (this.changedPassword.oldPassword !== '' && this.changedPassword.newPassword === '' && this.changedPassword.newPasswordRepeat !== '') {
                this.messages.errorNewPass = `<h4>Morate uneti Vasu novu sifru!</h4>`;
                setTimeout(() => this.messages.errorNewPass = '', 5000);
            }

            //Ako je unet old password, a nije uneto jedno od polja newPassword ili newPassword reapeat unosi se error
            else if (this.changedPassword.oldPassword !== '' && this.changedPassword.newPassword === '' && this.changedPassword.newPasswordRepeat === '') {
                this.messages.errorNewPass = `<h4>Morate uneti Vasu novu sifru!</h4>`;
                this.messages.errorRepNewPass = `<h4>Morate ponoviti Vasu novu sifru!</h4>`;
                setTimeout(() => this.messages.errorNewPass = '', 5000);
                setTimeout(() => this.messages.errorRepNewPass = '', 5000);
            }

            //Ako nije unet old password, a jesu novi ispisuje se error
            else if (this.changedPassword.oldPassword === '' && this.changedPassword.newPassword !== '' && this.changedPassword.newPasswordRepeat !== '') {
                this.messages.errorOldPass = `<h4>Morate prvo uneti Vasu staru sifru!</h4>`;
                setTimeout(() => this.messages.errorOldPass = '', 5000);
            }

            //Ako su uneta sva 3 passworda, nema errora za prazna polja, ali se proverava validnost samog unosa
            else if (this.changedPassword.oldPassword !== '' && this.changedPassword.newPassword !== '' && this.changedPassword.newPasswordRepeat !== '') {
                //Provera da li je stara sifra dobro uneta
                if (this.profile.lozinka !== this.changedPassword.oldPassword) {
                    this.messages.errorNotEqualOldPassword = `<h4>Vasa stara sifra je netacna! Molimo Vas pokusajte ponovo...</h4>`;
                    setTimeout(() => this.messages.errorNotEqualOldPassword = '', 5000);
                }
                else {
                    //Provera da li se nove sifre poklapaju
                    if (this.changedPassword.newPassword !== this.changedPassword.newPasswordRepeat) {
                        this.messages.errorNotEqualNewPassword = `<h4>Vase nove sifre se ne poklapaju! Molimo Vas pokusajte ponovo...</h4>`;
                        setTimeout(() => this.messages.errorNotEqualNewPassword = '', 5000);
                    }
                    else {
                        //ako je stara sifra dobro uneta, a nove se poklapaju,
                        //stara sifra se menja novom.
                        this.profile.password = this.changedPassword.newPassword;

                        axios.put(`rest/profile/${this.user.username}`, this.profile).then(Response => {
                            this.messages.successResponse = `<h4>Vas profil je uspesno izmenjen!</h4>`;
                            setTimeout(() => this.messages.successResponse = '', 5000);

                            this.getUserProfile();

                        })
                        .catch(error => {
                            if (error.response.status === 500 || error.response.status === 404) {
                                this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru,  molimo Vas pokusajte ponovo kasnije!</h4>`;
                                setTimeout(() => this.messages.errorResponse = '', 5000);
                            }
                        });

                    }
                }
            }
        //Slanje
            else {
                alert('Salje se agent na update!');
                axios.put(`rest/profile/${this.user.username}`, this.profile).then(Response => {
                    this.messages.successResponse = `<h4>Your profile was edited successfully!</h4>`;
                    setTimeout(() => this.messages.successResponse = '', 5000);

                    this.getUserProfile();

                })
                    .catch(error => {
                        if (error.response.status === 500 || error.response.status === 404) {
                            this.messages.errorResponse = `<h4>We had some server errors, please try again later!</h4>`;
                            setTimeout(() => this.messages.errorResponse = '', 5000);
                        }
                    });
            }
		},
		getUserProfile: function () {
			// axios.get(`profile/${this.user.username}`).then(Response => {
			// 	this.profile = Response.data;
			// })
        },
        isNumeric(num) {
            //isNaN(num) returns true if the variable does NOT contain a valid number
            return isNaN(num);
        }
    },
    computed:{
        id() {
            return this.$route.params.id; //preuzimam id usera na cijoj sam stranici za prikaz komentara
        },
        isAgentType(){
            if(this.profile.ime == '' && this.profile.prezime == '' && this.profile.jmbg == '' && this.profile.pol == null){
                return 'firma';
            }
            else if(this.profile.nazivFirme == '' && this.profile.poslovniMaticniBroj == ''){
                return 'osoba';
            }
        },
    },
}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}

#agent-profile-update .one-forth{
  width:24%;
  padding:10px;
  margin-bottom:15px
}

#agent-profile-update label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

</style>