

import * as React from 'react';
import '../Pictures/logo.png';
import {Link} from "react-router-dom";



export default function NaviBar(){
    return (
        <div className="navbar-navi">
            <a className="nav-title">Random Things</a>
            <a className="nav-context"><Link to="/account/email/sophia.moos@gmail.com" className="Link">Profile</Link></a>
            <a className="nav-bag"><Link  to="/order" className="Link">Bag </Link></a>
            <div className="indicator"></div>
        </div>

    );
}