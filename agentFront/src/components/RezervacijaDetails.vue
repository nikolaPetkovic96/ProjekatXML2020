<template>
    <div id="reservation-details">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Detalji <span id='titleEffect'>Rezervacije</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
           <div id='reservInfo'>
                <div class="card-header">
                    <h4><b>Rezervisan od:{{rezervacija.username}}</b></h4>
                    <h4><b>Termin rezervacije:</b> {{rezervacija.odDatuma}} - {{rezervacija.doDatuma}}</h4>
                    <h5><b>Ukupna cena:</b> {{rezervacija.ukupnaCena}} din</h5>
                    <h5><b>Bundle:</b> {{rezervacija.bundle}}</h5>
                    <br>
                    <h4><b>Rezervacija obuhvata:</b></h4>
                </div>
                <div v-bind:key="oglas.id" v-for='oglas in rezervacija.oglasi'>
                    <div class="card-header car-info">
                        <h4><b>Automobil:</b> {{oglas.automobil.markaAut}} {{oglas.automobil.modelAut}} (marka/model)</h4>
                        <h5><b>Klasa automobila:</b> {{oglas.automobil.klasaAut}}</h5>
                        <h6><b>Vrsta goriva:</b> {{oglas.automobil.vrstaGoriva}}</h6>
                        <h6><b>Tip menjaca:</b> {{oglas.automobil.tipMenjaca}}</h6>
                        <table id='showPriceTable'>
                    <thead>
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
                            <td>{{oglas.cenovnik.nazivCenovnika}}</td>
                            <td>{{oglas.cenovnik.cenaPoDanu}}</td>
                            <td>{{oglas.cenovnik.cenaPoKilometru}}</td>
                            <td>{{oglas.cenovnik.cenaCollisionDamageWaiver}}</td>
                            <td>{{oglas.cenovnik.popustZaPreko30Dana}}</td>
                        </tr>     
                    </tbody>            
                </table>
            </div>
                    </div>
                </div>
            </div>
        </div>
</template>

<script>
export default {
    name: 'reservation-details',
    data:function(){
        return {
            rezervacija:{
                id:1,
                odDatuma:'18.6.2020',
                doDatuma:'25.7.2020',
                ukupnaCena:6500,
                statusRezervacije:'RESERVED',
                username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                bundle:true,
                //Oglase vratiti kao array jer ih moze biti vise u bundleu
                //iz svakog oglasa koji je vezan za rezervaciju izvlacimo automobil
                //getAllAdsByReservId();
                oglasi:[
                    {
                        //Oglas
                        id:1,
                        odDatuma:'25.5.2020',
                        doDatuma:'25.6.2020',
                        lokacija:'9. Marta bb Novi Sad',
                        TAdresa:{
                            mesto:'',
                            ulica:'',
                            broj:'',
                            postanskiBroj:'',
                            longitude:'',
                            latitude:'',
                        },
                        planiranaKilometraza:2000,
                        //Oglas/Automobil
                        automobil:{
                            id:1,
                            markaAut:'Audi',
                            modelAut:'A6',
                            klasaAut:'Gradski',
                            vrstaGoriva:'dizel',
                            tipMenjaca:'manuelni',
                        },
                        //Oglas/Cenovnik
                        cenovnik:{ 
                            id:'1',
                            cenaPoDanu:100,
                            nazivCenovnika:'Cenovnik 1',
                            popustZaPreko30Dana:'10%',
                            cenaCollisionDamageWaiver:1000,
                            cenaPoKilometru:10
                        },
                    },
                
                    {
                        //Oglas
                        id:2,
                        odDatuma:'18.6.2020',
                        doDatuma:'25.7.2020',
                        lokacija:'Ne znanog i znanog junaka bb Beograd',
                        TAdresa:{
                            mesto:'',
                            ulica:'',
                            broj:'',
                            postanskiBroj:'',
                            longitude:'',
                            latitude:'',
                        },
                        planiranaKilometraza:2500,
                    
                        //Oglas/Automobil
                        automobil:                
                        {
                            id:2,
                            markaAut:'BMW',
                            modelAut:'R5',
                            klasaAut:'Gradski',
                            vrstaGoriva:'euro-dizel',
                            tipMenjaca:'automatski',
                        },
                        //Oglas/Cenovnik
                        cenovnik:{ 
                            id:'2',
                            cenaPoDanu:200,
                            nazivCenovnika:'Cenovnik 2',
                            popustZaPreko30Dana:'20%',
                            cenaCollisionDamageWaiver:null,
                            cenaPoKilometru:20
                        },
                    },

                ],
                //getujemo poruke preko id rezervacije getAllMessagesByReservId();
                poruke:[
                    //Za prvi automobil u bundleu
                    {
                        id:1,
                        tekstPoruke:'Da li imate automobil u crvenoj boji? Asdasd dasdsad dsad dsa da das . Asdasd dasdsad dsad dsa da das .',
                        rezervacijaId:1,
                        automobilId:1, //Kako ako ih je vise u rezerv. tj. ako je rezerv bundle?
                        commonData:{
                            userId:1,
                            datumKreiranja:'16.6.2020',
                        }
                    },
                    {
                        id:2,
                        tekstPoruke:'Nazalost nemamo.',
                        rezervacijaId:1,
                        automobilId:1,
                        commonData:{
                            userId:2,
                            datumKreiranja:'16.6.2020',
                        }
                    },
                    {
                        id:3,
                        tekstPoruke:'Nista... Hvala na brzom odgovoru!',
                        rezervacijaId:1,
                        automobilId:1,
                        commonData:{
                            userId:1,
                            datumKreiranja:'17.6.2020',
                        }
                    },
                    {
                        id:4,
                        tekstPoruke:'Nema na cemu!',
                        rezervacijaId:1,
                        automobilId:1,
                        commonData:{
                            userId:2,
                            datumKreiranja:'17.6.2020',
                        }
                    },
                    //Za drugi automobil u bundleu
                    {
                        id:5,
                        tekstPoruke:'A da li ovaj dolazi u plavoj boji?! Hvala unapred!',
                        rezervacijaId:1,
                        automobilId:2,
                        commonData:{
                            userId:1,
                            datumKreiranja:'17.6.2020',
                        }
                    },
                    {
                        id:6,
                        tekstPoruke:'Dolazi, nema na cemu!',
                        rezervacijaId:1,
                        automobilId:2,
                        commonData:{
                            userId:2,
                            datumKreiranja:'17.6.2020',
                        }
                    }
                ]
            },
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
                km: ${this.review.star},
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
            return this.$route.params.id; //preuzimam id rezervacije za koju prikazujem detalje.
        }
    },
    created() {
        if (!localStorage.getItem('jwt')){
            this.$router.push('/login');
        }

        // this.review.userId = this.user.username;
        // this.review.carId = this.id
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

.car-info{
    background-color: white;
    border-bottom-right-radius: 50px;
    border-bottom:solid gold 1px;
}

.car-info b{
    color: #35424a;
}

.card-header{
    border-bottom-right-radius: 50px;
}

/* Za cenu */
#showPriceTable{
    color:#35424a;
    margin-top:10px;
} 

#showPriceTable thead{
    border-bottom: 1px solid lightgrey;
    border-bottom-right-radius: 50px;
}

#showPriceTable thead th{
    padding-right:15px;
}

</style>