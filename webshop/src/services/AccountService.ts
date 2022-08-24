import api from "./Api";

export const AccountService = () => ({
    getAccount: async() => {
        const data = await api.get('account/17966a6e-1d0e-4fce-a754-badd4540493d').catch((error)=>{throw error})
        return data.data;
    }

})