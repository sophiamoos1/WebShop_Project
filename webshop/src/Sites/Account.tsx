import React, {useEffect, useState} from "react";
import {User} from "../types/UserType";
import {AccountService} from "../services/AccountService";

export default function Account(){
    const[accountData, setAccountData] = useState([]);
    useEffect(() => {
        AccountService().getAccount().then((data) => {
            setAccountData(data)
        });
    }, []);

    return(
        <div className="account">
            <h1 className="pagetitle">Users</h1>
            {accountData.map((user : User, i: number) => {
                return(
                    <a>{user.name}</a>
                );
            })};
        </div>
    );
}