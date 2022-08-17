import {useState} from "react";
import {User} from '../types/UserType';

type Card = {
    item: User;
};
export default function UserCard({item}:Card){
    return(
        <div>
                <div>
                    <ol>
                        <li>
                            Username: <span>{item?.username}</span>
                        </li>
                        <li>
                            Password: <span>{item?.password}</span>
                        </li>
                        <li>
                            ID: <span>{item?.userId}</span>
                        </li>
                    </ol>
                </div>
        </div>
    )

 }