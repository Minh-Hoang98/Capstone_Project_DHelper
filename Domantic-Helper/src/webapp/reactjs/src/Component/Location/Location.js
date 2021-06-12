import React, {Component} from 'react';
import {Button, Card, Form, Col} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSave, faUndo, faList} from "@fortawesome/free-solid-svg-icons";
import MyToast from "../MyToast";
import axios from "axios";

export default class Location extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.submitLocation = this.submitLocation.bind(this);
        this.locationChange = this.locationChange.bind(this);
    }

    initialState = {
        id: '', country: '', province: '', district: '', subDistrict: '', group: '', numberHome: ''
    }

    componentDidMount() {
        const idLocation = this.props.match.params.id;
        if (idLocation) {
            this.findLocationById(idLocation)
        }
    }

    findLocationById = (idLocation) => {
        axios.get("http://localhost:8090/location/find/" + idLocation)
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        id: response.data.id,
                        country: response.data.country,
                        province: response.data.province,
                        district: response.data.district,
                        subDistrict: response.data.subDistrict,
                        group: response.data.group,
                        numberHome: response.data.numberHome
                    })
                }
            }).catch((error) => {
                console.error("Error - " + error);
        })
    }
    submitLocation = event => {
        event.preventDefault();

        const location = {
            country: this.state.country,
            province: this.state.province,
            district: this.state.district,
            subDistrict: this.state.subDistrict,
            group: this.state.group,
            numberHome: this.state.numberHome
        };

        axios.post("http://localhost:8090/location/add", location)
            .then(response => {
                if (response.data != null) {
                    this.setState({"show": true})
                    setTimeout(() => this.setState({"show": false}), 3000);
                } else {
                    this.setState({"show": false})
                }
            })
    };

    locationChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    resetLocation = () => {
        this.setState(() => this.initialState);
    };

    locationList = () => {
        return this.props.history.push("/listLocation");
    };

    render() {
        const {country, province, district, subDistrict, group, numberHome} = this.state;

        return (
            <div>
                <div style={{"display": this.state.show ? "block" : "none"}}>
                    <MyToast show={this.state.show} message={"Location Saved Successfully."} type={"success"}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header>Add Location</Card.Header>
                    <Form onReset={this.resetLocation} onSubmit={this.submitLocation} id="locationFormId">
                        <Card.Body>
                            <Form.Row>
                                <Form.Group as={Col} controlId="formFile" className="mb-3">
                                    <Form.Label>Country</Form.Label>
                                    <Form.Control required autoComplete="off"
                                                  type="text" name="country"
                                                  value={country}
                                                  onChange={this.locationChange}
                                                  className={"bg-dark text-white"}
                                                  placeholder="Viet Nam"/>
                                </Form.Group>
                                <Form.Group as={Col}>
                                    <Form.Label>Province</Form.Label>
                                    <Form.Control required autoComplete="off"
                                                  type="text" name="province"
                                                  value={province}
                                                  onChange={this.locationChange}
                                                  className={"bg-dark text-white"}
                                                  placeholder="Ha Noi"/>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col}>
                                    <Form.Label>District</Form.Label>
                                    <Form.Control required autoComplete="off"
                                                  type="text" name="district" value={district}
                                                  onChange={this.locationChange}
                                                  className={"bg-dark text-white"}
                                                  placeholder="Hoan Kiem"/>
                                </Form.Group>
                                <Form.Group as={Col}>
                                    <Form.Label>Sub District</Form.Label>
                                    <Form.Control required autoComplete="off"
                                                  type="text" name="subDistrict"
                                                  value={subDistrict}
                                                  onChange={this.locationChange}
                                                  className={"bg-dark text-white"}
                                                  placeholder="Ho Tay"/>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col}>
                                    <Form.Label>Group</Form.Label>
                                    <Form.Control required autoComplete="off"
                                                  type="text" name="group"
                                                  value={group}
                                                  onChange={this.locationChange}
                                                  className={"bg-dark text-white"}
                                                  placeholder="Hoa Xuan"/>
                                </Form.Group>
                                <Form.Group as={Col}>
                                    <Form.Label>Home Number</Form.Label>
                                    <Form.Control required autoComplete="off"
                                                  type="number" name="numberHome"
                                                  value={numberHome}
                                                  onChange={this.locationChange}
                                                  className={"bg-dark text-white"}
                                                  placeholder="434"/>
                                </Form.Group>
                            </Form.Row>
                        </Card.Body>
                        <Card.Footer style={{"textAlign": "right"}}>
                            <Button size="sm" variant="success" type="submit">
                                <FontAwesomeIcon icon={faSave}/>Submit
                            </Button>

                            <Button size="sm" variant="info" type="reset">
                                <FontAwesomeIcon icon={faUndo}/> Reset
                            </Button>

                            <Button size="sm" variant="info" type="button" onClick={this.locationList.bind()}>
                                <FontAwesomeIcon icon={faList}/> Location List
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        );
    }
}