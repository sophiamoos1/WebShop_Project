import '../CSS/NavBar.css';

import * as React from 'react';
import '../Pictures/logo.png';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import {Link} from "react-router-dom";



export default function NaviBar(){
    return (
        <div className="navbar-navi">
            <a className="nav-title">Random Things</a>
            <a className="nav-context"><Link to="/account/17966a6e-1d0e-4fce-a754-badd4540493d">Profile</Link></a>
        </div>

    );
}