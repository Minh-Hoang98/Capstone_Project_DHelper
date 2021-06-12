import React, {Component} from 'react';
import {Button, Card, Form, Col} from "react-bootstrap";

export default class User extends Component {

    constructor(props) {
        super(props);
        this.state = {avatar: '', userName: '', password: '', phone: '', email: '', location: '', identity: ''};
    }

    submitUser(event) {
        alert(this.state.avatar);
        event.preventDefault();
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Register User</Card.Header>
                <Form onSubmit={this.submitUser} id="userFormId">
                    <Card.Body>
                        <Form.Group as={Col} controlId="formFile" className="mb-3">
                            <Form.Label>Avatar</Form.Label>
                            <Form.Control type="file"/>
                        </Form.Group>
                        <Form.Row>
                            <Form.Group as={Col}>
                                <Form.Label>User Name</Form.Label>
                                <Form.Control
                                    type="text" name="userName"
                                    className={"bg-dark text-white"}
                                    placeholder="Nguyen Van A"/>
                            </Form.Group>
                            <Form.Group as={Col}>
                                <Form.Label>Password</Form.Label>
                                <Form.Control type="password" name="password"
                                              className={"bg-dark text-white"}
                                              placeholder="**********"/>
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col}>
                                <Form.Label>Phone</Form.Label>
                                <Form.Control type="phone" name="phone"
                                              className={"bg-dark text-white"}
                                              placeholder="012345678"/>
                            </Form.Group>
                            <Form.Group as={Col}>
                                <Form.Label>email</Form.Label>
                                <Form.Control type="email" name="email"
                                              className={"bg-dark text-white"}
                                              placeholder="name@example.com"/>
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col}>
                                <Form.Label>Location</Form.Label>
                                <Form.Control type="text" name="location"
                                              className={"bg-dark text-white"}
                                              placeholder=""/>
                            </Form.Group>
                            <Form.Group as={Col}>
                                <Form.Label>Identity</Form.Label>
                                <Form.Control type="text" name="identity"
                                              className={"bg-dark text-white"}
                                              placeholder=""/>
                            </Form.Group>
                        </Form.Row>
                    </Card.Body>
                    <Card.Footer style={{"textAlign": "right"}}>
                        <Button size="sm" variant="success" type="submit">
                            Submit
                        </Button>
                    </Card.Footer>
                </Form>
            </Card>
        );
    }
}