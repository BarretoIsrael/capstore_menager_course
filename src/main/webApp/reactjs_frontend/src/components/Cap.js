import React, {Component} from 'react';
import {Card, Form, Button, Col} from 'react-bootstrap';

export default class Cap extends Component{



    render(){
        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Add cap</Card.Header>

                <Form id="capFormId">
                    <Card.Body>
                        <Form.Row>
                            <Form.Group as={Col}>
                                <Form.Label>Marca</Form.Label>
                                <Form.Control
                                 type="text" name="marca"
                                 className="bg-dark text-white"
                                 placeholder="Digite a Marca" />
                            </Form.Group>
                            <Form.Group as={Col}>
                                <Form.Label>Cor</Form.Label>
                                <Form.Control
                                 type="text" name="cor"
                                 className="bg-dark text-white"
                                 placeholder="Digite a Cor" />
                            </Form.Group>
                    </Form.Row>
                    <Form.Row>
                            <Form.Group as={Col}>
                                 <Form.Label>Tamanho</Form.Label>
                                 <Form.Control
                                  type="number" name="tamanho"
                                  className="bg-dark text-white"
                                  placeholder="Digite o tamanho de 1 a 3" />
                            </Form.Group>
                            <Form.Group as={Col}>
                                  <Form.Label>Autor</Form.Label>
                                  <Form.Control
                                    type="text" name="author"
                                   className="bg-dark text-white"
                                   placeholder="Digite o nome do Author" />
                            </Form.Group>

                        </Form.Row>
                    </Card.Body>
                    <Card.Footer style={{"textAlign":"right"}}>
                      <Button variant="success" size="sm" type="submit">
                        Submit
                      </Button>
                    </Card.Footer>
                </Form>
            </Card>
        );
    }
}
