package com.fpt.edu.DomanticHelper.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "helper_job")
public class HelperJob {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_helper")
    private int id;

    @Column(name = "number_child", length = 50)
    private int numberChild;

    @Column(name = "accommodation", length = 150)
    private String accommodation;

    @Column(name = "living_arrangement", length = 100)
    private String livingArrangement;

    @Column(name = "house_size")
    private float houseSize;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "care", length = 100)
    private String care;

    @Column(name = "cooking", length = 100)
    private String cooking;

    @Column(name = "houseKeeping", length = 100)
    private String houseKeeping;

    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateStart;

    @Column(name = "day_off")
    private String dayOff;

    @Column(name = "education_level", length = 50)
    private String educationLevel;

    @Column(name = "expected_monthly_salary")
    private float expectedMonthlySalary;

    @Column(name = "preferred_location", length = 50)
    private String preferredLocation;

    @Column(name = "year_of_experience")
    private int yearOfExperience;

    @Column(name = "skills", length = 100)
    private String skills;

    @Column(name = "status")
    private String status;


    public HelperJob() {
        super();
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumberChild() {
		return numberChild;
	}


	public void setNumberChild(int numberChild) {
		this.numberChild = numberChild;
	}


	public String getAccommodation() {
		return accommodation;
	}


	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}


	public String getLivingArrangement() {
		return livingArrangement;
	}


	public void setLivingArrangement(String livingArrangement) {
		this.livingArrangement = livingArrangement;
	}


	public float getHouseSize() {
		return houseSize;
	}


	public void setHouseSize(float houseSize) {
		this.houseSize = houseSize;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getCare() {
		return care;
	}


	public void setCare(String care) {
		this.care = care;
	}


	public String getCooking() {
		return cooking;
	}


	public void setCooking(String cooking) {
		this.cooking = cooking;
	}


	public String getHouseKeeping() {
		return houseKeeping;
	}


	public void setHouseKeeping(String houseKeeping) {
		this.houseKeeping = houseKeeping;
	}


	public Date getDateStart() {
		return dateStart;
	}


	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}


	public String getDayOff() {
		return dayOff;
	}


	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
	}


	public String getEducationLevel() {
		return educationLevel;
	}


	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
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


	public int getYearOfExperience() {
		return yearOfExperience;
	}


	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
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

  


}
