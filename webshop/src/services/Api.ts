import axios, { AxiosInstance } from "axios";
const BASE_AUTH_URL = `http://localhost:8080/`;
export const defaultAxiosInstance: AxiosInstance = axios.create({
    baseURL: BASE_AUTH_URL,
});


defaultAxiosInstance.interceptors.request.use(
    (request) => {
        //no expiration is checked.
        const token = localStorage.getItem("accessToken");
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