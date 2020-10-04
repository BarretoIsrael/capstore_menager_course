import React from 'react';
import logo from './logo.png';
import './App.css';
import Welcome from "./components/Welcome";
import NavigationBar from './components/NavigationBar';
import Footer from './components/Footer';
import Carousel from './components/Carousel';
import Cap from './components/Cap';
import CapList from './components/CapList';
import {Container, Row, Col, Jumbotron} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';



function App() {
    const marginTop = {
        marginTop:"20px"
    };

  return (
    <Router>
        <NavigationBar/>

        <container>
            <Row>
                <Col lg={12} style={marginTop}>
                <Switch>
                    <Route path="/" exact component={Welcome}/>
                    <Route path="/add" exact component={Cap}/>
                    <Route path="/list" exact component={CapList}/>
                </Switch>
                </Col>
            </Row>
        </container>
        <container>
            <Row>
                <Col lg={4} style={marginTop}></Col>
                <Col lg={4} style={marginTop}>
                    <img src={logo} className="App-logo" alt="logo"/>
                </Col>
                <Col lg={4} style={marginTop}></Col>
            </Row>
        </container>
        <Footer/>
    </Router>
  );
}

export default App;
