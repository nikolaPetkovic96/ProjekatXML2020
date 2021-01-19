<template>
    <div id="DataAndStatistic">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista završenih <span id='titleEffect'>rezervacija</span></h1>
            <h3 style="margin-top:10px;color:#35424a;">Koje ste Vi <span id='titleEffect'>napravili</span> </h3>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div id='main' class='container'>
            <table class="table">
                <thead>
                    <tr>
                        <th>Rezervisan od</th>
                        <th>Ukupna cena</th>
                        <th>Bundle</th>
                        <th>Status</th>
                        <th>Detaljnije</th>
                        <th>Komentar i ocena</th>
                    </tr>
                </thead>
                <tbody>                
                <tr v-bind:key="rezervacija.id" v-for='rezervacija in rezervacije'>
                    <td>{{rezervacija.username}}</td>
                    <td>{{rezervacija.ukupnaCena}}</td>
                    <td>{{rezervacija.bundle}}</td>
                    <td>{{rezervacija.statusRezervacije}}</td>
                    <td>
                        <button v-on:click='showDetails(rezervacija.id)' class="btn-outline-primary"> detalji </button>
                    </td>
                    <td>
                        <button v-on:click='writeReport(rezervacija.id)' class="btn-outline-primary"> komentar </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import userDataService from '../services/UserDataService'
export default {
    name: 'Messages',
    data:function(){
        return {
            showRank:false,
            bestByKm:false,
            bestByKom:false,
            bestByRat:false,
            //Za ocenu i komentar rezervacije sa statusom PAID koje su zavrsene
            rezervacije:[],
        }
    },
    methods:{
        getAllExpiredReservation(){
            userDataService.getAllRezervacijeExpiredUser().then( response =>{
                this.rezervacije = response.data;
            });
        },
        writeReport:function(id){
            this.$router.push(`/comments/${id}/new`);
        },
        showDetails(id){
            this.$router.push(`/reservation/${id}/details`);
        },

        disableReservation(){
            if(this.permissions.allowedToMakeReservation == true && this.permissions.status == 'aktivan'){
                return false
            }
            else{
                return true;
            }
        }

    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
           this.$router.push(`/login`);
        }
        else{
            this.getAllExpiredReservation();
        }   
    }
}
</script>

<style scoped>

#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}

#places{
    position: relative;
    margin-bottom:100px;
}
#first-place{
    border:solid 1px #35424a;
    padding:15px;
}
#first-place-img{
    position: absolute;
    left:15px;
    width:15%;
}
#first-place-info{
    position: absolute;
    right:65px;
    width:80%;
    background-color: red;
    height: fit-content;
    
}
#DataAndStatistic label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

#DataAndStatistic textarea{
    display: block;
    width: 100%;
    height: 200px;
    padding:8px;
}

.warning{
    color:white;
    background-color: #35424a;
}

</style>