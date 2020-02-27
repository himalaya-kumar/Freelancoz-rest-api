import React, { Component } from 'react';
import './css/ReactApp.css';
import ReactDOM from 'react-dom';
import { Route, HashRouter } from 'react-router-dom';

const Home = () => (<div>
    <h2>Home...</h2>
</div>
);

const About = () => (<div>
    <h2>About...</h2>
</div>);

const Contact = () => (<div>
    <h2>Contact...</h2>
</div>);


class ReactApp extends Component {

    render() {
        return (
            <div>
                <HashRouter>
                    <Route path="/home" component={Home} />
                    <Route path="/about" component={About} />
                    <Route path="/Contact" component={Contact} />
                </HashRouter>
            </div>
        );
    }
}

ReactDOM.render(<ReactApp />, document.getElementById('reactApp'));
