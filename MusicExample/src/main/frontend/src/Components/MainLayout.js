import React, { Component } from "react";
 

let performSearchRequest = async(url, httpMethod, data) =>{

	const response = await fetch(url, {
		method: httpMethod, 
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify(data)
	});
	let json = await response.json();
	console.log("asyncResult: " + json);
	return json;
}

class MainLayout extends Component {
	
	constructor(props) {
		super(props);
		this.state = {
				searchQuery: '',
				queryTarget: 'albums'
		};

		this.handleInputChange = this.handleInputChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}
	
	handleInputChange(event) {
		const target = event.target;
		const value = target.value;
		const name = target.name;

		this.setState({
			[name]: value
		}, () => console.log(this.state));
	}

	 handleSubmit(event) {
		event.preventDefault();
		let url = this.state.queryTarget =="albums" ? "/api/search/albums" : "/api/search/singers";
		console.log(url);
		performSearchRequest(url, "POST", this.state.searchQuery).then(result => {
			console.log("SearchResult: " + result[0].companyName);
		});
	 }	 
	

  render() {
    return (
      <React.Fragment>
      <div className="mainContainer">
      <div className="searchResults">
      </div>
      <div className="searchField">
      <form name="searchForm"  onSubmit={this.handleSubmit}>
      <label> Search for Artist/Album
      <select value={this.state.queryTarget} name="queryTarget" onChange={this.handleInputChange}>
      	<option value="albums">Albums</option>
      	<option value="singers">Singers</option>
      	</select>
      </label>
      <input type="text" name="searchQuery" onChange={this.handleInputChange} placeholder="Search term"/>
      <input type="submit" value="Search" />
      </form>
      </div>
      </div>
      </React.Fragment>
    );
  }
}
 
export default MainLayout;