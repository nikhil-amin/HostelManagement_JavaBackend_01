package com.hostelmanagement.backend.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.login.dto.AuthenticationRequest;
import com.hostelmanagement.backend.login.dto.AuthenticationResponse;
import com.hostelmanagement.backend.user.service.MyUserDetailsService;
import com.hostelmanagement.backend.util.JwtUtil;

@Controller
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) throws ServiceException {
        
		try {
			
			authenticationManager.authenticate(
        			new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        	);
		}catch (BadCredentialsException bce) {
			throw new ServiceException("[ERROR:BCE] login() ", bce);
		}catch (Exception e){
            throw new ServiceException("[ERROR:E] login() ", e);
        }
		
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
    }
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody AuthenticationRequest authenticationRequest) throws ServiceException {
        
		try{
            myUserDetailsService.registerNewUser(authenticationRequest);
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getRoomsList() ",se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getRoomsList() ",e);
        }
    }
}
