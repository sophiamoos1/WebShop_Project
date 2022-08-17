import api from "./Api";

export const UserService = () => ({
    getAllUsers: async() => {
        const data = await api.get("user/").catch((error)=>{throw error})
        return data.data;
    }

})