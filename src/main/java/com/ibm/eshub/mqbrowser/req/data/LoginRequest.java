package com.ibm.eshub.mqbrowser.req.data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginRequest {

	//@Email(message="input right format email")
	//@NotEmpty(message="email can't be empty")
	private String email;
	
	//@NotEmpty(message="password can't be empty")
	private String password;
	
	public LoginRequest() {
	}

	public LoginRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "LoginUserRequest{email='" + email + '\'' + '}';
	}
}
