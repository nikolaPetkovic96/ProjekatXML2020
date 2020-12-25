<template>
    <div id="DataAndStatistic">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista zavrsenih <span id='titleEffect'>rezervacija</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div id='main' class='container'>
            <table class="table">
                <thead>
                    <tr>
                        <th>Rezervisan od</th> <!--Korisnik koji ga rezervise-->
                        <th>Ukupna cena</th>
                        <th>Bundle</th>
                        <th>Status</th>
                        <th>Detaljnije</th>
                        <th>Izvestaj</th>
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

        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Statistika upotrebe <span id='titleEffect'>automobila</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div id='main' class='container'>
              (Ne obracati paznju sto ne prikazuje trenutno navecu km i rejting)
	        <div id='criterium' class="row">
					<div class="col-md-4 col-sm-6 mb-4">
                        <h4>Najvise komentara</h4>
						<button v-on:click='getBestByComments()'><img src="../assets/messageSign.jpg" alt=""></button>
					</div>

					<div class="col-md-4 col-sm-6 mb-4">
                        <h4>Najvise predjenih kilometara</h4>
						<button v-on:click='getBestByKm()'><img src="../assets/kmSign2.jpg" alt=""></button>
					</div>

					<div class="col-md-4 col-sm-6 mb-4">
						<h4>Najvisa ocena</h4>
						<button v-on:click='getBestByRating()'><img src="../assets/ratingSign2.jpg" alt=""></button>
					</div>
            </div>
            <div id='places' v-if='showRank'>                    
                <div id='first-place'>
                    <img  src="../assets/firstIcon2.png" alt="">
                    <div class="card-header">
                        <h2 v-if='bestByKm'><b>Kilometraza:</b> {{automobili[1].predjenaKilometraza}}</h2>
                        <h2 v-if='bestByKom'><b>Broj komentara:</b> {{automobili[1].broj_komentara}}</h2>
                        <h2 v-if='bestByRat'><b>Ukupna_ocena:</b> {{automobili[1].ukupna_ocena}}</h2>
                        <h4><b>Automobil:</b> {{automobili[1].markaAut}} {{automobili[1].modelAut}} (marka/model)</h4>
                        <h4><b>Klasa automobila:</b> {{automobili[1].klasaAut}}</h4>
                        <h5 v-if='bestByKom || bestByRat'><b>Kilometraza:</b> {{automobili[1].predjenaKilometraza}}</h5>
                        <h5 v-if='bestByRat || bestByKm'><b>Broj komentara:</b> {{automobili[1].broj_komentara}}</h5>
                        <h5 v-if='bestByKom || bestByKm '><b>Ukupna_ocena:</b> {{automobili[1].ukupna_ocena}}</h5>
                    </div>
                </div><!-- </first-place> -->
                <br>
                <div id='second-place'>
                    <div class="card-header">
                        <h4 v-if='bestByKm'><b>Kilometraza:</b> {{automobili[2].predjenaKilometraza}}</h4>
                        <h4 v-if='bestByKom'><b>Broj komentara:</b> {{automobili[2].broj_komentara}}</h4>
                        <h4 v-if='bestByRat'><b>Ukupna_ocena:</b> {{automobili[2].ukupna_ocena}}</h4>
                        <h5><b>Automobil:</b> {{automobili[2].markaAut}} {{automobili[2].modelAut}} (marka/model)</h5>
                        <h5><b>Klasa automobila:</b> {{automobili[2].klasaAut}}</h5>
                        <h6 v-if='bestByKom || bestByRat'><b>Kilometraza:</b> {{automobili[2].predjenaKilometraza}}</h6>
                        <h6 v-if='bestByRat || bestByKm'><b>Broj komentara:</b> {{automobili[2].broj_komentara}}</h6>
                        <h6 v-if='bestByKom || bestByKm '><b>Ukupna_ocena:</b> {{automobili[2].ukupna_ocena}}</h6>
                    </div>
                </div><!-- </second-place> -->
                <hr>
                <div id='third-place'>
                     <div class="card-header">
                        <h4 v-if='bestByKm'><b>Kilometraza:</b> {{automobili[0].predjenaKilometraza}}</h4>
                        <h4 v-if='bestByKom'><b>Broj komentara:</b> {{automobili[0].broj_komentara}}</h4>
                        <h4 v-if='bestByRat'><b>Ukupna_ocena:</b> {{automobili[0].ukupna_ocena}}</h4>
                        <h5><b>Automobil:</b> {{automobili[0].markaAut}} {{automobili[0].modelAut}} (marka/model)</h5>
                        <h5><b>Klasa automobila:</b> {{automobili[0].klasaAut}}</h5>
                        <h6 v-if='bestByKom || bestByRat'><b>Kilometraza:</b> {{automobili[0].predjenaKilometraza}}</h6>
                        <h6 v-if='bestByRat || bestByKm'><b>Broj komentara:</b> {{automobili[0].broj_komentara}}</h6>
                        <h6 v-if='bestByKom || bestByKm '><b>Ukupna_ocena:</b> {{automobili[0].ukupna_ocena}}</h6>
                    </div>
                </div><!-- </second-place> -->
            </div>
        </div>
    </div>
</template>
<!-- Isti get koji se radi i u Rezervacija.vue. Vrati sve rezervacije koje su napravljene
za oglase koje je kreirao ulogovani agent i kojima je status="accepted" -->

<script>
export default {
    name: 'Messages',
    data:function(){
        return {
            showRank:false,
            bestByKm:false,
            bestByKom:false,
            bestByRat:false,
            //Ovde moze i samo deo sa rezervacijom bez ostalih objekata
            //Isti DTO iskoristiti i u Poruke.vue
            rezervacije:[
                {
                    id:1,
                    ukupnaCena:6500,
                    statusRezervacije:'RESERVED',
                    username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    bundle:true,
                },
                {
                    id:2,
                    ukupnaCena:8500,
                    statusRezervacije:'RESERVED',
                    username:'Happy User 3', //u rezervDTOu za korisnika koji je rezervisao oglas.
                    bundle:true,
                },
                
            ],

            //Za statistiku:
            automobili:[
                {       
                    id:'1',
                    markaAut:'BMW',
                    modelAut:'M5',
                    klasaAut:'SUV',
                    tipGoriva:'Dizel',
                    tipMenjaca:'Automatik',
                    ukupna_ocena:5,
                    predjenaKilometraza:500,
                    brojDecMesta:2,
                    broj_komentara:5, //za ovaj dto
                    images:[],
                },
                {
                    id:'2',
                    markaAut:'Mercedes',
                    modelAut:'R8',
                    klasaAut:'Old Tajmer',
                    tipGoriva:'Dizel',
                    tipMenjaca:'Automatik',
                    ukupna_ocena:3,
                    predjenaKilometraza:800,
                    brojDecMesta:3,
                    broj_komentara:2,
                    images:[],
                },
                {
                    id:'3',
                    markaAut:'Audi',
                    modelAut:'A6',
                    klasaAut:'Gradski auto',
                    tipGoriva:'Dizel',
                    tipMenjaca:'Automatik',
                    ukupna_ocena:4,
                    predjenaKilometraza:650,
                    brojDecMesta:1,
                    broj_komentara:10,
                    image:[],
                },
            ]
        }
    },
    methods:{
        getBestByComments:function(){
            if(this.showRank===true){
                //get 3 automobila sa najvise komentara
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
                //get 3 automobila sa najvise kilometara
            }
            else{
                this.showRank = !this.showRank;
            }
            this.bestByKom = false;
            this.bestByKm = true;
            this.bestByRat = false;
        },
        getBestByRating:function(){
            if(this.showRank===true){
                //get 3 automobila sa najvisom ocenom
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

    }
}
</script>

<style scoped>

#titleEffect{
  color:gold;
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

</style>