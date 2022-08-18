import React from 'react';
import '../CSS/StartPage.css';

export default function StartPage(){
    return(
        <div className="startpage">
            <button className="button-login">Login</button>
            <h2>Random</h2>
            <h2 className="rotate">things</h2>
            <button className="button-register">Register</button>
        </div>
    );
}