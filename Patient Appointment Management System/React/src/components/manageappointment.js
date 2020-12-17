import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import doclogo from '../images/doctor.jpg';
import axios from 'axios'

class ManageAppointment extends Component {
    /* constructor(){
        super();
        this.forceUpdateHandler = this.forceUpdateHandler.bind(this);
      }; */
      
    state = {
        appointmentList: []
      }
    
    forceUpdateHandler = ()=>{
        this.forceUpdate();
      };

    componentDidMount(){
    /* alert("re")
    axios.get("http://localhost:9050/appointment").then(res=>this.setState({appointmentList:res.data})) */
    }

    confirmAppointment = (e,appointmentId) => {
        axios.put(`http://localhost:9050/appointment/confirm/${appointmentId}`).then(res=>{if(res.data.status==="Confirmed"){alert("Appointment Confirmed");console.log(res);}})
    }

    cancelAppointment = (e,appointmentId) => {
        axios.put(`http://localhost:9050/appointment/cancel/${appointmentId}`).then(res=>{if(res.data.status==="Cancelled"){alert("Appointment Cancelled");console.log(res);}})
    }

   
    render()
    {  
        axios.get("http://localhost:9050/appointment").then(res=>this.setState({appointmentList:res.data}))
        return (
            <div>
            <hr />
            <a href="/" ><button align="left" className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h3 align="center" className="my-1">All Appointments</h3>
            <table className="table table-bordered table-hover">
                <thead className="thead-light">
                    <tr>
                        <th>Appointment ID</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Patient</th>
                        <th>Doctor</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Status</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                   { 
                   this.state.appointmentList.map((app) =>(
                       <tr key={app.appointmentId}>
                           <td>{app.appointmentId}</td>
                           <td>{app.appDate}</td>
                           <td>{app.appTime}</td>
                           <td>{app.patientId}</td>
                           <td>{app.doctorId}</td>
                           <td>{app.category}</td>
                           <td>{app.description}</td>
                           <td>{app.status}</td>
                           <td><button className="btn btn-info" onClick={()=>{this.confirmAppointment(this,app.appointmentId);this.forceUpdateHandler()}}>Confirm</button></td>
                           <td><button className="btn btn-danger" onClick={()=>{this.cancelAppointment(this,app.appointmentId);this.forceUpdateHandler()}}>Cancel</button></td>
                       </tr>
                   ))
                   }
                </tbody>
            </table>
        </div>
        )
        
    }
}

export default ManageAppointment;