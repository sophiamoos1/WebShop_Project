
import {AxiosInstance} from "axios";
import api from "./Api";

export const AllProductsService = () => ({
    getAllProducts: async() => {
        const data = await api.get("product/all").catch((error)=>{throw error})
        return data.data;
    }

})