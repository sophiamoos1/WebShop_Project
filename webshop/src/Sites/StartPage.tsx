import React from 'react';
import '../CSS/StartPage.css';
import {useNavigate} from "react-router-dom";

export default function StartPage(){
    const navigate = useNavigate();
    const handleSubmit = async (event: any) => {
        navigate('/login');

    }
    return(
        <div className="startpage">
            <button className="button-login" onClick={handleSubmit}>Login</button>
            <h2>Random</h2>
            <h2 className="rotate">things</h2>
            <button className="button-register">Register</button>
        </div>
    );
}