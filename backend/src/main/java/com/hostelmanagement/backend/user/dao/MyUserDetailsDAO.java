package com.hostelmanagement.backend.user.dao;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.login.dto.AuthenticationRequest;
import com.hostelmanagement.backend.user.dto.UserDetailsDTO;

public interface MyUserDetailsDAO {

	public UserDetailsDTO findUserByUsername(String username) throws DBException;

	public void registerNewUser(AuthenticationRequest authenticationRequest) throws DBException;

	public Boolean isUserPresent(String username) throws DBException;
}
