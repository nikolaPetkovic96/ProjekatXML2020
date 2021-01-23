<template>
    <div id="car-new-comment">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Novi <span id='titleEffect'>Komentar</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
            <label>Komentar:</label>
            <div v-if='messages.errorText' class="alert alert-danger" v-html="messages.errorText"></div>
            <textarea v-model='noviKomentar.tekstKomentara' placeholder="Unesite komentar..."></textarea>
            <br>        
            <div v-if='messages.errorResponse' class="alert alert-danger" v-html="messages.errorResponse"></div>
            <div v-if='messages.successResponse' class="alert alert-success" v-html="messages.successResponse"></div>
            <button class="btn btn-lg btn-success shadow" v-on:click='addComment'> Potvrdi </button>
        </div>
    </div>
</template>

<script>
import agentDataService from '../services/AgentDataService'
export default {
    name: 'carNewComment',
    data:function(){
        return {
            noviKomentar: {
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
            console.log(`Komentar:
                automobilId: ${this.noviKomentar.automobilId},
                tekstKomentara: ${this.noviKomentar.tekstKomentara},
                odobren: ${this.noviKomentar.odobren},
            `);

                agentDataService.addKomentar(this.noviKomentar)
                    .then(response => {
                        this.messages.successResponse = `<h4>Vaša poruka je uspešno poslata!</h4>`;
                        this.noviKomentar.tekstKomentara = '';
                        setTimeout(() => this.messages.successResponse = '', 5000);

                    })
                    .catch(error => {
                        if (error.response.status === 500 || error.response.status === 404) {
                            this.messages.errorResponse = `<h4>Žao nam je imali smo nekoh problema na serveru, molimo Vas pokušajte kasnije!</h4>`;
                            setTimeout(() => this.messages.errorResponse = '', 5000);
                        }
                    });
            }
        },
    },

    computed: {
        id() {
            return this.$route.params.id; //preuzimam id automobila za koga dodajem novi komentara
        }
    },
    created() {
        const token = JSON.parse(localStorage.getItem('token'));
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.noviKomentar.automobilId = this.id;
        }
        
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