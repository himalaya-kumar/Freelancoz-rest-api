import React, { Component } from 'react';
import './css/ReactApp.css';
import ReactDOM from 'react-dom';
import { Router, Route } from 'react-router-dom';

class ReactApp extends Component { 

    render() {
        return (
            <div>
                <ul>
                <li>Home</li>
                <li>About</li>
                <li>Contact</li>
                </ul>
            </div>
        );
    }
}


export default class Contact extends Component {
    render() {
        return (
            <div>
                <h1>contact ..</h1>
            </div>
        )
    }
}

function routing(){
    return(
    <Router history= {browerHistory}>
        <Route path="/" component = {ReactApp}>
            <IndexRoute component={Home} />
            <Route path = "home" component={Home}/>
            <Route path = "about" component={About}/>
            <Route path = "contact" component={Contact}/>
        </Route>
    </Router>);
}

ReactDOM.render(routing, document.getElementById('reactApp'));