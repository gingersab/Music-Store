import React, { Component } from "react";
import { Link } from 'react-router-dom';
import logo from "../logo.svg"
 
class NavBar extends Component {
  render() {
    return (
      <React.Fragment>
      <div className="navwrapper">
      <img src={logo} alt="React logo"/>
        <nav className="navbar">
        	<Link to="/create">Add New</Link>
        	<Link to="/">Home</Link>
        </nav>
        <hr className="navLowerLine"/>
      </div>
      <div className="titleWrapper">
      	<h5>Music Store </h5>
      </div>
      </React.Fragment>
    );
  }
}
 
export default NavBar;