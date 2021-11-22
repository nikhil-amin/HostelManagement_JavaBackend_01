package com.hostelmanagement.backend.user.dao.constants;

public class QueryConstants {

	public final static String GET_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
	
	public final static String INSERT_NEW_USER = "INSERT INTO users(username, password, fullname, email) VALUES (?, ?, ?, ?)";

	public final static String GET_USER_ID_BY_USERNAME = "SELECT count(*) FROM users WHERE username = ?";
}
