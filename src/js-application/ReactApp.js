import React, { Component } from 'react';
import './css/ReactApp.css';
import ReactDOM from 'react-dom';
import { Route, HashRouter } from 'react-router-dom';

const LoginApplication = () => (<div>
<h1> this is login component</h1>
</div>);

class DisplayGet extends Component {

    constructor() {
        super();
        this.state = {
            home: '',
            clients: []
        }
    }

    componentDidMount() {
        this.fetchGet();
    }

    fetchGet() {
        fetch("home/checkGet")
            .then(response => response.json())
            .then(res => {
                console.log(res[0].home);
                this.setState({ home: res[0].home });
            })
    }

    render() {
        return (
            <div>
                <LoginApplication />
                <h1>Hello from the other way {this.state.home}</h1>
            </div>
        )
    }
}

const Home = () => (<div>
    <h2> Hello from the other place</h2>
</div>);

const ReactApp = () => (<div>
    <HashRouter>
        <Route path="/checkGet" component={DisplayGet} />
        <Route path="/home" component={Home} />
    </HashRouter>
</div>);

ReactDOM.render(<ReactApp />, document.getElementById('reactApp'));
