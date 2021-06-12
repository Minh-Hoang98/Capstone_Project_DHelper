import React, {Component} from 'react';
import {Card, Table} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList} from "@fortawesome/free-solid-svg-icons";

import axios from "axios";

export default class UserList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            users: []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8090/users/all")
            .then(response => response.data)
            .then((data) => {
                this.setState({users: data})
            })
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faList}/> User List</Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant="dark">
                        <thead>
                        <tr>
                            <th>avatar</th>
                            <th>User Name</th>
                            <th>Password</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Location</th>
                            <th>Identity</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.users.map((user) => (
                                <tr key={user.id}>
                                    <td>{user.avatar}</td>
                                    <td>{user.userName}</td>



                                </tr>

                            ))
                        }
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }
}
