import {AxiosInstance} from "axios";
import {defaultAxiosInstance} from "./Api";

export const LoginService = (api: AxiosInstance = defaultAxiosInstance) => ({
    login(email: string, password: string) {
        return api
            .post("/login", {
                email,
                password,
            })
            .then((response) => {
                if (response.data.accessToken) {
                    localStorage.setItem("accessToken", response.data.accessToken);
                    return true;
                }else{
                    return false;
                }
            }).catch(function (err) {
                return false;
            })
    },
});