package com.fpt.edu.DomanticHelper.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private int id;
	private String username;
	private String phone;
	private String email;
	private String avatar;
	private List<String> roles;

	public JwtResponse(String accessToken, int i, String username,String phone, String email, String avatar, List<String> roles) {
		this.token = accessToken;
		this.id = i;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.roles = roles;
		this.avatar = avatar;
	}
	public JwtResponse(String accessToken, int i, String username,String phone, String email, List<String> roles) {
		this.token = accessToken;
		this.id = i;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.roles = roles;
	
	}
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
