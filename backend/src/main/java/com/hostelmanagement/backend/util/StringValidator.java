package com.hostelmanagement.backend.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

	public static boolean isDbSafe(String value) {
		if((-1 < value.indexOf("<")) || (-1 < value.indexOf(">")) || (-1 < value.indexOf("/")) || (-1 < value.indexOf("?"))) {
			return false;
		}
		return true;
	}
	
	public static boolean isLengthBetween(String value, int min, int max) {
		if((value.length() > min) && (value.length() < max)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumber(String value) {
    	String allowedString = "0123456789";
    	for(int i=0; i<value.length(); i++) {
    		if(allowedString.indexOf(value.charAt(i)) < 0) {
    			return false;
    		}
    	}
    	return true;
    }
	
	public static boolean isEmailValid(String email) {
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
}
