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

	public UserEntity() {
		super();
	}

	public UserEntity(int id, String avatar, String userName, String password, String phone, String email,
			String status, LocationEntity currentLocation, IdentityEntity identityEntity) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.currentLocation = currentLocation;
		this.identityEntity = identityEntity;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocationEntity getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(LocationEntity currentLocation) {
		this.currentLocation = currentLocation;
	}

	public IdentityEntity getIdentityEntity() {
		return identityEntity;
	}

	public void setIdentityEntity(IdentityEntity identityEntity) {
		this.identityEntity = identityEntity;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", avatar=" + avatar + ", userName=" + userName + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", status=" + status + ", currentLocation="
				+ currentLocation + ", identityEntity=" + identityEntity + "]";
	}

}
