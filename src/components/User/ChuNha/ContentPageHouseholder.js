import React, { Component } from 'react'

export default class ContentPageHouseholder extends Component {
  render() {
    return (
      
          <div className='container' style={{marginTop:'5%'}}>
          <div className="row " style={{padding:'50px 0 50px 0',height:'700px'}}>
          <div className="col-3 border">
            {/* Tab navs */}
            <div className="nav flex-column nav-pills text-center " id="v-pills-tab" role="tablist" aria-orientation="vertical">
              <a className="nav-link active bg-warning" id="v-pills-home-tab" data-mdb-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Đăng bài tìm người giúp việc</a>
              <a className="nav-link bg-warning" id="v-pills-profile-tab" data-mdb-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Bài viết đã đăng</a>
              <a className="nav-link bg-warning" id="v-pills-messages-tab" data-mdb-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Tìm kiếm người giúp việc</a>
              <a className="nav-link bg-warning" id="v-pills-messages-tab" data-mdb-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Tìm kiếm người giúp việc</a>
              <a className="nav-link bg-warning" id="v-pills-messages-tab" data-mdb-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Tìm kiếm người giúp việc</a>
              <a className="nav-link bg-warning" id="v-pills-messages-tab" data-mdb-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Tìm kiếm người giúp việc</a>
            </div>
            {/* Tab navs */}
          </div>
          <div className="col-9 border">
            {/* Tab content */}
            <div className="tab-content" id="v-pills-tabContent">
              <div className="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                Đăng bài tìm giúp việc
              </div>
              <div className="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                Profile content
              </div>
              <div className="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                Messages content lorem100

                code tầm bậy
              </div>
            </div>
            {/* Tab content */}
          </div>
        </div>
          </div>
        


      
    )
  }
}
