import React, {Component} from 'react';
import {Jumbotron} from "react-bootstrap";

class HelloWorld extends Component {
    render() {
        return (
            <div>
                <Jumbotron className="bg-dark text-white text-uppercase">
                    <h1>Welcome to Domestic Helper!</h1>
                    <blockquote className="blockquote mb-0">
                        <p>
                            Mang đến niềm vui và hạnh phúc cho gia đình bạn
                        </p>
                        <footer className="blockquote-footer">
                            Mr_Css
                        </footer>
                    </blockquote>
                </Jumbotron>
            </div>
        );
    }
}

export default HelloWorld;