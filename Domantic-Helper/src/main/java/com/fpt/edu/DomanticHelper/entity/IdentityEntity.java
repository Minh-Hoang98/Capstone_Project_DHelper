package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "identity")
public class IdentityEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_dentity")
	private int idIdentity;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "day_of_birth")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;	
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "religion")
	private String religion;
	
	@Column(name = "native_country")
	private String nativeCountry;
	
	@Column(name = "identity_characteristics")
	private String identityCharacteristics;
	
	@Column(name = "date_of_issue")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfIssue;
	
	@ManyToOne
	@JoinColumn(name = "locationId")
	private LocationEntity locationHome;

	@OneToOne(mappedBy = "identityEntity")
    private UserEntity user;
	
	public IdentityEntity() {
		super();
	}

	public IdentityEntity(int idIdentity, String image, String firstName, String lastName, String nickName,
			String gender, Date dob, String nationality, String religion, String nativeCountry,
			String identityCharacteristics, Date dateOfIssue, LocationEntity locationHome) {
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
		this.identityCharacteristics = identityCharacteristics;
		this.dateOfIssue = dateOfIssue;
		this.locationHome = locationHome;
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
				+ ", identityCharacteristics=" + identityCharacteristics + ", dateOfIssue=" + dateOfIssue
				+ ", locationHome=" + locationHome + "]";
	}

	
}
