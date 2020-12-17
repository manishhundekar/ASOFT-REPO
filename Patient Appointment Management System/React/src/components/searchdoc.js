import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import doclogo from '../images/doctor.jpg';
import axios from 'axios'
import EditDoc from './editdoc';

class SearchDoc extends Component {
    state = {
        docName: "",
        docId : "" ,
        doctorBodyFlag: 0,
        doctorBody : ""
      }
    
    
    searchDoctorById = () => {
       axios.get(`http://localhost:9050/doctor/id/${this.state.docId}`)
            .then((res)=>{
                if(res.status === 200)
                {
                    alert("Loading...");
                    this.setState({
                        doctorBodyFlag : 1,
                        doctorBody : res.data
                    })
                    console.log(res)
                }
            })
            .catch((err) => {
                alert("Invalid Doctor ID - Doctor Not Found")
            })
    }

    searchDoctorByName = () => {
        axios.get(`http://localhost:9050/doctor/name/${this.state.docName}`)
             .then((res)=>{
                 if(res.status === 200)
                 {
                     alert("Loading...");
                     this.setState({
                         doctorBodyFlag : 1,
                         doctorBody : res.data
                     })
                     console.log(res)
                 }
             })
             .catch((err) => {
                alert("Invalid Doctor Name - Doctor Not Found")
            })
     }

   
    render()
    {  
        var contentBody = ""
        if(this.state.doctorBodyFlag === 1){
            contentBody = 
            <div>
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>Doctor ID</th>
                        <td>{this.state.doctorBody.doctorId}</td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td>{this.state.doctorBody.doctorName}</td>
                    </tr>
                    <tr>
                        <th>Department</th>
                        <td>{this.state.doctorBody.departmentNo}</td>
                    </tr>
                    <tr>
                        <th>Qualification</th>
                        <td>{this.state.doctorBody.qualification}</td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td>{this.state.doctorBody.address}</td>
                    </tr>
                    <tr>
                        <th>Phone</th>
                        <td>{this.state.doctorBody.phone}</td>
                    </tr>
                    <tr>
                        <th>E-mail</th>
                        <td>{this.state.doctorBody.email}</td>
                    </tr>
                </table>
            </div>
           
        }

        return (
            <div className="container">
            <hr />
            <a href="/" ><button align="left" className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h5 align="center" className="my-1"><u>Search Doctor by Id</u></h5>
            <div className="form-row">
                <div className="form-group col-12">
                     <input className="form-control" name="docID" value={this.state.docID} onChange={(e)=>{this.setState({docId : e.target.value})}}/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-12">
                    <button className="btn btn-primary" style={{width : 100 + '%'}} onClick={this.searchDoctorById}>Search</button>
                </div>
            </div>
            <hr />
            <h5 align="center" className="my-1"><u>Search Doctor by Name</u></h5>
            <div className="form-row">
                <div className="form-group col-12">
                     <input className="form-control" name="docName" value={this.state.docName} onChange={(e)=>{this.setState({docName : e.target.value})}}/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-12">
                    <button className="btn btn-primary" style={{width : 100 + '%'}} onClick={this.searchDoctorByName}>Search</button>
                </div>
            </div>
            <div>
                {contentBody}
            </div>
        </div>
        )
        
    }
}

export default SearchDoc;