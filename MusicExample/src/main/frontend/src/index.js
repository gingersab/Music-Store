import React from 'react';
import ReactDOM from 'react-dom';

import NavBar from './Components/NavBar'
import LoginForm from './Components/LoginForm'
import MainLayout from './Components/MainLayout'

import './index.css';
import './App.css';

let loggedInCookieValue = document.cookie.replace(/(?:(?:^|.*;\s*)isLoggedIn\s*\=\s*([^;]*).*$)|^.*$/, "$1");
loggedInCookieValue = loggedInCookieValue.length === 0 ? false : true;

let IsUserLoggedIn=() =>  loggedInCookieValue ? <MainLayout /> : <LoginForm />

ReactDOM.render(
  <React.StrictMode>
    <NavBar />
    <IsUserLoggedIn />
  </React.StrictMode>,
  document.getElementById('root')
);
