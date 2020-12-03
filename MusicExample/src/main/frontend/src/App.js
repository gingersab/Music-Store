import React, { Component } from "react";
import MainPageLayout from "./Components/MainPageLayout";
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
		        <Route exact path="/" component={MainPageLayout} />
		      </Router>
		    );
		  }
		}

export default App;