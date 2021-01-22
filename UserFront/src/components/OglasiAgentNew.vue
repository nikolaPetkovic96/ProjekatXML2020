<template>
  <div id="ads-new">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Dodaj <span id='titleEffect'>Oglas</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div id='main' class='container'>
            <div id='carInfo'>
              <div class="card-header">
                <h4><b class='effect-col'>Automobil:</b> {{automobil.markaAut}} {{automobil.modelAut}} (marka/model)</h4>
                <h4><b class='effect-col'>Klasa automobila:</b> {{automobil.klasaAut}}</h4>
                <h5><b class='effect-col'>Ocena:</b> {{automobil.ukupnaOcena}}</h5>
                <h5><b class='effect-col'>Predjena kilometraža:</b> {{automobil.predjenaKilometraza}} km</h5>
              </div>
            </div>
            <div style="margin-top:20px" v-if='messages.errorDates' class="alert alert-danger" v-html="messages.errorDates"></div>
            <div class="row">
              <div class="col">
                <label for="">Od datuma</label>
                <vuejsDatepicker placeholder="Select Checkin Date" v-model="dates.from" :highlighted="dates"
                  :disabled-dates="disabledDates">
                </vuejsDatepicker>
              </div>
              <div class="col">
                <label for="">Do datuma</label>
                <vuejsDatepicker placeholder="Select Checkout Date" v-model="dates.to" :highlighted="dates"
                  :disabled-dates="disabledDates">
                </vuejsDatepicker>
              </div>
            </div>
            <div style="margin-top:20px" v-if='messages.errorPrice' class="alert alert-danger" v-html="messages.errorPrice"></div>
            <div id='cenovnik'>
              <label>Cenovnik:</label>
              <select style="padding:7px; margin-right: 10px" id='prices' v-model="odabran_cenovnik.nazivCenovnika">
                <option disabled value="">Cenovnici</option>
                <option v-on:click="addChoosenPrice()" v-bind:key="cenovnik.id" v-for='cenovnik in cenovnici'>{{cenovnik.nazivCenovnika}}</option>
              </select>
        
              <table v-if='odabran_cenovnik.nazivCenovnika !== ""' id='showPriceTable'>
                  <thead>
                    <tr><b>Cenovnik sadrzi:</b></tr>
                    <tr>
                      <th>Naziv cenovnika</th>
                      <th></th>
                      <th>Cena po danu</th>
                      <th>Cena po kilometru</th>
                      <th>CDW</th>
                      <th></th>
                      <th>Popust preko 30 dana</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>{{odabran_cenovnik.nazivCenovnika}}</td>
                      <td></td>
                      <td>{{odabran_cenovnik.cenaPoDanu}} din</td>
                      <td>{{odabran_cenovnik.cenaPoKilometru}} din</td>
                      <td>{{odabran_cenovnik.cenaCollisionDamageWaiver}} din</td>
                      <td></td>
                      <td>{{odabran_cenovnik.popustZaPreko30Dana}} %</td>
                    </tr>     
                  </tbody>            
              </table>
            </div>          
          
            <div style="margin-top:20px" v-if='messages.errorPlannedCm' class="alert alert-danger" v-html="messages.errorPlannedCm"></div>
            <label for="">Planirana kilometraža</label>
            <p><i>(Ukoliko dati oglas nema planiranu kilometražu unesite vrednost 0)</i></p>
            <input class='half-size' type="text" placeholder="Unestie kilometrazu" v-model='noviOglas.planiranaKilometraza'>
           
            <div style="margin-top:20px" v-if='messages.errorAddress' class="alert alert-danger" v-html="messages.errorAddress"></div>
            <label>Adresa</label>
            <div>
              <input class="one-forth" placeholder="Unesite mesto..." v-model='noviOglas.adresa.mesto'>
              <input class="one-forth" placeholder="Unesite ulicu..." v-model='noviOglas.adresa.ulica'>
              <input class="one-forth" placeholder="Unesite broj..." v-model='noviOglas.adresa.broj'>
              <input class="one-forth" placeholder="Unesite postanski broj..." v-model='noviOglas.adresa.postanskiBroj'>
			      </div>
             <div style="margin-top:20px" v-if='messages.errorDates2' class="alert alert-danger" v-html="messages.errorDates2"></div>
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
            <button :disabled='btnEnabled' class='btn btn-success shadow' v-on:click='newAd()'>Potvrdi</button>
            <button :disabled='btnEnabled' class='btn btn-danger shadow' v-on:click='cancelNew()'>Odustani</button>
        </div>
  </div>
</template>

<script>
import Datepicker from 'vuejs-datepicker'
import UserDataService from '../services/UserDataService'
export default {
    name: 'Ads-new',
    data:function(){
        return {
          permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
          },
          btnEnabled:false,
          noviOglas:{
            odDatuma:null,
            doDatuma:null,
            planiranaKilometraza:'',
            automobilId:null,
            cenovnikId:null,
            adresa:{
              mesto:'',
              ulica:'',
              broj:'',
              postanskiBroj:'',
            }
          },

          //Za prikaz podataka o automobilu
          automobil:{},

          //lista svih cenovnika;
          cenovnici:[],

          //Za prikaz podataka o cenovniku
          odabran_cenovnik:{
            id:null,
            cenaPoDanu:null,
            nazivCenovnika:'',
            popustZaPreko30Dana:null,
            cenaCollisionDamageWaiver:null,
            cenaPoKilometru:null
          },

          messages: {
            errorAddress: '',
            errorPrice: '',
            errorPlannedCm: '',
            errorDates: '',
            errorDates2: '',
            errorResponse: '',
            successResponse: '',
			    },

          dates: {
            from: null,
            to: null
          },

          disabledDates: {
            to: null
          },
          
        }
    },
    methods:{
      getAutomobil:function(){
        UserDataService.getAutomobil(this.id).then(response => {
          this.automobil = response.data;
        });
      },
      getAllPrices:function(){
        UserDataService.getAllCenovnik().then(response => {
          this.cenovnici = response.data;
        });
      },
      getAllPermissions:function(){
            UserDataService.getAllPermissions().then(response => {
                this.permissions = response.data;
                if(this.permissions.status != "aktivan"){
                    this.btnEnabled = true
                }
                console.log(JSON.stringify(this.permissions));
            });
        },
      newAd:function(){
        if (this.dates.from == null) {
          this.messages.errorDates = `<h4>Morate odabrati početni termin oglasa!</h4>`;
          setTimeout(() => this.messages.errorDates = '', 5000);
			  }
        else if (this.dates.to == null) {
          this.messages.errorDates = `<h4>Morate odabrati krajnji termin oglasa!</h4>`;
          setTimeout(() => this.messages.errorDates = '', 5000);
        }
        else if (this.dates.from > this.dates.to) {
          this.messages.errorDates2 = `<h4>Krajnji termin mora biti veći od početnog!</h4>`;
          setTimeout(() => this.messages.errorDates2 = '', 5000);
        }
        else if (this.odabran_cenovnik.id == null) {
          this.messages.errorPrice = `<h4>Morate odabrati cenovnik za oglas!</h4>`;
          setTimeout(() => this.messages.errorPrice = '', 5000);
        }
        else if (this.noviOglas.planiranaKilometraza == '') {
          this.messages.errorPlannedCm = `<h4>Morate uneti planiranu kilometražu! </h4>`;
          setTimeout(() => this.messages.errorPlannedCm = '', 5000);
        }
        //Provera da li je planirana km broj
        else if (this.isNumeric(this.noviOglas.planiranaKilometraza)) {
          this.messages.errorPlannedCm = `<h4>Planirana kilometraža mora biti broj!</h4>`;
          setTimeout(() => this.messages.errorPlannedCm = '', 5000);
        }
        //Apartment address
        else if (this.noviOglas.adresa.mesto == '') {
          this.messages.errorAddress = `<h4>Polje mesto adrese ne sme biti prazno!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else if (this.noviOglas.adresa.ulica == '') {
          this.messages.errorAddress = `<h4>Polje ulica adrese ne sme biti prazno!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else if (this.noviOglas.adresa.broj == '') {
          this.messages.errorAddress = `<h4>Polje broj adrese ne sme biti prazno!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else if (this.noviOglas.adresa.postanskiBroj == '') {
          this.messages.errorAddress = `<h4>Polje poštanski broj adrese ne sme biti prazno!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else if (this.isNumeric(this.noviOglas.adresa.postanskiBroj)) {
          this.messages.errorAddress = `<h4>Poštanski broj adrese mora biti broj!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else {
          this.noviOglas.cenovnikId = this.odabran_cenovnik.id
          // unselected dates will be disabled
          this.noviOglas.odDatuma = this.dates.from.getTime();
          this.noviOglas.doDatuma = this.dates.to.getTime();
          //Obrisati

          // console.log(`Novi oglas:${JSON.stringify(this.noviOglas)}`);
           
          UserDataService.addOglas(this.noviOglas).then(response => {
            alert('Vaš oglas je uspešno dodat!');
            this.$router.push('/carsAgent');
          }).catch(error  => {
            console.log(error.response.data)
            if (error.response.status === 500 && error.response.data === "Za odabrani termin vec postoji oglas!") {
                this.messages.errorResponse = `<h4>Došlo je do preklapanja oglasa! Molimo Vas odaberite drugi interval!</h4>`;
                setTimeout(() => this.messages.errorResponse = '', 5000);
            }
            else if (error.response.status === 500 || error.response.status === 404) {
                this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru,  molimo Vas pokusajte ponovo kasnije!</h4>`;
                setTimeout(() => this.messages.errorResponse = '', 5000);
            }
           
          });


        }
      },

      cancelNew:function(){
        this.$router.push('/cars');
      },

      addChoosenPrice:function(){
        for(let i = 0; i < this.cenovnici.length; i++){
          if(this.odabran_cenovnik.nazivCenovnika === this.cenovnici[i].nazivCenovnika){
            this.odabran_cenovnik.id = this.cenovnici[i].id;
            this.odabran_cenovnik.cenaPoDanu = this.cenovnici[i].cenaPoDanu;
            this.odabran_cenovnik.popustZaPreko30Dana = this.cenovnici[i].popustZaPreko30Dana;
            this.odabran_cenovnik.cenaCollisionDamageWaiver = this.cenovnici[i].cenaCollisionDamageWaiver;
            this.odabran_cenovnik.cenaPoKilometru = this.cenovnici[i].cenaPoKilometru;
          }
        }
      },
      isNumeric(num) {
        //isNaN(num) returns true if the variable does NOT contain a valid number
        return isNaN(num);
		  }
    },
    components: {
		  vuejsDatepicker:Datepicker,
    },
    computed:{
      id(){
        return this.$route.params.id; //preuzimam id automobila za koji zelim da napravim rezervaciju.
      }
    },
    created() {
      if(JSON.parse(localStorage.getItem('token')) == null){
          this.$router.push(`/login`);
      }else{
        this.getAllPermissions();
        this.getAllPrices();
        this.getAutomobil();
      }
    },
    mounted() {
      //Preuzet id automobila iz urla se smesta u oglas.
      this.noviOglas.automobilId = this.id;
      //Da se podesi da su dostupni termini od danasnjeg datuma ka buducnosti...
      let to = new Date();
      to.setDate(to.getDate() - 1);
      this.disabledDates.to = to;
    }
}
</script>

<style scoped>
#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}

#ads-new label {
  display: block;
  margin: 20px 0 10px;
  font-size: 20px;
  font-weight: bold;
}

#ads-new .half-size{
  width:49%;
  padding:10px;
  margin-bottom:25px
}

#ads-new .one-forth{
  width:24%;
  padding:10px;
  margin-bottom:25px
}

#ads-new label{
  color:#35424a;
  display: block;
  margin: 10px 0 10px;
  font-size: 20px;
  font-weight: bold;
}

#ads-new #location{
  width:100%;
  padding:10px;
  margin-bottom:25px
}

/* Za cenu */
#showPriceTable{
    color:crimson;
    margin-top:10px;
    border-bottom: 1px solid lightgrey;
} 

#showPriceTable thead{
    border-bottom: 1px solid lightgrey;
}

#showPriceTable thead th{
    padding-right:15px;
}

.effect-col{
  color:#35424a;
}

.radio-effect{
  margin-top:15px;
  margin-bottom:15px;
  font-size: 20px;
  color:#35424a;
}
</style>
