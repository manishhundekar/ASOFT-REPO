import React, { Component } from 'react';
import axios from 'axios'

class NewAppointment extends Component {
        state = {
        appointment: {
            appDate : "",
            appTime : "" ,
            category : "",
            description : "",
            doctorId : "",
            patientId : "",
            timestamp : Date.now()
        },
        doctorList : [],
        patientList : []
    }
    
    
    componentDidMount(){
    axios.get("http://localhost:9050/doctor").then(res=>this.setState({doctorList:res.data}))
    axios.get("http://localhost:9050/patient").then(res=>this.setState({patientList:res.data}))
    console.log()
    }


    setValues = (e) => {
        this.setState((prevState, props) => ({
            appointment: {
                ...prevState.appointment,
                [e.target.name] : e.target.value
            },
        }));

        console.log(this.state.appointment)
    }

    submitForm = (e) => {
        e.preventDefault()
        axios.post("http://localhost:9050/appointment" , this.state.appointment)
        .then((res)=>
        {
        console.log(res)
        if(res.status === 200){
            axios.post("http://2factor.in/API/V1/bb723d84-7f41-11ea-9fa5-0200cd936042/ADDON_SERVICES/SEND/TSMS",{
                "From" : "MANISH",
                "To" : "9008878907",
                "TemplateName" : "Manish",
                "VAR1" : "Manish"
            }).then(res => {console.log("SMS SENT")})
            alert("Appointment has been placed Successfully")
        }
        })
        .catch((err) => {
           alert(err.response.data.message)
        })

    }


    render()
    {
        return (
            <div>
            <div >
            <hr />
            <a href="/"><button className="btn btn-secondary">Click here to go back</button></a>
            <hr />
            <h3 align="center" className="my-1">New Appointment</h3>
            <form>
            <div className="form-row">
                <div className="form-group col-md-6">
                    <label>Appointment Date:</label>
                    <input type="date" value={this.state.appointment.appDate} name="appDate" className="form-control" onChange={this.setValues} required/>
                </div>
                <div className="form-group col-md-6">
                    <label>Appointment Time:</label>
                    <input type="time" value={this.state.appointment.appTime} name="appTime" className="form-control" onChange={this.setValues} required/>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-md-6">
                    <label>Category:</label>
                    <select className="custom-select" name="category" onChange={this.setValues} value={this.state.appointment.category} required>
                    <option value="None">Select Category</option>
                        <option value="In-Patient">In-Patient Department</option>
                        <option value="Out-Patient">Out-Patient Department</option>
                    </select>
                </div>
                <div className="form-group col-md-6">
                    <label>Description:</label>
                    <input type="text"value={this.state.appointment.description} name="description" onChange={this.setValues} className="form-control" required />
                </div>
            </div>
            <div className="form-row">
            <div className="form-group col-md-6">
                    <label>Select Doctor:</label>
                    <select className="custom-select" value={this.state.appointment.doctorId} name="doctorId" onChange={this.setValues} required>
                            <option key="zero" /* selected={true} disabled="disabled" */ value="none">Select Doctor</option>
                            {
                                this.state.doctorList.map((doctor) => (
                                    <option key={doctor.doctorId} value={doctor.doctorId}>{doctor.doctorName}</option>
                                ))
                            }
                    </select>
            </div>
            <div className="form-group col-md-6">
                    <label>Select Patient:</label>
                    <select className="custom-select" value={this.state.appointment.patientId} name="patientId" onChange={this.setValues} required>
                            <option /* disabled  */value="None">Select Patient</option>
                            {
                                this.state.patientList.map((patient) => (
                                    <option key={patient.pid} value={patient.pid}>{patient.name}</option>
                                ))
                            }
                    </select>
            </div>
            </div>
            <div>
                <button type="submit" className="btn btn-primary" onClick={this.submitForm} id="add_doc" style={{width:100 + '%'}}>Add Appointment</button>
            </div>
            </form>
        </div>
        </div>
        )
    }
}

export default NewAppointment;