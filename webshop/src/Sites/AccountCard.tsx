import "../user-profile.png";
import {User} from "../types/UserType";

type Useraccount = {
    user : User;
}
export default function AccountCard({user}:Useraccount){
    return (
        <div className="accountCard">
            <img src="../user-profile.png"/>
            <div className="accountContent">
                <h3 className="accountTitle">Account</h3>
                <ol>
                    <li><span className="firstname">{user?.name}</span></li>
                    <li><span className="lsstname">{user?.lastname}</span></li>
                    <li><span className="email">{user?.email}</span></li>
                    <li><span className="password">{user?.password}</span></li>
                </ol>
            </div>

        </div>
    );

}