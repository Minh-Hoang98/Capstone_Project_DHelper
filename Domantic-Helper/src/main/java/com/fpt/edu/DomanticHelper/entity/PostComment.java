package com.fpt.edu.DomanticHelper.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "post_comment")
public class PostComment implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User userComment;
	
	@ManyToOne
    @JoinColumn(name = "post_id")
    private Post postComment;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date_rate")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;

	
	public PostComment() {
		super();
	}


	public PostComment(int id, User userComment, Post postComment, String description, Date date) {
		super();
		this.id = id;
		this.userComment = userComment;
		this.postComment = postComment;
		this.description = description;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUserComment() {
		return userComment;
	}


	public void setUserComment(User userComment) {
		this.userComment = userComment;
	}


	public Post getPostComment() {
		return postComment;
	}


	public void setPostComment(Post postComment) {
		this.postComment = postComment;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
}
