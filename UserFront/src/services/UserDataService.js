import axios from "axios"

const API_URL = "http://localhost:2020";
const LOGINREG_API_URL = `${API_URL}/loginreg-service/api/user`;
const CAR_API_URL = `${API_URL}/automobil-service`; //npr: http://localhost:2020/automobil-service/brand
const REVIEW_API_URL = `${API_URL}/rating-service`;
const RESERVATION_API_URL = `${API_URL}/reservation-service`

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
    // UserProfile.vue, UserProfileUpdate.vue
    getUser(id){
        console.log('getUser: ' + id);
        return axios.get(`${LOGINREG_API_URL}/profile`);
    }
    //UserProfile.vue 
    updateUserProfile(profile){
        return axios.put(`${LOGINREG_API_URL}/profile/update`, profile);
    }

     //AUTOMOBILI
    //ZA USERA KASNIJE
    // Automobili.vue
    // searchAutomobil(searchedQuery){
    //     return axios.get(`${CAR_API_URL}/search${searchedQuery}`);
    // }
    //AutomobiliAgent.vue
    getAllAutomobiliAgent(){
        return axios.get(`${CAR_API_URL}/car/agent`);
    }
    searchAgentModeCar(searchedQuery){
        console.log(`${CAR_API_URL}/car/agent/search${searchedQuery}`);
        return axios.get(`${CAR_API_URL}/car/agent/search${searchedQuery}`);
    }
    addAutomobil(automobil){
        return axios.post(`${CAR_API_URL}/car/agent/`, automobil);
    }
    // AutomobiliDetails.vue OglasiAgentNew
    getAutomobilDetails(id){
        return axios.get(`${CAR_API_URL}/car/${id}/details/`);
    }
    getAutomobilDetailsReviews(id){
        console.log('review id: ' + id);
        return axios.get(`${REVIEW_API_URL}/review/${id}`);
    }

      //CENOVNIK
    //Cenovnik.vue i OglasiNew.vue
    getAllCenovnik(){
        return axios.get(`${CAR_API_URL}/price/`);
    }
    getCenovnik(id){
        return axios.get(`${CAR_API_URL}/price/${id}`);
    }
    addCenovnik(cenovnik){
        console.log('Novi cenovnik: ' + JSON.stringify(cenovnik));
        return axios.post(`${CAR_API_URL}/price/`, cenovnik);
    }
    updateCenovnik(cenovnik){
        console.log('Edit cenovnik: ' + JSON.stringify(cenovnik));
        return axios.put(`${CAR_API_URL}/price/`, cenovnik);
    }
    deleteCenovnik(id){
        return axios.delete(`${CAR_API_URL}/price/${id}`);
    }


    // getAllAutomobiliReview(){
    //     return axios.get(`${REVIEW_API_URL}/comment`)
    // }
    // getAllRezervacijeOsnovno(){
    //     return axios.get(`${RESERVATION_API_URL}/rating`)
    // }

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

    //Reviews(Komentari i ocene)
    addKomentar(komentar){
        console.log('komentar: ' + JSON.stringify(komentar) );
        return axios.post(`${REVIEW_API_URL}/comment/`, komentar);
    }

}

export default new UserDataService();
//import UserDataService from '../services/UserDataService'