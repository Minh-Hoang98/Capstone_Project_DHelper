package com.fpt.edu.DomanticHelper.entity;

import javax.persistence.*;

@Entity
@Table(name="helper")
public class HelperEntity extends UserEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_job")
	private Long idJob;
	
	private String education;
	
	private float expectedMonthlySalary;
	
	private String preferredLocation;
	
	private String yearsOfExperience;
	
	private String skills;
	
	private String status;

	public HelperEntity() {
		super();
	}

	public HelperEntity(Long idJob, String education, float expectedMonthlySalary, String preferredLocation,
			String yearsOfExperience, String skills, String status) {
		super();
		this.idJob = idJob;
		this.education = education;
		this.expectedMonthlySalary = expectedMonthlySalary;
		this.preferredLocation = preferredLocation;
		this.yearsOfExperience = yearsOfExperience;
		this.skills = skills;
		this.status = status;
	}

	public Long getIdJob() {
		return idJob;
	}

	public void setIdJob(Long idJob) {
		this.idJob = idJob;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public float getExpectedMonthlySalary() {
		return expectedMonthlySalary;
	}

	public void setExpectedMonthlySalary(float expectedMonthlySalary) {
		this.expectedMonthlySalary = expectedMonthlySalary;
	}

	public String getPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "JobEntity [idJob=" + idJob + ", education=" + education + ", expectedMonthlySalary="
				+ expectedMonthlySalary + ", preferredLocation=" + preferredLocation + ", yearsOfExperience="
				+ yearsOfExperience + ", skills=" + skills + ", status=" + status + "]";
	}
	
	
}
