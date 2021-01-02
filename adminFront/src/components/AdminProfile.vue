<template>
<div id="admin-profile">
    <div>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Profil <span id='titleEffect'>Administratora</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container">
            <form>
                <ul id="services" class="list-group">
                    <li class="list-group-item">
                        <h5 class="header5">Korisnicko ime</h5>
                        <h4>{{profile.korisnickoIme}}</h4>
                    </li>
                    <li class="list-group-item">
                        <h5 class="header5">Ime i Prezime</h5>
                        <h4>{{profile.ime}} {{profile.prezime}}</h4>
                    </li>

                    <li class="list-group-item">
                        <h5 class="header5">JMBG</h5>
                        <h4>{{profile.jmbg}}</h4>
                    </li>

                    <li class="list-group-item">
                        <h5 class="header5">Pol</h5>
                        <h4>{{profile.pol}}</h4>
                    </li>

                    <li class="list-group-item">
                        <h5 class="header5">Email</h5>
                        <h4>{{profile.email}}</h4>
                    </li>

                    <li class="list-group-item">
                        <h5 class="header5">Adresa</h5>
                        <h4>{{profile.tadresa.ulica}} {{profile.tadresa.broj}} (ulica/broj)</h4>
                        <h6>{{profile.tadresa.postanskiBroj}} {{profile.tadresa.mesto}} (post_br/grad)</h6>
                    </li>
                </ul>

                <div id='buttonUpdate'>
                    <button type='button' class="btn btn-lg btn-success marg" v-on:click='updateAdmin(profile.id)'> Update</button> 
                </div>
            </form>
        </div>
    </div>
</div>
</template>
<script>
import adminDataService from '../services/AdminDataService'
import axios from 'axios'
export default {
    name: 'Admin-profile',
    data(){
        return{
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
        }
    },
    methods:{
        getAdminProfileData:function(){
            adminDataService.getAdmin().then(response => {
                this.profile = response.data;
                console.log("admin: " + JSON.stringify(this.profile));
            })
        },
        updateAdmin(id){
            this.$router.push(`/profile/${id}/update`);
        }
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            let parsToken = JSON.parse(localStorage.getItem('parsToken'));
            this.getAdminProfileData();
        }
    },
}
</script>

<style scoped>

#titleEffect{
  color:#00bcd4;
  font-weight: bold;
}

#admin-profile ul#services li{
    list-style: none;
    padding:15px;
    border-bottom: gray solid 1px;
    border-radius: 15px;
    margin-bottom: 3px; 
    background-color:#fff;
    width:90%;
}

#admin-profile #buttonUpdate{
  /* float:left; */
  margin-top:25px;
  margin-bottom: 30px;
}

.header5{
    color:#00bcd4;
    font-weight: bold;
}

.marg{
    margin-top:15px;
}

</style>