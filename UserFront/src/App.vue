<template>
  <div>
    <app-nav></app-nav>
    <router-view></router-view>
    <app-footer></app-footer>
  </div>
</template>

<script>

import Footer from './components/Footer.vue'
import axios from 'axios'
import Navigation from './components/Navigation'


export default {
  name:'app',
  components:{
    'app-footer':Footer,
    'app-nav':Navigation
  },
  data () {
    return{
      retrievedToken:null
    }
  },
  methods : {
    retrieveTokenFromLocalStorage(){
      if(localStorage.getItem('token')){
        this.retrievedToken = JSON.parse(localStorage.getItem('token'));
        axios.defaults.headers.common['Authorization'] = 'Bearer' + this.retrievedToken.accessToken;
      }
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
