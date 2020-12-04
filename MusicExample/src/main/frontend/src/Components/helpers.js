import React, { Component } from "react";

let PerformRequest = async(url, httpMethod, data) =>{

	const response = await fetch(url, {
		method: httpMethod, 
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify(data)
	});
	let json = await response.json();
	console.log("asyncResult: " + json);
	return json;
}

export default PerformRequest;
