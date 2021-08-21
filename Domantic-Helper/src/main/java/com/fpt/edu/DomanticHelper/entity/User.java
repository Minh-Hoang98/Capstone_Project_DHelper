package com.fpt.edu.DomanticHelper.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Lob
	@Column(name = "avatar", columnDefinition = "MEDIUMBLOB")
	private String avatar;

	@Column(name = "username", length = 125, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "phone", length = 50)
	private String phone;

	@Column(name = "email", nullable = false, length = 125)
	private String email;

	@Column(name = "hoc_van")
	private String hocVan;

	@Column(name = "chuyen_nganh")
	private String chuyenNganh;

	@Column(name = "status")
	private String status;

	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> role = new HashSet<>();

	@OneToMany(mappedBy = "userPost", cascade = CascadeType.ALL)
	private List<Post> posts;

	@ManyToOne
	@JoinColumn(name = "location_current")
	private Location currentLocation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "identity_entity_id")
	private Identity identityEntity;

	@OneToOne(mappedBy = "user_emp")
	private Employee employee;

	@OneToOne(mappedBy = "users_helper")
	private HelperJob helperJob;

	@OneToMany(mappedBy = "userApply", cascade = CascadeType.ALL)
	private List<PostApply> userPostApply;

	@OneToMany(mappedBy = "userComment", cascade = CascadeType.ALL)
	private List<PostComment> userCommentPost;

	public User() {
		super();
	}

	public User(String userName, String phone, String password, String email) {
		super();
		this.username = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public User(String userName, String phone, String password, String email, String avatar) {
		super();
		this.username = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.avatar = avatar;
	}

	public User(int id, String avatar, String username, String password, String phone, String email, String hocVan,
			String chuyenNganh, String status, String resetPasswordToken, Set<Role> role, List<Post> posts,
			Location currentLocation, Identity identityEntity, Employee employee, HelperJob helperJob,
			List<PostApply> userPostApply, List<PostComment> userCommentPost) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.hocVan = hocVan;
		this.chuyenNganh = chuyenNganh;
		this.status = status;
		this.resetPasswordToken = resetPasswordToken;
		this.role = role;
		this.posts = posts;
		this.currentLocation = currentLocation;
		this.identityEntity = identityEntity;
		this.employee = employee;
		this.helperJob = helperJob;
		this.userPostApply = userPostApply;
		this.userCommentPost = userCommentPost;
	}

	public String getHocVan() {
		return hocVan;
	}

	public void setHocVan(String hocVan) {
		this.hocVan = hocVan;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public List<PostComment> getUserCommentPost() {
		return userCommentPost;
	}

	public void setUserCommentPost(List<PostComment> userCommentPost) {
		this.userCommentPost = userCommentPost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<PostApply> getUserPostApply() {
		return userPostApply;
	}

	public void setUserPostApply(List<PostApply> userPostApply) {
		this.userPostApply = userPostApply;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
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

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public HelperJob getHelperJob() {
		return helperJob;
	}

	public void setHelperJob(HelperJob helperJob) {
		this.helperJob = helperJob;
	}

	public Identity getIdentityEntity() {
		return identityEntity;
	}

	public void setIdentityEntity(Identity identityEntity) {
		this.identityEntity = identityEntity;
	}

}
