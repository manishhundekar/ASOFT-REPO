import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import axios from 'axios'

class Navbar extends Component {

    render()
    {
        return (
            <div>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a className="navbar-brand font-weight-bold" href="index.html">Chikitsa Hospital</a>

        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarContent">
            <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                    <a className="nav-link" href="index.html">Home</a>
                </li>
                <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Appointment
                    </a>
                    <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a className="dropdown-item" href="#">New Appointment</a>
                        <a className="dropdown-item" href="#">Appointment Status</a>
                        <a className="dropdown-item" href="#">Modify Appointment</a>
                    </div>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#">Patient Records</a>
                </li>
                <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Patient
                    </a>
                    <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a className="dropdown-item" href="#">New Patient</a>
                        <a className="dropdown-item" href="#">Find Patient</a>
                        <a className="dropdown-item" href="#">Edit Patient</a>
                    </div>
                </li>
                <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Doctor
                    </a>
                    <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a className="dropdown-item" href="#"><i className="fas fa-user-plus"></i> New Doctor</a>
                        <a className="dropdown-item" href="#">View Doctor</a>
                        <a className="dropdown-item" href="#">Edit Doctor</a>
                    </div>
                </li>
                <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Department
                    </a>
                    <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a className="dropdown-item" href="#">New Department</a>
                        <a className="dropdown-item" href="#">View Department</a>
                        <a className="dropdown-item" href="#">Edit Department</a>
                    </div>
                </li>
                <li className="nav-item">
                    <a className="nav-link" onClick={this.props.logout}>Logout</a>
                </li>
            </ul>
        </div>
        
    </nav>
    
    </div>
        )
    }
}

export default Navbar;