package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "post_user_apply")
public class UserApply {
	
	  
	@Id
	    @ManyToOne
	    @JoinColumn(name = "postId")
	    private Post postId;
	@Id
	    @ManyToOne
	    @JoinColumn(name = "userId")
	    private User userId;

	    @Column(name = "status")
	    private int status;
	    
	    @Column(name = "date")
	    private Date date;

	    @ManyToOne
		@JoinColumn(name = "user_id_apply")
		private User postApply;
	   
		public UserApply() {
			super();
		}
		
		public UserApply(Post postId, User userId, int status, Date date) {
			super();
			this.postId = postId;
			this.userId = userId;
			this.status = status;
			this.date = date;
		}



		public Post getPostId() {
			return postId;
		}

		public void setPostId(Post postId) {
			this.postId = postId;
		}

		public User getUserId() {
			return userId;
		}

		public void setUserId(User userId) {
			this.userId = userId;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}



		@Override
		public String toString() {
			return "UserApply [postId=" + postId + ", userId=" + userId + ", status=" + status + ", date=" + date + "]";
		}
	    
	    

	    
	    
}
