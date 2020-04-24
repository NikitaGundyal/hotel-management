package com.neu.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.RoomDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.pojo.Guest;
import com.neu.edu.pojo.Room;
import com.neu.edu.pojo.Users;

@Controller
public class GuestController {
	
	@Autowired
	RoomDAO roomDao;
	
	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value="/admin/viewGuests.htm", method=RequestMethod.GET)
	public ModelAndView viewGuests(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		Users user = (Users)session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		List<Guest>guests =userDao.getAllGuests();	
		session.setAttribute("guests", guests);
		model.setViewName("view-guests");
		return model;			
	}

}
