import axios, { AxiosInstance } from "axios";
const BASE_AUTH_URL = `http://localhost:8080/`;
const api: AxiosInstance = axios.create({
    baseURL: BASE_AUTH_URL,
});
export default api;