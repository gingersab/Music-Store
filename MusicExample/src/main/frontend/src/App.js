import React, { Component } from "react";
import getAlbum from "./Components/getAlbum";
import { Route, BrowserRouter as Router } from "react-router-dom";
import Table from "./Components/Table";

class App extends Component {
  render() {
    return (
      <Router>
        <Route exact path="/" component={getAlbum}/>
        <Route exact path="/view" component={Table} />
      </Router>
    );
  }
}

export default App;