import {AxiosInstance} from "axios";
import {defaultAxiosInstance} from "./Api";


export const UserService = (api: AxiosInstance = defaultAxiosInstance) => ({
    getAllUsers: async() => {
        const data = await api.get("user/").catch((error)=>{throw error})
        return data.data;
    }

})