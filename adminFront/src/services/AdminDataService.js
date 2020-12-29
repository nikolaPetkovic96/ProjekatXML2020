// 1. Import axios
import axios from "axios";

// 2. Definisati 2 url
const API_URL = "http://localhost:2020";
const LOGINREG_API_URL = `${API_URL}/loginreg-service/api/user`;
const CAR_API_URL = `${API_URL}/automobil-service`; //npr: http://localhost:2020/automobil-service/brand
//3. Glavni deo: napravi klasu koja ima sve funkciju za pozivanje get/set/put/delet metode kojoj se prosledjuje 
//gore definisana putanja

if(JSON.parse(localStorage.getItem('token')) != null){
    const token = JSON.parse(localStorage.getItem('token'));
    axios.defaults.headers.common['Authorization'] = 'Bearer ' + token.accessToken;
}

class AdminDataService{

    //USERI

    //AdminUserAuthorities.vue
    getAllUsers(){
        const request = "?type=user";
        // const request = "";
        return axios.get(`${LOGINREG_API_URL}/${request}`);
    }
    //AdminRegAdmin.vue
    addAdmin(admin){
        return axios.post(`${LOGINREG_API_URL}/register-admin`, admin);
    }
    //AdminAgent.vue
    addAgent(agent){
        return axios.post(`${LOGINREG_API_URL}/register-agent`, agent);
    }
    //RegFomrAdmin.vue
    confirmRegistrationAdmin(admin){
        return axios.post(`${LOGINREG_API_URL}/activate`, admin);
    }
    //RegFomrAgent.vue
    confirmRegistrationAgent(agent){
        return axios.post(`${LOGINREG_API_URL}/activate`, agent);
    }
    //LoginForm.vue
    adminLoginUser(form){
        return axios.post(`${LOGINREG_API_URL}/login`, form);
    }

    // PROFIL
    // AdminProfile.vue
    getAdmin(id){
        console.log('getAdmin: ' + id);
        return axios.get(`${LOGINREG_API_URL}/profile`);
    }
    //AdminProfile.vue i AdminProfileUpdate.vue
    updateAdminProfile(profile){
        return axios.put(`${LOGINREG_API_URL}/profile/update`, profile);
    }


    //SIFRARNIK
    //AdminSifrarnik.vue

    //MARKA
    getAllMarkaAut(){
        return axios.get(`${CAR_API_URL}/brand`);
    }
    deleteMarkaAut(id){
        return axios.delete(`${CAR_API_URL}/brand/${id}`);
    }
    addMarkaAut(newObject){
        return axios.post(`${CAR_API_URL}/brand/`, newObject);
    }
    updateMarkaAut(updatedObject){
        return axios.put(`${CAR_API_URL}/brand/`, updatedObject);
    }

    //MODEL
    getAllModelAut(){
        return axios.get(`${CAR_API_URL}/model`);
    }
    deleteModelAut(id){
        return axios.delete(`${CAR_API_URL}/model/${id}`);
    }
    addModelAut(newObject){
        return axios.post(`${CAR_API_URL}/model/`, newObject);
    }
    updateModelAut(updatedObject){
        return axios.put(`${CAR_API_URL}/model/`, updatedObject);
    }

    //KLASA
    getAllKlasaAut(){
        return axios.get(`${CAR_API_URL}/class`);
    }
    deleteKlasaAut(id){
        return axios.delete(`${CAR_API_URL}/class/${id}`);
    }
    addKlasaAut(newObject){
        return axios.post(`${CAR_API_URL}/class/`, newObject);
    }
    updateKlasaAut(updatedObject){
        return axios.put(`${CAR_API_URL}/class/`, updatedObject);
    }

    //TIP MENJACA
    getAllTipMenjaca(){
        return axios.get(`${CAR_API_URL}/transmission`);
    }
    deleteTipMenjaca(id){
        return axios.delete(`${CAR_API_URL}/transmission/${id}`);
    }
    addTipMenjaca(newObject){
        return axios.post(`${CAR_API_URL}/transmission/`, newObject);
    }
    updateTipMenjaca(updatedObject){
        return axios.put(`${CAR_API_URL}/transmission/`, updatedObject);
    }

    //TIP GORIVA
    getAllTipGoriva(){
        return axios.get(`${CAR_API_URL}/fuel`);
    }
    deleteTipGoriva(id){
        return axios.delete(`${CAR_API_URL}/fuel/${id}`);
    }
    addTipGoriva(newObject){
        return axios.post(`${CAR_API_URL}/fuel/`, newObject);
    }
    updateTipGoriva(updatedObject){
        return axios.put(`${CAR_API_URL}/fuel/`, updatedObject);
    }


}

export default new AdminDataService();
//import adminDataService from '../services/AdminDataService'