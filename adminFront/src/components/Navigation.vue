<template>
  <div id="navigation">
  <nav class="navbar navbar-expand-lg navbar-dark static-top">
      <div class="container">
        <a class="navbar-brand" href="/"><h1><span id='titleEffect'>RentaAdmin</span>App</h1></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
           <li v-if='loggedIn==false' class="nav-item active">
              <router-link to='/' class="nav-link" exact> Home
                <span class="sr-only">(current)</span>
              </router-link>
            </li>
             <li v-if='loggedIn==true' class="nav-item active">
              <router-link to='/home' class="nav-link" exact> Home
                <span class="sr-only">(current)</span>
              </router-link>
            </li>
            <li class="nav-item">
              <router-link to='/about' class="nav-link" exact>About</router-link>
            </li>
          </ul>
          
          <router-link  to='/login' class="nav-link" exact> <button v-show="loggedIn==false" class="btn" id='btnLogin'>Log In</button> </router-link>
          <button  class="btn" v-show="loggedIn==true" id='btnLogout' v-on:click='logOut()'>Log Out</button> 
        </div>
      </div>
    </nav> 

  </div>
</template>

<script>
import { bus } from '../main'; 
import axios from "axios";
export default {
  name: 'Navigation',
  components: {
  },

  data:function(){
    return{
      // loggedOut: false, //loginovan je treba da pise log out dugme
      loggedIn: localStorage.getItem('token') ? true : false,
    }
  },
  methods:{
    logOut:function(){
      if(confirm('Da li ste sigurni da se zelite izlogovati?')){
        if(localStorage.getItem('token')){
          localStorage.removeItem('token');
          localStorage.removeItem('parsToken');
          axios.defaults.headers.common['Authorization'] = undefined;
  
          this.loggedIn = false;  //logout-ovan je treba da pise log in dugme
          this.$router.push('/');
        }
      }
    },
  
  },
  created(){
    //Prilikom created osluskujem da li je doslo do eventa login i ako jeste kazem da je loginovan;
    bus.$on('loggedIn',(data)=>{
      this.loggedIn = data;
    });
  }
}
</script>

<style scoped>
#navigation{
  background-color:#35424a;
  color:#fff;
  padding-top:30px;
  min-height: 70px;
  border-bottom:#00bcd4 3px solid;
} 
/* Ostaviti za sada ako ne obrisati */
ul{
  list-style-type: none;
  text-align: center;
  margin:0;
}
li{
  display:inline-block;
  margin: 0;
}

a{
  color:#fff;
  text-decoration: none;
  padding:6px 8px;
  border-radius: 10px;
}

#btnLogin{
  height:38px;
  /* color:rgb(15, 221, 236); */
  background-color:#00bcd4;
  color:#fff;
  border:none;
  padding: 0 20px;
}

#btnLogin:hover{
  background-color:#cccccc;
  color:#fff;
  font-weight: bold;
}

#btnLogout{
  height:38px;
  background-color:#00bcd4;
  color:#fff;
  border:none;
  padding: 0 20px;
}

#btnLogout:hover{
  background-color:#cccccc;
  color:#fff;
  font-weight: bold;
}

#titleEffect{
  /* color:#9400D3;FFD300 */
  color:#00bcd4;
  font-weight: bold;
}

.router-link-active{
  border-bottom: #fff solid 1px;
  font-weight: bold;
}
</style>
