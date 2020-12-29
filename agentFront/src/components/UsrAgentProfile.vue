<template>
<div id="user-profile">
    <div>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Profil <span id='titleEffect'>Agenta</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container">
            <form>
                <ul id="services" class="list-group">
                <!-- Osoba -->
                    <li class="list-group-item" v-if='isAgentType == "osoba"'>
                        <h5 class="header5">Korisnicko ime</h5>
                        <h4>{{profile.korisnickoIme}}</h4>
                    </li>
                    <li class="list-group-item" v-if='isAgentType == "osoba"'>
                        <h5 class="header5">Ime i Prezime</h5>
                        <h4>{{profile.ime}} {{profile.prezime}}</h4>
                    </li>

                    <li class="list-group-item" v-if='isAgentType == "osoba"'>
                        <h5 class="header5">Pol</h5>
                        <h4>{{profile.pol}}</h4>
                    </li>

                    <li class="list-group-item" v-if='isAgentType == "osoba"'>
                        <h5 class="header5">JMBG</h5>
                        <h4>{{profile.jmbg}}</h4>
                    </li>
                 <!-- Osoba -->
                    <li class="list-group-item" v-if='isAgentType == "firma"'>
                        <h5 class="header5">Naziv firme</h5>
                        <h4>{{profile.naziv}}</h4>
                    </li>

                    <li class="list-group-item" v-if='isAgentType == "firma"'>
                        <h5 class="header5">Poslovni Maticni Broj</h5>
                        <h4>{{profile.poslovniMaticniBroj}}</h4>
                    </li>

                    <li class="list-group-item">
                        <h5 class="header5">Email</h5>
                        <h4>{{profile.email}}</h4>
                    </li>

                    <li class="list-group-item">
                        <h5 class="header5">Adresa</h5>
                        <h4>{{profile.adresa.ulica}} {{profile.adresa.broj}} (ulica/broj)</h4>
                        <h6>{{profile.adresa.postanskiBroj}} {{profile.adresa.mesto}} (post_br/grad)</h6>
                    </li>
                </ul>

                <div id='buttonUpdate'>
                    <button type='button' class="btn btn-lg btn-success marg" v-on:click='updateAgent(profile.id)'> Update</button> 
                </div>
            </form>
        </div>
    </div>
</div>
</template>
<script>
import agentDataService from '../services/AgentDataService'
export default {
    data(){
        return{
        //kada je agent osoba //zakomentarisati kod za test agent firma
         profile: {
                //Osoba
                id:'',
                ime:'',
                prezime:'',
                jmbg:'',
                pol:'',
                //firma
                naziv:'',
                poslovniMaticniBroj:'',
                //user
                korisnickoIme:'',
                email:'',
                status:'',
                adresa:{
                    mesto:'',
                    ulica:'',
                    broj:'',
                    postanskiBroj:'',
                },
            }
        }
    },
    methods:{
        getAgentProfileData(id){
            agentDataService.getAgent(id).then(response => {
                this.profile = response.data;
            })
        },
        updateAgent(id){ 
            this.$router.push(`/profile/${id}/update`);
        },
        
    },
    computed:{
        isAgentType(){
            if(this.profile.ime == null && this.profile.prezime == null && this.profile.jmbg == null && this.profile.pol == null){
                return 'firma';
            }
            else if(this.profile.nazivFirme == null && this.profile.poslovniMaticniBroj == null){
                return 'osoba';
            }
        },
        id() {
            return this.$route.params.id; //preuzimam id usera na cijoj sam stranici za prikaz profila
        },
    },

    created(){
        let parsToken = JSON.parse(localStorage.getItem('parsToken'));
        this.getAgentProfileData(parsToken.id);
    },

}
</script>

<style scoped>

#titleEffect{
  color:gold;
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
    color:gold;
    font-weight: bold;
}

.marg{
    margin-top:15px;
}

</style>