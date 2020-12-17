import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import doclogo from '../images/doctor.jpg';
import axios from 'axios'

class EditPat extends Component {
        state = {
            patient: {
                pid : "",
                name : "" ,
                age : "",
                gender : "",
                address : "",
                phone : "",
                email : "",
                medHistory : ""
            }
    }
    
    

    componentDidMount(){
    axios.get(`http://localhost:9050/patient/id/${this.props.patid}`).then(res=>this.setState({patient:res.data}))
    }


    setValues = (e) => {
        this.setState((prevState, props) => ({
            patient: {
                ...prevState.patient,
                [e.target.name] : e.target.value
            },
        }));

        console.log(this.state.patient)
    }

    submitPatForm = (e) => {
        e.preventDefault()
        axios.put(`http://localhost:9050/patient/id/${this.props.patid}` , this.state.patient)
        .then((res)=>
        {
        console.log(res)
        if(res.status === 200){
            alert("Patient Edited Successfully")
        }
        })

    }


    render()
    {
        return (
            <div>
            <div id="addpatdiv" >
            <hr />
            <a href="/"><button className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h3 align="center" className="my-1">Edit Patient</h3>
            <form>
            <div className="form-row">
                <div className="form-group col-md-6">
                    <label>Name:</label>
                    <input type="text" value={this.state.patient.name} name="name" className="form-control" onChange={this.setValues} required/>
                </div>
                <div className="form-group col-md-6">
                    <label>Age:</label>
                    <input type="text" value={this.state.patient.age} name="age" className="form-control" onChange={this.setValues} required/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-md-6">
                    <label>Gender:</label>
                    <select className="custom-select" value={this.state.patient.gender} name="gender" onChange={this.setValues} required>
                            <option>Male</option>
                            <option>Female</option>
                    </select>
                </div>
                <div className="form-group col-md-6">
                    <label>Address:</label>
                    <input type="text"value={this.state.patient.address} name="address" onChange={this.setValues} className="form-control" required />
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-md-6">
                    <label>Phone:</label>
                    <input type="text" value={this.state.patient.phone} name="phone" onChange={this.setValues} className="form-control" pattern="[0-9]{}" required/>
                </div>
                <div className="form-group col-md-6">
                    <label>Email:</label>
                    <input type="email" value={this.state.patient.email} name="email" onChange={this.setValues} className="form-control" required/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-md-12">
                    <label>Medical History:</label>
                    <textarea rows="3" value={this.state.patient.medHistory} name="medHistory" onChange={this.setValues} className="form-control" pattern="[0-9]{}" required/>
                </div>
            </div>
            <div>
                <button type="submit" className="btn btn-primary" onClick={this.submitPatForm} id="add" style={{width:100 + '%'}}>Edit Patient</button>
            </div>
            </form>
        </div>
        </div>
        )
    }
}

export default EditPat;