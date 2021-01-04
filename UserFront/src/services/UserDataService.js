import axios from "axios"

const API_URL = "http://localhost:2020";
const LOGINREG_API_URL = `${API_URL}/loginreg-service/api/user`;
const CAR_API_URL = `${API_URL}/automobil-service`; //npr: http://localhost:2020/automobil-service/brand
const REVIEW_API_URL = `${API_URL}/rating-service`;

//Za svaki zahtev se dodaje token za autorizaciju i 
//autenitifikaciju ulogovanog korisnika u zaglavlje upita
if(JSON.parse(localStorage.getItem('token')) != null){
    const token = JSON.parse(localStorage.getItem('token'));
    axios.defaults.headers.common['Authorization'] = 'Bearer ' + token.accessToken;
}

class UserDataService{
    
    //USER
    
    //LoginForm.vue
    userLoginUser(form){
        return axios.post(`${LOGINREG_API_URL}/login`, form);
    }
    userRegistration(form){
        return axios.post(`${LOGINREG_API_URL}/register`, form);
    }
    


    // PROFIL
    // UserProfile.vue, USerProfileUpdate.vue
    getUser(id){
        console.log('getUser: ' + id);
        return axios.get(`${LOGINREG_API_URL}/profile`);
    }
    //UserProfile.vue 
    updateUserProfile(profile){
        return axios.put(`${LOGINREG_API_URL}/profile/update`, profile);
    }

    //AUTOMOBILI

    // Automobili.vue
    searchAutomobil(searchedQuery){
        return axios.get(`${CAR_API_URL}/search${searchedQuery}`);
    }
    //AutomobiliAgent.vue
    getAllAutomobiliAgent(){
        return axios.get(`${CAR_API_URL}/car/agent`);
    }

    //SIFRARNIK
    //Automobili.vue

    getAllMarkaAut(){
        return axios.get(`${CAR_API_URL}/brand`);
    }
    getAllModelAut(){
        return axios.get(`${CAR_API_URL}/model`);
    }
    getAllKlasaAut(){
        return axios.get(`${CAR_API_URL}/class`);
    }
    getAllTipMenjaca(){
        return axios.get(`${CAR_API_URL}/transmission`);
    }
    getAllTipGoriva(){
        return axios.get(`${CAR_API_URL}/fuel`);
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
     //Oglasi.vue
     getAllUsersOglas(){
        return axios.get(`${API_URL}/oglas/user`)
    }
    //IZVESTAJ
    addIzvestaj(izvestaj){
        return axios.post(`${API_URL}/izvestajAgent/`, izvestaj);
    }
}

export default new UserDataService();
//import UserDataService from '../services/UserDataService'