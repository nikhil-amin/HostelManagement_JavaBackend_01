package com.hostelmanagement.backend.login.dto;

public class AuthenticationResponse {

	private final String userName;
	private final String fullName;
	private final String email;
	private final String jwt;
	private final long tokenExpirationDate;

	public AuthenticationResponse(String userName, String fullName, String email, String jwt, long tokenExpirationDate) {
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.jwt = jwt;
		this.tokenExpirationDate = tokenExpirationDate;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getJwt() {
		return jwt;
	}
	
	public long getTokenExpirationDate() {
		return tokenExpirationDate;
	}

}
