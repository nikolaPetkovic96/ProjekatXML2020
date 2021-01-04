<template>
  <div id="regisrtation">
  <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h5 class="card-title text-center">Register</h5>
            <div id='message-box' class="alert alert-success" v-if='message' v-html="message"> </div>
            <div v-if='!this.submitted'>
              <form class="form-signin">
                <div v-if='messages.errorFirstName' id='testError' class="alert alert-danger" v-html="messages.errorFirstName"></div>
                <div class="form-label-group">
                  <input v-model="form.ime" type="text" id="inputName" class="form-control" placeholder="Insert name" required autofocus>
                  <label for="inputName">Ime</label>
                </div>

				        <div v-if='messages.errorLastName' class="alert alert-danger" v-html="messages.errorLastName"></div>
                <div class="form-label-group">
                  <input v-model="form.prezime" type="text" id="inputSurname" class="form-control" placeholder="Insert surname" required autofocus>
                  <label for="inputSurname">Prezime</label>
                </div>

				        <div v-if='messages.errorJMBG' class="alert alert-danger" v-html="messages.errorJMBG"></div>
                <div class="form-label-group">
                  <input v-model="form.jmbg" type="text" id="inputJmbg" class="form-control" placeholder="Jmbg" required>
                  <label for="inputJmbg">JMBG</label>
                </div>

				        <div v-if='messages.errorEmail' class="alert alert-danger" v-html="messages.errorEmail"></div>
                <div class="form-label-group">
                  <input v-model="form.email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
                  <label for="inputEmail">Email adresa</label>
                </div>

                <div style="margin-top:20px" v-if='messages.errorGender' class="alert alert-danger" v-html="messages.errorGender"></div>
                <div class="form-group">
                    <label>Pol</label>
                    <br>
                    <input type="radio" v-model="form.pol" required value="muski"> Muški
                    <input type="radio" v-model="form.pol" required value="zenski"> Ženski
                    <input type="radio" v-model="form.pol" required value="drugo"> Drugo
                </div>

                <div style="margin-top:20px" v-if='messages.errorAdress' class="alert alert-danger" v-html="messages.errorAdress"></div>
                <label>Adresa</label>
                <div>
                  <input class="one-forth" placeholder="Unesite grad..." v-model='form.tadresa.mesto'>
                  <input class="one-forth" placeholder="Unesite ulicu..." v-model='form.tadresa.ulica'>
                  <input class="one-forth" placeholder="Unesite broj..." v-model='form.tadresa.broj'>
                  <input class="one-forth" placeholder="Unesite postanski broj..." v-model='form.tadresa.postanskiBroj'>
                </div>
  
                <hr>

				        <div v-if='messages.errorUsername' class="alert alert-danger" v-html="messages.errorUsername"></div>
                <div class="form-label-group">
                  <input v-model="form.korisnickoIme" type="text" id="inputUsername" class="form-control" placeholder="Username" required>
                  <label for="inputUsername">Korisničko ime</label>
                </div>

                <div v-if='messages.errorPassword' class="alert alert-danger" v-html="messages.errorPassword"></div>
                <div class="form-label-group">
                  <input v-model="form.lozinka" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                  <label for="inputPassword">Šifra</label>
                </div>
                
                <div v-if='messages.errorRepNewPass' class="alert alert-danger" v-html="messages.errorRepNewPass"></div>
                <div class="form-label-group"> 
                  <input  v-model="confPassword" type="password" id="inputConfirmPassword" class="form-control" placeholder="Password" required>
                  <label for="inputConfirmPassword">Potvrda šifre</label>
                </div>

                <div class="alert alert-warning" v-if='messageConfirmPassword' v-html="messageConfirmPassword"> </div>
                 <div style="margin-top:20px" v-if='messages.error' class="alert alert-danger" v-html="messages.error"></div>
                <button type="button" class="btn btn-lg btn-primary btn-block text-uppercase" v-on:click='submition'>
                  Registruj se
                </button>
                <a class="d-block text-center mt-2 small" href="#">Sign In</a>
                <hr class="my-4">
              </form>
            </div>  
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>
<script>
import UserDataService from '../services/UserDataService'
export default {
  name: 'Registration',
	data() {
      return {
      form: {
        korisnickoIme:'',
        lozinka:'',
        email:'',
        ime:'',
        prezime:'',
        pol:null,
        jmbg:'',
        uloga:'ROLE_USER',
        tadresa:{
          mesto:'',
          ulica:'',
          broj:'',
          postanskiBroj:''
        }
      },
      confPassword: '',
      message: '',
      messageConfirmPassword: '',
      submitted:false,

      messages:{
				errorUsername:'',
				errorFirstName:'',
        errorLastName:'',
        errorEmail:'',
        errorAdress:'',
        errorJMBG:'',
        errorGender:'',
        errorPassword:'',
				errorRepNewPass:'',
				errorResponse:'',
        successResponse:'',
        error:''
			}
     }
  },
  methods: {
    submition:function() {
			if(this.form.ime  == ''){
        this.messages.errorFirstName = `<h4>Polje ime ne može biti prazno!</h4>`;
        setTimeout(()=>this.messages.errorFirstName='',5000);
        this.messages.error = `<h4>Greška pri unosu!</h4>`;
        setTimeout(() => this.messages.error = '', 3000);
			}
	
			else if(this.form.prezime == ''){
        this.messages.errorLastName = `<h4>Polje prezime ne može biti prazno!</h4>`;
        setTimeout(()=>this.messages.errorLastName='',5000);
        this.messages.error = `<h4>Greška pri unosu!</h4>`;
        setTimeout(() => this.messages.error = '', 3000);
      }

      else if (this.form.jmbg == '' ) {
        this.messages.errorJMBG = `<h4>Polje JMBG ne može biti prazno!</h4>`;
        this.messages.error = `<h4>Greška pri unosu!</h4>`;
        setTimeout(() => this.messages.errorJMBG = '', 5000);     
        setTimeout(() => this.messages.error = '', 3000);
      }

      //Provera da li je jmbg broj
      else if(this.isNumeric(this.form.jmbg)){
        this.messages.errorJMBG = `<h4>Vrednost JMBG korisnika mora biti broj!</h4>`;
        this.messages.error = `<h4>Greška pri unosu!</h4>`;
        setTimeout(() => this.messages.errorJMBG = '', 5000);
        setTimeout(() => this.messages.error = '', 3000);
      }

      else if(this.form.email == ''){
        this.messages.errorEmail =  `<h4>Polje email ne može biti prazno!</h4>`;
        setTimeout(()=>this.messages.errorEmail='',5000);
        this.messages.error = `<h4>Greška pri unosu!</h4>`;
        setTimeout(() => this.messages.error = '', 3000);
      }

      else if (this.form.pol == null) {
        this.messages.errorGender = `<h4> Morate odabrati pol korisnika!</h4>`;
        setTimeout(() => this.messages.errorGender = '', 5000);
        this.messages.error = `<h4>Greška pri unosu!</h4>`;
        setTimeout(() => this.messages.error = '', 3000);
      }
      //Adresa
      else if (this.form.tadresa.mesto == '') {
        this.messages.errorAdress = `<h4> Polje mesto u adresi korisnika ne može biti prazno!</h4>`;
        setTimeout(() => this.errorAdress = '', 5000);
      }
      else if (this.form.tadresa.ulica == '') {
        this.messages.errorAdress = `<h4> Polje ulica u adresi korisnika ne može biti prazno!</h4>`;
        setTimeout(() => this.errorAdress = '', 5000);
      }
      else if (this.form.tadresa.broj == '') {
        this.messages.errorAdress = `<h5> Polje broj u adresi korisnika ne može biti prazno!</h5>`;
        setTimeout(() => this.errorAdress = '', 5000);
      }
      else if (this.form.tadresa.postanskiBroj == '') {
        this.messages.errorAdress = `<h5> Polje poštanski broj u adresi korisnika ne može biti prazno!</h5>`;
        setTimeout(() => this.errorAdress = '', 5000);
      }
      else if(this.isNumeric(this.form.tadresa.postanskiBroj)){
        this.messages.errorAdress = `<h5> Vrednost poštanskog broj mora biti broj!</h5>`;
        setTimeout(() => this.messages.errorAdress = '', 5000);
      }

    //----------------------------------------------------------------------

      else if(this.form.korisnickoIme == ''){
				this.messages.errorUsername =  `<h5>Korisničko ime ne može biti prazno polje!</h5>`;
				setTimeout(()=>this.messages.errorUsername='',3000);
      }
		
			else if(this.form.lozinka == ''){
        this.messages.errorPassword =  `<h5>Lozinka ne može biti prazno polje!</h5>`;
        setTimeout(()=>this.messages.errorPassword='',3000);
			}
	
			else if(this.confPassword == ''){
        this.messages.errorRepNewPass =  `<h5>Lozinka za potvrdu ne može biti prazno polje!</h5>`;
        setTimeout(()=>this.messages.errorRepNewPass='',3000);
			}
      else{
        if(this.form.lozinka === this.confPassword){

          console.log('form: ' + JSON.stringify(this.form))
          UserDataService.userRegistration(this.form).then(response => {
            this.message = `<h4>Hvala <b>${response.data.ime} ${response.data.prezime}</b> što ste se registrovali! Na imejl adresu koju ste uneli Vam je poslat mejl za potvrdu registracije!</h4>`;
            this.submitted = true;
          }).catch(error => {
            // && error.response.data.message==='Username already exists!'
            if(error.response.status === 409){
              this.messageConfirmPassword = `<h5>Već postoji korisnik sa unetim <b>korisničkim imenom<b> ! Molimo Vas pokušajte uneti druge vrednosti !</h5>`;
              setTimeout(()=>this.messageConfirmPassword='',3000);
            }
            else if (error.response.status === 500 || error.response.status === 404 || error.response.status === 504) {
                this.messages.errorResponse = `<h5>Imali smo nekih problema na serveru, molimo Vas pokusajte ponovo kasnije!</h5>`;
                setTimeout(() => this.messages.errorResponse = '', 5000);
            }
          }); 

        }
        else{
          this.messageConfirmPassword = `<h5>Šifre koje ste uneli se ne poklapaju! Molimo Vas pokušajte ponovo!</h5>`;
          setTimeout(()=>this.messageConfirmPassword='',3000);
        }
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
.form-signin .btn {
  font-size: 80%;
  border-radius: 5rem;
  letter-spacing: .1rem;
  font-weight: bold;
  padding: 1rem;
  transition: all 0.2s;
}

.form-label-group {
  position: relative;
  margin-bottom: 1rem;
}

.form-label-group input {
  height: 65px;
  /* height: auto; */
  text-align: center;
  border-radius: 2rem;
  
}

.form-label-group>input,
.form-label-group>label {
  padding: var(--input-padding-y) var(--input-padding-x);
}

.form-label-group>label {
  position: absolute;
  top: 10px;
  left: 30px;
  display: block;
  width: 100%;
  margin-bottom: 0;
  /* Override default `<label>` margin */
  line-height: 1.5;
  color: #495057;
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
  font-size: 18px;
}

.form-label-group input::-webkit-input-placeholder {
  color: transparent;
}

.form-label-group input:-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-moz-placeholder {
  color: transparent;
}

.form-label-group input::placeholder {
  color: transparent;
}

.form-label-group input:not(:placeholder-shown) {
  padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
  padding-bottom: calc(var(--input-padding-y) / 3);
}

.form-label-group input:not(:placeholder-shown)~label {
  padding-top: calc(var(--input-padding-y) / 3);
  padding-bottom: calc(var(--input-padding-y) / 3);
  font-size: 12px;
  color: #777;
}

.one-forth{
  width:24%;
  padding:10px;
  margin-bottom:15px;
  border-radius:20px;
}

#message-box{
  margin-bottom:400px;
  padding:50px;
}
</style>
