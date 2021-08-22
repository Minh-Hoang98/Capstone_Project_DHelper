package com.fpt.edu.DomanticHelper.security.jwt;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


public class FindJobRequest {

	String title;
	int typeJob;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date dateStart;
	String address;
	String salary;
	String status;
	String content;

	public FindJobRequest() {
		super();
	}

	public FindJobRequest(String title, int typeJob, Date dateStart, String address, String salary, String status,
			String content) {
		super();
		this.title = title;
		this.typeJob = typeJob;
		this.dateStart = dateStart;
		this.address = address;
		this.salary = salary;
		this.status = status;
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(int typeJob) {
		this.typeJob = typeJob;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}