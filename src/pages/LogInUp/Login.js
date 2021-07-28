import React, { Component} from 'react'
import './Login.css';
import img_login from './login.svg';
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";


import AuthService from "../../services/auth.service";



const requiredPassword = value => {
  if (!value) {
    return (
      <div className="text-danger alertLog " role="alert">
            Vui lòng điền mật khẩu!
      </div>
    );
  }
};

const requiredUserName = value => {
  if (!value) {
    return (
      <div className="text-danger alertLog " role="alert">
        Vui lòng điền tên đăng nhập !
      </div>
    );
  }
};


export default class Login extends Component {
  // eslint-disable-next-line react-hooks/rules-of-hooks
  constructor(props) {
    super(props);
    this.handleLogin = this.handleLogin.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);

    this.state = {
      username: "",
      password: "",
      loading: false,
      message: ""
    };



  } 


//   componentDidMount() {
//     // If the OAuth2 login encounters an error, the user is redirected to the /login page with an error.
//     // Here we display the error and then remove the error query parameter from the location.
//     if(this.props.location.state && this.props.location.state.error) {
//         setTimeout(() => {
//             Alert.error(this.props.location.state.error, {
//                 timeout: 5000
//             });
//             this.props.history.replace({
//                 pathname: this.props.location.pathname,
//                 state: {}
//             });
//         }, 100);
//     }
// }


  componentDidMount(){

    if ( this.props.location.state) 
    
    {
        const data =this.props.history.location.state.myData;
      console.log("sSSSS",data)
      this.setState({
        message: data});

      
    }

    setTimeout(() =>
      this.setState({
        message: ""
      }),3000)

  }
  


  onChangeUsername(e) {
    this.setState({
      username: e.target.value
    });
  }

  onChangePassword(e) {
    this.setState({
      password: e.target.value
    });
  }

  handleLogin(e) {
    e.preventDefault();

    this.setState({
      message: "",
      loading: true
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      AuthService.login(this.state.username, this.state.password).then(
        () => {
          this.props.history.push("/");
          window.location.reload();
        },
        error => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          this.setState({
            loading: false,
            message: resMessage
          });
        }
      );
    } else {
      this.setState({
        loading: false
      });
    }
  }
 
  render() {
 
    return (
      <div>
     
  <div className="block">
    <div className="forms-container">
      <div className="signin-signup">
        
             <Form 
            className='loginUp sign-in-form'
            onSubmit={this.handleLogin}
            ref={c => {
              this.form = c;
            }}
          >
            {this.state.message && (
              <div className="form-group">
                <div className="alert alert-danger" role="alert">
                  {this.state.message}
                </div>
              </div>
            )}
          <h2 className="titleLg">Đăng Nhập</h2>
          <div className="input-field inputfield">
            <i className="fas fa-user" />
            <Input
                type="text"
                name="username"
                placeholder="Tên Đăng Nhập"
                value={this.state.username}
                onChange={this.onChangeUsername}
                validations={[requiredUserName]}
              />
             
          </div>
          <div className="gc"></div>
          <div className="input-field inputfield">
            <i className="fas fa-lock" />
            <Input
                 className="pt-2"
                type="password"
                name="password"
                placeholder="Mật khẩu"
                value={this.state.password}
                onChange={this.onChangePassword}
                validations={[requiredPassword]}
              />
          </div>
          <div className="gc"></div>
          <div className="form-group">
                  <button>Resetpass:</button>
              <button
                className="btn btn-primary btn-block btnLg"
                disabled={this.state.loading}
              >
                {this.state.loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}

           
            
                <span>Login</span>
              </button>
            </div>
         
            
            <CheckButton
              style={{ display: "none" }}
              ref={c => {
                this.checkBtn = c;
              }}
            />
          <p className="social-text">Hoặc đăng nhập bằng:</p>
          <div className="social-media">
            <a href="#" className="social-icon">
              <i className="fab fa-facebook-f" />
            </a>
            <a href="#" className="social-icon">
              <i className="fab fa-google" />
            </a>
            <a href="#" className="social-icon">
              <i className="fab fa-linkedin-in" />
            </a>
          </div>
        </Form>
       
      </div>
    </div>
    <div className="panels-container">
      <div className="panel left-panel">
        <div className="content">
          <h3>Bạn cần thuê người giúp việc ?</h3>
          <p>
            Vui lòng đăng ký tài khoản để bạn có thể tuyển được nhiều giúp việc phù hợp nhất với mình !
          </p>
           <button className="btn transparent btnLg" onclick={this.changeInUp}  id="sign-up-btn">
            Đăng ký
          </button>
           
          
        </div>
        <img src={img_login} alt="logo" className="imagee" />
      </div>
    </div>
  </div>
</div>

    )
  }
}

