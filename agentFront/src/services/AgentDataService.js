// 1. Import axios
import axios from "axios";

// 2. Definisati url i smestiti token u header
const API_URL = "http://localhost:8080";

const token = JSON.parse(localStorage.getItem('token'));
axios.defaults.headers.common['Authorization'] = 'Bearer ' + token.accessToken;

//3. Glavni deo: napravi klasu koja ima sve funkciju za pozivanje get/set/put/delete metode kojoj se prosledjuje 
//gore definisana putanja a u cijem headeru se nalazi smesten token za autentifikaciju
class AgentDataService{

    //User

    //UsrAgentProfile i UsrAgentProfileUpdate
    getAgent(userId){
        return axios.get(`${API_URL}/user/${userId}`);
    }

    //UsrAgentProfile i UsrAgentProfileUpdate
    updateAgent(profile){
        return axios.put(`${API_URL}/user`, profile);
    }

    //Cenovnik
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

    //Rezervacija
    getAllRezervacijeOsnovno(){
        return axios.get(`${API_URL}/rezervacija/`);
    }

    //Oglas
    getAllAgentsOglas(){
        return axios.get(`${API_URL}/oglas/agent`)
    }

    //Oglas
    deleteOglas(id){
        return axios.delete(`${API_URL}/oglas/${id}`)
    }

    //Komentari 
    
    //(AutomobiliComments.vue)
    getAllAutomobiliReview(){
        return axios.get(`${API_URL}/automobilReview/`);
    }

    addKomentar(komentar){
        return axios.post(`${API_URL}/komentar/`, komentar);
    }
}

export default new AgentDataService();

//import agentDataService from '../services/AgentDataService'