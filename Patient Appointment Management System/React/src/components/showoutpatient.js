import React, { Component } from 'react';
import axios from 'axios'
import EditPat from './editpat';

class ShowOutPatient extends Component {
    state = {
        patList: []
      }
    
    componentDidMount(){
    axios.get("http://localhost:9050/patient/category/outpatient").then(res=>this.setState({patList:res.data}))
    }

    render()
    {  
        return (
            <div>
            <hr />
            <a href="/" ><button align="left" className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h3 align="center" className="my-1">All Out-Patient Patients</h3>
            <table className="table table-bordered table-hover">
                <thead className="thead-light">
                    <tr>
                        <th>Patient ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                   { 
                   this.state.patList.map((pat) =>(
                       <tr key={pat.pid}>
                           <td>{pat.pid}</td>
                           <td>{pat.name}</td>
                           <td>{pat.age}</td>
                           <td>{pat.gender}</td>
                           <td>{pat.address}</td>
                           <td>{pat.phone}</td>
                           <td>{pat.email}</td>
                       </tr>
                   ))
                   }
                </tbody>
            </table>
        </div>
        )
        
    }
}

export default ShowOutPatient;