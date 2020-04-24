package com.neu.edu.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.RoomDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.exception.RoomException;
import com.neu.edu.pojo.Booking;
import com.neu.edu.pojo.Guest;
import com.neu.edu.pojo.Room;
import com.neu.edu.pojo.Users;
import com.neu.edu.validator.RoomBookValidator;
import com.neu.edu.validator.RoomValidator;

@Controller

public class RoomController {
	
	@Autowired
	RoomDAO roomDao;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	@Qualifier("roomvalidator")
	RoomValidator roomvalidator;
	
	@Autowired
	@Qualifier("roombookvalidator")
	RoomBookValidator roombookvalidator;
	
	@Autowired
	ServletContext servletContext;
	
	@InitBinder("room")
	private void initRoomBinder(WebDataBinder binder) {
		binder.setValidator(roomvalidator);
	}
	
	@InitBinder("booking")
	private void initBookingBinder(WebDataBinder binder) {
		binder.setValidator(roombookvalidator);
	}
	

	private static String local_path = "C:/images/books";
	
	private static final double singleRoomPrice = 250.00;
	private static final double doubleRoomPrice = 450.00;
	private static final double executiveRoomPrice = 650.00;
	private static final double suiteRoomPrice = 1000.00;
	
	
	@RequestMapping(value="/admin/addRooms.htm", method=RequestMethod.GET)
	public ModelAndView addRooms() throws Exception {
		ModelAndView model = new ModelAndView();
		model.addObject("room", new Room());
		model.setViewName("add-rooms");
		return model;			
	}
	
	@RequestMapping(value="/admin/addRooms.htm", method=RequestMethod.POST)
	public ModelAndView addRoomsForm(HttpServletRequest request, @ModelAttribute("room") Room room, BindingResult result) throws Exception {
		
		//roomvalidator.validate(room, result);

//		if (result.hasErrors()) {
//			return new ModelAndView("add-rooms","room",room);
//		}

		HttpSession session = request.getSession();
		try {
			int totalrooms = Integer.parseInt(request.getParameter("totalrooms"));
			CommonsMultipartFile photoInMemory = room.getRoomPhoto();
			System.out.println(photoInMemory);
			String fileName = photoInMemory.getOriginalFilename();
			File localFile = new File(local_path + File.separator + fileName);
			photoInMemory.transferTo(localFile);
			room.setFilename(File.separator + "images" + File.separator + fileName);
					
			String roomType = request.getParameter("roomTypes");
			room.setRoomType(roomType);
			if(roomType.equals("single")) room.setRoomPrice(singleRoomPrice);
			else if(roomType.equals("double")) room.setRoomPrice(doubleRoomPrice);
			else if(roomType.equals("executive")) room.setRoomPrice(executiveRoomPrice);
			else room.setRoomPrice(suiteRoomPrice);
			List<Room> rooms = new ArrayList<Room>();
			for (int i = 0; i < totalrooms; i++) {
				System.out.println(i + " " + totalrooms);
				rooms.add(room);
			}
			roomDao.addRooms(rooms);
			List<Room> distinctRooms=roomDao.getAllRoomsByType();		
			session.setAttribute("room",distinctRooms);			
		}
		catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("*** IOException: " + e.getMessage());
		} catch (RoomException e) {
			e.printStackTrace();
		}
		return new ModelAndView("admin-home");		
	}
	
	private String generateFileName(MultipartFile multipart) {
		return new Date().getTime()+"-"+multipart.getOriginalFilename().replace("", "-");
		
	}
	
	@RequestMapping(value = "/guest/roomBookRequest.htm", method = RequestMethod.GET)
	public ModelAndView getAvailableRooms(HttpServletRequest request) throws Exception {
		List<Room> availableRooms = new ArrayList<Room>();
		try {
			availableRooms = roomDao.getAvailableRooms();
		} catch (RoomException e) {
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView();
		model.addObject("availableRooms", availableRooms);
		Booking booking = new Booking();
		Users user = (Users)request.getSession().getAttribute("user");
		booking.setGuest(userDao.getGuest(user));
		model.addObject("reserveRoom", booking);
		model.setViewName("available-rooms");
		return model;
	}
	
	@RequestMapping(value = "/guest/roomBookRequest.htm", method = RequestMethod.POST)
	public ModelAndView registerBookRequest(HttpServletRequest request,
			@ModelAttribute("reserveRoom") Booking reserveRoom, BindingResult result) throws Exception {

		HttpSession session = request.getSession();
		//roombookvalidator.validate(reserveRoom, result);

//		if (result.hasErrors()) {
//			return new ModelAndView("available-rooms", "reserveRoom", reserveRoom);
//		}
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date check_In=sdf.parse(checkIn);
        Date check_Out=sdf.parse(checkOut);
        reserveRoom.setCheckIn(check_In);
        reserveRoom.setCheckOut(check_Out);
        reserveRoom.setNumOfDays(Integer.parseInt(request.getParameter("numdays")));
		ModelAndView model = new ModelAndView();
		Users user = (Users) session.getAttribute("user");
		Guest guest = userDao.getGuest(user);
		reserveRoom.setGuest(guest);
		

		Long roomId = Long.parseLong(request.getParameter("roomid"));
		Room room =roomDao.getRoomRequested(roomId);
		room.setAvailable(false);
		roomDao.updateRoomAvailability(room);
		reserveRoom.setRoom(room);
		Booking booking = roomDao.createReservation(reserveRoom);
		
        model.addObject("requestedRoom", booking.getRoom());
		model.addObject("requestNumber", booking);	
		model.setViewName("user-home");

		return model;
	}
	
	@RequestMapping(value="/admin/viewAllRooms.htm", method=RequestMethod.GET)
	public ModelAndView viewAllRooms(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		List<Room> rooms=roomDao.getAllRooms();
		session.setAttribute("rooms", rooms);
		ModelAndView model = new ModelAndView();
		model.setViewName("view-allRooms");
		return model;			
	}
	
	@RequestMapping(value="/admin/room/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRoom(HttpServletRequest request,@PathVariable("id") Long id) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		Room room = roomDao.getRoomRequested(id);
		ModelAndView model = new ModelAndView();
		model.addObject("room", room);
		model.setViewName("edit-room");
		return model;			
	}

	
	@RequestMapping(value="/admin/room/delete/{id}", method=RequestMethod.GET)
	public String deleteRoom(HttpServletRequest request, @PathVariable("id") Long id) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		roomDao.removeRoom(id);
		return "redirect:/admin/viewAllRooms.htm";			
	}
	
	@RequestMapping(value="/editRooms.htm", method=RequestMethod.POST)
	public String editRoomsForm(HttpServletRequest request, @ModelAttribute("room") Room room, BindingResult result) throws Exception {
		HttpSession session = request.getSession();
		try {
			int totalrooms = Integer.parseInt(request.getParameter("totalrooms"));
			CommonsMultipartFile photoInMemory = room.getRoomPhoto();
			System.out.println(photoInMemory);
			String fileName = photoInMemory.getOriginalFilename();
			File localFile = new File(local_path + File.separator + fileName);
			photoInMemory.transferTo(localFile);
			room.setFilename(File.separator + "images" + File.separator + fileName);
					
			String roomType = request.getParameter("roomTypes");
			room.setRoomType(roomType);
			if(roomType.equals("single")) room.setRoomPrice(singleRoomPrice);
			else if(roomType.equals("double")) room.setRoomPrice(doubleRoomPrice);
			else if(roomType.equals("executive")) room.setRoomPrice(executiveRoomPrice);
			else room.setRoomPrice(suiteRoomPrice);
			List<Room> rooms = new ArrayList<Room>();
			for (int i = 0; i < totalrooms; i++) {
				System.out.println(i + " " + totalrooms);
				rooms.add(room);
			}
			
			roomDao.addRooms(rooms);
			roomDao.updateRoom(room);					
		}
		catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("*** IOException: " + e.getMessage());
		} catch (RoomException e) {
			e.printStackTrace();
		}
		return  "redirect:/admin/viewAllRooms.htm";		
	}


}
