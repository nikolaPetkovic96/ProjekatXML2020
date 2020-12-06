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
                <div class="form-label-group">
                  <input v-model="form.ime" type="text" id="inputName" class="form-control" placeholder="Insert name" required autofocus>
                  <label for="inputName">Ime</label>
                </div>

                <div class="form-label-group">
                  <input v-model="form.prezime" type="text" id="inputSurname" class="form-control" placeholder="Insert surname" required autofocus>
                  <label for="inputSurname">Prezime</label>
                </div>

                <div class="form-label-group">
                  <input v-model="form.adresa" type="text" id="inputAddress" class="form-control" placeholder="Insert address" required autofocus>
                  <label for="inputAddress">Adresa</label>
                </div>

                <div class="form-label-group">
                  <input v-model="form.email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
                  <label for="inputEmail">Email adresa</label>
                </div>

                <div class="form-label-group">
                  <input v-model="form.username" type="text" id="inputUsername" class="form-control" placeholder="Username" required>
                  <label for="inputUsername">Korisnicko ime</label>
                </div>

                <div class="form-label-group">
                  <input v-model="form.jmbg" type="text" id="inputJmbg" class="form-control" placeholder="Jmbg" required>
                  <label for="inputJmbg">JMBG</label>
                </div>

                <div class="form-label-group">
                  <input v-model="form.password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                  <label for="inputPassword">Sifra</label>
                </div>
                
                <div class="form-label-group">
                  <input  v-model="confPassword" type="password" id="inputConfirmPassword" class="form-control" placeholder="Password" required>
                  <label for="inputConfirmPassword">Potvrda sifre</label>
                </div>

                <div class="alert alert-warning" v-if='messageConfirmPassword' v-html="messageConfirmPassword"> </div>
                
                <button type="button" class="btn btn-lg btn-primary btn-block text-uppercase" v-on:click='submition'>
                  Register
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
          ime: '',
          prezime: '',
          adresa: '',
          jmbg: '',
          email: '',
          username:'',
          password: '',
      },
      confPassword: '',
      message: '',
      messageConfirmPassword: '',
      submitted:false,
     }
  },
  methods: {
    submition:function() {
      if(this.form.password ===  this.confPassword){
        KlijentDataService.registratingKlijent({
          username:this.form.username,
          password:this.form.password,
          ime:this.form.ime,
          jmbg:this.form.jmbg,
          prezime:this.form.prezime,
          adresa:this.form.adresa,
          email:this.form.email
        }).then(response =>{
          this.message = `<h4>Hvala <b>${response.data.ime}</b> sto ste se registrovali! Na imejl adresu koju ste uneli Vam je poslat mejl za potvrdu registracije!</h4>`;
          this.submitted = true;
        }).catch(error => {
          if(error.response.status === 500  && error.response.data.message==='Username already exists you mappet!'){
            this.messageConfirmPassword = `<h5>Vec postoji korisnik sa unetim <b>korisnickim imenom<b> ! Molimo Vas pokusajte uneti druge vrednosti !</h5>`;
              
            setTimeout(()=>this.errorMessage='',3000);
          }
        }); 

      }
      else{
          this.messageConfirmPassword = `<h5>Sifre koje ste uneli se ne poklapaju!Molimo Vas pokusajte ponovo!</h5>`;
          setTimeout(()=>this.messageConfirmPassword='',3000);
      }
    },

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
  height: auto;
  border-radius: 2rem;
}

.form-label-group>input,
.form-label-group>label {
  padding: var(--input-padding-y) var(--input-padding-x);
}

.form-label-group>label {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  margin-bottom: 0;
  /* Override default `<label>` margin */
  line-height: 1.5;
  color: #495057;
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
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

#message-box{
  margin-bottom:400px;
  padding:50px;
}
</style>
