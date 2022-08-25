import {AxiosInstance} from "axios";
import api from "./Api";


export const UserService = () => ({
    getAllUsers: async() => {
        const token = localStorage.getItem("accessToken");
        if (token) {
            const head = JSON.parse(atob(token.split(".")[0]));
            console.log(head);
        }

        const data = await api.get("user/").catch((error)=>{throw error})
        return data.data;
    }

})