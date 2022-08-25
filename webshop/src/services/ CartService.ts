import api from "./Api";

export const CartService = () => ({
    getCart: async() => {
        const id = localStorage.getItem("userId");
        let key = null;
        if(id){
            key = id;
        }
        const data = await api.get(`account/order/${key}`).catch((error)=>{throw error})
        return data.data;
    }

})