import React from 'react';

import {Jumbotron} from 'react-bootstrap';

class Welcome extends React.Component{
    render(){
        return(
            <Jumbotron className="bg-dark text-white">
                <h1>Welcome to TaOsso Shop</h1>
                <blockquote className="blockquote mb-0">
                    <p><h3>
                    Site em desenvolvimento
                    </h3></p>
                    <footer className="blockquote-footer">
                        Israel Barreto
                    </footer>
                </blockquote>
            </Jumbotron>
        );
    }

}
export default Welcome;