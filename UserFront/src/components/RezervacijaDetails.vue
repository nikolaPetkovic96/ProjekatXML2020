<template>
    <div id="reservation-details">
        <div class="container" id='page-title'>
            <h1 style="margin-top:10px;color:#35424a;">Detalji <span id='titleEffect'>Rezervacije</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container" id='main'>
           <div id='reservInfo'>
                <div class="card-header ">
                    <h3><b>Rezervisao: {{rezervacija.username}}</b></h3>
                    <h4><b>Ukupna cena:</b> <b>{{rezervacija.ukupnaCena}}</b> din</h4>
                    <h4><b>Bundle:</b> {{rezervacija.bundle}}</h4>
                    <h4><b>Status:</b> {{rezervacija.statusRezervacije}}</h4>
                    <br>
                    <h3><b>Rezervacija obuhvata:</b></h3>
                </div>
                <div v-bind:key="narudzbenica.id" v-for='narudzbenica in rezervacija.narudzbenice'>
                    <div class="card-header car-info">
                        <h4 class='h4'><b>Termin rezervacije:</b> {{formatDatuma(narudzbenica.odDatuma)}} - {{formatDatuma(narudzbenica.doDatuma)}} (MM:DD:YYYY)</h4>
                        <h5><b>Trajanje rezervacije:</b> {{calculateNoOfDays(narudzbenica.odDatuma, narudzbenica.doDatuma)}} dana</h5>
                        <h4 class='h4'><b>Automobil:</b> {{narudzbenica.oglas.automobil.markaAut}} {{narudzbenica.oglas.automobil.modelAut}} (marka/model)</h4>
                        <h5><b>Klasa automobila:</b> {{narudzbenica.oglas.automobil.klasaAut}}</h5>
                        <h6><b>Tip goriva:</b> {{narudzbenica.oglas.automobil.tipGoriva}}</h6>
                        <h6><b>Tip menjaca:</b> {{narudzbenica.oglas.automobil.tipMenjaca}}</h6>
                        <h4 class='h4'><b>Cenovnik:</b></h4>
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
                        <div class='reserv_end'>Cena: {{calculatePrice(narudzbenica.odDatuma, narudzbenica.doDatuma, narudzbenica.oglas.cenovnik.cenaPoDanu, narudzbenica.oglas.cenovnik.popustZaPreko30Dana)}}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
export default {
    name: 'reservation-details',
    data:function(){
        return {
            rezervacija:{},
        }
        
    },
    methods:{
        getReservation:function(){
            UserDataService.getRezervacijaDetails(this.id).then(response => {
                this.rezervacija = response.data;                
            });
        },
     
        formatDatuma(datum){
            const date = new Date(datum);       //konvertujemo input tip u Date
            return date.toLocaleDateString();
           
        },

        //Pomocna metoda za racunanje broja dana na osnovu pocetnog i krajnjeg datuma u narudzbenici...
        calculateNoOfDays(odDatuma, doDatuma){
            //Konvertovanje datuma u broj dana... 
            const odDat = new Date(odDatuma);       //konvertujemo input tip u Date
            const doDat = new Date(doDatuma);       //konvertujemo input tip u Date

            const NoOfDays = doDat - odDat;         //Dobijeni rezultat je u milisekundama
            const noOFMill = 1000 * 60 * 60 * 24;   //broj milisekundi sa kojima delimo NoOfDays da se dobije broj dana.
            
            return Math.ceil(NoOfDays/noOFMill);
        },

        //Metoda za automatsko racunanje cene rezervacija spram cene apartmana * broj nocenja
		calculatePrice: function (odDatuma, doDatuma, cenaPoDanu, popustZaPreko30Dana) {
            const odabran_br_dana =  this.calculateNoOfDays(odDatuma, doDatuma);
            let popust = 0;
            let ukupnaCena = odabran_br_dana * cenaPoDanu;

            if(odabran_br_dana > 30){
               
                if(popustZaPreko30Dana != null){
                  popust =  ukupnaCena * (popustZaPreko30Dana/100);
                }
                //Ukoliko korisnik odabere neki cenovnik koji ima popust, a zatim odabere cenovnik koji nema popust
                //ostaje upamcen popust prethodnog cenovnika... Zato se resetuje na 0;
                if(popustZaPreko30Dana === null && popust !== 0){
                    popust = 0;
                }

                ukupnaCena = ukupnaCena -  popust;
                return ukupnaCena;
            }

            return ukupnaCena;
        }
    },
    computed: {
        id() {
            return this.$route.params.id; //preuzimam id rezervacije za koju prikazujem detalje.
        }
    },
    created() {
        //ovo radi...
        // if (!localStorage.getItem('token')){
        //     this.$router.push('/login');
        // }

        this.getReservation(); 
    },
}
</script>

<style scoped>
#titleEffect{
    color:gold;
    font-weight: bold;
}
.car-info{
    background-color: white;
}

.car-info b{
    color: #35424a;
}

/* Za cenu */
#showPriceTable{
    width: 100%;
    color:#35424a;
    margin-top:10px;
    font-size: 20px;
    border-bottom: 1px solid lightgrey;
} 

#showPriceTable thead{
    border-bottom: 1px solid lightgrey;
}

#showPriceTable thead th{
    padding-right:15px;
}

                        
#reservation-new label {
  display: block;
  margin: 20px 0 10px;
  font-size: 20px;
  font-weight: bold;
}

#reservation-new textarea {
  display: block;
  width: 100%;
  height: 200px;
  padding:8px;
}

.margTop{
    margin-top: 15px;
}

#reservInfo .h4{
    padding:10px;
    margin-bottom:15px;
    margin-top:35px;
    background-color:gold;
    color:#fff;
    font-weight: bold;
    border-bottom:2px solid #35424a;;
}

#reservInfo b{
    color: #35424a;
}

.reserv_end{
  padding:10px;
  margin-bottom:15px;
  margin-top:35px;
  background-color:#35424a;
  color:#fff;
  font-size: 16px;
  font-weight: bold;
  border-bottom:2px solid gold;
}


</style>