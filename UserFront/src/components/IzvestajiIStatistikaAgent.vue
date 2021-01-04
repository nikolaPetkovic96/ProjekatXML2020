<template>
    <div id="DataAndStatistic">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista završenih <span id='titleEffect'>rezervacija</span></h1>
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
                        <th>Izveštaj</th>
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
                        <button v-on:click='writeReport(rezervacija.id)' class="btn-outline-primary"> izvestaj </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <!-- <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Statistika upotrebe <span id='titleEffect'>automobila</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div> -->
        <!-- <div id='main' class='container'>
              (Ne obracati paznju sto ne prikazuje trenutno navecu km i rejting)
	        <div id='criterium' class="row">
					<div class="col-md-4 col-sm-6 mb-4">
                        <h4>Najviše komentara</h4>
						<button v-on:click='getBestByComments()'><img src="../assets/messageSign.jpg" alt=""></button>
					</div>

					<div class="col-md-4 col-sm-6 mb-4">
                        <h4>Najviše pređenih kilometara</h4>
						<button v-on:click='getBestByKm()'><img src="../assets/kmSign2.jpg" alt=""></button>
					</div>

					<div class="col-md-4 col-sm-6 mb-4">
						<h4>Najviša ocena</h4>
						<button v-on:click='getBestByRating()'><img src="../assets/ratingSign2.jpg" alt=""></button>
					</div>
            </div> -->
            <!-- <div id='places' v-if='showRank'>
                <div id='first-place-warn' class='alert alert-warning' v-if='automobili[0].predjenaKilometraza == -1'> Nema automobila koji je prvo mesto!</div>                    
                <div id='first-place' v-if='automobili[0].predjenaKilometraza !== -1'>
                    <div class="card-header">
                        <img  src="../assets/firstIcon2.png" alt="">
                        <h2 style='color:#FF8C00' v-if='bestByKm'><b>Kilometraža:</b> {{automobili[0].predjenaKilometraza}} km</h2>
                        <h2 style='color:#FF8C00' v-if='bestByKom'><b>Broj komentara:</b> {{automobili[0].brojKomentara}}</h2>
                        <h2 style='color:#FF8C00' v-if='bestByRat'><b>Ukupna ocena:</b> {{automobili[0].ukupnaOcena}}</h2>
                        <h4><b>Automobil:</b> {{automobili[0].markaAut}} {{automobili[0].modelAut}} (marka/model)</h4>
                        <h4><b>Klasa automobila:</b> {{automobili[0].klasaAut}}</h4>
                        <h5 v-if='bestByKom || bestByRat'><b>Kilometraža:</b> {{automobili[0].predjenaKilometraza}}</h5>
                        <h5 v-if='bestByRat || bestByKm'><b>Broj komentara:</b> {{automobili[0].brojKomentara}}</h5>
                        <h5 v-if='bestByKom || bestByKm '><b>Ukupna ocena:</b> {{automobili[0].ukupnaOcena}}</h5>
                    </div>
                </div>
                <hr>
                <div id='second-place-warn' class='alert alert-warning' v-if='automobili[1].predjenaKilometraza == -1'> Nema automobila koji je drugo mesto!</div>
                <div id='second-place' v-if='automobili[1].predjenaKilometraza!== -1'>
                    <div class="card-header">
                        <h1 style='color:#FF8C00'><i>#2</i></h1>
                        <h4 v-if='bestByKm'><b>Kilometraža:</b> {{automobili[1].predjenaKilometraza}} km</h4>
                        <h4 v-if='bestByKom'><b>Broj komentara:</b> {{automobili[1].brojKomentara}}</h4>
                        <h4 v-if='bestByRat'><b>Ukupna ocena:</b> {{automobili[1].ukupnaOcena}}</h4>
                        <h5><b>Automobil:</b> {{automobili[1].markaAut}} {{automobili[1].modelAut}} (marka/model)</h5>
                        <h5><b>Klasa automobila:</b> {{automobili[1].klasaAut}}</h5>
                        <h6 v-if='bestByKom || bestByRat'><b>Kilometraža:</b> {{automobili[1].predjenaKilometraza}}</h6>
                        <h6 v-if='bestByRat || bestByKm'><b>Broj komentara:</b> {{automobili[1].brojKomentara}}</h6>
                        <h6 v-if='bestByKom || bestByKm '><b>Ukupna ocena:</b> {{automobili[1].ukupnaOcena}}</h6>
                    </div>
                </div>
                <hr>
                <div id='third-place-warn' class='alert alert-warning' v-if='automobili[2].predjenaKilometraza == -1'> Nema automobila koji je trece mesto!</div>
                <div id='third-place' v-if='automobili[2].predjenaKilometraza !== -1'>
                     <div class="card-header">
                        <h1 style='color:#FF8C00'><i>#3</i></h1>
                        <h4 v-if='bestByKm'><b>Kilometraža:</b> {{automobili[2].predjenaKilometraza}} km</h4>
                        <h4 v-if='bestByKom'><b>Broj komentara:</b> {{automobili[2].brojKomentara}}</h4>
                        <h4 v-if='bestByRat'><b>Ukupna ocena:</b> {{automobili[2].ukupnaOcena}}</h4>
                        <h5><b>Automobil:</b> {{automobili[2].markaAut}} {{automobili[2].modelAut}} (marka/model)</h5>
                        <h5><b>Klasa automobila:</b> {{automobili[2].klasaAut}}</h5>
                        <h6 v-if='bestByKom || bestByRat'><b>Kilometraža:</b> {{automobili[2].predjenaKilometraza}}</h6>
                        <h6 v-if='bestByRat || bestByKm'><b>Broj komentara:</b> {{automobili[2].brojKomentara}}</h6>
                        <h6 v-if='bestByKom || bestByKm '><b>Ukupna ocena:</b> {{automobili[2].ukupnaOcena}}</h6>
                    </div>
               </div> 
            </div> 
        </div> -->
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
            //Za izvestaj rezervacije sa statusom PAID koje su zavrsene
            rezervacije:[],
            //Za statistiku:
            automobili:[]
        }
    },
    methods:{
        getAllExpiredReservation(){
            userDataService.getAllRezervacijeExpired().then( response =>{
                this.rezervacije = response.data;
            });
        },

        getBestByComments:function(){
            if(this.showRank===true){
                userDataService.getBestByCategory("comment").then(response => {
                   this.automobili = response.data;
                });
            }
            else{
                this.showRank = !this.showRank;
            }
            this.bestByKom = true;
            this.bestByKm = false;
            this.bestByRat = false;
        
        },
        getBestByKm:function(){
            if(this.showRank===true){
                userDataService.getBestByCategory("km").then(response => {
                    console.log('200 OK');
                    this.automobili = response.data;
                    console.log('this.automobili.id: ' + this.automobili.id);
                     if(this.automobili.length == 0){
                        this.addDummyCars(0);
                    }
                    else if(this.automobili.length == 1){
                        this.addDummyCars(1);
                    }
                    else if(this.automobili.length == 2){
                        this.addDummyCars(2);
                    }
                });
            }
            else{
                this.showRank = !this.showRank;
            }
            this.bestByKom = false;
            this.bestByKm = true;
            this.bestByRat = false;
        },
        //ukoliko je prosledjen sa beka samo jedan automobil
        //Onda se popunjavaju 2. i 3. mesto nekim praznim
        //Vozilom da ne bi pukao front
        addDummyCars(noOfCars){
            const dummyAuto = {
                id:'3',
                predjenaKilometraza:-1,
            }
            if(noOfCars == 0){
                this.automobili[0] = dummyAuto;
                this.automobili[1] = dummyAuto;
                this.automobili[2] = dummyAuto;
            }
            if(noOfCars == 1){
                this.automobili[1] = dummyAuto;
                this.automobili[2] = dummyAuto;
            }
            else if(noOfCars == 2){
                this.automobili[2] = dummyAuto;
            }
        },

        getBestByRating:function(){
            if(this.showRank===true){
                userDataService.getBestByCategory("rating").then(response => {
                   this.automobili = response.data;
                });
            }
            else{
                this.showRank = !this.showRank;
            }
            this.bestByKom = false;
            this.bestByKm = false;
            this.bestByRat = true;
        },
        writeReport:function(id){
            this.$router.push(`/statistics/${id}/report`);
        },
        showDetails(id){
            this.$router.push(`/reservation/${id}/details`);
        }

    },
    created(){
        this.getAllExpiredReservation();
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