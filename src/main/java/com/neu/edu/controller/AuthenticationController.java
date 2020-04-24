package com.neu.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.RoomDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.exception.RoomException;
import com.neu.edu.exception.UserLoginException;
import com.neu.edu.pojo.Guest;
import com.neu.edu.pojo.Room;
import com.neu.edu.pojo.Users;
import com.neu.edu.validator.UserValidator;

@Controller
public class AuthenticationController {
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	RoomDAO roomDao;
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView model = new ModelAndView("home");	
		List<Room> rooms;
		try {
			rooms = roomDao.getAllRoomsByType();
			model.addObject("rooms", rooms);
			
		} catch (RoomException e) {
			
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView model = new ModelAndView("login");		
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("guest", new Guest());
		model.setViewName("register");
		return model;
	
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView authenticate(HttpServletRequest request) throws RoomException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = (HttpSession) request.getSession();
		ModelAndView mv = new ModelAndView();			
		try {
			System.out.println(username);
			System.out.println(password);
			System.out.print("loginUser");
			Users user = userDao.authenticateUser(username, password);			
			if(user == null){
				System.out.println("UserName/Password does not exist");
				mv.addObject("errorMessage", "UserName/Password does not exist");
				mv.setViewName("login");				
			}
			else if(user.getRole().getRole().equalsIgnoreCase("ROLE_ADMIN")){
				session.setAttribute("user", user);
				List<Room> rooms = roomDao.getAvailableRooms();
				session.setAttribute("rooms", rooms);	
				List<Guest> guests = userDao.getAllGuests();
				session.setAttribute("guests", guests);
				mv.setViewName("admin-home");
			}else if(user.getRole().getRole().equalsIgnoreCase("ROLE_GUEST")){
				session.setAttribute("user", user);
				System.out.println(user.getFirstname());
				System.out.println(user.getLastname());
				List<Room> rooms = roomDao.getAvailableRooms();
				session.setAttribute("rooms", rooms);	
				Guest guest = userDao.getGuest(user);				
				session.setAttribute("guest",guest);
				mv.setViewName("user-home");
			}
			
			return mv;
				
		} catch (UserLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("someerror", "Some error occured");
			mv.setViewName("error-page");
			return mv;
		}
		 catch (RoomException e) {			
				e.printStackTrace();
				mv.addObject("someerror", "Some error occured");
				mv.setViewName("error-page");
				return mv;
	    }
			
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	protected ModelAndView addGuest(HttpServletRequest request,  @ModelAttribute("guest") Guest guest, BindingResult result){
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		//userValidator.validate(guest, result);
		
//		if (result.hasErrors()) {
//			return new ModelAndView("register", "guest", guest);
//		}
		try {
			Guest g =userDao.createGuest(guest);
			session.setAttribute("guest", g);			
		} catch (UserLoginException e) {
			e.printStackTrace();
		}
		
		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value={"/home"}, method = RequestMethod.GET)
	public String returnHome(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if(user == null){
			return "not-authorized";
		}
		if(user.getRole().getRole().equalsIgnoreCase("ROLE_ADMIN")){
			return "admin-home";
		}else{
			return "user-home";
		}
	}
	

}
