<template>
  <div id="car-details">
    <div class="container" id="page-title">
      <h1 style="margin-top: 10px; color: #35424a">
        Detalji o <span id="titleEffect">Automobilu</span>
      </h1>
      <hr style="background: #35424a; height: 1px" />
    </div>

    <div id="test3" class="container">
      <div class="col-lg-12">
        <div id="slidebar">
          <header class="container">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
              </ol>
              <div class="carousel-inner" role="listbox">
                <!-- Slide One - Set the background image for this slide in the line below  "{background-image:  'url(' + getImgUrl() + ')}"-->
                <div
                  class="carousel-item active"
                  :style="{ 'background-image':'url(' + this.automobil.images[0] + ')' }">
                </div>
                <!-- Slide Two - Set the background image for this slide in the line below -->
                <div class=" carousel-item" v-bind:key="img" v-for="img in getOtherImgs" 
                    :style="{ 'background-image': 'url(' + img + ')' }">
                </div>
              </div>
              <a v-show="isOtherImgs" class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a v-show="isOtherImgs" class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>
          </header>
        </div>
        <!-- /.card -->
      </div>
      <!--/.slidebar-->

      <div class="card-body">
        <div class="card-header">
          <h4>Karakteristike automobila</h4>
        </div>
        <h3 class="card-title colr"> Automobil:
            <span class="colrbl" style="font-size: 25px">{{ automobil.markaAut }} {{ automobil.modelAut }} (marka/model)</span>
        </h3>

        <h3 class="card-title colr"> Klasa:
            <span class="colrbl" style="font-size: 25px">{{ automobil.klasaAut }}</span>
        </h3>

        <h4 class="card-title colr">Tip goriva:
            <span class="colrbl" style="font-size: 25px">{{ automobil.tipGoriva }}</span>
        </h4>

        <h4 class="card-title colr">Tip menjaca:
            <span class="colrbl" style="font-size: 25px">{{ automobil.tipMenjaca }}</span>
        </h4>

        <h4 class="card-title colr">Broj sedista za decu:
            <span class="colrbl" style="font-size: 25px">{{ automobil.brojSedistaZaDecu }}</span>
        </h4>

        <h4 class="card-title colr"> Predjena kilometraza: 
            <span class="colrbl" style="font-size: 25px">{{ automobil.predjenaKilometraza }} km</span>
        </h4>

        <h4 class="card-title colr">Colison DMG Waiver:
            <span class="colrbl" v-if="automobil.collisionDamageWaiver" style="font-size: 25px">Sadrži</span>
          <span class="colrbl" v-if="!automobil.collisionDamageWaiver" style="font-size: 25px">Ne sadrži</span>
        </h4>
      </div>
      <div class="card card-outline-secondary my-4">
        <div class="card-header">
          <h4>Ocene i komentari</h4>
        </div>

        <div class="card-body" v-bind:key="review.id" v-for="review in automobil.reviews" v-show="!noReview">
          <div style="margin-bottom: 10px" id="star-rating" v-if='review.star > 0'>
            <star-rating
              inactive-color="#35424a"
              active-color="gold"
              v-bind:read-only="true"
              v-bind:star-size="20"
              v-bind:show-rating="false"
              v-bind:rating="review.star">
            </star-rating>
          </div>
          <p>{{ review.text }}</p>
          <small class="text-muted">Posted by {{ review.username }}</small>
          <hr />
        </div>

        <div v-show="noReview" class="card-body">
          <h3>There are no reviews for this apartment...</h3>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import StarRating from "vue-star-rating";
import UserDataService from "../services/UserDataService";
export default {
  name: "Car-details",
  data: function () {
    return {
      permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
      },
      btnEnabled:false,
      isOtherImgs: true,
      noReview: false,
      automobil: {
        id: "",
        markaAut: "",
        modelAut: "",
        klasaAut: "",
        tipGoriva: "",
        tipMenjaca: "",
        ukupnaOcena: null,
        brojSedistaZaDecu: null,
        predjenaKilometraza: null,
        collisionDamageWaiver: null,
        images: [],
        reviews: [],
      },
    };
  },
  methods: {

    getAutomobilDetails: function () {
      UserDataService.getAutomobilDetails(this.id).then((response) => {
        
        this.automobil.id = response.data.id;
        this.automobil.markaAut = response.data.markaAut;
        this.automobil.modelAut = response.data.modelAut;
        this.automobil.klasaAut = response.data.klasaAut;
        this.automobil.tipGoriva = response.data.tipGoriva;
        this.automobil.tipMenjaca = response.data.tipMenjaca;
        this.automobil.ukupnaOcena = response.data.ukupnaOcena;
        this.automobil.brojSedistaZaDecu = response.data.brojSedistaZaDecu;
        this.automobil.predjenaKilometraza = response.data.predjenaKilometraza;
        this.automobil.collisionDamageWaiver = response.data.collisionDamageWaiver;
        for (let i = 0; i < response.data.slikeVozila.slika.length; i++) {
          this.automobil.images.push(response.data.slikeVozila.slika[i]);
        }
        //console.log(this.automobil.images);
      });
    },
    getAutomobilReviews:function(){
      UserDataService.getAutomobilDetailsReviews(this.id).then(response => {
        this.automobil.reviews = response.data;
        console.log(JSON.stringify(response.data));
        this.noComment();
      });
    },
    getAllPermissions:function(){
            UserDataService.getAllPermissions().then(response => {
                this.permissions = response.data;
                if(this.permissions.status != "aktivan"){
                    btnEnabled = true
                }
                console.log(JSON.stringify(this.permissions));
            });
    },
    getFirstImg: function () {
      //provera da li ima slika za dati stan
      if (!this.automobil.images.length) {
        console.log("getFirstImg");
        console.log("images.length : " + this.automobil.images.length);
        let img = ["@/assets/No_Image_Available.png"];
        // ako nema smesti noimage sliku
        this.automobil.images = img;
        console.log(this.automobil.images[0]);
      }
    },
    noComment: function () {
      if (this.automobil.reviews === undefined || this.automobil.reviews.length === 0) {
        console.log('Usao u slucaj kada je duzina prazna: ');
        console.log('this.automobil.reviews.length: ' + this.automobil.reviews.length);
        this.noReview = true;
        console.log('this.noReview: ' + this.noReview);
      } else if ( this.automobil.reviews !== undefined || this.automobil.reviews.length !== 0) {
          console.log('Usao u slucaj kada  duzina NIJE prazna: ');
        console.log('this.automobil.reviews.length: ' + this.automobil.reviews.length);
        let visible = false;
        //ako ima komentara za dati stan, prolazimo kroz sve komentare
        //i proveravamo da li su odobreni ako ni jedan nije odobren opet prikazujemo poruku
        for (let i = 0; i < this.automobil.reviews.length; i++) {
          if (this.automobil.reviews[i].odobren === false) {
            console.log(`odobren[${i}]: ` + this.automobil.reviews[i].odobren);
            continue;
          } else {
            visible = true;
            break;
          }
        }
        console.log("visible: " + visible);
        //Ako je visibility svakog komentara false onda
        //prikazuje poruku kako nema komentara
        if (visible === false) {
          console.log('Usao u noReview = true');
          this.noReview = true;
        } else {
        console.log('Usao u noReview = false');
        this.noReview = false;
      }
      console.log("this.noReview: " + this.noReview);
      }
    },
  },
  components: {
    "star-rating": StarRating,
  },
  computed: {
    id() {
      return this.$route.params.id; //preuzimam id automobila na cijoj sam stranici za prikaz detalja
    },
    getOtherImgs: function () {
      console.log("getOtherImgs: ");
      //Prva slika mora da se manuelno postavi, a ostale se dodaju preko v-for:
      let imgs = this.automobil.images.slice(1);
      //Ako ima samo jednu sliku onda se sklanjaju strelice < > za kretanje kroz slike.
      if (imgs.length === 0) {
        console.log("imgs.lenght je = 0 ");
        this.isOtherImgs = false;
        console.log("this.isOtherImgs: " + this.isOtherImgs);
      } else {
        //vec je true, ali za svaki slucaj
        this.isOtherImgs = true;
        return imgs;
      }
    },
  },
  created() {
    if(JSON.parse(localStorage.getItem('token')) == null){
        this.$router.push(`/login`);
    }else{
      this.getAllPermissions();
      this.getAutomobilDetails();
      this.getAutomobilReviews();
      this.noComment();
    }
  },
  mounted() {
  },
};
</script>

<style scoped>
#titleEffect {
  color:#FF8C00;
  font-weight: bold;
}

#car-details header .carousel-item {
  height: 85vh;
  min-height: 350px;
  background: no-repeat center center scroll;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

.colr {
  color: #35424a;
  font-weight: bold;
}

.colrbl {
  color: #000;
}
</style>
