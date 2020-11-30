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

                    <!-- <li class="list-group-item">
                        <h5 class="header5">Prezime</h5>
                        <h4>{{profile.prezime}}</h4>
                    </li> -->

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
                        <h4>{{profile.TAdresa.ulica}} {{profile.TAdresa.broj}} (ulica/broj)</h4>
                        <h6>{{profile.TAdresa.postanskiBroj}} {{profile.TAdresa.mesto}} (post_br/grad)</h6>
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
import axios from 'axios'
export default {
    name: 'Admin-profile',
    data(){
        return{
            profile: {
                id:'1',
                ime:'Admin',
                prezime:'Adminovic',
                jmbg:'21321412412',
                pol:'Muski',
                korisnickoIme:'AdminX',
                email:'admin996@gmai.com',
                status:'aktivan',
                TAdresa:{
                    mesto:'Beograd',
                    ulica:'Bulevar Bulevara',
                    broj:'bb',
                    postanskiBroj:'11000',
                },
            }
        }
    },
    methods:{
        updateAdmin(id){
            this.$router.push(`/profile/${id}/update`);
        }
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