package com.fpt.edu.DomanticHelper.payload.request;
import javax.validation.constraints.*;
public class ResetRequest {

	@NotBlank
	private String token;
	@NotBlank
	private String password;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




}
