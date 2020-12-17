import './App.css';
import React, { Component } from 'react';
import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import axios from 'axios'
import MainPage from './components/mainpage';
import Navbar from './components/navbar';
import ViewDoc from './components/viewdoc';
import AddDoc from './components/adddoc';
import SearchDoc from './components/searchdoc';
import NewAppointment from './components/newappointment';
import AppointmentStatus from './components/appointmentStatus';
import ManageAppointment from './components/manageappointment';
import SearchPatient from './components/searchpatient';
import AddPatient from './components/addpatient';
import ViewPat from './components/viewpat';
import ShowAdmitted from './components/showadmitted';
import ShowOutPatient from './components/showoutpatient';
import PatientRecords from './components/patientrecords';

class HomePage extends Component {
  state = {
    courseList: []
  }

  componentDidMount(){
    //axios.get("http://localhost:5000/students").then(res=>this.setState({courseList:res.data}))
  }

  render() {
    return (
      <div>
        <Navbar logout={this.props.logout}/>
        <div className="container">
        <Router>
         <Route exact path="/" render={props =>(
              <React.Fragment>
                <MainPage />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/adddoc" render={props =>(
              <React.Fragment>
                <AddDoc />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/viewdoc" render={props =>(
              <React.Fragment>
                <ViewDoc />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/searchdoc" render={props =>(
              <React.Fragment>
                <SearchDoc />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/newappointment" render={props =>(
              <React.Fragment>
                <NewAppointment />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/appointmentstatus" render={props =>(
              <React.Fragment>
                <AppointmentStatus />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/manageappointment" render={props =>(
              <React.Fragment>
                <ManageAppointment />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/searchpatient" render={props =>(
              <React.Fragment>
                <SearchPatient />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/newpatient" render={props =>(
              <React.Fragment>
                <AddPatient />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/viewpat" render={props =>(
              <React.Fragment>
                <ViewPat />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/showadmitted" render={props =>(
              <React.Fragment>
                <ShowAdmitted />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/showoutpatient" render={props =>(
              <React.Fragment>
                <ShowOutPatient />
              </React.Fragment>
            )} >
         </Route>
         <Route exact path="/patientrecords" render={props =>(
              <React.Fragment>
                <PatientRecords />
              </React.Fragment>
            )} >
         </Route>
        </Router>
        </div>
      </div>
    )
  }
}


export default HomePage;