package com.ibm.eshub.mqbrowser.logic.data;

public class LoginData {
	private String token;

	private String email;

	public LoginData() {
	}

	public LoginData(String token, String email) {
		this.token = token;

		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

}