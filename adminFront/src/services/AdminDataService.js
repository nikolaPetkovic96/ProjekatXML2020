// 1. Import axios
import axios from "axios";

// 2. Definisati 2 url
const API_URL = "http://localhost:8080";
const ADMIN_API_URL = `${API_URL}/admin`;

//3. Glavni deo: napravi klasu koja ima sve funkciju za pozivanje get/set/put/delet metode kojoj se prosledjuje 
//gore definisana putanja

class AdminDataService{
    confirmRegistrationAdmin(form){
        return axios.post(`${ADMIN_API_URL}/confirm`, form);
    }
    confirmRegistrationAgent(form){
        return axios.post(`${API_URL}/confirm`, form);
    }
}

export default new AdminDataService();