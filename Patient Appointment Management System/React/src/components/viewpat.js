import React, { Component } from 'react';
import axios from 'axios'
import EditPat from './editpat';

class ViewPat extends Component {
    state = {
        patList: [],
        editView : 0,
        editpatientID : ""
      }
    
    componentDidMount(){
    axios.get("http://localhost:9050/patient").then(res=>this.setState({patList:res.data}))
    }

    editPatient = (e,patientID) => {
        this.setState({editView : 1 , editpatientID : patientID})
    }

    deletePatient = (e,patientID) => {
        axios.post(`http://localhost:9050/patient/disable/id/${patientID}`).then((res)=>{if(res.status === 200){alert("Deleted Successfully");window.location.reload(false);}})
    }

   
    render()
    {  
        var editBody = ""
        if(this.state.editView === 1){
            editBody = 
            <div>
            <EditPat patid={this.state.editpatientID}/>
            <button type="button" className="btn btn-info" onClick={()=>{this.setState({editView : 0})}} style={{width:100 + '%'}}>Cancel</button>
            </div>
           
        }

        return (
            <div>
            <hr />
            <a href="/" ><button align="left" className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h3 align="center" className="my-1">All Patients</h3>
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
                        <th>Medical History</th>
                        <th></th>
                        <th></th>
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
                           <td>{pat.medHistory}</td>
                           <td><button className="btn btn-info" onClick={()=>{this.editPatient(this,pat.pid)}}>Edit</button></td>
                           <td><button className="btn btn-danger" onClick={()=>{this.deletePatient(this,pat.pid)}}>Delete</button></td>
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

export default ViewPat;