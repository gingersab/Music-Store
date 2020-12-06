import React, { Component } from "react";
import ReactDOM from 'react-dom';
import {PerformJSONGETRequest, PerformPlainTextPOSTRequest} from "./helpers"

const testData = [
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 2001,
    "albumName": "A MAJOR",
    "singerName": "ALICIA KEYS"
},
{
    "companyName": "COLUMBIA RECORDS",
    "albumYear": 2002,
    "albumName": "B MAJOR",
    "singerName": "ALICIA KEYS"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 2005,
    "albumName": "C MAJOR",
    "singerName": "ALICIA KEYS"
},
{
    "companyName": "COLUMBIA RECORDS",
    "albumYear": 2004,
    "albumName": "IRREPALCE",
    "singerName": "BEYONCE KNOWLES"
},
{
    "companyName": "ATLANTIC RECORDS",
    "albumYear": 2010,
    "albumName": "REPLACE",
    "singerName": "BEYONCE KNOWLES"
},
{
    "companyName": "CAPITOL RECORDS",
    "albumYear": 2010,
    "albumName": "TO THE LEFT",
    "singerName": "BEYONCE KNOWLES"
},
{
    "companyName": "WARNER BROS. RECORDS",
    "albumYear": 1999,
    "albumName": "FIRST TIME",
    "singerName": "BRITNEY SPEARS"
},
{
    "companyName": "COLUMBIA RECORDS",
    "albumYear": 2005,
    "albumName": "I'M BACK",
    "singerName": "BRITNEY SPEARS"
},
{
    "companyName": "WARNER BROS. RECORDS",
    "albumYear": 2003,
    "albumName": "ONE MORE",
    "singerName": "BRITNEY SPEARS"
},
{
    "companyName": "EPIC RECORDS",
    "albumYear": 1997,
    "albumName": "MY HEART",
    "singerName": "CELINE DION"
},
{
    "companyName": "WARNER BROS. RECORDS",
    "albumYear": 1998,
    "albumName": "PRAYER",
    "singerName": "CELINE DION"
},
{
    "companyName": "UNIVERSAL RECORDS",
    "albumYear": 1998,
    "albumName": "WILL GO ON",
    "singerName": "CELINE DION"
},
{
    "companyName": "ATLANTIC RECORDS",
    "albumYear": 2002,
    "albumName": "HIGH SCHOOL",
    "singerName": "FERGIE"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 2011,
    "albumName": "WILDCATS",
    "singerName": "FERGIE"
},
{
    "companyName": "INTERSCOPE RECORDS",
    "albumYear": 2000,
    "albumName": "WILSON",
    "singerName": "FERGIE"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 1956,
    "albumName": "BROWNIE",
    "singerName": "JAMES BROWN"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 1970,
    "albumName": "JAMES BROWN",
    "singerName": "JAMES BROWN"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 1960,
    "albumName": "JIMMY",
    "singerName": "JAMES BROWN"
},
{
    "companyName": "COLUMBIA RECORDS",
    "albumYear": 2005,
    "albumName": "AMERICA",
    "singerName": "KATY PERRY"
},
{
    "companyName": "CAPITOL RECORDS",
    "albumYear": 2007,
    "albumName": "GOD BLESS",
    "singerName": "KATY PERRY"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 2009,
    "albumName": "U.S.A.",
    "singerName": "KATY PERRY"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 1980,
    "albumName": "BAD",
    "singerName": "MICHAEL JACKSON"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 1982,
    "albumName": "BEAT IT",
    "singerName": "MICHAEL JACKSON"
},
{
    "companyName": "INTERSCOPE RECORDS",
    "albumYear": 1998,
    "albumName": "BLACK OR WHITE",
    "singerName": "MICHAEL JACKSON"
},
{
    "companyName": "CAPITOL RECORDS",
    "albumYear": 1985,
    "albumName": "DO IT LIKE",
    "singerName": "MICK JAGGER"
},
{
    "companyName": "UNIVERSAL RECORDS",
    "albumYear": 1990,
    "albumName": "MICK JAGGER",
    "singerName": "MICK JAGGER"
},
{
    "companyName": "EPIC RECORDS",
    "albumYear": 1989,
    "albumName": "MICKIE",
    "singerName": "MICK JAGGER"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 1978,
    "albumName": "I WONDER",
    "singerName": "STEVIE WONDER"
},
{
    "companyName": "MOTOWN RECORD CORP",
    "albumYear": 1979,
    "albumName": "STEPHEN",
    "singerName": "STEVIE WONDER"
},
{
    "companyName": "EPIC RECORDS",
    "albumYear": 1984,
    "albumName": "WONDERFUL",
    "singerName": "STEVIE WONDER"
}
];

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
				ReactDOM.render(<p>{album}, {singer}, {company}, {year}</p>, document.getElementById(elementID));
			}
			else if(target=="singers"){
				let company = data[i].companyName;
				let dob = data[i].dateOfBirth;
				let singer = data[i].singerName;
				let sex = data[i].singerSex;
				ReactDOM.render(<p>{singer}, {company}, {sex}, {dob}</p>, document.getElementById(elementID));
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
      <label> Search for Singers/Albums
      <select value={this.state.queryTarget} name="queryTarget" onChange={this.handleInputChange}>
      	<option value="albums">Albums</option>
      	<option value="singers">Singers</option>
      	</select>
      </label>
      <input type="text" name="searchQuery" onChange={this.handleInputChange} placeholder="Search term"/>
      <input type="submit" value="Search" />
      <button name ="albums" value="Display All Albums" onClick={this.handleClick}> Get All Albums</button>
      <button name="singers" value="Display All Singers" onClick={this.handleClick}> Get All Singers </button>
      </form>
      </div>
      </div>
      </React.Fragment>
    );
  } 
}
 
export default MainLayout;