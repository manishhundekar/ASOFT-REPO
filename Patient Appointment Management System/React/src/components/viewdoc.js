import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import doclogo from '../images/doctor.jpg';
import axios from 'axios'
import EditDoc from './editdoc';

class ViewDoc extends Component {
    state = {
        docList: [],
        editView : 0,
        editdoctorID : ""
      }
    
    componentDidMount(){
    axios.get("http://localhost:9050/doctor").then(res=>this.setState({docList:res.data}))
    }

    editDoctor = (e,doctorID) => {
        this.setState({editView : 1 , editdoctorID : doctorID})
    }

    deleteDoctor = (e,doctorID) => {
        axios.delete(`http://localhost:9050/doctor/id/${doctorID}`).then((res)=>{if(res.status === 200){alert("Deleted Successfully");window.location.reload(false);}})
    }

   
    render()
    {  
        var editBody = ""
        if(this.state.editView === 1){
            editBody = 
            <div>
            <EditDoc docid={this.state.editdoctorID}/>
            <button type="button" className="btn btn-info" onClick={()=>{this.setState({editView : 0})}} style={{width:100 + '%'}}>Cancel</button>
            </div>
           
        }

        return (
            <div>
            <hr />
            <a href="/" ><button align="left" className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h3 align="center" className="my-1">All Doctors</h3>
            <table className="table table-bordered table-hover">
                <thead className="thead-light">
                    <tr>
                        <th>Doctor ID</th>
                        <th>Doctor Name</th>
                        <th>Department</th>
                        <th>Qualification</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                   { 
                   this.state.docList.map((doc) =>(
                       <tr key={doc.doctorId}>
                           <td>{doc.doctorId}</td>
                           <td>{doc.doctorName}</td>
                           <td>{doc.departmentNo}</td>
                           <td>{doc.qualification}</td>
                           <td>{doc.address}</td>
                           <td>{doc.phone}</td>
                           <td>{doc.email}</td>
                           <td><button className="btn btn-info" onClick={()=>{this.editDoctor(this,doc.doctorId)}}>Edit Doctor</button></td>
                           <td><button className="btn btn-danger" onClick={()=>{this.deleteDoctor(this,doc.doctorId)}}>Delete Doctor</button></td>
                       </tr>
                   ))
                   }
                </tbody>
            </table>
            <div>
                {editBody}
            </div>
        </div>
        )
        
    }
}

export default ViewDoc;