import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import doclogo from '../images/doctor.jpg';
import axios from 'axios'
import EditDoc from './editdoc';

class AppointmentStatus extends Component {
    state = {
        appointmentId : "" ,
        appointmentBodyFlag: 0,
        appointmentBody : ""
      }
    
    
    searchAppointmentById = () => {
       axios.get(`http://localhost:9050/appointment/${this.state.appointmentId}`)
            .then((res)=>{
                if(res.status === 200)
                {
                    alert("Loading...");
                    this.setState({
                        appointmentBodyFlag : 1,
                        appointmentBody : res.data
                    })
                    console.log(res)
                }
            })
            .catch((err) => {
                alert(err.response.data.message)
            })
    }


    render()
    {  
        var contentBody = ""
        if(this.state.appointmentBodyFlag === 1){
            contentBody = 
            <div>
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>Appointment ID</th>
                        <td>{this.state.appointmentBody.appointmentId}</td>
                    </tr>
                    <tr>
                        <th>Date</th>
                        <td>{this.state.appointmentBody.appDate}</td>
                    </tr>
                    <tr>
                        <th>Time</th>
                        <td>{this.state.appointmentBody.appTime}</td>
                    </tr>
                    <tr>
                        <th>Patient</th>
                        <td>{this.state.appointmentBody.patientId}</td>
                    </tr>
                    <tr>
                        <th>Doctor</th>
                        <td>{this.state.appointmentBody.doctorId}</td>
                    </tr>
                    <tr>
                        <th>Category</th>
                        <td>{this.state.appointmentBody.category}</td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>{this.state.appointmentBody.description}</td>
                    </tr>
                    <tr>
                        <th>Status</th>
                        <td>{this.state.appointmentBody.status}</td>
                    </tr>
                </table>
            </div>
           
        }

        return (
            <div className="container">
            <hr />
            <a href="/" ><button align="left" className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h5 align="center" className="my-1"><u>Appointment Status</u></h5>
            <div className="form-row">
                <div className="form-group col-12">
                     <input className="form-control" name="appointmentId" value={this.state.appointmentId} onChange={(e)=>{this.setState({appointmentId : e.target.value})}}/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-12">
                    <button className="btn btn-primary" style={{width : 100 + '%'}} onClick={this.searchAppointmentById}>Search</button>
                </div>
            </div>
            <div>
                {contentBody}
            </div>
        </div>
        )
        
    }
}

export default AppointmentStatus;