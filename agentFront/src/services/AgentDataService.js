// 1. Import axios
import axios from "axios";

// 2. Definisati 2 url
const API_URL = "http://localhost:8080";
const AGENT_API_URL = `${API_URL}/agent`;


// const proxyurl = "https://cors-anywhere.herokuapp.com/"; //radi vraca 404

//3. Glavni deo: napravi klasu koja ima sve funkciju za pozivanje get/set/put/delet metode kojoj se prosledjuje 
//gore definisana putanja

class AgentDataService{
    
    agentAddNewAd(newVehicle){
        return axios.post(`${API_URL}/addAd`, newVehicle);
    }
    agentShowAllAds(userId){
        return axios.get(`${API_URL}/showAllAds`, userId);
    }
    agentLoginUser(user){
        return axios.get(`${API_URL}/loginUser`, user);
    }
    agentRegistration(agentData){
        return axios.post(`${API_URL}/pacijentLogin`, agentData);
    }
}

export default new AgentDataService();