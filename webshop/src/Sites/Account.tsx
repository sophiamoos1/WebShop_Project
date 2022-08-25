import React, {useEffect, useState} from "react";
import {User} from "../types/UserType";
import {AccountService} from "../services/AccountService";
import "../user-profile.png";
import AccountCard from "./AccountCard";

export default function Account(){
    const[accountData, setAccountData] = useState<User>();
    useEffect(() => {
        AccountService().getAccount().then((data) => {
            setAccountData(data)
        });
    }, []);

    return(
        <div className="account">
            <img src={require("../user-profile.png")}/>
            <div className="accountContent">
                <h3 className="accountTitle">Account</h3>
                <ol>
                    <li><span className="firstname">{accountData?.name}</span></li>
                    <li><span className="lsstname">{accountData?.lastname}</span></li>
                    <li><span className="email-info">{accountData?.email}</span></li>
                    <li><span className="password-info">{accountData?.password}</span></li>
                </ol>
            </div>

        </div>
    );
}