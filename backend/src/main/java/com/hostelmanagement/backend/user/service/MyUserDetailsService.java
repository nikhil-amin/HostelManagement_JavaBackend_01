package com.hostelmanagement.backend.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.login.dto.AuthenticationRequest;
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
	
	private Boolean isUserPresent(String username) throws ServiceException {
		
		try{
			return myUserDetailsDAO.isUserPresent(username);
		}catch (DBException de){
            throw new ServiceException("[ERROR:SE] registerNewUser() ",de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] registerNewUser() ",e);
        }
	}

	public void registerNewUser(AuthenticationRequest authenticationRequest) throws ServiceException {
		
		try{
			
			// Encrypting user password
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String password = passwordEncoder.encode(authenticationRequest.getPassword());
			authenticationRequest.setPassword(password);
			
			if(isUserPresent(authenticationRequest.getUsername())) {
				throw new ServiceException("Username Already Exists!");
			}
			
			myUserDetailsDAO.registerNewUser(authenticationRequest);
			
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] registerNewUser() ",de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] registerNewUser() ",e);
        }
	}

}
