<template>
  <div id="car-new">
    <div class="container">
      <h1 style="margin-top: 10px; color: #35424a">Dodaj <span id="titleEffect">automobil</span></h1>
      <hr style="background: #35424a; height: 1px" />
    </div>

    <!-- Page Content -->
    <div class="container">
      <img src="../assets/showcase4.jpg" alt="" />
      <div style="margin-top: 20px" v-if="messages.errorMarka" class="alert alert-danger" v-html="messages.errorMarka"></div>
      <div style="margin-top: 20px" v-if="messages.errorModel" class="alert alert-danger" v-html="messages.errorModel"></div>
      <div style="margin-top: 20px" v-if="messages.errorKlasa" class="alert alert-danger" v-html="messages.errorKlasa"></div>
      <div style="margin-top: 20px" v-if="messages.errorMenjac" class="alert alert-danger" v-html="messages.errorMenjac"></div>
      <div style="margin-top: 20px" v-if="messages.errorGorivo" class="alert alert-danger" v-html="messages.errorGorivo"></div>
      <div style="margin-top: 20px" v-if="messages.errorBrojSedZaDec" class="alert alert-danger" v-html="messages.errorBrojSedZaDec"></div>
      <div style="margin-top: 20px" v-if="messages.errorCDW" class="alert alert-danger" v-html="messages.errorCDW"></div>
      <div style="margin-top: 20px" v-if="messages.errorImg" class="alert alert-danger" v-html="messages.errorImg"></div>
      <div class="row">
        <!-- Cars -->
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-0">
            <label>Marka automobila</label>
            <select v-model="odabranaKompon.markaAutomobila" v-on:change="addChoosenMarka($event)">
              <option disabled value="">Marka</option>
              <option v-bind:key="marka.id" :value="marka.id" v-for="marka in markaAut">
                {{ marka.nazivMarke }}
              </option>
            </select>
          </div>
        </div>

        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-0">
            <label>Model automobila</label>
            <select v-on:change="addChoosenModel($event)" v-model="odabranaKompon.modelAutomobila">
              <option disabled value="">Model</option>
              <option style="padding-bottom: 5px" :value="model.id" v-bind:key="model.id" v-for="model in modelAutFilt">
                {{ model.nazivModela }}
              </option>
            </select>
            <small v-if="modelAutFilt.length == 0" style="color: red">* prvo odaberite marku</small>
          </div>
        </div>

        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-0">
            <label>Klasa automobila</label>
            <select v-model="odabranaKompon.klasaAutomobila" v-on:change="addChoosenKlasa($event)" >
              <option disabled value="">Klasa</option>
              <option v-bind:key="klasa.id" :value="klasa.id" v-for="klasa in klasaAut">
                {{ klasa.nazivKlase }}
              </option>
            </select>
          </div>
        </div>

        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-0">
            <label>Tip menjaca</label>
            <select v-model="odabranaKompon.tipMenjaca" v-on:change="addChoosenMenjac($event)">
              <option disabled value="">Tip menjaca</option>
              <option v-bind:key="menjac.id" :value="menjac.id" v-for="menjac in tipMenjaca">
                {{ menjac.nazivMenjaca }}
              </option>
            </select>
          </div>
        </div>

        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-0">
            <label>Vrsta goriva</label>
            <select v-model="odabranaKompon.tipGoriva" v-on:change="addChoosenGorivo($event)">
              <option disabled value="">Vrsta goriva</option>
              <option v-bind:key="gorivo.id" :value="gorivo.id" v-for="gorivo in tipGoriva">
                {{ gorivo.nazivTipa }}
              </option>
            </select>
          </div>
        </div>

        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-0">
            <label>Decija sedista</label>
            <select v-model="AutomobilNew.brojSedistaZaDecu">
              <option disabled value="">Br. sed. za decu</option>
              <option v-bind:key="bszd" v-for="bszd in brojSedZaDec">
                {{ bszd }}
              </option>
            </select>
          </div>
        </div>

        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-0">
            <span>
              <label>Coll Ddmg Waiver</label>
              <input type="radio" required value="true" v-model="AutomobilNew.collisionDamageWaiver"/>True
              <input type="radio" required value="false" v-model="AutomobilNew.collisionDamageWaiver"/> False
            </span>
          </div>
        </div>
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-0">
            <span>
              <label>Images</label>
              <input type="file" name="file" class="filestyle" multiple @change="uploadImage"/>
            </span>
            <small style="color: red">* Odaberite jednu po jednu sliku</small>
            <p style="color:#35424a;"><b>Broj slika:</b> {{AutomobilNew.slikeVozila.length}}</p>
          </div>
        </div>
        <br />
      </div>
      <div v-if="messages.errorResponse" class="alert alert-danger" v-html="messages.errorResponse"></div>
      <div v-if="messages.successResponse" class="alert alert-success" v-html="messages.successResponse"></div>
      <button class="btn btn-success shadow" v-on:click="addCar()">Potvrdi</button>
      <button class="btn btn-danger shadow" v-on:click="closeNew()">Odustani</button>
      <br/>
    </div>
    <!--container-->
  </div>
  <!--Automobil-new-->
</template>

<script>
import UserDataService from "../services/UserDataService";
export default {
  name: "Car-new",
  data: function () {
    return {
      markaAut: [],
      modelAut: [],
      modelAutFilt: [], //filtrirani prikaz modela spram odabrane marke
      klasaAut: [],
      tipGoriva: [],
      tipMenjaca: [],
      brojSedZaDec: null,

      //Na kraju ni ne treba
      odabranaKompon: {
        markaAutomobila: null,
        modelAutomobila: null,
        klasaAutomobila: null,
        tipGoriva: null,
        tipMenjaca: null,
      },

      messages: {
        errorMarka: "",
        errorModel: "",
        errorKlasa: "",
        errorGorivo: "",
        errorMenjac: "",
        errorBrojSedZaDec: "",
        errorCDW: "",
        errorImg: "",
        errorResponse: "",
        successResponse: "",
      },

      AutomobilNew: {
        markaAutomobilaId: null,
        modelAutomobilaId: null,
        klasaAutomobilaId: null,
        tipGorivaId: null,
        tipMenjacaId: null,
        ukupnaOcena: 0,
        predjenaKilometraza: 0,
        collisionDamageWaiver: null,
        brojSedistaZaDecu: null,
        slikeVozila: [],
      },
    };
  },
  methods: {
    addChoosenMarka: function (event) {
      console.log(event);
      const id = event.target.value;
      this.AutomobilNew.markaAutomobilaId = id;
      this.modelAutFilt = [];
      for (let i = 0; i < this.modelAut.length; i++) {
        if (this.modelAut[i].markaAutomobilaId == id) {
          this.modelAutFilt.push(this.modelAut[i]);
        }
      }
    },
    addChoosenModel: function (event) {
      const id = event.target.value;
      this.AutomobilNew.modelAutomobilaId = id;
    },
    addChoosenKlasa: function (event) {
      const id = event.target.value;
      this.AutomobilNew.klasaAutomobilaId = id;
    },
    addChoosenMenjac: function (event) {
      const id = event.target.value;
      this.AutomobilNew.tipMenjacaId = id;
    },
    addChoosenGorivo: function (event) {
      const id = event.target.value;
      this.AutomobilNew.tipGorivaId = id;
    },

    getAllOptions: function () {
      UserDataService.getAllMarkaAut().then((response) => {
        this.markaAut = response.data;
      });
      UserDataService.getAllModelAut().then((response) => {
        this.modelAut = response.data;
        console.log(JSON.stringify(this.modelAut));
      });
      UserDataService.getAllKlasaAut().then((response) => {
        this.klasaAut = response.data;
      });
      UserDataService.getAllTipMenjaca().then((response) => {
        this.tipMenjaca = response.data;
      });
      UserDataService.getAllTipGoriva().then((response) => {
        this.tipGoriva = response.data;
      });
    },
    addCar: function () {
      if (this.AutomobilNew.markaAutomobilaId == null) {
      	this.messages.errorMarka = `<h4>Polje marka automobila ne moze biti prazno!</h4>`;
      	setTimeout(() => this.messages.errorMarka = '', 3000);
      }
      else if (this.AutomobilNew.modelAutomobilaId == null) {
      	this.messages.errorModel = `<h4>Polje model automobila ne moze biti prazno!</h4>`;
      	setTimeout(() => this.messages.errorModel = '', 3000);
      }
      else if (this.AutomobilNew.klasaAutomobilaId == null) {
      	this.messages.errorKlasa= `<h4>Polje klasa automobila ne moze biti prazno!</h4>`;
      	setTimeout(() => this.messages.errorKlasa = '', 3000);
      }
      else if (this.AutomobilNew.tipMenjacaId == null) {
      	this.messages.errorMenjac = `<h4>Polje tip menjaca ne moze biti prazno!</h4>`;
      	setTimeout(() => this.messages.errorMenjac = '', 3000);
      }
      else if (this.AutomobilNew.tipGorivaId == null) {
      	this.messages.errorGorivo = `<h4>Polje vrsta goriva ne moze biti prazno!</h4>`;
      	setTimeout(() => this.messages.errorGorivo = '', 3000);
      }
      else if (this.AutomobilNew.brojSedistaZaDecu == null) {
      	this.messages.errorBrojSedZaDec = `<h4>Polje broj sedista za decu ne moze biti prazno!</h4>`;
      	setTimeout(() => this.messages.errorBrojSedZaDec = '', 3000);
      }
      else if (this.AutomobilNew.collisionDamageWaiver == null) {
      	this.messages.errorCDW = `<h4>Polje Collision Damage Waiver automobila ne moze biti prazno!</h4>`;
      	setTimeout(() => this.messages.errorCDW = '', 3000);
      }
      else if (this.AutomobilNew.slikeVozila.length == 0) {
      	this.messages.errorImg = `<h4>Morate odabrati sliku/slike automobila!</h4>`;
      	setTimeout(() => this.messages.errorImg = '', 3000);
      }
      else {
      console.log(`Automobil: ${JSON.stringify(this.AutomobilNew)}`);
      UserDataService
        .addAutomobil(this.AutomobilNew)
        .then((response) => {
          alert("Vaš automobil je uspešno dodat!");
          this.$router.push("/carsAgent");
        })
        .catch((error) => {
          if (error.response.status === 500 || error.response.status === 404) {
            this.messages.errorResponse = `<h4>Imali smo nekih problema na serveru, molimo Vas pokusajte ponovo kasnije!</h4>`;
            setTimeout(() => (this.messages.errorResponse = ""), 5000);
          }
        });
      }
    },

    closeNew: function () {
      if (confirm("Da li ste sigurni da želite odustati?")) {
        this.$router.push("/carsAgent");
      }
    },

    uploadImage: function (e) {
      console.log("Usao u ");
      // this.AutomobilNew.slikeVozila = [];
      const reader = new FileReader();
      let images = e.target.files;
      console.log(images);
      for (let i = 0; i < images.length; i++) {
        reader.readAsDataURL(images[i]);
        reader.onload = () => {
          this.AutomobilNew.slikeVozila.push(reader.result);
          console.log("this.AutomobilNew.slikeVozila: ",this.AutomobilNew.slikeVozila);
        };
      }
    },

    // pomocna metoda za ogranicen odabir broja sedista za decu:
    range(start = 1, end) {
      var ans = [];
      for (let i = start; i <= end; i++) {
        ans.push(i);
      }
      return ans;
    },
  },
  created() {
    if(JSON.parse(localStorage.getItem('token')) == null){
        this.$router.push(`/login`);
    }else{
      //prilikom kreiranja stranice opcija za broj sedista za decu se postavi na od 1 - 5;
      this.brojSedZaDec = this.range(0, 5);
      this.getAllOptions();
    }
  },
};
</script>

<style scoped>
#titleEffect {
  color: gold;
  font-weight: bold;
}

#car-new label {
  color: #35424a;
  display: block;
  margin: 20px 0 10px;
  font-size: 20px;
  font-weight: bold;
}
</style>