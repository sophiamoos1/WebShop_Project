import api from "./Api";

export const AccountService = () => ({
    getAccount: async() => {
        const token = localStorage.getItem("accessToken");
        let mail = null;
        if (token) {
            const head = JSON.parse(atob(token.split(".")[0]));
            const email = head.email;
            console.log(email);
            mail = email;
        }
        const data = await api.get(`account/email/${mail}`).catch((error)=>{throw error})
        return data.data;
    }

})