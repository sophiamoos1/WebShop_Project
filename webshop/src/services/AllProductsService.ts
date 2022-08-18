
import {AxiosInstance} from "axios";
import {defaultAxiosInstance} from "./Api";

export const AllProductsService = (api : AxiosInstance = defaultAxiosInstance) => ({
    getAllProducts: async() => {
        const data = await api.get("product/all").catch((error)=>{throw error})
        return data.data;
    }

})