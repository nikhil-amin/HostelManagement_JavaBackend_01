package com.hostelmanagement.backend.user.dto;

import java.io.Serializable;

public class UserDetailsDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int userID;
	private String userName;
	private String password;
	private String fullName;
	private String email;
	
	public UserDetailsDTO() {
	}

	public UserDetailsDTO(String userName, String password, String fullName, String email) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
