import React, { Component } from 'react';
import loginlogo from '../images/loginlogo.png';
import {connect} from 'react-redux';
//import { getUser , userStatus } from "../actions/UserAction";
import { getUser } from "../actions/UserAction";
import HomePage from "../HomePage"

class Login extends Component {

    state = {
        userDetails : {
            userName : "",
            password : ""
        },
    loggedUser : null
    }

    componentDidMount() {
        //this.props.userStatus();
        this.setState({loggedUser : JSON.parse(localStorage.getItem("loggeduser"))})
        console.log(this.props)
        console.log("Component Loaded..")

    }

    setValues = (e) => {
        this.setState((prevState, props) => ({
            userDetails: {
                ...prevState.userDetails,
                [e.target.name] : e.target.value
            },
        }));

        console.log(this.state.doctor)
    }

    login = () =>{
        this.props.getUser(this.state.userDetails)
        this.setState({loggedUser : JSON.parse(localStorage.getItem("loggeduser"))})
    }

    logout = () =>{
        alert("Logged out Successfully")
        localStorage.removeItem("loggeduser");
        this.setState({loggedUser : null})
    }

    render()
    {
        let loggedIn = false;
        //let userName = this.state.userName;
        let loggedUser = this.state.loggedUser;
        if (loggedUser !== null) {
            loggedIn = true
            console.log(this.props)
        }

        return (
            <div>

            { loggedIn ? (
                
                <div>
                   {/*  <h2>Welcome</h2>
                    <button onClick={()=>{this.logout()}}>Logout</button> */}
                    <HomePage logout={this.logout}/>
                </div>
                
           
            ) : (

                <center><div className="my-5 card" style={{width : 25 + 'rem'}}>
                <img src={loginlogo} className="my-3 mx-5 card-img-top" alt="loginicon" style={{width : 75 + '%' , border : '2px solid black'}} />
                <div className="card-body">
                    <h5 className="card-title">Login</h5>
                    <form onSubmit={(e)=>{this.login() ; e.preventDefault()}}>
                        <div className="form-row">
                            <div className="form-group col-12">
                                <label className="float-left font-weight-bold">Username:</label><br />
                                <input type="text" name="userName" value={this.state.userName} onChange={this.setValues} className="form-control" placeholder="Enter your username" required/>
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-12">
                                <label align="left" className="float-left font-weight-bold">Password:</label><br />
                                <input type="password" name="password" value={this.state.password} className="form-control" onChange={this.setValues} placeholder="Enter your password" required/>
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-12">
                            <button type="submit" className="btn btn-primary my-2" style={{width : 100 + '%'}}>Login</button>
                            <button type="submit" className="btn btn-info" style={{width : 100 + '%'}}>Register</button>
                            </div>
                        </div>
                    </form>
                </div>
                </div></center>
            )}
            
            </div>
        )
    }
}

const mapStatetoProps = state => (
    {
       // userId: state.user.userId,
        userName: state.user.userName
    }
)

export default connect(mapStatetoProps, { getUser })(Login);
//export default connect(mapStatetoProps, { getUser , userStatus })(Login);
//export default Login;