import './App.css';
import NavigationBar from "./Component/NavigationBar";
import HelloWorld from "./Component/HelloWorld";
import User from "./Component/User/User";
import UserList from "./Component/User/UserList";
import Footer from "./Component/Footer";

import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import {Container, Row, Col} from "react-bootstrap";
import LocationList from "./Component/Location/LocationList";
import Location from "./Component/Location/Location";

function App() {
    const marginTop = {
        marginTop: "20px"
    };

    return (
        <Router>
            <NavigationBar/>
            <Container>
                <Row>
                    <Col lg={12} style={marginTop}>
                        <Switch>
                            <Route path="/" exact component={HelloWorld}/>
                            <Route path="/add" exact component={User}/>
                            <Route path="/list" exact component={UserList}/>
                            <Route path="/listLocation" exact component={LocationList}/>
                            <Route path="/addLocation" exact component={Location}/>
                            <Route path="/edit/:id" exact component={Location}/>
                        </Switch>
                    </Col>
                </Row>
            </Container>
            <Footer/>
        </Router>
    );
}

export default App;
