package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "post_comment")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post postId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@Column(name = "description")
	private String description;

	@Column(name = "date_rate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateRate;

	public PostComment(int id, User userId, Post postId, String description, Date dateRate) {
		super();
		this.id = id;
		this.userId = userId;
		this.postId = postId;
		this.description = description;
		this.dateRate = dateRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Post getPostId() {
		return postId;
	}

	public void setPostId(Post postId) {
		this.postId = postId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateRate() {
		return dateRate;
	}

	public void setDateRate(Date dateRate) {
		this.dateRate = dateRate;
	}

}
