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
            <textarea v-model='noviKomentar.tekstKomentara' placeholder="Unesite komentar..."></textarea>
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
            noviKomentar: {
                userId: '', //za CommonData
                automobilId: '',
                tekstKomentara: '',
                odobren: false,
            },
            messages: {
                errorText: '',
                errorResponse: '',
                successResponse: '',
            }
        }
    },
    methods:{
        addComment: function () {
            if (this.noviKomentar.tekstKomentara == '') {
                this.messages.errorText = `<h4>Tekst komentara ne moze biti prazan!</h4>`;
                setTimeout(() => this.messages.errorText = '', 3000);
            }
            else {
                alert(`
                automobilId: ${this.noviKomentar.automobilId},
                username: ${this.noviKomentar.userId},
                text: ${this.noviKomentar.tekstPoruke},
                visible: ${this.noviKomentar.odobren},
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
            return this.$route.params.id; //preuzimam id automobila za koga dodajem novi komentara
        }
    },
    created() {
        if (!localStorage.getItem('jwt')){
            this.$router.push('/login');
        }

        //this.review.userId = this.user.username;
        this.noviKomentar.automobilId = this.id
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