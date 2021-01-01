<template>  
    <div id='users-message-overview'>
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Lista <span id='titleEffect'>Komentara</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <!-- Objavljivanje ili odbijanje komentara korisnika. -->
        <div id='main' class='container'>
            <!-- <div class="comments" v-bind:key="automobil.id" v-for='automobil in automobili'>
                    <div id='carInfo'>
                    <div class="card-header">
                        <h4><b>Automobil:</b> {{automobil.markaAut}} {{automobil.modelAut}} (marka/model)</h4>
                        <h4><b>Klasa automobila:</b> {{automobil.klasaAut}}</h4>
                        <h4><b>Ukupna ocena:</b> {{automobil.ukupnaOcena}}</h4>
                    </div>
                </div>
                <div v-show='isThereReviews(automobil)' class="card-body">
                        <h3>Nema ocene niti komentara za ovaj automobil...</h3>
                </div>
                <div id='all-comments' v-bind:key="comment.id" v-for='comment in automobil.reviews'> -->
                <div id='all-comments'  class="comments" v-bind:key="comment.id" v-for='comment in reviews'>
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
                        <div id='comment-visibility' style="margin-bottom: 5px;">
                            <label style="display:block;">Prikazi komentar</label>
                            <input type="checkbox" v-on:mouseup='checkComment(comment)' v-model='comment.odobren'>
                            <div id='visibility-message' v-if='comment.odobren'>
                                <p>Ovaj komentar i ocena ce biti prikazani drugim korisnicima!</p> 
                            </div>
                        </div>
                    </div>
                </div>
            <!-- </div> comments -->
        </div>
    </div> 
</template>

<script>
import adminDataService from '../services/AdminDataService'
import StarRating from 'vue-star-rating'
export default {
    name:'Users-message-overview',
    data:function(){
        return{
            reviews:[
                // {
                //     id:'1',
                //     username:'ThisUserMessage',
                //     text:'Najbolji automobil ikada! Sve pohvaleeeee! Vrh je bas',
                //     star:5,
                //     odobren:true,
                // },
                //     {
                //     id:'3',
                //     username:'ThisUserMessage',
                //     text:'Nije netki automobil! Sda dnl, lndakd ondasjb jdba ndisa!',
                //     star:2,
                //     odobren:false,
                // },
            ],
            // automobili: [
            //     {
            //         id:'1',
            //         markaAut:'BMW',
            //         modelAut:'M5',
            //         klasaAut:'SUV',
            //         vrstaGoriva:'dizel',
            //         tipMenjaca:'manuelni',
            //         ukupnaOcena:5,
            //         brojSedistaZaDecu:1,
            //         predjenaKilometraza:5000,
            //         collisionDamageWaiver:true,
            //         images:[],
            //         reviews:
            //         [
            //             {
            //                 id:'1',
            //                 username:'ThisUserMessage',
            //                 text:'Najbolji automobil ikada! Sve pohvaleeeee! Vrh je bas',
            //                 star:5,
            //                 odobren:true,
            //             },
            //               {
            //                 id:'3',
            //                 username:'ThisUserMessage',
            //                 text:'Nije netki automobil! Sda dnl, lndakd ondasjb jdba ndisa!',
            //                 star:2,
            //                 odobren:false,
            //             },
            //         ]
            //     },
              
            // ],
        }
    },
    methods:{
        getAllReviews:function(){
            adminDataService.getAllReviws().then(response => {
                this.reviews = response.data;
                console.log('Reviews:');
                console.log(JSON.stringify(this.reviews));
            });
        },
        showComments:function(id){
            this.$router.push(`/adminTest/${id}/comments`);;
        },

        checkComment: function (updatedComment) {
            console.log(JSON.stringify(updatedComment));
            // updatedComment.visible = !updatedComment.visible;
            //mora ovako jer inace kasni za jednu promenu checkbox;
            updatedComment.odobren = !updatedComment.odobren;
            adminDataService.approveComment(updatedComment.automobKomentarId, updatedComment.odobren)
                .then(response => {
                    this.getAllReviews();
                })
        },
        isThereReviews:function(automobil){     
            console.log('this.apartment.reviews.length: ' + automobil.reviews.length);   
            if(automobil.reviews === undefined || automobil.reviews.length === 0){
              return true;
            }
            else {
                return false;
            }
        },
    },
    components: {
        'star-rating':StarRating
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.getAllReviews();
        }
        
    }
}
</script>

<style scoped>

#titleEffect {
    color:#00bcd4;
    font-weight: bold;
}

#users-message-overvie #carInfo h3{
    color:#35424a;
    font-weight: bold;
    font-size: 30px; 
    padding: 30px 0 0 25px;
}

#users-message-overview .comments{
    margin:auto;
    width:70%;
}

#users-message-overview .comments .single-comment{
    background-color: #f4f4f4;
    padding:20px;
    margin:20px 0;
    border: 1px solid #777;
    border-radius: 10px;
    color:#35424a;
}

#users-message-overview .comments .single-comment #username{
    font-weight: bold;
    font-size:20px;
    margin:5px 0 5px 5px;
    border-bottom: 1px solid #777;
}

#users-message-overview .comments .single-comment #star-rating{
    padding:5px 0 5px 5px;
}

#users-message-overview .comments .single-comment #comment{
    /* font-weight: bold; */
    font-size:15px;
    margin:10px 0;
    padding:10px;
}


#cusers-message-overview .comments .single-comment #comment-visibility{
    background-color: #f4f4f4;
    padding:15px;
}

#users-message-overview .comments .single-comment #check-visibility{
    float: left;
    width: 5%;
}

#users-message-overview .comments .single-comment #visibility-message{
    background-color: #f4f4f4;
    color:#777;
    float: right;
    width: 90%;
    text-align: center;
}

#users-message-overview .marg{
    margin-top:5px;
    margin-bottom: 15px;
} 

</style>