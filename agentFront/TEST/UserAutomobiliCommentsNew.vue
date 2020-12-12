<template>
    <div id="car-new-comment">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Komentar</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
            <!-- <label>Comment:</label>-->
            <label>Komentar:</label> 
            <div v-if='messages.errorText' class="alert alert-danger" v-html="messages.errorText"></div>
            <textarea v-model='review.text' placeholder="Enter comment..."></textarea>
            <br>
            <!-- <label>Rating: </label> -->
            <label>Ocena:</label> 
            <div v-if='messages.errorStar' class="alert alert-danger" v-html="messages.errorStar"></div>
            <star-rating
                inactive-color="#35424a"
                active-color="gold"
                glow:2
                glow-color="#e8491d"
                v-model="review.star"></star-rating>
            <br>

            <button class="btn btn-lg btn-success shadow" v-on:click='addComment'> Potvrdi </button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'AutomobiliCommentsNew ',
    data:function(){
        return {
            review: {
                usertId: '',
                carId: '',
                text: '',
                star: null,
                visible: false,
            },
            messages: {
                errorText: '',
                errorStar: '',
                errorResponse: '',
                successResponse: '',
            }
        }
    },
    methods:{
        addComment: function () {
            if (this.review.text == '' && this.review.star != null) {
                this.messages.errorText = `<h4>Text of comment can't be empty!</h4>`;
                setTimeout(() => this.messages.errorText = '', 3000);
            }
            else if (this.review.text != '' && this.review.star == null) {
                this.messages.errorStar = `<h4>Rating can't be empty!</h4>`;
                setTimeout(() => this.messages.errorStar = '', 3000);
            }
            else if (this.review.text == '' && this.review.star == null) {
                this.messages.errorText = `<h4>Text of comment can't be empty!</h4>`;
                this.messages.errorStar = `<h4>Rating can't be empty!</h4>`;
                setTimeout(() => this.messages.errorText = '', 3000);
                setTimeout(() => this.messages.errorStar = '', 3000);

            }
            else {
                alert(`
                carId: ${this.review.carId},
                text: ${this.review.text},
                star: ${this.review.star},
                visible: ${this.review.visible},
                `);
                // axios
                //     .post('rest/reviews/', this.review)
                //     .then(response => {
                //         this.messages.successResponse = `<h4>Your review was sent successfully! Thank you for your feedback!</h4>`;
                //         this.review.text = '';
                //         this.review.star = null;
                //         setTimeout(() => this.messages.successResponse = '', 5000);

                //     })
                //     .catch(error => {
                //         if (error.response.status === 500 || error.response.status === 404) {
                //             this.messages.errorResponse = `<h4>We had some server errors, please try again later!</h4>`;
                //             setTimeout(() => this.messages.errorResponse = '', 5000);
                //         }
                //     });
            }
        },
    },

    computed: {
        id() {
            // alert('Car id: ' + this.$route.params.id);
            return this.$route.params.id; //preuzimam id automobila za koga dodajem novi komentara
        }
    },
    created() {
        if (!localStorage.getItem('jwt')){
            this.$router.push('/login');
        }

        // this.review.userId = this.user.username;
        this.review.carId = this.id
    },
    
}
</script>

<style scoped>
#titleEffect{
    color:gold;
    font-weight: bold;
}
#car-new-comment label{
    color:#35424a;
    display: block;
    margin: 20px 0 10px;
    font-size: 20px;
    font-weight: bold;
}

#car-new-comment textarea{
    display: block;
    width: 100%;
    height: 200px;
    padding:8px;
}

/* active-color="#e8491d" */
</style>