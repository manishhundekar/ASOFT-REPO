import React, { Component } from 'react';
import axios from 'axios'

class PatientRecords extends Component {
    state = {
        patList : [],
        patId : "" ,
        patientBodyFlag: 0,
        patientBody : "",
        recordsBody : ""
      }
    
    componentDidMount(){
    axios.get("http://localhost:9050/patient").then(res=>this.setState({patList:res.data}))
    }
    
    patientRecordsById = () => {
       axios.get(`http://localhost:9050/records/patient/${this.state.patId}`)
            .then((res)=>{
                if(res.status === 200)
                {
                    alert("Loading...");
                    this.setState({
                        patientBodyFlag : 1,
                        patientBody : res.data.patientId,
                        recordsBody : res.data.records
                    })
                    console.log(res)
                }
            })
            .catch((err) => {
                console.log(err.response.data.message)
                alert(err.response.data.message)
            })
    }

    render()
    {  
        var contentBody = ""
        if(this.state.patientBodyFlag === 1){
            contentBody = 
            <div>
                <table className="table table-bordered table-hover">
                    <tr>
                        <th>Patient ID</th>
                        <td>{this.state.patientBody.pid}</td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td>{this.state.patientBody.name}</td>
                    </tr>
                    <tr>
                        <th>Age</th>
                        <td>{this.state.patientBody.age}</td>
                    </tr>
                    <tr>
                        <th>Gender</th>
                        <td>{this.state.patientBody.gender}</td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td>{this.state.patientBody.address}</td>
                    </tr>
                    <tr>
                        <th>Phone</th>
                        <td>{this.state.patientBody.phone}</td>
                    </tr>
                    <tr>
                        <th>E-mail</th>
                        <td>{this.state.patientBody.email}</td>
                    </tr>
                    <tr>
                        <th>Medical History</th>
                        <td>{this.state.patientBody.medHistory}</td>
                    </tr>
                </table>
                <h3>Appointment History</h3>
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
                    </tr>
                </thead>
                <tbody>
                   { 
                   this.state.recordsBody.map((app) =>(
                       <tr key={app.appointmentId}>
                           <td>{app.appointmentId}</td>
                           <td>{app.appDate}</td>
                           <td>{app.appTime}</td>
                           <td>{app.patientId}</td>
                           <td>{app.doctorId}</td>
                           <td>{app.category}</td>
                           <td>{app.description}</td>
                           <td>{app.status}</td>
                       </tr>
                   ))
                   }
                </tbody>
                </table>
            </div>
           
        }

        return (
            <div className="container">
            <hr />
            <a href="/" ><button align="left" className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h5 align="center" className="my-1"><u>Search Patient Records by Id</u></h5>
            <div className="form-row">
                <div className="form-group col-12">
                     <input className="form-control" name="docID" value={this.state.patId} onChange={(e)=>{this.setState({patId : e.target.value})}}/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-12">
                    <button className="btn btn-primary" style={{width : 100 + '%'}} onClick={this.patientRecordsById}>Search</button>
                </div>
            </div>
            <hr />
            <div>
                {contentBody}
            </div>
        </div>
        )
        
    }
}

export default PatientRecords;