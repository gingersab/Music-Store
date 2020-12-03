import React, { Component } from "react";
import logo from "../logo.svg"

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
		
		const response = fetch("/api/login/", {
			method: "POST", 
			mode: "cors",
			cache: "no-cache", 
			credentials: "same-origin", 
			headers: {
				"Content-Type": "application/json"
			},
			redirect: "follow", 
			referrerPolicy: "no-referrer", 
			body: JSON.stringify(this.state)
		});
		
		console.log("RESP: " + response);
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