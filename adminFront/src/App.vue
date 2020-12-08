<template>
  <div id="app">
   <app-nav></app-nav>
   <router-view></router-view>
   <app-footer></app-footer>
  </div>
</template>

<script>

import Footer from './components/Footer.vue'
import Navigation from './components/Navigation.vue'
import axios from "axios";

export default {
  name: 'app',
  components: {
    'app-footer':Footer,
    'app-nav':Navigation,
  },
  data:function(){
    return{
      retrivedToken:null,
    }
  },
  methods:{
    //pogledam u locallstorage da li imam token ako ima axios.setHedar(token)... isto kao kod logovnja 
    retriveTokenFromLocalStorage(){
      if(localStorage.getItem('token')){
        this.retrivedToken = JSON.parse(localStorage.getItem('token'));
        axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.retrivedToken.accessToken;
      }
    }
  }
}
</script>

<style>

</style>