import React, {Component} from 'react';
import {Card, Table, ButtonGroup, Button} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList, faEdit} from "@fortawesome/free-solid-svg-icons";

import axios from "axios";
import {Link} from "react-router-dom";
import MyToast from "../MyToast";

export default class LocationList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            locations: []
        }
    }

    componentDidMount() {
        this.findAllLocation();
    }

    findAllLocation() {
        axios.get("http://localhost:8090/location/all")
            .then(response => response.data)
            .then((data) => {
                this.setState({locations: data})
            })
    };

    deleteLocation = (id) => {
        alert(id)
    };

    render() {
        return (
            <div>
                <div style={{"display": this.state.show ? "block" : "none"}}>
                    <MyToast show={this.state.show} message={"Location Saved Successfully."} type={"danger"}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header><FontAwesomeIcon icon={faList}/> Location List</Card.Header>
                    <Card.Body>
                        <Table bordered hover striped variant="dark">
                            <thead>
                            <tr>
                                <th>Home Number</th>
                                <th>Group</th>
                                <th>Sub District</th>
                                <th>District</th>
                                <th>Province</th>
                                <th>Country</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.locations.map((location) => (
                                    <tr key={location.idLocation}>
                                        <td>{location.numberHome}</td>
                                        <td>{location.group}</td>
                                        <td>{location.subDistrict}</td>
                                        <td>{location.district}</td>
                                        <td>{location.province}</td>
                                        <td>{location.country}</td>
                                        <td>
                                            <ButtonGroup>
                                                <Link to={"edit/" + location.idLocation}
                                                      className="btn btn-sm btn-outline-primary"><FontAwesomeIcon
                                                    icon={faEdit}/></Link>{''}
                                                <Button size="sm" variant="outline-danger"
                                                        onClick={this.deleteLocation.bind(this, location.idLocation)}>
                                                    <FontAwesomeIcon icon={faEdit}/></Button>
                                            </ButtonGroup>
                                        </td>
                                    </tr>
                                ))
                            }
                            </tbody>
                        </Table>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}
