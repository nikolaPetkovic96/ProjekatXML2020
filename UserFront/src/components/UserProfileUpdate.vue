<template>
	<div id="admin-profile-update">
		<div id='main'>
			<div class="container" id='page-title'>
				<h1 style="margin-top:10px;color:#FF8C00;">Izmena profila <span id='titleEffect'>Korisnika</span></h1>
				<hr style='background:#FF8C00;height:1px;'>
			</div>
			<div class="container">
				<h4>Promena podataka</h4>
				<hr>
				<fieldset class="form-group">
					<label>Korisnicko ime</label>
					<input type="text" class="form-control" v-model="profile.korisnickoIme" disabled />
				</fieldset>

				<div v-if='messages.errorFirstName' id='testError' class="alert alert-danger" v-html="messages.errorFirstName"></div>
				<fieldset class="form-group">
					<label>Ime</label>
					<input type="text" class="form-control" v-model="profile.ime" />
				</fieldset>

				<div v-if='messages.errorLastName' class="alert alert-danger" v-html="messages.errorLastName"></div>
				<fieldset class="form-group">
					<label>Prezime</label>
					<input type="text" class="form-control" v-model="profile.prezime" />
				</fieldset>

				<div class="form-group">
					<label>Pol</label>
					<br>
					<input type="radio" v-model="profile.pol" required value="Muski"> Muski
					<input type="radio" v-model="profile.pol" required value="Zenski"> Zenski
					<input type="radio" v-model="profile.pol" required value="Drugo"> Drugo
					<br>
					<br>
				</div>

                 <div style="margin-top:20px" v-if='messages.errorAdresa' class="alert alert-danger" v-html="messages.errorAdresa"></div>
                    <label>Adresa</label>
                    <div>
                    <input class="one-forth" placeholder="Unesite grad..." v-model='profile.tadresa.mesto'>
                    <input class="one-forth" placeholder="Unesite ulicu..." v-model='profile.tadresa.ulica'>
                    <input class="one-forth" placeholder="Unesite broj..." v-model='profile.tadresa.broj'>
                    <input class="one-forth" placeholder="Unesite postanski broj..." v-model='profile.tadresa.postanskiBroj'>
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

				<button :disabled='btnEnabled' type="button" class="btn btn-lg btn-success" v-on:click='updateProfile'> Potvrdi </button>
				<hr>
				<div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
				<div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
			</div>
		</div>
	</div>
</template>

<script>
import axios from 'axios'
import UserDataService from '../services/UserDataService'
export default {
    data(){
        return{
            permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
            },
            btnEnabled:false,
            profile: {
            	id:null,
                korisnickoIme:null,
                lozinka:null,
                email:null,
                status:null,
                pol:null,
                prezime:null,
                ime:null,
                jmbg:null,
                staraLozinka:null,
                tadresa:{
                    mesto:'',
                    ulica:'',
                    broj:'',
                    postanskiBroj:'',
                }
            },

			changedPassword: {
                oldPassword: '',
                newPassword: '',
                newPasswordRepeat: '',
            },
			
			messages: {
                errorFirstName: '',
                errorLastName: '',
                errorAdresa:'',
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
        getAllPermissions:function(){
            UserDataService.getAllPermissions().then(response => {
                this.permissions = response.data;
                if(this.permissions.status != "aktivan"){
                    btnEnabled = true
                }
                console.log(JSON.stringify(this.permissions));
            });
        },
        getUserProfileData:function(){
            UserDataService.getUser().then(response => {
                this.profile = response.data;
                console.log("user: " + JSON.stringify(this.profile));
            })
        },
        updateProfile: function () {
            // First name i last name se u paru gledaju da li su popunjeni
            // Ako su oba prazna u isto vreme ce za oba izbaciti error
            if (this.profile.ime == '' && this.profile.prezime != '') {
                this.messages.errorFirstName = `<h4>Polje ime ne moze biti prazno!</h4>`;
                setTimeout(() => this.messages.errorFirstName = '', 5000);
            }
            else if (this.profile.ime != '' && this.profile.prezime == '') {
                this.messages.errorLastName = `<h4>Polje prezime ne moze biti prazno!</h4>`;
                setTimeout(() => this.messages.errorLastName = '', 5000);
            }
            else if (this.profile.ime == '' && this.profile.prezime == '') {
                this.messages.errorFirstName = `<h4>Polje ime ne moze biti prazno!</h4>`;
                this.messages.errorLastName = `<h4>Polje prezime ne moze biti prazno!</h4>`;
                setTimeout(() => this.messages.errorFirstName = '', 5000);
                setTimeout(() => this.messages.errorLastName = '', 5000);

            }
           //Adresa
            else if (this.profile.tadresa.mesto == '') {
                this.messages.errorAdresa = `<h4> Polje mesto u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
            }
            else if (this.profile.tadresa.ulica == '') {
                this.messages.errorAdresa = `<h4> Polje ulica u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
            }
            else if (this.profile.tadresa.broj == '') {
                this.messages.errorAdresa = `<h4> Polje broj u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
            }
            else if (this.profile.tadresa.postanskiBroj == '') {
                this.messages.errorAdresa = `<h4> Polje postanski broj u adresi agenta ne moze biti prazno!</h4>`;
                setTimeout(() => this.errorAdresa = '', 5000);
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
                //Provera da li se nove sifre poklapaju
                if (this.changedPassword.newPassword !== this.changedPassword.newPasswordRepeat) {
                    this.messages.errorNotEqualNewPassword = `<h4>Vase nove sifre se ne poklapaju! Molimo Vas pokusajte ponovo...</h4>`;
                    setTimeout(() => this.messages.errorNotEqualNewPassword = '', 3000);
                }
                else {
                    //ako je stara sifra dobro uneta, a nove se poklapaju,
                    //stara sifra se menja novom.
                    this.profile.staraLozinka = this.changedPassword.oldPassword;
                    this.profile.lozinka = this.changedPassword.newPassword;
                    console.log("Admin: " + JSON.stringify(this.profile));
                    UserDataService.updateAdminProfile(this.profile).then(Response => {
                        this.messages.successResponse = `<h4>Vas profil je uspesno izmenjen!</h4>`;
                        setTimeout(() => this.messages.successResponse = '', 3000);

                        this.profile = Response.data;
                    })
                    .catch(error => {
                        // && error.response.data.message === "Wrong password!"
                        if(error.response.status === 409 ){
                            this.messages.errorResponse = `<h4>Vaša stara sifra je netačna! Molimo Vas pokušajte ponovo...</h4>`;
            
                            setTimeout(()=>this.messages.errorResponse='', 5000);
                        }
                        else if (error.response.status === 500 || error.response.status === 404) {
                            this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru,  molimo Vas pokušajte ponovo kasnije!</h4>`;
                            setTimeout(() => this.messages.errorResponse = '', 5000);
                        }
                
                    });

                }
                
            }
           //Slanje
            else {
                UserDataService.updateUserProfile(this.profile).then(Response => {
                    this.messages.successResponse = `<h4>Vas profil je uspesno izmenjen!</h4>`;
                    setTimeout(() => this.messages.successResponse = '', 5000);
                    console.log(Response.data)
                    this.profile = Response.data;

                })
                .catch(error => {
                    if (error.response.status === 500 || error.response.status === 404) {
                        this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokušajte kasnije!</h4>`;
                        setTimeout(() => this.messages.errorResponse = '', 5000);
                    }
                });
            }
		},
    },
    computed:{
        id() {
            return this.$route.params.id; //preuzimam id usera na cijoj sam stranici za prikaz komentara
        },
    },    
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            let parsToken = JSON.parse(localStorage.getItem('parsToken'));
            this.getUserProfileData();
            this.getAllPermissions();
        }
    },
}
</script>

<style scoped>

#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}

#admin-profile-update .one-forth{
  width:24%;
  padding:10px;
  margin-bottom:15px
}

#admin-profile-update label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

</style>