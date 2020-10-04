import React from 'react';

import {Navbar, Container, Col} from 'react-bootstrap';

class Footer extends React.Component{
    render(){
        let fullYear = new Date().getFullYear();

        return(
            <Navbar fixed="bottom" bg="dark" variant="dark">
                <container>
                    <Col lg={12} className="text-center text-muted">
                        <div>{fullYear}, All Rights Reserved by TaOsso Sublime</div>
                    </Col>
                </container>
            </Navbar>
        );
    }

}

export default Footer;