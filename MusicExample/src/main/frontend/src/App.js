import React, { Component } from "react";
import NavBar from "./Components/NavBar";
import {
	  BrowserRouter as Router,
	  Switch,
	  Route,
	  Link
	} from "react-router-dom";
import "./App.css"
		
class App extends Component {
	 render() {
		    return (
		      <Router>
		        <Route exact path="/" component={NavBar} />
		      </Router>
		    );
		  }
		}

export default App;