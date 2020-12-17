import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import doclogo from '../images/doctor.jpg';
import axios from 'axios'

class SearchPatient extends Component {
    state = {
        patName: "",
        patId : "" ,
        patientBodyFlag: 0,
        patientBody : ""
      }
    
    
    searchPatientById = () => {
       axios.get(`http://localhost:9050/patient/id/${this.state.patId}`)
            .then((res)=>{
                if(res.status === 200)
                {
                    alert("Loading...");
                    this.setState({
                        patientBodyFlag : 1,
                        patientBody : res.data
                    })
                    console.log(res)
                }
            })
            .catch((err) => {
                console.log(err)
                alert(err.response.data.message)
            })
    }

    searchPatientByName = () => {
        axios.get(`http://localhost:9050/patient/name/${this.state.patName}`)
             .then((res)=>{
                 if(res.status === 200)
                 {
                     alert("Loading...");
                     this.setState({
                        patientBodyFlag : 1,
                        patientBody : res.data
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
        if(this.state.patientBodyFlag === 1){
            contentBody = 
            <div>
                <table class="table table-bordered table-hover">
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
            </div>
           
        }

        return (
            <div className="container">
            <hr />
            <a href="/" ><button align="left" className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h5 align="center" className="my-1"><u>Search Patient by Id</u></h5>
            <div className="form-row">
                <div className="form-group col-12">
                     <input className="form-control" name="docID" value={this.state.patId} onChange={(e)=>{this.setState({patId : e.target.value})}}/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-12">
                    <button className="btn btn-primary" style={{width : 100 + '%'}} onClick={this.searchPatientById}>Search</button>
                </div>
            </div>
            <hr />
            <h5 align="center" className="my-1"><u>Search Doctor by Name</u></h5>
            <div className="form-row">
                <div className="form-group col-12">
                     <input className="form-control" name="docName" value={this.state.patName} onChange={(e)=>{this.setState({patName : e.target.value})}}/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-12">
                    <button className="btn btn-primary" style={{width : 100 + '%'}} onClick={this.searchPatientByName}>Search</button>
                </div>
            </div>
            <div>
                {contentBody}
            </div>
        </div>
        )
        
    }
}

export default SearchPatient;