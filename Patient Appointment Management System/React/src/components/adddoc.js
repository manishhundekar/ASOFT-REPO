import React, { Component } from 'react';
//import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import doclogo from '../images/doctor.jpg';
import axios from 'axios'

class AddDoc extends Component {
        state = {
        doctor: {
            doctorName : "",
            departmentNo : "" ,
            qualification : "",
            address : "",
            phone : "",
            email : ""
        },
        departmentList : []
    }
    
    

    componentDidMount(){
    axios.get("http://localhost:9050/department").then(res=>this.setState({departmentList:res.data}))
    }

    /* setValues = (e)=>{
        this.setState({doctor : {[e.target.name] : e.target.value}})
        console.log(this.state.doctor)
    } */

    setValues = (e) => {
        this.setState((prevState, props) => ({
            doctor: {
                ...prevState.doctor,
                [e.target.name] : e.target.value
            },
        }));

        console.log(this.state.doctor)
    }

    submitDocForm = (e) => {
        e.preventDefault()
        axios.post("http://localhost:9050/doctor" , this.state.doctor)
        .then((res)=>
        {
        console.log(res)
        if(res.status === 200){
            alert("Doctor Added Successfully")
        }
        })

        /*
        console.log(JSON.stringify(this.state.doctor))
         axios({
        method: 'post',
        url: 'http://localhost:9050/doctor',
        data: JSON.stringify(this.state.doctor),
        headers: {'Content-Type': 'application/json' }
        })
        .then(function (response) {
            //handle success
            console.log(response);
        })
        .catch(function (response) {
            //handle error
            console.log(response);
        }); */
    }


    render()
    {
        return (
            <div>
            <div id="adddocdiv" >
            <hr />
            <a href="/"><button className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h3 align="center" className="my-1">Add Doctor</h3>
            <form onSubmit={this.submitDocForm}>
            <div className="form-row">
                <div className="form-group col-md-6">
                    <label>Name:</label>
                    <input type="text" value={this.state.doctor.doctorName} name="doctorName" className="form-control" onChange={this.setValues} required/>
                </div>
                <div className="form-group col-md-6">
                    <label>Department:</label>
                    <select className="custom-select" value={this.state.doctor.departmentNo} name="departmentNo" onChange={this.setValues} required>
                            <option disabled value="None">Select Department</option>
                            {
                                this.state.departmentList.map((department) => (
                                    <option key={department.deptID} value={department.deptID}>{department.deptName}</option>
                                ))
                            }
                    </select>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-md-6">
                    <label>Qualification:</label>
                    <input type="text" value={this.state.doctor.qualification} name="qualification" className="form-control" onChange={this.setValues} required/>
                </div>
                <div className="form-group col-md-6">
                    <label>Address:</label>
                    <input type="text"value={this.state.doctor.address} name="address" onChange={this.setValues} className="form-control" required />
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-md-6">
                    <label>Phone:</label>
                    <input type="text" value={this.state.doctor.phone} name="phone" onChange={this.setValues} className="form-control" pattern="[0-9]{}" required/>
                </div>
                <div className="form-group col-md-6">
                    <label>Email:</label>
                    <input type="email" value={this.state.doctor.email} name="email" onChange={this.setValues} className="form-control" required/>
                </div>
            </div>
            <div>
                <button type="submit" className="btn btn-primary"  id="add_doc" style={{width:100 + '%'}}>Add Doctor</button>
            </div>
            </form>
        </div>
        </div>
        )
    }
}

export default AddDoc;