import React, { Component } from "react";

let PerformJSONPOSTRequest = async(url, data) =>{

	const response = await fetch(url, {
		method: "POST", 
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify(data)
	});
	let json = await response.json();
	console.log("JSONPostResult: " + json);
	return json;
}

let PerformJSONGETRequest = async(url) =>{

	const response = await fetch(url, {
		method: "GET", 
		headers: {"Content-Type": "application/json"},
	});
	let json = await response.json();
	console.log("JSONGetResult: " + json);
	return json;
}

let PerformPlainTextPOSTRequest = async(url, data) =>{

	const response = await fetch(url, {
		method: "POST", 
		headers: {"Content-Type": "text/plain"},
		body: JSON.stringify(data)
	});
	let json = await response.json();
	console.log("PlainTextPostResult: " + json);
	return json;
}

let PerformPlainTextGETRequest = async(url) =>{

	const response = await fetch(url, {
		method: "GET", 
		headers: {"Content-Type": "text/plain"},
	});
	let json = await response.json();
	console.log("PlainTextGetResult: " + json);
	return json;
}

export default PerformJSONPOSTRequest;
export {PerformPlainTextPOSTRequest, PerformPlainTextGETRequest, PerformJSONGETRequest };
