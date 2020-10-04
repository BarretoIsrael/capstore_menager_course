import React, {Component} from 'react';
import {Card, Table} from 'react-bootstrap';


export default class CapList extends Component{
    render(){
        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Cap List</Card.Header>
                <Card.Body>
                    <Table striped bordered hover variant="dark">
                      <thead>
                        <tr>
                          <th>Marca</th>
                          <th>Cor</th>
                          <th>Tamanho</th>
                          <th>Autor</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr align="center">
                          <td colSpan="6">No Itens Available</td>
                        </tr>
                      </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }
}