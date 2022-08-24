import axios, { AxiosInstance } from "axios";
import { request } from "http";
const BASE_AUTH_URL = `http://localhost:8080/`;


const api: AxiosInstance = axios.create({
    baseURL: BASE_AUTH_URL,
});


api.interceptors.request.use(
    (request) => {
        //no expiration is checked.
        const token = localStorage.getItem("accessToken");
        console.log(token);
        if (token) {
            if (request.headers) {
                request.headers.Authorization = "Bearer " + token;
            }else{
                return false;
            }
        }
        return request;
    },
    (error) => {
        return Promise.reject(error);
    }
);

export default api;
/*defaultAxiosInstance.interceptors.request.use(
    (request) => {
        //no expiration is checked.
        const token = localStorage.getItem("accessToken");
        console.log(token);
        if (token) {
            if (request.headers) {
                request.headers.Authorization = "Bearer " + token;
            }else{
                return false;
            }
        }
        return request;

    },
    (error) => {
        return Promise.reject(error);
    }
);*/