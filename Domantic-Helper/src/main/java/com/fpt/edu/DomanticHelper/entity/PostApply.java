package com.fpt.edu.DomanticHelper.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "post_user_apply")
public class PostApply implements Serializable{
	
	@Id
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User userApply;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "post_id")
    private Post postApply;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	@OneToMany(mappedBy = "ratePostApply", cascade = CascadeType.ALL)
    private List<PostRate> rates;
	
	public PostApply(User userApply, Post postApply, int status, Date date) {
		super();
		this.userApply = userApply;
		this.postApply = postApply;
		this.status = status;
		this.date = date;
	}

	public User getUserApply() {
		return userApply;
	}

	public void setUserApply(User userApply) {
		this.userApply = userApply;
	}

	public Post getPostApply() {
		return postApply;
	}

	public void setPostApply(Post postApply) {
		this.postApply = postApply;
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
	
}
