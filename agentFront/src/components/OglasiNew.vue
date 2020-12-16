<template>
  <div id="ads-new">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Dodaj <span id='titleEffect'>Oglas</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div id='main' class='container'>
            <div id='carInfo'>
              <div class="card-header">
                  <h4><b>Automobil:</b> {{automobil.markaAut}} {{automobil.modelAut}} (marka/model)</h4>
                  <h4><b>Klasa automobila:</b> {{automobil.klasaAut}}</h4>
                  <h4><b>Ocena:</b> {{automobil.ukupnaOcena}}</h4>
              </div>
            </div>
            <label for="">Od datuma</label>
            <input type="date" v-model='noviOglas.odDatuma'>

            <label for="">Do datuma</label>
            <input type="date" v-model='noviOglas.doDatuma'>
       
            <!-- <div style="margin-top:20px" v-if='messages.errorDates' class="alert alert-danger" v-html="messages.errorDates"></div> -->
            <!-- <label>Dates available</label>
            <div class="row">
              <div class="col">
                <vuejsDatepicker placeholder="Select Checkin Date" v-model="dates.from" :highlighted="dates"
                  :disabled-dates="disabledDates">
                </vuejsDatepicker>
              </div>
              <div class="col">
                <vuejsDatepicker placeholder="Select Checkout Date" v-model="dates.to" :highlighted="dates"
                  :disabled-dates="disabledDates">
                </vuejsDatepicker>
              </div>
            </div> -->
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

            <label for="">Planirana kilometraza</label>
            <input class='half-size' type="text" placeholder="Unestie kilometrazu"
            v-model='noviOglas.planiranaKilometraza'>

            <!-- <div style="margin-top:20px" v-if='messages.errorLocation' class="alert alert-danger"
              v-html="messages.errorLocation"></div> -->
            <!-- <label>Lokacija</label> -->

            <!-- Ako imamo lokaciju kao atribut -->
            <!-- <label>Lokacija</label>
            <input type="text" placeholder="ulica/broj/mesto" class='location' v-model='noviOglas.lokacija'> -->
 
            <!-- Ako imamo lokaciju kao klasu TAdresa-->
            <label>Lokacija</label>
            <input class='half-size' type="text" placeholder="Unestie geograf. sirinu..."
              v-model='noviOglas.TAdresa.latitude'> -
            <input class='half-size' type="text" placeholder="Unesite geograf. duzinu..."
              v-model='noviOglas.TAdresa.longitude'>

            <!-- <div style="margin-top:20px" v-if='messages.errorAddress' class="alert alert-danger"
              v-html="messages.errorAddress"></div> -->
            <label>Adresa</label>
            <div>
              <input class="one-forth" placeholder="Unesite grad..." v-model='noviOglas.TAdresa.mesto'>
              <input class="one-forth" placeholder="Unesite ulicu..." v-model='noviOglas.TAdresa.ulica'>
              <input class="one-forth" placeholder="Unesite broj..." v-model='noviOglas.TAdresa.broj'>
              <input class="one-forth" placeholder="Unesite postanski broj..." v-model='noviOglas.TAdresa.postanskiBroj'>
			      </div>

            <button class='btn btn-success shadow'>Potvrdi</button>
            <button class='btn btn-danger shadow' v-on:click='cancelNew()'>Odustani</button>
        </div>
  </div>
</template>

<script>
export default {
    name: 'Ads-new',
    data:function(){
        return {
          noviOglas:{
            odDatuma:null,
            doDatuma:null,
            // lokacija:'',
            planiranaKilometraza:null,
            automobilId:null,
            cenaId:null,
            TAdresa:{
              mest:'',
              ulica:'',
              broj:'',
              postanskiBroj:'',
              longitude:'',
              latitude:'',
            }
          },

          //Za prikaz podataka o automobilu napraviti ovakav DTO na beku
          automobil:[
            {
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
            // {
            //   id:'2',
            //   markaAut:'Mercedes',
            //   modelAut:'R8',
            //   klasaAut:'Old Tajmer',
            //   tipMenjaca:'manuelni',
            //   vrstaGoriva:'gorivo',
            //   ukupnaOcena:4, //ovo treba dodati u automobil
            //   brojSedistaZaDecu:3,
            //   predjenaKilometraza:800,
            //   collisionDamageWaiver: true,
              
            // },
            // {
            //   id:'3',
            //   markaAut:'Audi',
            //   modelAut:'A6',
            //   klasaAut:'Gradski auto',
            //   tipMenjaca:'manuelni',
            //   vrstaGoriva:'evro-dizel',
            //   ukupnaOcena:5, //ovo treba dodati u automobil
            //   brojSedistaZaDecu:3,
            //   collisionDamageWaiver: true,
            //   predjenaKilometraza:650,
              
            // }
          ],

          //nije iskoristeno
          odabran_auto:{
            id:null,
            markaAut:'',
            modelAut:'',
            klasaAut:'',
            tipMenjaca:'',
            vrstaGoriva:'',
            predjenaKilometraza:null,
            brojSedistaZaDecu:null,
            collisionDamageWaiver:null,
            ukupnaOcena:null, //ovo treba dodati u automobil
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
      addChoosenPrice:function(){
        for(let i = 0; i < this.cenovnici.length; i++){
          console.log(this.cenovnici[i].nazivCenovnika);
          if(this.odabran_cenovnik.nazivCenovnika === this.cenovnici[i].nazivCenovnika){
              this.odabran_cenovnik.id = this.cenovnici[i].id;
              this.odabran_cenovnik.cenaPoDanu = this.cenovnici[i].cenaPoDanu;
              this.odabran_cenovnik.popustZaPreko30Dana = this.cenovnici[i].popustZaPreko30Dana;
              this.odabran_cenovnik.cenaCollisionDamageWaiver = this.cenovnici[i].cenaCollisionDamageWaiver;
              this.odabran_cenovnik.cenaPoKilometru = this.cenovnici[i].cenaPoKilometru;
              this.calculatePriceAndDate();
          }
        }
      },
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
</style>
