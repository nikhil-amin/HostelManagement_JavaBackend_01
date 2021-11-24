package com.hostelmanagement.backend.login.dto;

public class AuthenticationRequest {

		private String userName;
		private String password;
		private String fullName;
		private String email;
		
		public AuthenticationRequest() {
		}

		// login
		public AuthenticationRequest(String userName, String password) {
			this.userName = userName;
			this.password = password;
		}
		
		// register
		public AuthenticationRequest(String userName, String password, String fullName, String email) {
			this.userName = userName;
			this.password = password;
			this.fullName = fullName;
			this.email = email;
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
