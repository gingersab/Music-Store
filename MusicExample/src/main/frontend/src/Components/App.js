import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route } from 'react-router-dom';

import NavBar from './NavBar'
import LoginForm from './LoginForm'
import MainLayout from './MainLayout'
import CreateNew from './CreateNew'

import '../index.css';
import '../App.css';

let loggedInCookieValue = document.cookie.replace(/(?:(?:^|.*;\s*)isLoggedIn\s*\=\s*([^;]*).*$)|^.*$/, "$1");
loggedInCookieValue = loggedInCookieValue.length === 0 ? false : true;
let IsUserLoggedIn=() =>  loggedInCookieValue ? <MainLayout /> : <LoginForm />

class App extends Component {

	render() {
		
		return (
				<BrowserRouter>
				<Route path="/" component={NavBar}/>
				<Route exact path="/" component={IsUserLoggedIn}/>
				<Route exact path="/create" component={CreateNew}/>
				</BrowserRouter>
		);
	}
}

export default App;
export {loggedInCookieValue};
