import axios from "axios";

const API_URL = "http://localhost:8090/api/auth/";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "signin", {
        username,
        password
      })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(username, email,phone, password) {
    return axios.post(API_URL + "signup", {
      username,
      email,
      phone,
      password
    });
  }
  forgot(email) {
    return axios.post(API_URL + "forgot_password", {
  
      email,
     
    });
  }
  reset(password) {
    return axios.post(API_URL + "reset_password", {
  
      password,
     
    });
  }
  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }
}

export default new AuthService();
