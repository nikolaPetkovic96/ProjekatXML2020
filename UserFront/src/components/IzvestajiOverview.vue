<template>
    <div id="izvestaji-overview">
        <div class="container">
            <h1 style="margin-top:10px;color:#35424a;">Pregled <span id='titleEffect'>Izvestaja</span></h1>
            <hr style='background:#35424a;height:1px;'>
        </div>
        <div class="container">
            <div class="container" id='tabela'>
                <v-data-table class="table">
                    <thead>
                        <tr>
                            <!-- <th>ID Izvestaja</th> -->
                            <th>Predjena kilometraza</th>
                            <th>Tekst izvestaja</th>
                            <!-- <th>ID narudzbenice</th>
                            <th>ID automobila</th>
                            <th>ID rezervacije</th> -->
                            <th>Prekoracena kilometraza</th>
                            <th>Dodatni troskovi</th>
                            <!-- <th>Common data</th> -->
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="izvestaj in listaIzvestaja" v-bind:key='izvestaj.izvestajId'>
                            <!-- <td>{{izvestaj.izvestajId}}</td> -->
                            <td>{{izvestaj.predjenaKilometraza}}</td>
                            <div style="height: 150px; width: 250px; overflow-y: scroll;">
                                <td>{{izvestaj.tekstIzvestaja}}</td>
                            </div>
                            <!-- <td>{{izvestaj.narudzbenicaId}}</td> -->
                            <!-- <td>{{izvestaj.automobilId}}</td>
                            <td>{{izvestaj.rezervacijaId}}</td> -->
                            <td>{{izvestaj.prekoracenaKilometraza}}</td>
                            <td>{{izvestaj.dodatniTroskovi}}</td>
                            <!-- <td>{{izvestaj.commonDataId}}</td> -->
                        </tr>
                    </tbody>
                </v-data-table>
            </div>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'
export default {
    data(){
        return{
            izvestaj:{
                izvestajId: '',
                predjenaKm : '',
                tekstIzvestaja: '',
                narudzbenicaId: '',
                automobilId : '',
                rezervacijaId : '',
                prekoracenaKm : '',
                dodatniTroskovi : '',
                // commonDataId : ''
            },
            listaIzvestajaTemp : [
                {
                    izvestajId: '123',
                    predjenaKm:'21321',
                    tekstIzvestaja: 'Nasumicni tekst izvestaja',
                    narudzbenicaId: '21',
                    automobilId : '442',
                    rezervacijaId : '633',
                    prekoracenaKm : '340',
                    dodatniTroskovi : '15000',
                },
                {
                    izvestajId: '321',
                    predjenaKm:'421',
                    tekstIzvestaja: 'Nasumicni tekst izvestaja koji je neuobicajeno dugacak s obzirom da je rec o primeru koji sluzi za testiranje. Duzina izvestaja pravda se zeljom da se prikaze ispravnost slajdera koji sluzi za iscitavanje teksta u celosti.',
                    narudzbenicaId: '532',
                    automobilId : '11',
                    rezervacijaId : '3356',
                    prekoracenaKm : '5322',
                    dodatniTroskovi : '1399',
                }
            ],
            listaIzvestaja:[

            ]
        }
    },
    methods:{
        getIzvestaji(){
            UserDataService.getAgentIzvestaji().then(response => {
                console.log("ODGOVOR SA BEKA")
                this.listaIzvestaja = response.data;
            });
        }
    },
    created(){
        if(JSON.parse(localStorage.getItem('token')) == null){
            this.$router.push(`/login`);
        }else{
            this.getIzvestaji();
        }
    }
}
</script>

<style scoped>
#titleEffect{
  color:#FF8C00;
  font-weight: bold;
}
</style>