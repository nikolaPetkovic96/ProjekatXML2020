<template>
<div id="home">
    <div class="container">
        <h1 style="margin-top:10px;color:#35424a;">Dobrodošli <span id='titleEffect'>{{user.username}}</span>!</h1>
        <hr style='background:#35424a;height:1px;'>
    </div>

    <!-- Page Content -->
    <div class="container">
        <div class="row">

            <!-- Cars -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/car_elements" class="nav-link"
                        exact>
                        <img src="../assets/sifrarnikHomeIcon.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Sifrarnik</h5>
                            <div class="card-text text-black-50">Pogledajte listu svih sifrarnika i dodajte nove elemente...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Ads -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/users" class="nav-link"
                        exact>
                        <img src="../assets/users1.2.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Korisnici</h5>
                            <div class="card-text text-black-50">Pogledajte listu svih korisnika i definisite njihove permisije...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Reservations -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/reservations" class="nav-link"
                        exact>
                        <img src="../assets/reviewHomeIcon.png" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Komentari i ocene</h5>
                            <div class="card-text text-black-50">Pogledajte listu svih komentara i definisite njihovu vidljivost...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Prices-->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/price" class="nav-link" exact>
                        <img src="../assets/registrationHomeIcon.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Registrovanje agenta</h5>
                            <div class="card-text text-black-50">Registrujte i dodajte nove agente u sistem...</div>
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
             username:'Admin'
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
    color:#00bcd4;
    font-weight: bold;
}


</style>