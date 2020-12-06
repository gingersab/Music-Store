import React, { Component } from "react";
import ReactDOM from 'react-dom';
import {PerformJSONGETRequest, PerformPlainTextPOSTRequest} from "./helpers"

class MainLayout extends Component {
	
	constructor(props) {
		super(props);
		this.state = {
				searchQuery: '',
				queryTarget: 'albums',
				resultsQueryTarget: '',
				data: ''
		};

		this.handleInputChange = this.handleInputChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.handleClick = this.handleClick.bind(this);
		this.handlePageClick = this.handlePageClick.bind(this);
		this.paginateResults = this.paginateResults.bind(this);
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
		let url = "/api/search/"+this.state.queryTarget;
		console.log(url);
		let resultData ='';
		PerformPlainTextPOSTRequest(url, this.state.searchQuery).then(result => {
			this.state.resultsQueryTarget=this.state.queryTarget;
			this.state.data = result;
			this.paginateResults(result, 1, this.state.resultsQueryTarget);
		});
		
	 }
	 
	 handlePageClick(event){
		 event.preventDefault();
		 this.paginateResults(this.state.data, event.target.id, this.state.resultsQueryTarget);
	 }
	
	
	paginateResults(data, page, target){
		let outputElement = document.getElementsByClassName('searchResults');
		let currentPage = page;
		let resultsPerPage = 5;
		let maxIndexForPage = (currentPage * resultsPerPage) - 1;
		let minIndexForPage = (maxIndexForPage - (resultsPerPage-1));
		let outputObj ="";
		let elementAppendTo = document.getElementsByClassName('searchResults')[0];
		document.getElementsByClassName('searchResults')[0].innerHTML="";
		for(let i=minIndexForPage; i<=maxIndexForPage; i++){
			if(data.length <= i)
				break;
			const elementID = i;
			const newElement = document.createElement("div");
			newElement.id = i;
			elementAppendTo.appendChild(newElement);
			if(target =="albums"){
				let company = data[i].companyName;
				let album = data[i].albumName;
				let singer = data[i].singerName;
				let year = data[i].albumYear;
				ReactDOM.render(<div>{album}, {singer}, {company}, {year}<hr /></div>, document.getElementById(elementID));
			}
			else if(target=="singers"){
				let company = data[i].companyName;
				let dob = data[i].dateOfBirth;
				let singer = data[i].singerName;
				let sex = data[i].singerSex;
				ReactDOM.render(<div>{singer}, {company}, {sex}, {dob}<hr /></div>, document.getElementById(elementID));
			}
			else{
				ReactDOM.render(<h3>something went wrong </h3>, elementAppendTo);
			}
		}
		//page numbers
		const pageNumbers = [];
		for(let i=0; i<Math.ceil(data.length / resultsPerPage); i++)
			pageNumbers.push(i+1);
		
		let pageNumberAppendTo = document.getElementsByClassName("pageNumbers")[0];
		document.getElementsByClassName("pageNumbers")[0].innerHTML="";
		console.log("results: " + data.length + "pages required: " + pageNumbers.length);
		for(let i =0; i < pageNumbers.length; i++){
			const pageNumber = pageNumbers[i];
			const newElement = document.createElement("ul");
			newElement.id = "li"+i;
			pageNumberAppendTo.appendChild(newElement);
			ReactDOM.render(<li key={pageNumber} id = {pageNumber} onClick={this.handlePageClick}>{pageNumber}</li>, document.getElementById("li"+i));
		}
	}
	
	 handleClick(event){
		 event.preventDefault();
		 this.state.queryTarget = event.target.name;
		 let url = "/api/" + this.state.queryTarget;
		 PerformJSONGETRequest(url).then(result => {
			this.state.resultsQueryTarget = this.state.queryTarget;
			this.state.data = result;
			this.paginateResults(result, 1, this.state.resultsQueryTarget);
		});
	 }
	 
  render() {
    return (
      <React.Fragment>
      <div className="mainContainer">
      <div className="searchResults">
      </div>
      <div className="pageNumbers">
      </div>
      <div className="searchField">
      <form name="searchForm"  onSubmit={this.handleSubmit}>
      <select value={this.state.queryTarget} name="queryTarget" onChange={this.handleInputChange}>
      	<option value="albums">Albums</option>
      	<option value="singers">Singers</option>
      	</select>
      <input type="text" name="searchQuery" onChange={this.handleInputChange} placeholder="Search term"/>
      <input type="submit" value="Search" />
      </form>
      <hr />
      <div className="getAllButtons">
      <button name ="albums" value="Display All Albums" onClick={this.handleClick}> Get All Albums</button>
      <button name="singers" value="Display All Singers" onClick={this.handleClick}> Get All Singers </button>
      </div>
      </div>
      </div>
      </React.Fragment>
    );
  } 
}
 
export default MainLayout;