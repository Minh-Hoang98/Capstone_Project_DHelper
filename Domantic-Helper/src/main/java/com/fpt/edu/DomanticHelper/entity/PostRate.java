package com.fpt.edu.DomanticHelper.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "post_rate")
public class PostRate implements Serializable{

	@Id
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<UserApply> userRateApply;

	@Id
	@OneToMany(mappedBy = "postId", cascade = CascadeType.ALL)
	private List<UserApply> postRateApply;

	@Column(name = "rate")
	private int rate;

	@Column(name = "description")
	private String description;

	@Column(name = "date_rate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateRate;

	public PostRate() {
		super();
	}

	public PostRate(List<UserApply> userRateApply, List<UserApply> postRateApply, int rate, String description,
			Date dateRate) {
		super();
		this.userRateApply = userRateApply;
		this.postRateApply = postRateApply;
		this.rate = rate;
		this.description = description;
		this.dateRate = dateRate;
	}

	public List<UserApply> getUserRateApply() {
		return userRateApply;
	}

	public void setUserRateApply(List<UserApply> userRateApply) {
		this.userRateApply = userRateApply;
	}

	public List<UserApply> getPostRateApply() {
		return postRateApply;
	}

	public void setPostRateApply(List<UserApply> postRateApply) {
		this.postRateApply = postRateApply;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
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