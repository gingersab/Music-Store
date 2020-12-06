import React, { Component } from "react";
import PerformJSONPostRequest from "./helpers";
import {loggedInCookieValue} from "./App"
import logo from "../logo.svg"

class CreateNew extends Component {



	//name company singer year
	//name company sex date

	constructor(props) {
		super(props);
		this.state = {
				createType: 'album',
				albumName: '',
				albumCompany: '',
				albumSinger: '',
				albumYear: ''
		};

		this.handleInputChange = this.handleInputChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.updateState = this.updateState.bind(this);
		this.updateFormElements = this.updateFormElements.bind(this);
	}

	updateFormElements = () =>{
		switch (this.state.createType){
		case "album":
			let singerNameElement = document.getElementById('singerName');
			singerNameElement.id = "albumName";
			singerNameElement.name="albumName";
			singerNameElement.placeholder ="Album Name";
			singerNameElement.value="";
			let singerCompanyElement = document.getElementById('singerCompany');
			singerCompanyElement.id = "albumSinger";
			singerCompanyElement.name="albumSinger";
			singerCompanyElement.placeholder ="Singer Name";
			singerCompanyElement.value="";
			let singerSexElement = document.getElementById('singerSex');
			singerSexElement.id = "albumCompany";
			singerSexElement.name="albumCompany";
			singerSexElement.placeholder ="Company";
			singerSexElement.value="";
			let singerDOBElement = document.getElementById('singerDOB');
			singerDOBElement.id = "albumYear";
			singerDOBElement.name="albumYear";
			singerDOBElement.placeholder ="Year (1930-2020)";
			singerDOBElement.type="number";
			singerDOBElement.value="";

			break;
		case "singer":
			let albumNameElement = document.getElementById('albumName');
			albumNameElement.id = "singerName";
			albumNameElement.name="singerName";
			albumNameElement.placeholder ="Singer Name";
			albumNameElement.value="";
			let albumSingerElement = document.getElementById('albumSinger');
			albumSingerElement.id = "singerCompany";
			albumSingerElement.name="singerCompany";
			albumSingerElement.placeholder ="Company";
			albumSingerElement.value="";
			let albumCompanyElement = document.getElementById('albumCompany');
			albumCompanyElement.id = "singerSex";
			albumCompanyElement.name="singerSex";
			albumCompanyElement.placeholder ="Sex ('Male' or 'Female')";
			albumCompanyElement.value="";
			let albumYearElement = document.getElementById('albumYear');
			albumYearElement.id = "singerDOB";
			albumYearElement.name="singerDOB";
			albumYearElement.placeholder ="Date of Birth (yyyyMMdd)";
			albumYearElement.value="";
			break;
		default:
			console.log("Something happened when updating the form");
		}
	}

	updateState =() =>{
		let newState={};
		console.log("Updating for type " + this.state.createType);
		newState = this.state.createType=='album' ? { createType: 'album', albumName: '', albumCompany: '', albumSinger:'', albumYear: ''} :
		{ createType: 'singer', singerName: '', singerCompany: '', singerSex:'', singerDOB: ''};
		this.state=newState;
		this.updateFormElements();
	}

	handleInputChange(event) {
		const target = event.target;
		const value = target.value;
		const name = target.name;

		this.setState({
			[name]: value
		}, () => {if(target.type==='select-one'){this.updateState()}});
	}

	handleSubmit(event){
		event.preventDefault();
		let canSubmit = false;
		if(this.state.createType=="singer"){
			let dateOfBirth = document.getElementById("singerDOB").value;

			if(!(dateOfBirth.toString().length==8))alert("Enter a valid DoB (yyyyMMdd)");
			else{
				let validSex = document.getElementById('singerSex').value.toUpperCase();
				if(validSex == "MALE" || validSex =="FEMALE" )
				{
					this.state.singerSex = validSex;
					canSubmit = true;
				}
				else
					alert("Enter sex as 'Male' or 'Female'");
			}
		}
		else{
			let validYear = document.getElementById('albumYear').value;
			if(validYear > 2020  || validYear < 1930 )
				alert("Album year must be between 1930 and 2020");
			else
				canSubmit = true;
		}
		if(canSubmit){
			console.log(this.state)
			let url= this.state.createType=="album" ? "/api/add/album" : "/api/add/singer";
			console.log(url);
			PerformJSONPostRequest(url, this.state).then(result => {
				console.log(result);
			});
		}

	}

	render() {
		if(loggedInCookieValue===false)
		{
			window.location.href="http://localhost:8080";
			return null;
		}
		return (
				<div className="addNewFormWrapper">
				<form name ="addNew" htmlFor="createType" onSubmit={this.handleSubmit}>
				<select value={this.state.createType} onChange={this.handleInputChange} name="createType" id="createType">
				<option value="album">Albums</option>
				<option value="singer">Singers</option>
				</select>					
				<input type="text" id="albumName" name="albumName" placeholder="Album Name" onChange={this.handleInputChange} />					
				<input type="text" id="albumSinger"  name="albumSinger" placeholder="Singer" onChange={this.handleInputChange} />				
				<input type="text" id="albumCompany" name="albumCompany" placeholder="Company" onChange={this.handleInputChange} />					
				<input type="number"  id="albumYear"  name="albumYear"  placeholder="Year (1930-2020)" onChange={this.handleInputChange}/>
				<input type="submit" id="submitCreate" name="submitCreate" value="Add"/>
					</form>
				</div>
		);
	}
}

export default CreateNew;