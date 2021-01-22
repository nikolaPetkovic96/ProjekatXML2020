<template>
    <div id="car-comments">
        <div id="car-comments">
            <div class="container" id='page-title'>
                <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Komentara</span></h1>
                <hr style='background:#35424a;height:1px;'>
            </div>

            <div id='main' class='container'>
                
                <div class="comments" v-bind:key="automobil.id" v-for='automobil in automobili'>
                    <div id='carInfo'>
                        <div class="card-header">
                            <h4><b>Automobil:</b> {{automobil.markaAut}} {{automobil.modelAut}} (marka/model)</h4>
                            <h4><b>Klasa automobila:</b> {{automobil.klasaAut}}</h4>
                            <h4><b>Ocena:</b> {{automobil.ukupnaOcena}}</h4>
                            <h4><small v-if='disableComment()' style='color:crimson;'>! Ostavljanje komentara je zabranjeno </small></h4>
                        </div>
                        
                    </div>
                    <div v-show='isThereReviews(automobil)' class="card-body">
                        <h3>Nema ocene niti komentara za ovaj automobil...</h3>
                    </div>
                    <div id='all-comments' v-bind:key="comment.id" v-for='comment in automobil.reviews'>

                        <div class="single-comment"  v-show='!isThereReviews(automobil)'>
                            <div id='username'>{{comment.username}} </div>
                            <div id='star-rating' v-if='comment.star > 0'>
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
                    <button class="btn btn-success marg" button :disabled='btnEnabled' v-on:click='addComment(automobil.id)'>Ostavi komentar</button>
                </div> <!--comments-->
            </div>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
import StarRating from 'vue-star-rating'
export default {
    name: 'AutomobiliKomentar',
    data:function(){
        return {
            automobili: [],
            reviews:[],
            autovi:[],

            permissions:{
                allowedToCommend:null,
                allowedToMessage:null,
                allowedToMakeReservation:null,
                status:null,
            },
            btnEnabled:false
        }
    },
    methods: {
        getAgentsAutomobils: function () {
            UserDataService.getAllAutomobiliAgent().then(response => {
                this.autovi = response.data;
                this.getAutomobilReviews(this.autovi);
            });
        },
        getAutomobilReviews:function(automobili){
             for(let i = 0; i< automobili.length; i++){
                console.log(`this.automobili[${i}].id` + automobili[i].id);

                UserDataService.getAutomobilDetailsReviews(automobili[i].id).then(response => {
                    automobili[i].reviews = response.data;
                    this.reviews.push(response.data);
                    this.automobili.push(automobili[i]);
                });
            }  
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
        isThereReviews:function(automobil){     
            if(automobil.reviews === undefined || automobil.reviews.length === 0){
              return true;
            }
            else {
                return false;
            }
        },
        addComment(id){
            this.$router.push(`/carsAgent/comments/${id}/new`);
        },

        disableComment(){
            if(this.permissions.allowedToCommend == true && this.permissions.status == 'aktivan'){
                return false
            }
            else{
                return true;
            }
        }
    },
    components: {
        'star-rating':StarRating
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.getAgentsAutomobils();
            this.getAllPermissions();
        }
    }
}
</script>

<style scoped>

#titleEffect{
  color:#FF8C00;
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
  font-size: 18px;
  margin: 10px 0;
  padding: 10px;
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
