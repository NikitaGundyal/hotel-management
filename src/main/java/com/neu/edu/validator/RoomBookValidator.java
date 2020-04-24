package com.neu.edu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Booking;
import com.neu.edu.pojo.Guest;

@Component
public class RoomBookValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Booking.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Booking booking = (Booking) target;
		if(booking.getCheckIn().before(booking.getCheckOut()) || booking.getCheckIn().compareTo(booking.getCheckOut())==0) {
			errors.rejectValue("checkIn", "checkIn-invalid", "Please choose a valid date");
		}		
		
		
	}

}
