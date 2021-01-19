<template>
<div id="home">
    <div class="container">
        <h1 style="margin-top:10px;color:#35424a;">Welcome <span id='titleEffect'>{{user.username}}</span>!</h1>
        <hr style='background:#35424a;height:1px;'>
    </div>

    <div style='font-size:25px;' class="container">
        <label>User</label>
        <switches  v-model="mode"  theme="bulma" color="green"></switches>
        <!-- <switches v-model="enabled" theme="bootstrap" color="blue"></switches> -->
        <label>Agent</label>
    </div>

    <!-- Page Content -->
    <div class="container" v-show=korisnik>
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
            <!-- <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/ads" class="nav-link"
                        exact>
                        <img src="../assets/AdHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Oglasi</h5>
                            <div class="card-text text-black-50">Pogledajte listu svih oglasa i dodajte novi oglas...</div>
                        </div>
                    </router-link>
                </div>
            </div> -->

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
            <!-- <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/price" class="nav-link" exact>
                        <img src="../assets/priceTagHomeIcon2.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Cenovnik</h5>
                            <div class="card-text text-black-50">Pogledajte listu cenovnika i dodajte novi...</div>
                        </div>
                    </router-link>
                </div>
            </div> -->

            <!-- Statistics -->
            <!-- <div class="col-xl-3 col-md-6 mb-4" >
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/statistics" class="nav-link" exact>
                        <img src="../assets/statisticHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Izvestaj i Statistika</h5>
                            <div class="card-text text-black-50">Ostavite izvestaj i pogledajte statistiku o vasim vozilima...</div>
                        </div>
                    </router-link>
                </div>
            </div> -->

            <!-- Comments User-->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/comments" class="nav-link" exact>
                        <img src="../assets/messageHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Komentari i ocene</h5>
                            <div class="card-text text-black-50">Ostavite komentar i ocenu i prenesite nam Vaše utiske...</div>
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

    <div class="container" v-show=agent>
        <div class="row"> 

            <!-- Cars -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/carsAgent" class="nav-link"
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
                    <router-link style='text-decoration: none;color:#35424a;' to="/adsAgent" class="nav-link"
                        exact>
                        <img src="../assets/AdHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Oglasi</h5>
                            <div class="card-text text-black-50">Pogledajte listu svih oglasa i dodajte novi oglas...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Reservations -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/reservationAgent" class="nav-link"
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
                    <router-link style='text-decoration: none;color:#35424a;' to="/priceAgent" class="nav-link" exact>
                        <img src="../assets/priceTagHomeIcon2.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Cenovnik</h5>
                            <div class="card-text text-black-50">Pogledajte listu cenovnika i dodajte novi...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Statistics -->
            <div class="col-xl-3 col-md-6 mb-4" >
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/reportAgent" class="nav-link" exact>
                        <img src="../assets/statisticHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Izvestaji</h5>
                            <div class="card-text text-black-50">Ostavite izveštaj o rezervaciji vaših vozilima...</div>
                        </div>
                    </router-link>
                </div>
            </div>

            <!-- Messages-->
            <!-- <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-0 shadow">
                    <router-link style='text-decoration: none;color:#35424a;' to="/messages" class="nav-link" exact>
                        <img src="../assets/messageHomeIcon1.1.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title mb-0">Poruke</h5>
                            <div class="card-text text-black-50">Razmenite poruke sa korisnicima koji su iznajmili Vaša vozila...</div>
                        </div>
                    </router-link>
                </div>
            </div> -->

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
import Switches from 'vue-switches'

export default {
    components:{
        Switches
    },
    data(){
        return{
            user:{
                username:''
            },
            mode: false,
            korisnik : true,
            agent : false,
            temp : ''
        }
    },
    methods:{
        parseJwt:function(token) {
            var base64Url = token.split('.')[1];
            var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));

            return JSON.parse(jsonPayload);
        }
    },
    watch:{
        mode: function(val){
            console.log("KLIJENT: " + this.korisnik)
            this.agent = !this.agent;
            this.korisnik = !this.korisnik;
            console.log("KLIJENT: " + this.korisnik)
            if(this.agent == true){
                localStorage.setItem("userMode", "agent")
            }
            else{
                localStorage.setItem("userMode", "korisnik")
            }
            console.log("LOCALE STORAGE: " + localStorage.getItem("userMode"))
        }
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
           this.$router.push(`/login`);
        }
        else{
            let parsToken = this.parseJwt(localStorage.getItem('token'));
            localStorage.setItem('parsToken', JSON.stringify(parsToken));
            this.user.username = parsToken.sub;
            console.log('USERNAME: ' + this.user.username);
            this.temp = ""
            try{
                this.temp = localStorage.getItem("userMode");
                console.log("MODE JE: " + this.temp)
                if(this.temp == "korisnik"){
                this.mode = false;
                }
                else if(this.temp == "agent"){
                    this.mode = true;
                }
            }catch(err){
                
            }finally{
                if (this.temp == ""){
                // this.korisnik = true;
                this.mode = true;
                }
            }
        // let parsToken = this.parseJwt(localStorage.getItem('token'));
        const temp = localStorage.getItem("userMode")
        }
    },
}
</script>

<style scoped>

#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}


</style>