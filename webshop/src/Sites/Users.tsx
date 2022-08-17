import React, {useEffect, useState} from 'react';
import '../CSS/Users.css';
import {User} from '../types/UserType';
import {UserService} from "../services/UserService";
import UserCard from "./UserCard";

export default function Users(){
    const[userData, setUserData] = useState([]);
    useEffect(() => {
        UserService().getAllUsers().then((data) => {
            setUserData(data)
        });
    }, []);

    return(
        <div className="userPage">
        <h1 className="pagetitle">Users</h1>
            {userData.map((user : User, i: number) => {
                return(<UserCard item={user}/>);
            })};
        </div>
    );
}