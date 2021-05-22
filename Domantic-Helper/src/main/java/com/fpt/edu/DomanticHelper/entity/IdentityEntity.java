
package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "identity")
public class IdentityEntity {
	
	@Id
	@Column(name = "idIdentity")
	private String idIdentity;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "nickName")
	private String nickName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "day_of_birth")
	private Date dob;	
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "religion")
	private String religion;
	
	@Column(name = "nativeCountry")
	private String nativeCountry;
	
	@ManyToOne 
	@JoinColumn(name = "idLocation")
	private LocationEntity locationWork;

	@Column(name = "identityCharacteristics")
	private String identityCharacteristics;
	
	@Column(name = "dateOfIssue")
	private Date dateOfIssue;
	
	@ManyToOne 
	@JoinColumn(name = "idLocation")
	private LocationEntity locationHome;
	
	
	public IdentityEntity() {
		super();
	}
	
	public IdentityEntity(String idIdentity, String image, String firstName, String lastName, String nickName,
			String gender, Date dob, String nationality, String religion, String nativeCountry,
			LocationEntity locationWork, String identityCharacteristics, Date dateOfIssue,
			LocationEntity locationHome) {
		super();
		this.idIdentity = idIdentity;
		this.image = image;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.gender = gender;
		this.dob = dob;
		this.nationality = nationality;
		this.religion = religion;
		this.nativeCountry = nativeCountry;
		this.locationWork = locationWork;
		this.identityCharacteristics = identityCharacteristics;
		this.dateOfIssue = dateOfIssue;
		this.locationHome = locationHome;
	}

	public String getIdIdentity() {
		return idIdentity;
	}
	public void setIdIdentity(String idIdentity) {
		this.idIdentity = idIdentity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getNativeCountry() {
		return nativeCountry;
	}
	public void setNativeCountry(String nativeCountry) {
		this.nativeCountry = nativeCountry;
	}
	public LocationEntity getLocationWork() {
		return locationWork;
	}
	public void setLocationWork(LocationEntity locationWork) {
		this.locationWork = locationWork;
	}
	public String getIdentityCharacteristics() {
		return identityCharacteristics;
	}
	public void setIdentityCharacteristics(String identityCharacteristics) {
		this.identityCharacteristics = identityCharacteristics;
	}
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public LocationEntity getLocationHome() {
		return locationHome;
	}
	public void setLocationHome(LocationEntity locationHome) {
		this.locationHome = locationHome;
	}
	@Override
	public String toString() {
		return "IdentityEntity [idIdentity=" + idIdentity + ", image=" + image + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nickName=" + nickName + ", gender=" + gender + ", dob=" + dob
				+ ", nationality=" + nationality + ", religion=" + religion + ", nativeCountry=" + nativeCountry
				+ ", locationWork=" + locationWork + ", identityCharacteristics=" + identityCharacteristics
				+ ", dateOfIssue=" + dateOfIssue + ", locationHome=" + locationHome + "]";
	}
	
	
}
