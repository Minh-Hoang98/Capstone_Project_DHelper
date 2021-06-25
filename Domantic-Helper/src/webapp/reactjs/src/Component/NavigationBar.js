import React, {Component} from 'react';

import {Navbar, Nav} from 'react-bootstrap';
import {Link} from "react-router-dom";

class NavigationBar extends Component {
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="/"><img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRabAbb6DJ3F4Snn2IKf9DI9EVoC30gMSFaow&usqp=CAU"
                    width="50" height="50" alt="abc"/> DHelper
                </Navbar.Brand>
                <Nav className="me-auto">
                    <Link to={"add"} className="nav-link">Add User</Link>
                    <Link to={"list"} className="nav-link">User List</Link>
                    <Link to={"listLocation"} className="nav-link">Location List</Link>
                    <Link to={"addLocation"} className="nav-link">Add Location</Link>
                </Nav>
            </Navbar>
        );
    }
}

export default NavigationBar;