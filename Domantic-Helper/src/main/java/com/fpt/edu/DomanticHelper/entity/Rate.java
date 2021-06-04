package com.fpt.edu.DomanticHelper.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "rate")
public class Rate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="date_rate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateRate;
	
	@Column(name = "star_rate")
	private int starRate;
	
	@Column(name = "content", length = 255)
	private String content;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // Quan hệ n-n với đối tượng ở dưới (Emp) (1 rate có nhiều người danh gia)
    @JoinTable(name = "rate_emp", //Tạo ra một join Table tên là "rate_emp"
            joinColumns = @JoinColumn(name = "rate_id"),  // TRong đó, khóa ngoại chính là rate trỏ tới class hiện tại (Rate)
            inverseJoinColumns = @JoinColumn(name = "employee_id") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Employee)
    )
    private Collection<Employee> employees;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // Quan hệ n-n với đối tượng ở dưới (Helper) (1 người có nhiều đánh giá)
    @JoinTable(name = "rate_helper_job", //Tạo ra một join Table tên là "rate_helper_job"
            joinColumns = @JoinColumn(name = "rate_id"),  // TRong đó, khóa ngoại chính là rate trỏ tới class hiện tại (Rate)
            inverseJoinColumns = @JoinColumn(name = "helper_job_id") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Helper)
    )
    private Collection<HelperJob> helperJobs;
	
	public Rate() {
		super();
	}

	public Rate(int id, Date dateRate, int starRate, String content, Collection<Employee> employees,
			Collection<HelperJob> helperJobs) {
		super();
		this.id = id;
		this.dateRate = dateRate;
		this.starRate = starRate;
		this.content = content;
		this.employees = employees;
		this.helperJobs = helperJobs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateRate() {
		return dateRate;
	}

	public void setDateRate(Date dateRate) {
		this.dateRate = dateRate;
	}

	public int getStarRate() {
		return starRate;
	}

	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}

	public Collection<HelperJob> getHelperJobs() {
		return helperJobs;
	}

	public void setHelperJobs(Collection<HelperJob> helperJobs) {
		this.helperJobs = helperJobs;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", dateRate=" + dateRate + ", starRate=" + starRate + ", content=" + content
				+ ", employees=" + employees + ", helperJobs=" + helperJobs + "]";
	}
	
}
