// 1. Import axios
import axios from "axios";

// 2. Definisati url i smestiti token u header
const API_URL = "http://localhost:8081";

if(JSON.parse(localStorage.getItem('token')) != null){
    const token = JSON.parse(localStorage.getItem('token'));
    axios.defaults.headers.common['Authorization'] = 'Bearer ' + token.accessToken;
}

//3. Glavni deo: napravi klasu koja ima sve funkciju za pozivanje get/set/put/delet metode kojoj se prosledjuje 
//gore definisana putanja a u cijem headeru se nalazi smesten token za autentifikaciju
class AgentDataService{

    //USER

    //UsrAgentProfile.vue i UsrAgentProfileUpdate.vue
    getAgent(userId){
        return axios.get(`${API_URL}/user/${userId}`);
    }
    updateAgent(profile){
        return axios.put(`${API_URL}/user`, profile);
    }

    //CENOVNIK

    //Cenovnik.vue i OglasiNew.vue
    getAllCenovnik(){
        return axios.get(`${API_URL}/cenovnik/`);
    }

    getCenovnik(id){
        return axios.get(`${API_URL}/cenovnik/${id}`);
    }

    addCenovnik(cenovnik){
        return axios.post(`${API_URL}/cenovnik/`, cenovnik);
    }

    updateCenovnik(cenovnik){
        return axios.put(`${API_URL}/cenovnik/`, cenovnik);
    }

    deleteCenovnik(id){
        return axios.delete(`${API_URL}/cenovnik/${id}`);
    }

    //REZERVACIJA

    //Rezervacija.vue
    getAllRezervacijeOsnovno(){
        return axios.get(`${API_URL}/rezervacija/`);
    }
    updateReservationAccept(status){
        return axios.put(`${API_URL}/rezervacija/status`, status);
    }
    updateReservationDecline(status){
        return axios.put(`${API_URL}/rezervacija/status`, status);
    }
    //RezervacijaNew,vue
    addRezervacija(rezervacija){
        return axios.post(`${API_URL}/rezervacija/`, rezervacija);
    }

    //IzvestajiIStatistika
    getAllRezervacijeExpired(){
        return axios.get(`${API_URL}/rezervacija/expired`);
    }

    //RezervacijaDetails.vue i PorukaOverviewNew.vue i IzvestajiNew
    getRezervacijaDetails(id){
        return axios.get(`${API_URL}/rezervacija/${id}/details`);
    }

    //OGLAS

    //Oglasi.vue
    getAllAgentsOglas(){
        return axios.get(`${API_URL}/oglas/agent`);
    }
    deleteOglas(id){
        return axios.delete(`${API_URL}/oglas/${id}`);
    }
    //OglasiNew.vue
    addOglas(oglas){
        return axios.post(`${API_URL}/oglas/`, oglas);
    }
    //RezervacijaOglasiOverview.vue
    getOglasDetails(id){
        return axios.get(`${API_URL}/oglas/${id}/details`);
    }
    //RezervacijaOglasiOverview.vue
    getAllOglasiDetailsImg(){
        return axios.get(`${API_URL}/oglas/img`);
    }

    //KOMENTARI

    //(AutomobiliComments.vue)
    getAllAutomobiliReview(){
        return axios.get(`${API_URL}/automobilReview/`);
    }
    addKomentar(komentar){
        return axios.post(`${API_URL}/komentar/`, komentar);
    }

    //PORUKE

    addPoruka(poruka){
        return axios.post(`${API_URL}/poruka/`, poruka);
    }

    //IZVESTAJ

    addIzvestaj(izvestaj){
        return axios.post(`${API_URL}/izvestaj/`, izvestaj);
    }

    //AUTOMOBILI

    //Automobili.vue
    getAllAutomobili(){
        return axios.get(`${API_URL}/automobil/`);
    }
    deleteAutomobil(id){
        return axios.delete(`${API_URL}/automobil/${id}/`);
    }
    searchAutomobil(searchedQuery){
        return axios.get(`${API_URL}/search${searchedQuery}`);
    }
    //OglasiNew.vue i AutomobiliEdit.vue
    getAutomobil(id){
        return axios.get(`${API_URL}/automobil/${id}/`);
    }
    //AutomobiliNew.vue
    addAutomobil(automobil){
        return axios.post(`${API_URL}/automobil/`, automobil);
    }
    // IzvestajiIStatistika
    getBestByCategory(category){
        return axios.get(`${API_URL}/automobil/best/${category}`);
    }
    //AutomobiliDetails
    getAutomobilDetails(id){
        return axios.get(`${API_URL}/automobil/${id}/details`);
    }
    //AutomobiliEdit.vue
    updateAutomobil(automobil){
        return axios.put(`${API_URL}/automobil/`, automobil);
    }

    //OPCIJE

    //AutomobilNew.vue
    getAllMarkaAut(){
        return axios.get(`${API_URL}/markaAutomobila/`);
    }
    getAllModelAut(){
        return axios.get(`${API_URL}/modelAutomobila/`);
    }
    getAllKlasaAut(){
        return axios.get(`${API_URL}/klasaAutomobila/`);
    }
    getAllTipMenjaca(){
        return axios.get(`${API_URL}/tipMenjaca/`);
    }
    getAllTipGoriva(){
        return axios.get(`${API_URL}/tipGoriva/`);
    }


    getAgentIzvestaji(){
        return axios.get(`${API_URL}/izvestaj`)
    }
}

export default new AgentDataService();

//import agentDataService from '../services/AgentDataService'