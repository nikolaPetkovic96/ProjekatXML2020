import axios from "axios"

const API_URL = "http://localhost:8080";
const USER_API_URL = `${API_URL}/user`;

class UserDataService{
    userLoginUser(user){
        return axios.get(`${API_URL}/userLogin`, user)
    }
    verifyUsera(user){
        return axios.get(`${API_URL}/verifyUser`, user) // ?
    }
}

export default new UserDataService();