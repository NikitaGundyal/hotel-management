package com.neu.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.BookingRequestDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.pojo.Booking;
import com.neu.edu.pojo.Guest;
import com.neu.edu.pojo.Users;

@Controller

public class BookingRequestController {
	
	@Autowired
	BookingRequestDAO bookingrequestDao;
	
	@Autowired
	UserDAO userDao;
//	
//	@RequestMapping(value = "/guest/viewBookingRequest.htm", method = RequestMethod.GET)
//	protected ModelAndView showOpenRequests() throws Exception {
//
//		ModelAndView model = new ModelAndView();
//		List<Booking> roomBookRequests = bookingrequestDao.getPendingRequest("Pending");
//		model.addObject("roomBookRequests", roomBookRequests);
//		model.setViewName("requests-pending");
//		return model;
//	}
	
	@RequestMapping(value = "/admin/viewGuestsBookedRooms.htm", method = RequestMethod.GET)
	protected ModelAndView showGuestBookedRooms() throws Exception {

		ModelAndView model = new ModelAndView();
		List<Booking> allBookedRooms = bookingrequestDao.getAllBookings();
		model.addObject("allBookedRooms", allBookedRooms);
		model.setViewName("booked-rooms");
		return model;
	}
//	
//	@RequestMapping(value = "/guest/viewBookedRoomDetails.htm", method = RequestMethod.GET)
//	protected ModelAndView showRoomDetails() throws Exception {
//
//		ModelAndView model = new ModelAndView();
//		List<Booking> roomBookRequests = bookingrequestDao.getStatus("Booked");
//		model.addObject("roomBookRequests", roomBookRequests);
//		model.setViewName("requests-pending");
//		return model;
//	}

	@RequestMapping(value = "/guest/viewRoomBookRequest.htm", method = RequestMethod.GET)
	public ModelAndView getUserRequests(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		Guest guest = userDao.getGuest(user);
		List<Booking>bookings = bookingrequestDao.getSpecificGuestBookedRoom(guest);
		sendEmail(guest);
		return new ModelAndView("requested-room", "bookingsList", bookings);
	}
	
	private void sendEmail(Guest guest) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("nikitatestweb@gmail.com","nikita170893"));
		email.setSSLOnConnect(true);
		email.setFrom("gundyal.n@husky.neu.edu");
		email.setSubject("Test Mail");
		email.setMsg("Your booking has been confirmed");
		email.addTo(guest.getEmailID());
		email.send();
		
	}

}
