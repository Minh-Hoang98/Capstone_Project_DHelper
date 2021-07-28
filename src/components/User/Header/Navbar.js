import React, {Component} from 'react';
import './Navbar.css'
import { NavLink, Link } from 'react-router-dom'

import AuthService from "../../../services/auth.service";
import EventBus from "../../common/EventBus";
class Navbar extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showModeratorBoard: user.roles.includes("ROLE_MODERATOR"),
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
    
    EventBus.on("logout", () => {
      this.logOut();
    });
  }

  componentWillUnmount() {
    EventBus.remove("logout");
  }

  logOut() {
    AuthService.logout();
    this.setState({
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    });
  }

  render() {
    const { currentUser, showModeratorBoard, showAdminBoard } = this.state;

    return (
      
        <nav className="navbar navbar-expand">
          <Link to={"/"} className="navbar-brand">
          <input type="checkbox" id="check" />
    <label htmlFor="check" className="checkbtn">
      <i className="fa fa-align-justify" />
    </label>
     <a href='/home'>
     <label className="logo" href="#">HelperChoice</label>
     </a>
          </Link>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
<ul>
      <li><NavLink to="/home" className="btLightRun" >
          <span />
          <span />
          <span />
          <span />
          {currentUser.username}
        </NavLink>
      </li>
      <li><NavLink to="/home" className="btLightRun" id="btnSignUp">
          <span />
          <span />
          <span />
          <span />
          <a href="/login" className="nav-link" onClick={this.logOut}>
                  LogOut
                </a>
        </NavLink>
      </li>
    </ul>
            </div>
          ) : (
            <div>
  {/* Menu */}
  <nav>
    <input type="checkbox" id="check" />
    <label htmlFor="check" className="checkbtn">
      <i className="fa fa-align-justify" />
    </label>
     <a href='/home'>
     <label className="logo" href="#">HelperChoice</label>
     </a>
    <ul>
      <li><NavLink to="/login" className="btLightRun" >
          <span />
          <span />
          <span />
          <span />
          Đăng Nhập
        </NavLink>
      </li>
      <li><NavLink to="/register" className="btLightRun" id="btnSignUp">
          <span />
          <span />
          <span />
          <span />
          Đăng Ký
        </NavLink>
      </li>
    </ul>
  </nav>
</div>
          )}
        </nav>
        );
  }
}

export default Navbar;
