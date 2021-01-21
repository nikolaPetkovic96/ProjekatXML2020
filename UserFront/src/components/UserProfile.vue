<template>
<div id="user-profile">
    <div>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Profil <span id='titleEffect'>Usera</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container">
            <form>
                <ul id="services" class="list-group">
                <!-- Osoba -->
                    <li class="list-group-item" >
                        <h5 class="header5">Korisnicko ime</h5>
                        <h4>{{profile.korisnickoIme}}</h4>
                    </li>
                    <li class="list-group-item" >
                        <h5 class="header5">Ime i Prezime</h5>
                        <h4>{{profile.ime}} {{profile.prezime}}</h4>
                    </li>

                    <li class="list-group-item" >
                        <h5 class="header5">Pol</h5>
                        <h4>{{profile.pol}}</h4>
                    </li>

                    <li class="list-group-item" >
                        <h5 class="header5">JMBG</h5>
                        <h4>{{profile.jmbg}}</h4>
                    </li>
                 <!-- Osoba -->

                    <li class="list-group-item">
                        <h5 class="header5">Email</h5>
                        <h4>{{profile.email}}</h4>
                    </li>

                    <li class="list-group-item">
                        <h5 class="header5">Adresa</h5>
                        <h6>{{profile.tadresa.ulica}} {{profile.tadresa.broj}} (ulica/broj)</h6>
                        <h6>{{profile.tadresa.postanskiBroj}} {{profile.tadresa.mesto}} (post_br/grad)</h6>
                    </li>
                </ul>

                <div id='buttonUpdate'>
                    <button :disabled='btnEnabled' type='button' class="btn btn-lg btn-success marg" v-on:click='updateUser(profile.id)'> Update</button> 
                </div>
            </form>
        </div>
    </div>
</div>
</template>
<script>
import UserDataService from '../services/UserDataService'
export default {
    data(){
        return{
            permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
            },
            btnEnabled:false,
            //Ostaviti proil objekat zbog mapiranja
            profile: {
                //Osoba
                id:null,
                ime:'',
                prezime:'',
                jmbg:'',
                pol:'',
                //user
                korisnickoIme:'',
                email:'',
                status:'',
                tadresa:{
                    mesto:'',
                    ulica:'',
                    broj:'',
                    postanskiBroj:'',
                },
            }
        }
    },
    methods:{
        getAllPermissions:function(){
            UserDataService.getAllPermissions().then(response => {
                this.permissions = response.data;
                if(this.permissions.status != "aktivan"){
                    btnEnabled = true
                }
                console.log(JSON.stringify(this.permissions));
            });
        },
        getUserProfileData(id){
            UserDataService.getUser(id).then(response => {
                this.profile = response.data;
            })
        },
        updateUser(id){ 
            this.$router.push(`/profile/${id}/update`);
        },
        
    },
    computed:{
        id() {
            return this.$route.params.id; //preuzimam id usera na cijoj sam stranici za prikaz profila
        },
    },

    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
           this.$router.push(`/login`);
        }
        else{
            let parsToken = JSON.parse(localStorage.getItem('parsToken'));
            this.getUserProfileData(parsToken.jti);
            this.getAllPermissions();
        }
        
    },

}
</script>

<style scoped>

#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}

#user-profile ul#services li{
    list-style: none;
    padding:15px;
    border-bottom: gray solid 1px;
    border-radius: 15px;
    margin-bottom: 3px; 
    background-color:#fff;
    width:90%;
}

#user-profile#buttonUpdate{
  float:left;
}

.header5{
    color:#FF8C00;
    font-weight: bold;
}

.marg{
    margin-top:15px;
}

</style>