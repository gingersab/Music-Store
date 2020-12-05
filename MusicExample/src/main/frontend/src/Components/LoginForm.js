import React, { Component } from "react";
import PerformJSONPOSTRequest from "./helpers";

class LoginForm extends Component {

	constructor(props) {
		super(props);
		this.state = {
				username: "",
				password: ""
		};

		this.handleInputChange = this.handleInputChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleInputChange(event) {
		const target = event.target;
		const value = target.type === 'checkbox' ? target.checked : target.value;
		const name = target.name;

		this.setState({
			[name]: value
		});
	}

	 handleSubmit(event) {
		event.preventDefault();
		PerformJSONPOSTRequest("/api/login", this.state).then(result => {
			if(result){
				document.cookie="isLoggedIn=true; path=/; max-age=10800;";
			}
			window.location.reload(true);
		});
	 }


	render() {
		return (
				<React.Fragment>
				<div className="loginForm">
				<form name="login" onSubmit={this.handleSubmit}>
				<h3>Login</h3>
				<input type="text" name="username" placeholder="Username" onChange={this.handleInputChange}/>
				<input type="password" name="password" placeholder="**********" onChange={this.handleInputChange}/>
				<input type="submit" value="Login"/>  
				</form>
				</div>
				</React.Fragment>
		);
	}
}

export default LoginForm;