import axios from "axios"

const API_URL = "http://localhost:2020";
const LOGINREG_API_URL = `${API_URL}/loginreg-service/api/user`;
const CAR_API_URL = `${API_URL}/automobil-service`; //npr: http://localhost:2020/automobil-service/brand
const REVIEW_API_URL = `${API_URL}/rating-service`;
const RESERVATION_API_URL = `${API_URL}/reservation-service`
const AD_API_URL = `${API_URL}/oglas-service`
const MESSAGE_API_URL = `${API_URL}/message-service`

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
    deleteAutomobil(id){
        return axios.delete(`${CAR_API_URL}/car/${id}`);
    }
    updateAutomobil(automobil){
        console.log("Tu");
        return axios.put(`${CAR_API_URL}/car/`, automobil);
    }

    getAutomobil(id){
        return axios.get(`${CAR_API_URL}/car/${id}`);
    }

    //CENOVNIK
    //Cenovnik.vue i OglasiNew.vue
    getAllCenovnik(){
        return axios.get(`${AD_API_URL}/price/`);
    }
    getCenovnik(id){
        return axios.get(`${AD_API_URL}/price/${i/userd}`);
    }
    addCenovnik(cenovnik){
        console.log('Novi cenovnik: ' + JSON.stringify(cenovnik));
        return axios.post(`${AD_API_URL}/price/`, cenovnik);
    }
    updateCenovnik(cenovnik){
        console.log('Edit cenovnik: ' + JSON.stringify(cenovnik));
        return axios.put(`${AD_API_URL}/price/`, cenovnik);
    }
    deleteCenovnik(id){
        return axios.delete(`${AD_API_URL}/price/${id}`);
    }

    //REZERVACIJE
    getAllRezervOsnovnoUser(){
        return axios.get(`${RESERVATION_API_URL}/reservation/user`);
    }
    getAllRezervOsnovnoAgent(){
        return axios.get(`${RESERVATION_API_URL}/reservation/agent`);
    }
    getRezervacijaDetails(id){
        return axios.get(`${RESERVATION_API_URL}/reservation/${id}/details`);
    }
    //Svi isto gadjaju (razdvojeno zbog preglednosti)
    updateReservationStatusAccept(status){
        return axios.put(`${RESERVATION_API_URL}/reservation/status`, status);
    }
    updateReservationStatusCancel(status){
        return axios.put(`${RESERVATION_API_URL}/reservation/status`,status);
    }
    updateReservationStatusTest(status){
        return axios.put(`${RESERVATION_API_URL}/reservation/status`,status);
    }
    updateReservationStatusPaid(status){
        return axios.put(`${RESERVATION_API_URL}/reservation/status`,status);
    }
    //IzvestajiAgent.vue
    getAllRezervacijeExpiredAgent(){
        return axios.get(`${RESERVATION_API_URL}/reservation/agent/expired`);
    }
    //AutomobilCommentUser.vue
    getAllRezervacijeExpiredUser(){
        return axios.get(`${RESERVATION_API_URL}/reservation/user/expired`);
    }

    addRezervacija(rezervacija){
        return axios.post(`${RESERVATION_API_URL}/reservation/`, rezervacija);
    }
    //IzvestajNew.vue
    addIzvestaj(izvestaj){
        return axios.post(`${RESERVATION_API_URL}/report/`, izvestaj);
    }
    
    //PORUKA:
    addPoruka(poruka){
        return axios.post(`${MESSAGE_API_URL}/message`, poruka);
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

    //Reviews(Komentari i ocene)
    addKomentar(komentar){
        return axios.post(`${REVIEW_API_URL}/comment/`, komentar);
    }
    addOcena(ocena){
        return axios.post(`${REVIEW_API_URL}/rating/`, ocena);
    }

    //OGLASI
    getAllUsersOglas(){        
        return axios.get(`${AD_API_URL}/ads/agent`);
    }

    deleteOglas(id){
        return axios.delete(`${AD_API_URL}/ads/${id}`);
    }

    addOglas(oglas){
        console.log('oglas: ');
        console.log(JSON.stringify(oglas) );
        return axios.post(`${AD_API_URL}/ads/`, oglas);
    }
    //getAllAutomobiliAgent()
    searchOglas(searchedQuery){
        console.log(`${AD_API_URL}/ads/search${searchedQuery}`);
        return axios.get(`${AD_API_URL}/ads/search${searchedQuery}`);
    }
    getAllOglas(){
        return axios.get(`${AD_API_URL}/ads/img`);
    }
    getOglasDetails(id){
        console.log('ID: ' + id);
        return axios.get(`${AD_API_URL}/ads/${id}/details`);
    }

    getNoOfUsersAds(){
        return axios.get(`${AD_API_URL}/ads/numberOfAds`);
    }

    getAllPermissions(){
        return axios.get(`${LOGINREG_API_URL}/getPermissions`);
    }

}

export default new UserDataService();
//import UserDataService from '../services/UserDataService'