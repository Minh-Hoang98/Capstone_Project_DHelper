package com.fpt.edu.DomanticHelper.payload.request;
import javax.validation.constraints.*;
public class ForgotRequest {

	@NotBlank
	private String email;



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
