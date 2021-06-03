package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
<<<<<<< HEAD

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "status")
	private String status;
	
	@Column(name = "role")
	private String role;
=======
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git

<<<<<<< HEAD
	@ManyToOne
	@JoinColumn(name = "location_current")
	private LocationEntity currentLocation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "identity_entity_id")
	private IdentityEntity identityEntity;
	
	@OneToOne(mappedBy = "user_emp")
    private Employee employee;
	
	@OneToOne(mappedBy = "users_helper")
    private HelperJob helperJobs;
=======
	@Column(name = "avatar")
	private String avatar;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "location_current")
	private LocationEntity currentLocation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "identity_entity_id")
	private IdentityEntity identityEntity;
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git

	public UserEntity() {
		super();
	}

	public UserEntity(int id, String avatar, String userName, String password, String phone, String email,
<<<<<<< HEAD
			String status, String role, LocationEntity currentLocation, IdentityEntity identityEntity) {
=======
			String status, LocationEntity currentLocation, IdentityEntity identityEntity) {
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
		super();
		this.id = id;
		this.avatar = avatar;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.status = status;
<<<<<<< HEAD
		this.role = role;
		this.currentLocation = currentLocation;
		this.identityEntity = identityEntity;
		this.employee = employee;
		this.helperJobs = helperJobs;
=======
		this.currentLocation = currentLocation;
		this.identityEntity = identityEntity;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
<<<<<<< HEAD
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
=======
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

<<<<<<< HEAD
	public String getRole() {
		return role;
=======
	public LocationEntity getCurrentLocation() {
		return currentLocation;
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	}

<<<<<<< HEAD
	public void setRole(String role) {
		this.role = role;
=======
	public void setCurrentLocation(LocationEntity currentLocation) {
		this.currentLocation = currentLocation;
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	}

<<<<<<< HEAD
	public LocationEntity getCurrentLocation() {
		return currentLocation;
=======
	public IdentityEntity getIdentityEntity() {
		return identityEntity;
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	}

<<<<<<< HEAD
	public void setCurrentLocation(LocationEntity currentLocation) {
		this.currentLocation = currentLocation;
	}

	public IdentityEntity getIdentityEntity() {
		return identityEntity;
	}

	public void setIdentityEntity(IdentityEntity identityEntity) {
		this.identityEntity = identityEntity;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public HelperJob getHelperJobs() {
		return helperJobs;
	}

	public void setHelperJobs(HelperJob helperJobs) {
		this.helperJobs = helperJobs;
=======
	public void setIdentityEntity(IdentityEntity identityEntity) {
		this.identityEntity = identityEntity;
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", avatar=" + avatar + ", userName=" + userName + ", password=" + password
<<<<<<< HEAD
				+ ", phone=" + phone + ", email=" + email + ", status=" + status + ", role=" + role
				+ ", currentLocation=" + currentLocation + ", identityEntity=" + identityEntity + ", employee="
				+ employee + ", helperJobs=" + helperJobs + "]";
=======
				+ ", phone=" + phone + ", email=" + email + ", status=" + status + ", currentLocation="
				+ currentLocation + ", identityEntity=" + identityEntity + "]";
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	}

}
