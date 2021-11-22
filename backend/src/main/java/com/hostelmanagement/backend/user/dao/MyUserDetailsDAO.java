package com.hostelmanagement.backend.user.dao;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.user.dto.UserDetailsDTO;

public interface MyUserDetailsDAO {

	public UserDetailsDTO findUserByUsername(String username) throws DBException;
}
