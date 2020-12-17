import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
import doclogo from '../images/doctor.jpg';
import patientlogo from '../images/patient.png';
import patrec from '../images/case.webp';
import appointlogo from '../images/appointments.png';
//import axios from 'axios'

class MainPage extends Component {

    render()
    {
        return (
            <div className="container">
            <div id="home">
            <hr />
            <h2 align="center">Welcome to the Dashboard</h2>
            <hr />
            <div className="row">
                <div className="card col-md-3 col-sm-6">
                    <img src={appointlogo} className="card-img-top" style={{height:200 + 'px'}} alt=""/>
                    <div className="card-body">
                        <h5 className="card-title">Appointments</h5>
                        <a href="/newappointment" className="btn btn-primary my-1" style={{width: 100 +'%'}}>New Appointment</a>
                        <a href="/appointmentstatus" className="btn btn-primary my-1" style={{width: 100 +'%'}}>Appointment Status</a>
                        <a href="/manageappointment" className="btn btn-primary my-1" style={{width: 100 +'%'}}>Manage Appointment</a>
                    </div>
                </div>
                <div className="card col-md-3 col-sm-6">
                    <img src={patrec} className="card-img-top" style={{height:200 + 'px'}} alt=""/>
                    <div className="card-body">
                        <h5 className="card-title">Patient Records</h5>
                        <a href="/patientrecords" className="btn btn-primary my-1" style={{width: 100 +'%'}}>View Patient Records</a>
                        <a href="/showadmitted" className="btn btn-primary my-1" style={{width: 100 +'%'}}>Show Admitted Patients</a>
                        <a href="/showoutpatient" className="btn btn-primary my-1" style={{width: 100 +'%'}}>Show Out-Patient List</a>
                    </div>
                </div>
                <div className="card col-md-3 col-sm-6">
                    <img src={patientlogo} className="card-img-top img-fluid" style={{height:200 + 'px'}} alt=""/>
                    <div className="card-body">
                        <h5 className="card-title">Patient</h5>
                        <a href="/searchpatient" className="btn btn-primary my-1" style={{width: 100 +'%'}}>Search Patient</a>
                        <a href="/newpatient" className="btn btn-primary my-1" style={{width: 100 +'%'}}>New Admission</a>
                        <a href="/viewpat" className="btn btn-primary my-1" style={{width: 100 +'%'}}>Manage Patient Details</a>
                    </div>
                </div>
                <div className="card col-md-3 col-sm-6">
                    <img src={doclogo} className="card-img-top img-fluid" style={{height:200 + 'px'}}  alt=""/>
                    <div className="card-body">
                        <h5 className="card-title">Doctor</h5>
                        <a href="/searchdoc" className="btn btn-primary my-1" style={{width: 100 +'%'}}>Search Doctor</a>
                        <a href="/adddoc"  className="btn btn-primary my-1" style={{width: 100 +'%'}}>Add Doctor</a>
                        <a href="/viewdoc"  className="btn btn-primary my-1" style={{width: 100 +'%'}}>View All Doctors</a>
                    </div>
                </div>
            </div>
        </div>
        </div>
        )
    }
}

export default MainPage;