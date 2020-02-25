import React, { Component } from 'react';
import './css/ReactApp.css';
import ReactDOM from 'react-dom';

class ReactApp extends Component { 
    render() {
        return (
            <div id="main">
                <h2>Hello from the other side</h2>
            </div>
        );
    }
}

ReactDOM.render(<ReactApp />, document.getElementById('reactApp'));