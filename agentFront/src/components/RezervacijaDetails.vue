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
                    <h5><b>Ukupna cena:</b> {{rezervacija.ukupnaCena}} din</h5>
                    <h5><b>Bundle:</b> {{rezervacija.bundle}}</h5>
                    <h5><b>Status:</b> {{rezervacija.statusRezervacije}}</h5>
                    <br>
                    <h4><b>Rezervacija obuhvata:</b></h4>
                </div>
                <div v-bind:key="narudzbenica.id" v-for='narudzbenica in rezervacija.narudzbenice'>
                    <div class="card-header car-info">
                        <h4><b>Termin rezervacije:</b> {{narudzbenica.odDatuma}} - {{narudzbenica.doDatuma}}</h4>
                        <h4><b>Automobil:</b> {{narudzbenica.oglas.automobil.markaAut}} {{narudzbenica.oglas.automobil.modelAut}} (marka/model)</h4>
                        <h5><b>Klasa automobila:</b> {{narudzbenica.oglas.automobil.klasaAut}}</h5>
                        <h6><b>Vrsta goriva:</b> {{narudzbenica.oglas.automobil.vrstaGoriva}}</h6>
                        <h6><b>Tip menjaca:</b> {{narudzbenica.oglas.automobil.tipMenjaca}}</h6>
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
                                    <td>{{narudzbenica.oglas.cenovnik.nazivCenovnika}}</td>
                                    <td>{{narudzbenica.oglas.cenovnik.cenaPoDanu}}</td>
                                    <td>{{narudzbenica.oglas.cenovnik.cenaPoKilometru}}</td>
                                    <td>{{narudzbenica.oglas.cenovnik.cenaCollisionDamageWaiver}}</td>
                                    <td>{{narudzbenica.oglas.cenovnik.popustZaPreko30Dana}}</td>
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
                ukupnaCena:6500,
                statusRezervacije:'RESERVED',
                username:'Happy User 2', //u rezervDTOu za korisnika koji je rezervisao oglas.
                bundle:true,
                //Narudzbenice vratiti kao array jer ih moze biti vise u bundleu
                //iz svakog oglasa koji je vezan za rezervaciju izvlacimo automobil
                //getAllAdsByReservId();
                narudzbenice:[
                    {
                        id:1,
                        odDatuma:'18.6.2020',
                        doDatuma:'25.7.2020',
                        oglasId:1,
                        userId:2,
                        agentId:1, 
                        oglas:{
                            id:1,
                            odDatuma:'25.5.2020',
                            doDatuma:'25.6.2020',
                            TAdresa:{
                                mesto:'Novi Sad',
                                ulica:'9. Marta',
                                broj:'bb',
                                postanskiBroj:'21000',
                                longitude:'45',
                                latitude:'54',
                            },
                            planiranaKilometraza:2000,
                            agentId:1,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                            korisnickoIme:'This host',  //u DTOu za korisnika koji je kreirao oglas.
                            //automobil
                            automobil:{
                                id:1,
                                markaAut:'BMW',
                                modelAut:'M5',
                                klasaAut:'SUV',
                                vrstaGoriva:'dizel',
                                tipMenjaca:'manuelni',
                                ukupnaOcena:5,
                                brojSedistaZaDecu:1,
                                predjenaKilometraza:5000,
                                collisionDamageWaiver:true,
                                images:['https://source.unsplash.com/RCAhiGJsUUE/1920x1080','https://source.unsplash.com/wfh8dDlNFOk/1920x1080','https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                            },
                            //cena    
                            cenovnik:{
                                id:'1',
                                cenaPoDanu:100,
                                nazivCenovnika:'Cenovnik 1',
                                popustZaPreko30Dana:'10%',
                                cenaCollisionDamageWaiver:1000,
                                cenaPoKilometru:10
                            },
                        },
                    },
                
                    {
                        id:2,
                        agentId:2,
                        userId:5,
                        oglasId:2,
                        odDatuma:'25.6.2020',
                        doDatuma:'10.7.2020',
                        oglas:{
                            id:2,
                            odDatuma:'18.6.2020',
                            doDatuma:'25.7.2020',
                            TAdresa:{
                                mesto:'Beograd',
                                ulica:'Ne znanog i znanog junaka',
                                broj:'bb',
                                postanskiBroj:'11000',
                                longitude:'21.23',
                                latitude:'34.14',
                            },
                            planiranaKilometraza:2500,
                            agentId:2,                  //u DTOu id korisnika koji je kreirao oglas (uzeto iz commonData oglasa).
                            korisnickoIme:'Other host', //u DTOu za korisnika koji je kreirao oglas.
                            //Oglas/Automobil
                            automobil:{
                                id:2,
                                markaAut:'Audi',
                                modelAut:'A6',
                                klasaAut:'Gradski',
                                vrstaGoriva:'dizel',
                                tipMenjaca:'manuelni',
                                predjenaKilometraza:4500,
                                ukupnaOcena:4.25,
                                collisionDamageWaiver:true,
                                brojSedistaZaDecu:1,
                                images:['https://source.unsplash.com/O7fzqFEfLlo/1920x1080'],
                            },
                            //Oglas/Cenovnik
                            cenovnik:{ 
                                id:'2',
                                cenaPoDanu:500,
                                nazivCenovnika:'Cenovnik 2',
                                popustZaPreko30Dana:'20%',
                                cenaCollisionDamageWaiver:null,
                                cenaPoKilometru:20
                            },
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
        //ovo radi...
        // if (!localStorage.getItem('jwt')){
        //     this.$router.push('/login');
        // }

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