import React, { Component } from "react";
import Tinh from "./TinhThanh.json";
import style from './PostTop_home.module.css'
import baiPost from './Top10post.json'
import top5 from './Top5.json'


export default class PostTop_home extends Component {
  renderTinh = () => {
    return Tinh.map((tenTinh, index) => {
      return <option>{tenTinh.Tinh}</option>;
    });
  };
  renderPost = () =>{
    return baiPost.map((post,index) => {
      return (
        <div className="media border p-1 mt-1 mb-1" key={index}>
          <div className="media-body">
            <h5  style={{color:'#203181'}}>{post.tenChuNha} | <span class="badge badge-light"> Hình thức:{post.hinhThuc}</span> | <span class="badge badge-light"> Lương: {post.salary}</span>  <span class="badge badge-info" >{post.diaChi}</span> </h5>
            <p className='text-break' style={{fontSize:'15px'}}> <b>Nội dung:</b> {post.Content.substr(0,190)} <a className='text-primary ' style={{textDecoration:'none' ,cursor:'pointer'}}>  Xem thêm...</a></p>
            <small style={{paddingRight:'60px'}}><i className='text-secondary'>Được đăng lúc:{post.timePost}</i></small>
          </div>
          <img src={post.imgProfile} alt="John Doe" className="ml-2 mt-3 rounded-circle" style={{width:'70px',height:'80px'}} />
       </div>
      )
    }) 
  }

  renderTop5 = () => {
    return top5.map((top,index) => {
      return (
        <div className="media border p-1  mt-1 mb-1" key={index}>
        <div className="media-body">
          <h5  style={{color:'#203181'}}> {top.tenUngVien} | <span className="badge badge-light"> {top.tuoi} Tuổi </span>  </h5>
        
             <span className="badge badge-info" >{top.diaChi}</span>
             <span className="badge badge-light ml-3"> Lượt thuê:{top.luotThue}</span>
              <br/>
              <br/>
               <div className='row pl-3 pt-2 '>
                    <i class="fa fa-star" style={{color:'#ffc800'}}></i>
                    <i class="fa fa-star" style={{color:'#ffc800'}}></i>
                    <i class="fa fa-star" style={{color:'#ffc800'}}></i>
                    <i class="fa fa-star" style={{color:'#ffc800'}}></i>
                    <i class="fa fa-star" style={{color:'#ffc800'}}></i>
               <div type="button" className={style.buttonPT} > <i class="fa fa-arrow-right"></i> Tuyển dụng</div>
               </div>
        </div>
        <img src='https://toplist.vn/images/800px/kamiwedding-316252.jpg' alt="John Doe" className="ml-2 mt-3 rounded-circle" style={{width:'70px',height:'80px'}} />
   </div>
      )
    })
  }

  render() {
   
    return (
      <div className="container-fluid">
        <div className="row  w-100 pb-3 pl-0 pr-0">
          <div className="col-2 text-center border border-right-0 filter" style={{ width: "100%" }}>
            
            <form action="/action_page.php" style={{ paddingTop: "20%",paddingBottom:'20%' ,marginTop:'80px' }} className='border'>
           
              <div style={{ width: "100%" }}>
                <div className="form-check-inline ">
                  <label className="form-check-label" htmlFor="check1">
                    <input
                      type="checkbox"
                      className="form-check-input"
                      id="check1"
                      name="vehicle1"
                      defaultValue="something"
                      
                    />
                    Full Time
                  </label>
                </div>
                <div className="form-check-inline">
                  <label className="form-check-label" htmlFor="check2">
                    <input
                      type="checkbox"
                      className="form-check-input"
                      id="check2"
                      name="vehicle2"
                      defaultValue="something"
                    />
                    Part Time
                  </label>
                </div>
              </div>
              {/* tìm kiếm địa chỉ */}
              <div className="form-group"></div>
            
              <div style={{ width: "100%", padding: "20px 5px 20px 5px" }}>
                <label htmlFor="sel1">Tỉnh thành:</label>
                <select className="form-control px-2 " id="sel1" name="sellist1">
                  <option>Chọn tỉnh :</option>
                  {this.renderTinh()}
                </select>
              </div>

              <button type="submit" className="btn btn-primary">
                Tìm kiếm
              </button>
            </form>
          </div>
          <div className="col-7 border border-left-0">
          <h2 className="p-3 text-center" style={{color:'#203181'}} >TOP BÀI ĐĂNG MỚI NHẤT</h2>
              {this.renderPost()}
              <ul class="pagination justify-content-center pt-3" >
                  <li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
                  <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
                  <li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
                  <li class="page-item"><a class="page-link" href="javascript:void(0);">3</a></li>
                  <li class="page-item"><a class="page-link" href="javascript:void(0);">4</a></li>
                  <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
               </ul>
          </div>
          <div className="col-3 border">
             <h4 className="p-3 mb-4 text-center" style={{color:'#203181'}} >TOP 5 ỨNG VIÊN XUẤT SẮC</h4>
             <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
             <div class="btn-group" role="group">
    <button
      id="btnGroupDrop1"
      type="button"
      class="btn btn-primary dropdown-toggle"
      data-mdb-toggle="dropdown"
      aria-expanded="false"
    >
      Dropdown
    </button>
    <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
    </ul>
  </div>
             </div>
             {this.renderTop5()}
            
          </div>
        </div>
      </div>
    );
  }
}
