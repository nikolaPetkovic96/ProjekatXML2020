<template>
  <div id="cart">
    <div class="container" id='page-title'>
      <h1 style="margin-top:10px;color:#35424a;">Vaša <span id='titleEffect'>Korpa</span></h1>
      <button id='back_button' class="btn-lg btn-outline-dark" v-on:click='goBack()'> Nazad</button>
      <hr style='background:#35424a;height:1px;'>
    </div>
        
    <div class='container' id='search'>
      <h3 class="cart-empty" v-if="oglasi_korpa.length == 0">Vaša korpa je prazna!</h3>
      <div class="row" >
        <div  class="col-lg-3 col-md-4 col-sm-6 mb-4" v-bind:key='oglas.id'  v-for="oglas in oglasi_korpa">
          <div class="card h-100 ">
              <img id='overview-img' class="card-img-top" v-bind:src="oglas.automobil.slikeVozila.slika[0]" alt="">
              <div class="card-body">
                  <div class="card-text">
                      <h5 class="theme-colr"><b>Automobil: </b>{{oglas.automobil.markaAut}} {{oglas.automobil.modelAut}}</h5> 
                      <h5 class="theme-colr"><b>Klasa: </b>{{oglas.automobil.klasaAut}}</h5>
                      <h6 class="theme-colr"><b>Ocena:</b>({{oglas.automobil.ukupnaOcena}})   
                        <star-rating
                          inactive-color="#35424a"
                          active-color="#FF8C00;"
                          v-bind:read-only= "true"
                          v-bind:star-size="25"
                          v-bind:show-rating="false"
                          v-bind:rating="oglas.automobil.ukupnaOcena">
                        </star-rating>
                      </h6>
                      <h6 class="theme-colr"><b>Cena po danu: </b>{{oglas.cenovnik.cenaPoDanu}} din</h6>
                      <h6><b>Kilometraža: </b>{{oglas.automobil.predjenaKilometraza}} km</h6>
                  </div>
                    <button class="btn-sm btn-outline-primary" v-on:click='showDetails(oglas.id)'> Detalji </button>
                    <button class="btn-sm btn-outline-danger" v-on:click='removeAds(oglas.id)'> Ukloni </button>
                    <div v-bind:id='oglas.id'>
                    </div>
              </div>
          </div>
        </div>
      </div><!-- /.row -->
      <div class="cart-total container">
        <span>Ukupno</span>
        <span>{{total}} din</span>
      </div>
      <button class="btn-lg btn-success" v-on:click='makeReseravation()'> Potvrdi </button>
      <button class="btn-lg btn-danger" v-on:click='cancelReservation()'> Odustani </button>
    </div>
  </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
import StarRating from "vue-star-rating";
export default {
    data() {
      return {
        total:0,
        korpa:[], //nalaze se narudzbenice preuzete iz localStorage
        /*
          korpa:[
            {
              agentId:null,
              userId:null,
              oglasId:null,
              odDatuma:null,
              doDatuma:null,
            },
            ...
          ]
        */
       
        oglasi_korpa:[],  //nalaze se samo oglasi zarad prikaza u korpi i manipulaciju njima
        rezervacije:[],
        poruke:[],
      }
    },
    methods:{
      //metoda koja sluzi da proveri da li za svaki od oglasa postoji bar jos neki oglas (a da to nije on) u korpi koji pripada istom agentu
      //Ako ima prikazuje se dugme bundle za posmatrani oglas...
      isBundle:function(oglas){
        for(let i = 0; i < this.oglasi_korpa.length; i ++){
          if(oglas.agentId === this.oglasi_korpa[i].agentId && oglas.id != this.oglasi_korpa[i].id){
            return true;
          }
        }
        return false;
      },
    //REMOVE Logika
      removeAds:function(id){
        if (confirm('Da li ste sigurni da želite ukloniti ovu rezervaciju?')) { 
          this.korpa = this.removeItem(this.korpa, id);
  
          localStorage.setItem('cart', JSON.stringify(this.korpa));
        }
      },
      //Pomocna metoda koja se poziva iz metode removeAds
      //Sluzi za proveru da li je neki oglas u nekom nizu
      //Ako jeste brise se iz niza i vraca se niz...
      removeItem(korpa, oglasId) {
        console.log('Usao u removeItem');
        for(let i = 0; i< korpa.length; i ++){
          if(korpa[i].oglasId == oglasId){
            console.log('Obrisano: ' + korpa.splice(i, 1));
            this.removeVisually(oglasId);
          }
        }
        return korpa;
      },
      //Pomocna metoda koja se poziva iz metode  removeItem
      //Sluzi da u slucaju kada se brise iz korpe neki element
      //se on obirise i vizuelno uklanjanjem tog oglasa iz oglas_korpa
      removeVisually(oglasId){
        console.log('Usao u removeVisually!');
          for(let i = 0; i< this.oglasi_korpa.length; i ++){
            if(this.oglasi_korpa[i].id == oglasId){
              console.log('sadadasdsadasdsa');
              this.oglasi_korpa.splice(i, 1);
              this.total = 0;
              for(let i = 0; i < this.oglasi_korpa.length; i++){

                this.countTotalPrice(this.oglasi_korpa[i]);
              }
            }
          }
      },
    //<--remove

    //ADD LOGIKA
      //Metoda koja sluzi za kreiranje rezervacija i njihovo slanje na bek
      makeReseravation:function(id){
        let bundle = false;
        for(let i = 0; i < this.oglasi_korpa.length; i ++){
          //Ako ima bilo koja 2 da su u bundleu onda se postavlja pitanje...
          if(this.isBundle(this.oglasi_korpa[i]) == true){
            bundle = true;
          }
        }
        if(bundle == true){
          //Slucaj ako postoji bundle i on ga prihvati
          if (confirm('Postoje narudzbenice od istog vlasnika da li želite da ih smestite u bundle?')) {
            console.log('Prihvatio bundle!');
           
              let singleReserv = this.putInBundle();
              if(singleReserv.length > 0){
                console.log(`SingleReserv.length: ${singleReserv.length}`);
                for(let i = 0; i < singleReserv.length; i ++){
                  this.createSingleReservation(singleReserv[i]);
                }
              }
              
              //saljem zahtev na bek
              console.log('BUNDLE REZERVACIJA PRIHVATIO!');
          }
          //Slucaj ako postoji bundle i on ga odbije
          else{
            console.log('Odustao od bundla ponasa se kao slucaj kada su svi odvojeni!');
            for(let i = 0; i < this.oglasi_korpa.length; i ++){
              this.createSingleReservation(this.oglasi_korpa[i])
            }
              //saljem zahtev na bek
              console.log('BUNDLE REZERVACIJA NIJE PRIHVATIO!');
          }
        }
        //Slucaj kada ne postoje narudzbenice za bundle
        else{
          console.log('Usao u slucaj kada su svi odvojeni!');
          for(let i = 0; i < this.oglasi_korpa.length; i ++){
            this.createSingleReservation(this.oglasi_korpa[i])
          }
          console.log('NIJE BUNDLE REZERVACIJA! ');
        }
            //saljem zahtev na bek

          console.log(JSON.stringify(this.rezervacije));
          UserDataService.addRezervacija(this.rezervacije).then(respnse => {
            alert('Vaša rezervacija je uspešno poslata!');
            this.$$router.push("/cars");
          });
      },

      //Metoda koja sluzi za kreiranje rezervacije sa samo jednom narudzbenicom...
      createSingleReservation:function(oglas){
        for(let i = 0; i < this.korpa.length; i++){
          if(oglas.id == this.korpa[i].oglasId){
            const narudzbenica = this.korpa[i];
            console.log(`Usao u createSingleReservation za ${narudzbenica.oglasId}!`);
            const rezervacijaOglasDTO = {
            //rezervacija
              ukupnaCena: 0,
              statusRezervacije:'PENDING',
              username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
              bundle:false,
              poruka:'',
              
              narudzbenice:[{ //u singleReserv je samo 1 narudzbenica
              //Narudzbenica
                oglasId:oglas.id,                   
                odDatuma:narudzbenica.odDatuma,
                doDatuma:narudzbenica.doDatuma,
                agentId:oglas.agentId, // ili samo username pa na beku id da dodelimo...
              }]
              //userId:null //Ili Ime i prezime onoga za koga se rezervise da li treba???
              //Na beku se dodaje:
              //commonDataId: u oba
              //NarudzbenicaId: u rezervaciju
            }
            //Racunanje ukupne cene sa popustom
            const odabran_br_dana = this.calculateNoOfDays(narudzbenica.odDatuma, narudzbenica.doDatuma);
            rezervacijaOglasDTO.ukupnaCena += this.calculatePrice(oglas.cenovnik.cenaPoDanu, oglas.cenovnik.popustZaPreko30Dana, odabran_br_dana);
            
            this.rezervacije.push(rezervacijaOglasDTO);
            localStorage.setItem('reserv', JSON.stringify(this.rezervacije));
          }
        }
      },
      //Metoda koja sluzi za kreiranje rezervacije nizom narudzbenica...
      createBundleReservation:function(bundle){
        console.log('Usao u createBundleReservation!');
        console.log('bundle.length: ' + bundle.length);
        let narudzbenice = [];
        let ukupnaCena = 0;
        for(let i = 0; i< bundle.length; i++ ){
          for(let j = 0; j < this.korpa.length; j++ ){
            if(bundle[i].id == this.korpa[j].oglasId){
              console.log(`Isti za ${bundle[i].id} i ${this.korpa[j].oglasId}`);
              const oglas = bundle[i];
              const narudzbenica = this.korpa[j];
              //Narudzbenica
              const nar = {
                oglasId:oglas.id,                   
                odDatuma:narudzbenica.odDatuma,
                doDatuma:narudzbenica.doDatuma,
                agentId:oglas.agentId, // ili samo username pa na beku id da dodelimo...
                //userId:null //Ili Ime i prezime onoga za koga se rezervise da li treba???
              }
              // ukupnaCena += oglas.cenovnik.cenaPoDanu * this.calculateNoOfDays(narudzbenica.odDatuma,narudzbenica.doDatuma);
              //Racunanje ukupne cene sa popustom
              const odabran_br_dana = this.calculateNoOfDays(narudzbenica.odDatuma, narudzbenica.doDatuma);
              ukupnaCena += this.calculatePrice(oglas.cenovnik.cenaPoDanu, oglas.cenovnik.popustZaPreko30Dana, odabran_br_dana);
              narudzbenice.push(nar);
            }
          }
        }
        const rezervacijaOglasDTO = {
        //rezervacija
          ukupnaCena: ukupnaCena,
          statusRezervacije:'PENDING',
          username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
          bundle:true,
          poruka:'',
          narudzbenice:narudzbenice, //u bundleReserv je array narudzbenica...
        }
        this.rezervacije.push(rezervacijaOglasDTO);
        localStorage.setItem('reserv', JSON.stringify(this.rezervacije));
      },
    
      //Metoda koja sluzi da razvrsta oglase na one koji su u nekom bundle i one koji su sami.
      //Za jedan oglas pronadje sve ostale od istog agenta i smesti ih u bundl...
      //Metoda vraca niz oglasa koji nisu u bundlu kako bi se za njih napravile posebne rezerv.
      putInBundle:function(){
        console.log('U putInBundle je!')
        let singleAds = [];
        let oglas_korpa = this.oglasi_korpa;// 1,2,3,4 i 
        let allBundles = [];
        for(let i = 0; i < oglas_korpa.length-1; i ++){
          if (this.isInBundle(allBundles, oglas_korpa[i]) == true){
            continue;
          }
          var bundle = [];
          bundle.push(oglas_korpa[i]);
          for(let j = i+1; j < oglas_korpa.length; j ++){
            //Da se ne bi proveravalo kasnije ponovo i za 1 i 4 i za 4 i 1...
            //Izbacujemo 1,4 iz drugog niza i kasnije dodeljujemo taj drugi niz prvom nizu kako bi smo 
            //Izbegli redudantnost podataka...
            if (this.isInBundle(allBundles, oglas_korpa[j]) == true){
              continue;
            }
            //Ako se nadju 2 oglasa sa istim id-jem agenta dodaju se u bundle
            //Racuna se i kada naidje na samog sebe, zato je kasnija provera if(bundle.length==1);
            if(oglas_korpa[i].agentId == oglas_korpa[j].agentId) {
              bundle.push(oglas_korpa[j]);
              allBundles.push(oglas_korpa[j]);
            }
            
          }            
          //Ako nije dodato vise oglasa nego samo jedan kada se oglas sam sa sobom podudari
          //za njega treba praviti poseban oglas, a ne bundle...
          if(bundle.length == 1){
            console.log(`SASASSAASASSAASSASA: ${oglas_korpa[i].oglasId}`);
            singleAds.push(oglas_korpa[i]);
          }
          else{
            allBundles.push(oglas_korpa[i]);
            this.createBundleReservation(bundle);
          }
          
        }
        if(this.isInBundle(allBundles, oglas_korpa[oglas_korpa.length-1]) == false){
          console.log(`RATATATATATATAT: ${oglas_korpa[oglas_korpa.length-1].oglasId}`);
          singleAds.push(oglas_korpa[oglas_korpa.length-1]);
        }
        console.log(`singleAds: ${singleAds.length}`);
        return singleAds;
      },

      //Pomocna metoda koja se poziva iz metode putInBundle
      //Sluzi za proveru da li je neki oglas vec u bundlu
      //Ako jeste vraca se true, ako nije false
      isInBundle(arr, value) {
        console.log('Usao u isInBundle');
        var index = arr.indexOf(value);
        if (index > -1) {
          return true;
        }
        return false;
      },
    //<--add

    //BRISANJE, POVRATAK, DETALJI
      //Metoda koja sluzi za prekid rezervacije i brisanje sadrzaja korpe iz localStorage 
      cancelReservation:function(){
        if (confirm('Da li ste sigurni da želite odustati? Vaša korpa će biti prazna!')) {
          localStorage.removeItem('cart');
          this.$router.push(`/cars`);
        }
      },
      goBack:function(){
        this.$router.push(`/cars`);
      },

      showDetails:function(id){
        this.$router.push(`/shoppingCart/reservation/${id}/details`);
      },
    //<--Del,back,detail

    //POMOCNE METODE ZA DINAMICKU KALKULACIJU 
      //Pomocna metoda za racunanje broja dana na osnovu pocetnog i krajnjeg datuma u narudzbenici...
      calculateNoOfDays(odDatuma,doDatuma){
        //Konvertovanje datuma u broj dana... 
        const odDat = new Date(odDatuma);       //konvertujemo input tip u Date
        const doDat = new Date(doDatuma);       //konvertujemo input tip u Date
        const NoOfDays = doDat - odDat;         //Dobijeni rezultat je u milisekundama
        const noOFMill = 1000 * 60 * 60 * 24;   //broj milisekundi sa kojima delimo NoOfDays da se dobije broj dana.
        
        console.log(`Broj dana: ${NoOfDays/noOFMill}`);
        return NoOfDays/noOFMill;
      },
      //Metoda za automatsko racunanje cene rezervacija spram cene apartmana * broj nocenja
      calculatePrice: function (cenaPoDanu, popustZaPreko30Dana, odabran_br_dana) {
        console.log('Odabran_br_dana: ' + odabran_br_dana);
        let popust = 0;
        let ukupnaCena = odabran_br_dana * cenaPoDanu;
        console.log('Cena bez pop: ' + ukupnaCena);
        if(odabran_br_dana > 30){
            
          if(popustZaPreko30Dana != null){
              popust =  ukupnaCena * (popustZaPreko30Dana/100);
              console.log('Popust: ' + popust);
          }
          //Ukoliko korisnik odabere neki cenovnik koji ima popust, a zatim odabere cenovnik koji nema popust
          //ostaje upamcen popust prethodnog cenovnika... Zato se resetuje na 0;
          if(popustZaPreko30Dana === null && popust !== 0){
              popust = 0;
          }
          ukupnaCena = ukupnaCena -  popust;
          console.log('Cena sa pop: ' + ukupnaCena);
            
        }
        return ukupnaCena;
      },
      countTotalPrice:function(oglasi_korpa){
        console.log("LENGTH: " + JSON.stringify(oglasi_korpa));
        // for(let i = 0; i< oglasi_korpa.length; i++ ){
          for(let j = 0; j < this.korpa.length; j++ ){
            if(oglasi_korpa.id == this.korpa[j].oglasId){
              console.log(`Nasli se u ${oglasi_korpa.id} i ${this.korpa[j].oglasId}`);
              const odabran_br_dana = this.calculateNoOfDays(this.korpa[j].odDatuma , this.korpa[j].doDatuma);
              this.total += this.calculatePrice(oglasi_korpa.cenovnik.cenaPoDanu, oglasi_korpa.cenovnik.popustZaPreko30Dana, odabran_br_dana);
              continue;
            }
          }
        // }
      },
      /* countNewTotalPrice:function() {
          //Preuzimanje objekta korpa iz localStorage
          this.korpa = JSON.parse(localStorage.getItem('cart'));
          for(let i = 0; i < this.korpa.length; i++){
          //Traze se svi oglasi iz korpe preko id-ja kako bi se smestili u odabraniOglasi 
          //i prikazali njihovi podacu i slike vizuelno u korpi...
          UserDataService.getOglasDetails(this.korpa[i].oglasId).then(response => {
            this.oglasi_korpa = [];
            this.oglasi_korpa.push(response.data);  
            this.countTotalPrice(response.data);
          });
        }
      }*/ 
    //<--calc
    },
      components: {
        "star-rating": StarRating,
    },
    created(){
      if(JSON.parse(localStorage.getItem('token')) == null){
          this.$router.push(`/login`);
      }
      else{

        if(JSON.parse(localStorage.getItem('cart'))== null){
          this.korpa = [];
        }
        else {
          // Preuzimanje objekta korpa iz localStorage
          this.korpa = JSON.parse(localStorage.getItem('cart'));
          for(let i = 0; i < this.korpa.length; i++){
            //Traze se svi oglasi iz korpe preko id-ja kako bi se smestili u odabraniOglasi 
            //i prikazali njihovi podacu i slike vizuelno u korpi...
            UserDataService.getOglasDetails(this.korpa[i].oglasId).then(response => {
              this.oglasi_korpa.push(response.data);  
              this.countTotalPrice(response.data);
            });
          }
        }
        // this.countTotalPrice(this.oglasi_korpa);
      }
      
    },
  }
</script>

<style>
#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}
#cart{
  position: relative;
}
.cart-total{
  padding:10px;
  margin-bottom:15px;
  margin-top:35px;
  background-color:#35424a;
  color:#fff;
  font-size: 16px;
  font-weight: bold;
  border-bottom:2px solid #FF8C00;
}
#overview-img{
  width: 253px;
  height: 150px;
}
#buttons{
  display: inline;
}
#page-title{
  position: relative;
}
#back_button{
  position: absolute;
  right:35px;
  top:5px;
}
.isBundle{
  /* border: 1px solid red; */
  color:#fff;
  background-color:red;
  padding:10px;
  margin:8px;
  border-radius:25px;
  text-align: center;
}
</style>