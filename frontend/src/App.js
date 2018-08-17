import React, { Component } from 'react';
import Game from "./Game.js";
import './App.css';

class App extends Component {
    constructor(props){
        super(props);
    }
  render() {
    return (
      <div className="App">
        <header className="App-header">
            <header>Welcome to my Game.</header>
            <Game/>
        </header>
          <div>
          </div>
      </div>
    );
  }
}

export default App;
