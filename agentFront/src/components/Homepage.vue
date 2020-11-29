<template>
<div id="home">
    <div class="container">
        <h1 style="margin-top:10px;color:#35424a;">Welcome <span id='titleEffect'>{{user.username}}</span>!</h1>
        <hr style='background:#35424a;height:1px;'>
    </div>

    <!-- Page Content -->
    <div class="container">
        <div class="row">

            <!-- Cars -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/cars" class="nav-link"
                        exact>
                        <img src="../assets/CarHomeIcon3.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Automobili</h5>
                            <div class="card-text text-black-50">Pogledajte listu svih automobila i dodajte novi...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Ads -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/ads" class="nav-link"
                        exact>
                        <img src="../assets/AdHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Oglasi</h5>
                            <div class="card-text text-black-50">Pogledajte listu svih oglasa i dodajte novi...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Reservations -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/reservations" class="nav-link"
                        exact>
                        <img src="../assets/reservation1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Rezervacije</h5>
                            <div class="card-text text-black-50">Pogledajte listu rezervacija napravljenih za vaša vozila...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Prices-->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/price" class="nav-link" exact>
                        <img src="../assets/priceTagHomeIcon2.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Cenovnik</h5>
                            <div class="card-text text-black-50">Pogledajte listu cenovnika i dodajte novi...</div>
                        </div>
                    </router-link>
                </div>
            </div>

             <!-- Statistics -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/profile" class="nav-link" exact>
                        <img src="../assets/statisticHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Statistika</h5>
                            <div class="card-text text-black-50">Pogledajte statistiku o vasim vozilima...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Messages-->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/profile" class="nav-link" exact>
                        <img src="../assets/messageHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Poruke</h5>
                            <div class="card-text text-black-50">Razmenite poruke sa korisnicima koji su iznajmili Vaša vozila...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Profile-->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/profile" class="nav-link" exact>
                        <img src="../assets/profile3.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Profil</h5>
                            <div class="card-text text-black-50">Pogledajte i izmenite vaše lične podatke na profilu...</div>
                        </div>
                    </router-link>
                </div>
            </div>
        </div><!-- /.row -->
    </div>
</div>
</template>
<script>
import axios from 'axios'
export default {
    data(){
        return{
         user:{
             username:'Agent'
         }
        }
    },
    methods:{

    },
    created(){
     
    },
}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}


</style>