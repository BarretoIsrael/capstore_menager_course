import React from 'react';
import {Navbar, Nav} from 'react-bootstrap';
import nav from './nav.png';
import {Link} from 'react-router-dom';

class NavigationBar extends React.Component{
    render(){
        return (
            <Navbar bg="dark" variant="dark">
                <Link to={""} className="navbar-brand">
                    <img src={nav} className="App-Nav" alt="Ue" width="30" height="30"/>
                </Link>
                <Nav className="mr-auto">
                  <Link to={"add"} className="nav-link">Add Sublimes</Link>
                  <Link to={"list"} className="nav-link">List Sublimes</Link>
                </Nav>
              </Navbar>

        );
    }
}

export default NavigationBar;