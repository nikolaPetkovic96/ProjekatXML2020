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
                      <th>Cena po danu</th>
                      <th>Cena po kilometru</th>
                      <th>CDW</th>
                      <th>Popust preko 30 dana</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>{{odabran_cenovnik.nazivCenovnika}}</td>
                      <td>{{odabran_cenovnik.cenaPoDanu}}</td>
                      <td>{{odabran_cenovnik.cenaPoKilometru}}</td>
                      <td>{{odabran_cenovnik.cenaCollisionDamageWaiver}}</td>
                      <td>{{odabran_cenovnik.popustZaPreko30Dana}}</td>
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
              <input class="one-forth" placeholder="Unesite mesto..." v-model='noviOglas.TAdresa.mesto'>
              <input class="one-forth" placeholder="Unesite ulicu..." v-model='noviOglas.TAdresa.ulica'>
              <input class="one-forth" placeholder="Unesite broj..." v-model='noviOglas.TAdresa.broj'>
              <input class="one-forth" placeholder="Unesite postanski broj..." v-model='noviOglas.TAdresa.postanskiBroj'>
			      </div>

            <!-- <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div> -->
            <button class='btn btn-success shadow' v-on:click='newAd()'>Potvrdi</button>
            <button class='btn btn-danger shadow' v-on:click='cancelNew()'>Odustani</button>
        </div>
  </div>
</template>

<script>
import Datepicker from 'vuejs-datepicker'
export default {
    name: 'Ads-new',
    data:function(){
        return {
          noviOglas:{
            odDatuma:null,
            doDatuma:null,
            // lokacija:'',
            planiranaKilometraza:'',
            automobilId:null,
            cenaId:null,
            TAdresa:{
              mesto:'',
              ulica:'',
              broj:'',
              postanskiBroj:'',
            }
          },

          //Za prikaz podataka o automobilu napraviti ovakav DTO na beku
          automobil:{
            id:'1',
            markaAut:'BMW',
            modelAut:'M5',
            klasaAut:'SUV',
            tipMenjaca:'automatik',
            vrstaGoriva:'dizel',
            ukupnaOcena:5, //ovo treba dodati u automobil
            brojSedistaZaDecu:3,
            predjenaKilometraza:500,
            collisionDamageWaiver: true,
          },

          //lista svih cenovnika koji se getuju prilikom kreiranja stranice;
          cenovnici:[
            {
              id:'1',
              cenaPoDanu:100,
              nazivCenovnika:'Cenovnik 1',
              popustZaPreko30Dana:'10%',
              cenaCollisionDamageWaiver:1000,
              cenaPoKilometru:10
            },
            {
              id:'2',
              cenaPoDanu:200,
              nazivCenovnika:'Cenovnik 2',
              popustZaPreko30Dana:'20%',
              cenaCollisionDamageWaiver:null,
              cenaPoKilometru:20
            },
            {
              id:'3',
              cenaPoDanu:300,
              nazivCenovnika:'Cenovnik 3',
              popustZaPreko30Dana:null,
              cenaCollisionDamageWaiver:3000,
              cenaPoKilometru:30
            },
            {
              id:'4',
              cenaPoDanu:400,
              nazivCenovnika:'Cenovnik 4',
              popustZaPreko30Dana:'20%',
              cenaCollisionDamageWaiver:null,
              cenaPoKilometru:40
            },
            {
              id:'5',
              cenaPoDanu:500,
              nazivCenovnika:'Cenovnik 5',
              popustZaPreko30Dana:null,
              cenaCollisionDamageWaiver:5000,
              cenaPoKilometru:50
            },
          ],

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
          this.messages.errorDates = `<h4>Krajnji termin mora biti veći od početnog!</h4>`;
          setTimeout(() => this.messages.errorDates = '', 5000);
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
        else if (this.noviOglas.TAdresa.mesto == '') {
          this.messages.errorAddress = `<h4>Polje mesto adrese ne sme biti prazno!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else if (this.noviOglas.TAdresa.ulica == '') {
          this.messages.errorAddress = `<h4>Polje ulica adrese ne sme biti prazno!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else if (this.noviOglas.TAdresa.broj == '') {
          this.messages.errorAddress = `<h4>Polje broj adrese ne sme biti prazno!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else if (this.noviOglas.TAdresa.postanskiBroj == '') {
          this.messages.errorAddress = `<h4>Polje poštanski broj adrese ne sme biti prazno!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
         else if (this.isNumeric(this.noviOglas.TAdresa.postanskiBroj)) {
          this.messages.errorAddress = `<h4>Poštanski broj adrese mora biti broj!</h4>`;
          setTimeout(() => this.messages.errorAddress = '', 5000);
        }
        else {
          this.noviOglas.cenaId = this.odabran_cenovnik.id
          // unselected dates will be disabled
          this.noviOglas.odDatuma = this.dates.from.getTime();
          this.noviOglas.doDatuma = this.dates.to.getTime();
          //Obrisati
          console.log(`Novi oglas:
            odDatuma: ${this.noviOglas.odDatuma},
            doDatuma: ${this.noviOglas.doDatuma},
            cenaId: ${this.noviOglas.cenaId},
            automobilId: ${this.noviOglas.automobilId},
            planiranaKilometraza: ${this.noviOglas.planiranaKilometraza},
            Adresa: ${this.noviOglas.TAdresa.mesto} ${this.noviOglas.TAdresa.ulica} ${this.noviOglas.TAdresa.broj} ${this.noviOglas.TAdresa.postanskiBroj},
          `);
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
  color:gold;
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
