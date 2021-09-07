import React , {Component} from 'react';
import {Card, Form} from "react-bootstrap";
import * as ReactBootstrap from 'react-bootstrap';
import CardHeader from "react-bootstrap/CardHeader";


export default class Users extends Component {


    render() {
        return (
            <div>
            <Card className="border border-dark bg-dark text-white">
                <CardHeader>Create a new user</CardHeader>
                    <Card.Body>

                        <Form onSubmit={this.submitUser} id="userFormId">

                            <Form.Group className="mb-3" >
                                <Form.Label>First name</Form.Label>
                                <Form.Control name="first_name" type="text" placeholder="First name" />
                            </Form.Group>
                            <Form.Group className="mb-3" >
                                <Form.Label>Last name</Form.Label>
                                <Form.Control name="last_name"  type="text" placeholder="Last name" />
                            </Form.Group>

                            <Form.Group className="mb-3" controlId="formBasicEmail">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control name="email" type="email" placeholder="Enter email" />
                                <Form.Text className="text-muted">
                                    We'll never share your email with anyone else.
                                </Form.Text>
                            </Form.Group>

                            <Form.Group className="mb-3" controlId="formBasicPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control name="password"  type="password" placeholder="Password" />
                            </Form.Group>
                            <Form.Group className="mb-3" >
                                <Form.Label>Phone number</Form.Label>
                                <Form.Control name="phone" type="text" placeholder="example : +216 99 999 999" />
                            </Form.Group>
                            <Form.Group className="mb-3">
                            <Form.Select name="role" >
                                <option>Select role...</option>
                                <option>Project Manager</option>
                                <option>Employee</option>
                            </Form.Select>
                            </Form.Group>
                            <Form.Group className="mb-3" controlId="formBasicCheckbox">
                                <Form.Check type="checkbox" label="I agree to all terms and conditions" />
                            </Form.Group>

                            <Card.Footer >

                                    <ReactBootstrap.Button variant="primary" type="submit">
                                        Create
                                    </ReactBootstrap.Button>

                            </Card.Footer>
                        </Form>
                    </Card.Body>


            </Card>
            <br></br><br></br>
            </div>


        );
    }

}

