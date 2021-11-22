package com.hostelmanagement.backend.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.user.dao.MyUserDetailsDAO;
import com.hostelmanagement.backend.user.dto.UserDetailsDTO;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MyUserDetailsDAO myUserDetailsDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try{
			UserDetailsDTO userDetails = myUserDetailsDAO.findUserByUsername(username);
			
			return new User(userDetails.getUserName(), userDetails.getPassword(), new ArrayList<>());
			
        }catch (DBException de){
            throw new UsernameNotFoundException("[ERROR:DE] loadUserByUsername() ", de);
        }catch (Exception e){
            throw new UsernameNotFoundException("[ERROR:E] loadUserByUsername() ", e);
        }
		
	}

}
