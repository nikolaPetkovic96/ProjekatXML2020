import axios from "axios"

const API_URL = "http://localhost:8080";
const USER_API_URL = `${API_URL}/user`;

class UserDataService{
    getUser(userId){
        return axios.get(`${API_URL}/user/${userId}`);
    }
    updateUser(profile){
        return axios.put(`${API_URL}/user`, profile);
    }
    addPoruka(msg){
        return axios.post(`${API_URL}/poruka`, msg)
    }
    getRezervacijaDetails(id){
        return axios.get(`${API_URL}/rezervacija/${id}/details`)
    }
    getAllRezervacijeOsnovno(){
        return axios.get(`${API_URL}/rezervacija/`)
    }
    searchCarsFiltered(filtered){
        return axios.post(`${API_URL}/searchCars`, filtered)
    }
}

export default new UserDataService();