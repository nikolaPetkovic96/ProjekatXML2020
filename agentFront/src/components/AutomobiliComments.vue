<template>
    <div id="car-comments">
        <div id="car-comments">
            <div class="container" id='page-title'>
                <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Komentara</span></h1>
                <hr style='background:#35424a;height:1px;'>
            </div>

            <div id='main' class='container'>
                <div class="comments" v-bind:key="car.id" v-for='car in cars'>
                    <div id='carInfo'>
                        <div class="card-header">
                            <h4><b>Rezervisan od?:</b></h4>
                            <h4><b>Automobil:</b> {{car.markaAut}} {{car.modelAut}} (marka/model)</h4>
                            <h4><b>Klasa automobila:</b> {{car.klasaAut}}</h4>
                            <h4><b>Ocena:</b> {{car.ocena}}</h4>
                        </div>
                    </div>
                    <div v-show='isThereReviews(car)' class="card-body">
                            <h3>Nema ocene niti komentara za ovaj automobil...</h3>
                    </div>
                    <div id='all-comments' v-bind:key="comment.id" v-for='comment in car.reviews'>
                        <div class="single-comment">
                            <div id='username'>{{comment.username}} </div>
                            <div id='star-rating'>
                                <star-rating
                                    inactive-color="#35424a"
                                    active-color="gold"
                                    v-bind:read-only= "true"
                                    v-bind:star-size="25"
                                    v-bind:show-rating="false"
                                    v-bind:rating="comment.star">
                                </star-rating>
                            </div>
                            <div id='comment'>
                                {{comment.text}}  
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-success marg" v-on:click='addComment(car.id)'>Ostavi komentar</button>
                </div> <!--comments-->
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'carComments',
    data:function(){
        return {

            //overview u modelu
            comments: [],
            //trebaju da se getuju automobili sa svim komentarima vezanim za njih
            //potrebni su i podaci o vlasniku automobila
            // cars:[],
             cars: [
                {
                    id:'1',
                    markaAut:'BMW',
                    modelAut:'M5',
                    klasaAut:'SUV',
                    ocena:5,
                    cena:2500,
                    kilometraza:500,
                    vlasnik:{
                        ime:'Nikola',
                        prezime:'Nikic',
                        username:"Nix333"
                    },
                    reviews:
                    [
                        {
                            id:'1',
                            username:'VeryHappyUser002',
                            text:'Najbolji automobil ikada! Sve pohvaleeeee! Vrh je bas',
                            star:5,
                        },
                        {
                            id:'2',
                            username:'happyUser1',
                            text:'Najbolji automobil ikada! Sve pohvale!',
                            star:5,
                        }
                    ]
                },
                {
                    id:'2',
                    markaAut:'Mercedes',
                    modelAut:'R8',
                    klasaAut:'Old Tajmer',
                    ocena:3,
                    cena:1200,
                    kilometraza:800,
                    vlasnik:{
                        ime:'Mika',
                        prezime:'Mikic',
                        username:"MikiKralj321"
                    },
                    reviews:[
                        {
                            id:'3',
                            username:'NotSoHappyUser2',
                            text:'Nije netki automobil! Sda dnl, lndakd ondasjb jdba ndisa!',
                            star:2,
                        },
                        {
                            id:'4',
                            username:'NotSoHappyUser3',
                            text:'Nije netki automobil! Moglo je to mnogo bolje! Nisam bas odusevljen uslugom',
                            star:4,
                        },
                        {
                            id:'5',
                            username:'VeryHappyUser4',
                            text:'Sve naj naj! Dsadas dsadsd das, dasjdiod ndi assndi.',
                            star:5,
                        }
                    ]
                },
                    {
                    id:'3',
                    markaAut:'Audi',
                    modelAut:'A6',
                    klasaAut:'Gradski auto',
                    ocena:4,
                    cena:1800,
                    kilometraza:650,
                    //ne treba mi kod agenta kada je agent vlasnik
                    vlasnik:{
                        ime:'Pera',
                        prezime:'Peric',
                        username:"PeraCar222"
                    },
                    reviews:
                    [
     
                    ]
                },
            ],
        }
    },
  methods: {
        setRating: function (rating) {
            this.rating = rating;
        },
        getComments: function () {
            // dobavljanje svih komentara preko apartmana za prikaz adminu ili hostu
            axios
                .get('rest/apartment/all')
                .then(response => {
                    this.apartments = response.data;
                })
        },
        checkComment: function (updatedComment) {

            updatedComment.visible = !updatedComment.visible;
            axios
                .put(`rest/reviews/${updatedComment.id}`, updatedComment)
                .then(response => {
                    this.getComments();
                })
        },
        isThereReviews:function(apartment){     
            console.log('this.apartment.reviews.length: ' + apartment.reviews.length);   
            if(apartment.reviews === undefined || apartment.reviews.length === 0){
              // console.log('this.apartment.reviews.length = 0 ');
              return true;
            }
            else {
                return false;
            }
        },
        addComment(id){
            this.$router.push(`/carComments/${id}/newComment`);
        }

    },
}
</script>

<style scoped>

#titleEffect{
  color:gold;
  font-weight: bold;
}


#car-comments #carInfo h3{
  color:#35424a;
  font-weight: bold;
  font-size: 30px; 
  padding: 30px 0 0 25px;
}

#car-comments .comments{
  margin:auto;
  width:70%;
}

#car-comments .comments .single-comment{
  background-color: #f4f4f4;
  padding:20px;
  margin:20px 0;
  border: 1px solid #777;
  border-radius: 10px;
  color:#35424a;
}

#car-comments .comments .single-comment #username{
  font-weight: bold;
  font-size:20px;
  margin:5px 0 5px 5px;
  border-bottom: 1px solid #777;
}

#car-comments .comments .single-comment #star-rating{
  padding:5px 0 5px 5px;
}

#car-comments .comments .single-comment #comment{
  /* font-weight: bold; */
  font-size:15px;
  margin:10px 0;
  padding:10px;
}


#car-comments .comments .single-comment #comment-visibility{
  background-color: #f4f4f4;
  padding:15px;
}

#car-comments .comments .single-comment #check-visibility{
  float: left;
  width: 5%;
}

#car-comments .comments .single-comment #visibility-message{
  background-color: #f4f4f4;
  color:#777;
  float: right;
  width: 90%;
  text-align: center;
}

#car-comments .marg{
    margin-top:5px;
    margin-bottom: 15px;
} 

</style>
