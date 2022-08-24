import {AxiosInstance} from "axios";
import api from "./Api";

export const LoginService = () => ({
    login: async (email: string, password: string): Promise<boolean> => {
        const params = new URLSearchParams();
        params.append('username', email);
        params.append('password', password);
        return api
            .post("login", params)
            .then((response) => {
                console.log(response);
                if (response.headers.access_token) {
                    console.log(response.headers.access_token);
                    localStorage.setItem("accessToken", response.headers.access_token);
                    return true;
                }else{
                    return false;
                }
            }).catch(function (err) {
                return false;
            })
    },
});