<template>
    <div id="reservation-new">
    <div class="container" id='page-title'>
        <h1 style="margin-top:10px;color:#35424a;">Kreiranje <span id='titleEffect'>Rezervacije</span></h1>
        <hr style='background:#e8491d;height:1px;'>
    </div>

    <div id='main' class='container'>
        <label>Datum pocetka rezervacije:</label>
        <input type="date" v-model="reservation.beginning">
        <label>Datum okoncanja rezervacije:</label>
        <input type="date" v-model="reservation.ending">
        <label>Planirana kilometraza:</label>
        <input style="padding:7px; margin-right: 10px" id='NoOfNights' v-model="reservation.planned_distance"/>
        <label>Tekst rezervacije:</label>
        <textarea v-model='reservation.message' placeholder="message..."></textarea>
        <button class="btn btn-lg btn-success" v-on:click='makeReservation(vehId)'> Send </button>
    </div> 
</div>
</template>

<script>

// import KlijentDataService from './components/KlijentDataService'

export default {
    data(){
        return{
            user: {
                username: '',
                role: ''
            },
            vehId: '',
            isAdmin: false,
            isHost: false,
            isGuest: true,

            reservation:{
                beginning: null,
                ending: null,
                planned_distance: 0,
                message:''
            }
        }
    },
    methods:{
        makeReservation(id){
            console.log('SLANJE ZAHTEVA ZA REGISTRACIJU NA SERVER');
            KlijentDataService.vehReservation(id).then(response =>{

            }).catch(error =>{

            });
        }
    },
    created() {
        this.user.username = localStorage.getItem('user');
        this.user.role = localStorage.getItem('role');
        if (this.user.role == "ADMIN") {
            this.isAdmin = true;
        } else if (this.user.role == "HOST") {
            this.isHost = true;
        } else {
            this.isGuest = true;
        }
        this.vehId = this.$route.params.vehId;
    }
}
</script>

<style>
body{
    background-color:#f4f4f4;
    margin:0;
    padding:0;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 15px;
    line-height: 1.5em;
    /*isto*/
    font: 15px 1.5em Arial, Helvetica, sans-serif;
}
#main-footer {
    margin-top:200px;
    padding:20px;
    margin-top:20px;
    background-color:#e8491d;
    color:#fff;
    text-align: center;
    font-size: 12px;
}


#titleEffect{
  color:gold;
  font-weight: bold;
}

.router-link-active{
  border-bottom: #fff solid 1px;
  font-weight: bold;
}

/* RESERVATIONS PAGE*/
#reservation-list th:hover{
  color:#35424a;
  font-weight: bold;
  cursor: pointer;
}

/* #main.container div div.vue-star-rating{
  margin-bottom:50px;
} */
#main.container div button.btn.btn-lg.btn-success{
  margin-top:80px;
}

/* Apartments overview page*/
#apartments-overview th:hover{
  color:#35424a;
  font-weight: bold;
  cursor: pointer;
}

#apartments-overview img:hover{
  cursor: pointer;
}

.classButton{
  margin-left: 5px;
  color:#fff;
  background-color: #e8491d;
  padding:10px;
}

.classButton:hover{
  margin-left: 5px;
  color:#fff;
  background-color: #e8491d;
  font-weight: bold;
  padding:10px;
}
/* apartmentCommentNew */                          /*apartmentAmenityNew */
#aparm-new-comment label, #new-Reservation label,
#new-amenity label, #new-apartment label {
  display: block;
  margin: 20px 0 10px;
  font-size: 20px;
  font-weight: bold;
}

#aparm-new-comment textarea,  #new-Reservation textarea{
  display: block;
  width: 100%;
  height: 200px;
  padding:8px;
}


/* Comments Overview */
#apartment-comments #apartmentInfo h3{
  color:#35424a;
  font-weight: bold;
  font-size: 30px; 
  padding: 30px 0 0 25px;
}

#apartment-comments .comments{
  margin:auto;
  width:70%;
}

#apartment-comments .comments .single-comment{
  background-color: #f4f4f4;
  padding:20px;
  margin:20px 0;
  border: 1px solid #777;
  border-radius: 10px;
  color:#35424a;
}

#apartment-comments .comments .single-comment #username{
  font-weight: bold;
  font-size:20px;
  margin:5px 0 5px 5px;
  border-bottom: 1px solid #777;
}

#apartment-comments .comments .single-comment #star-rating{
  padding:5px 0 5px 5px;
}

#apartment-comments .comments .single-comment #comment{
  /* font-weight: bold; */
  font-size:15px;
  margin:10px 0;
  padding:10px;
}


#apartment-comments .comments .single-comment #comment-visibility{
  background-color: #f4f4f4;
  padding:15px;
}

#apartment-comments .comments .single-comment #check-visibility{
  float: left;
  width: 5%;
}

#apartment-comments .comments .single-comment #visibility-message{
  background-color: #f4f4f4;
  color:#777;
  float: right;
  width: 90%;
  text-align: center;
}

#new-apartment select{
  width:25%;
  padding:10px;
}

#new-apartment .half-size{
  width:49%;
  padding:10px;
  margin-bottom:25px
}

#new-apartment #address,#new-apartment #price{
  width:100%;
  padding:10px;
  margin-bottom:25px
}

/* ApartmentAmenitiesOverview */
#amenities-overview #main #new-amenity #amenity-type{
  margin-bottom: 15px;
}
#amenities-overview #main #new-amenity #amenity-type input{
  display:inline-block;
  margin-right: 10px;
}
#amenities-overview #main #new-amenity #amenity-type label{
  display:inline-block;
  size:16px;
  font-weight: bold;
}
.test{
  border-color: black;
  border-style: solid;
}
</style>-->