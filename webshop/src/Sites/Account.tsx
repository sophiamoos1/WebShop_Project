import React, {useEffect, useState} from "react";
import {User} from "../types/UserType";
import {AccountService} from "../services/AccountService";
import "../user-profile.png";
import "../CSS/Account.css";

export default function Account(){
    const[accountData, setAccountData] = useState<User>();
    useEffect(() => {
        AccountService().getAccount().then((data) => {
            setAccountData(data)
        });
    }, []);
    localStorage.setItem("userId", accountData?.userId as string);
    return(
        <div className="account">
            <h3 className="accountTitle">Account</h3>
            <div className="account-card">
            <img src={require("../user-profile.png")} className="profile"/>
            <div className="accountContent">
                <ol>
                    <li>Firstname <span className="firstname">{accountData?.name}</span></li>
                    <li>Lastname <span className="lastname">{accountData?.lastname}</span></li>
                    <li>Email <span className="email-info">{accountData?.email}</span></li>
                    <li>Password <span className="password-info">{accountData?.password}</span></li>
                </ol>
            </div>
                </div>
        </div>
    );
}