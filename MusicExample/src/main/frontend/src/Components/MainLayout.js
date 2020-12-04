import React, { Component } from "react";
import PerformRequest from "./helpers";
 
class MainLayout extends Component {
	
	constructor(props) {
		super(props);
		this.state = {
				searchQuery: ""
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
		PerformRequest("/api/search", "POST", this.state).then(result => {
			console.log("SearchResult: " + result);
		});
	 }

  render() {
    return (
      <React.Fragment>
      <div className="mainContainer">
      <div className="searchResults">
      </div>
      <div className="searchField">
      <form name="searchForm">
      <input type="text" name="searchTerm" placeholder="Search term" />
      <input type="submit" value="Search" />
      </form>
      </div>
      </div>
      </React.Fragment>
    );
  }
}
 
export default MainLayout;