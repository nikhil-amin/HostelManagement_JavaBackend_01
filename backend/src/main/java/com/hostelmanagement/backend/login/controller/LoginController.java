package com.hostelmanagement.backend.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.login.dto.AuthenticationRequest;
import com.hostelmanagement.backend.login.dto.AuthenticationResponse;
import com.hostelmanagement.backend.user.dto.UserDetailsDTO;
import com.hostelmanagement.backend.user.service.MyUserDetailsService;
import com.hostelmanagement.backend.util.JwtUtil;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
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
			System.out.println("LOGIN CALLED "+authenticationRequest);
			authenticationManager.authenticate(
        			new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
        	);
		}catch (BadCredentialsException bce) {
			throw new ServiceException("[ERROR:BCE] login() ", bce);
		}catch (Exception e){
            throw new ServiceException("[ERROR:E] login() ", e);
        }
		
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		
		final UserDetailsDTO ud = myUserDetailsService.findUserByUsername(authenticationRequest.getUserName());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		final long tokenExpirationMilliSeconds = jwtUtil.extractExpiration(jwt).getTime();
		
		return ResponseEntity.ok(new AuthenticationResponse(ud.getUserName(), ud.getFullName(), ud.getEmail(), jwt, tokenExpirationMilliSeconds));
		
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
