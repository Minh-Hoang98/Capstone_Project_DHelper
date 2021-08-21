package com.fpt.edu.DomanticHelper.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "post_rate")
public class PostRate implements Serializable{

	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
	  @JoinColumn(name = "user_id", insertable = false, updatable = false),
	  @JoinColumn(name = "post_id", insertable = false, updatable = false)
	})
	private PostApply ratePostApply;
	
	 @Column(name = "rate")
	private int rate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date_rate")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	public PostRate(PostApply ratePostApply, int rate, String description, Date date) {
		super();
		this.ratePostApply = ratePostApply;
		this.rate = rate;
		this.description = description;
		this.date = date;
	}

	public PostApply getRatePostApply() {
		return ratePostApply;
	}

	public void setRatePostApply(PostApply ratePostApply) {
		this.ratePostApply = ratePostApply;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
