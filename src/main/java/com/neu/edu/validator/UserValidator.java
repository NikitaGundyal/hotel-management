package com.neu.edu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.dao.UserDAO;
import com.neu.edu.pojo.Guest;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	UserDAO userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(Guest.class);
		//return Guest.class.isAssignableFrom(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Guest guest = (Guest) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.firstname", "error.invalid.user.firstName", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.lastname", "error.invalid.user.lastname", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.username", "error.invalid.user.username", "Username Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "error.invalid.user.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guest.address", "error.invalid.guest.address", "Address Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guest.zipcode", "error.invalid.guest.zipcode", "Zipcode Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guest.state", "error.invalid.guest.state", "State Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guest.phNum", "error.invalid.guest.phNum", "Phone Number Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guest.emailID", "error.invalid.guest.emailID", "Email ID Required");

		boolean name = userDao.validateUsername(guest.getUser().getUsername());
		boolean email = userDao.validateEmailID(guest.getEmailID());
		
		if(name) {
			
			errors.rejectValue("user.username", "user.username-invalid", "Username already exists; please enter another value");
		}
		if(email) {
			
			errors.rejectValue("guest.emailId", "guest.emailId-invalid", "Email already exists; please enter another value");
			
		}
		
		
	}
	
	

}
