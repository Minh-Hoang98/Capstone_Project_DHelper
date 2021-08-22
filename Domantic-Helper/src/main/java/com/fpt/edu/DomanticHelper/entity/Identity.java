package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "identity")
public class Identity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_dentity")
	private int idIdentity;

	@Column(name="number_identity", nullable = false)
	private String numberIdentity;
	
	@Lob
	@Column(name = "image", columnDefinition = "MEDIUMBLOB")
	private String image;

	@Lob
	@Column(name = "image2", columnDefinition = "MEDIUMBLOB")
	private String image2;

	@Column(name = "name", nullable = false, length = 125)
	private String name;

	@Column(name = "gender", nullable = false, length = 50)
	private String gender;

	@Column(name = "day_of_birth", nullable = false, length = 125)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	@Column(name = "nationality", nullable = false, length = 125)
	private String nationality;

	@Column(name = "religion", nullable = false, length = 125)
	private String religion;

	@Column(name = "identity_characteristics", nullable = false, length = 125)
	private String identityCharacteristics;

	@Column(name = "date_of_issue", nullable = false, length = 125)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfIssue;

	@ManyToOne
	@JoinColumn(name = "locationId")
	private Location locationHome;

	@OneToOne(mappedBy = "identityEntity")
	private User user;

	public Identity() {
		super();
	}

	public Identity(int idIdentity, String numberIdentity, String image, String image2, String name, String gender,
			Date dob, String nationality, String religion, String identityCharacteristics, Date dateOfIssue,
			Location locationHome, User user) {
		super();
		this.idIdentity = idIdentity;
		this.numberIdentity = numberIdentity;
		this.image = image;
		this.image2 = image2;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.nationality = nationality;
		this.religion = religion;
		this.identityCharacteristics = identityCharacteristics;
		this.dateOfIssue = dateOfIssue;
		this.locationHome = locationHome;
		this.user = user;
	}
	
	public Identity(String numberIdentity, String image, String image2, String name, String gender,
			Date dob, String nationality, String religion, String identityCharacteristics, Date dateOfIssue,
			Location locationHome, User user) {
		super();
	
		this.numberIdentity = numberIdentity;
		this.image = image;
		this.image2 = image2;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.nationality = nationality;
		this.religion = religion;
		this.identityCharacteristics = identityCharacteristics;
		this.dateOfIssue = dateOfIssue;
		this.locationHome = locationHome;
		this.user = user;
	}

	public Identity(int idIdentity, String image, String image2, String name, String gender, Date dob,
			String nationality, String religion, String identityCharacteristics, Date dateOfIssue) {
		super();
		this.idIdentity = idIdentity;
		this.image = image;
		this.image2 = image2;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.nationality = nationality;
		this.religion = religion;
		this.identityCharacteristics = identityCharacteristics;
		this.dateOfIssue = dateOfIssue;
	}

	public String getNumberIdentity() {
		return numberIdentity;
	}

	public void setNumberIdentity(String numberIdentity) {
		this.numberIdentity = numberIdentity;
	}

	public int getIdIdentity() {
		return idIdentity;
	}

	public void setIdIdentity(int idIdentity) {
		this.idIdentity = idIdentity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Location getLocationHome() {
		return locationHome;
	}

	public void setLocationHome(Location locationHome) {
		this.locationHome = locationHome;
	}
}
