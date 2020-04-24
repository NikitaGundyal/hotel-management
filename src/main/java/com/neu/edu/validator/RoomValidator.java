package com.neu.edu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.dao.RoomDAO;
import com.neu.edu.pojo.Guest;
import com.neu.edu.pojo.Room;

@Component
public class RoomValidator implements Validator{
	
	@Autowired
	RoomDAO roomDao;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Room.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Room room = (Room) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomNumber", "error.invalid.roomNumber", "Room Number Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomType", "error.invalid.roomType", "Room Type Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomPrice", "error.invalid.roomPrice", "Room Price Required");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomDesc", "error.invalid.roomDesc", "Room Description Required");

	    boolean roomNum = roomDao.validateRoomNumber(room.getRoomNumber());
	    if(roomNum) {
	    	errors.rejectValue("roomNumber", "roomNumber-invalid", "Room Number already exists; please enter another value");
		}
	}
	
   
}
