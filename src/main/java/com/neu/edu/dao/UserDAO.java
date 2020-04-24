package com.neu.edu.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import com.neu.edu.exception.UserLoginException;
import com.neu.edu.pojo.Guest;
import com.neu.edu.pojo.Role;
import com.neu.edu.pojo.Users;

@Transactional
public class UserDAO extends DAO{
	
	public Users authenticateUser(String username, String password) throws UserLoginException 
	{
        Users loggedInUser = null;
        try {
        	begin();
        	Query q = getSession().createQuery("from Users where username=:username and password=:password");
        	q.setParameter("username", username);
        	q.setParameter("password", password);
        	loggedInUser=(Users)q.getSingleResult();
        	commit();
        	if(loggedInUser!=null && loggedInUser.isEnabled()) {
        		return loggedInUser;
            }
        	
        	return null;
        	
        }catch(Exception e) {
        	rollback();
        	throw new UserLoginException("User not found"+username,e);
        }
        		
    }
	public Guest createGuest(Guest g)  throws UserLoginException 
	{
		try {
			begin();
			Users user = new Users(g.getUser().getFirstname(),g.getUser().getLastname(),g.getUser().getUsername(),
					g.getUser().getPassword(),getUserByRole("ROLE_GUEST"),true);
			getSession().save(user);			
			Guest guest = new Guest();
			guest.setUser(user);
			guest.setAddress(g.getAddress());
			guest.setPhNum(g.getPhNum());
			guest.setState(g.getState());
			guest.setZipcode(g.getZipcode());
			guest.setEmailID(g.getEmailID());
			getSession().save(guest);
			commit();			
			return guest;
		}
		catch(Exception e) {
			rollback();
        	throw new UserLoginException("Guest could not be added"+e.getMessage(),e);			
		}
	}
	
	public Role getUserByRole(String role) throws UserLoginException {
		try {
			Query q = getSession().createQuery("from Role WHERE role LIKE :value");
			q.setParameter("value", role);
			Role roleMem = (Role) q.getSingleResult();			
			return roleMem;

		} catch (HibernateException e) {
			rollback();
			throw new UserLoginException("User not found"+e.getMessage(),e);
		}
	}
	
	public Guest getGuestById(long id) throws UserLoginException {
		try {
			begin();
			Query q = getSession().createQuery("from Guest where id=:id");
			q.setParameter("id",id);
			Guest g = (Guest)q.getSingleResult();
			commit();			
			return g;			
		}
		catch(HibernateException e ) {
			rollback();
			throw new UserLoginException("Guest not found"+e.getMessage(),e);
		}
		
	}
	
	public Guest getGuest(Users u) throws UserLoginException {
		try {

			Query q = getSession().createQuery("from Guest g where g.user.userId = :userId");
			q.setParameter("userId", u.getUserId());
			Guest guest = (Guest) q.getSingleResult();		
			return guest;
		}
		catch(HibernateException e) {
			rollback();
			throw new UserLoginException("Guest not found"+e.getMessage(),e);			
		}
		
	}
	
	public List<Guest> getAllGuests() throws UserLoginException{
		try {
			begin();
			Query q = getSession().createQuery("from Guest");
			List<Guest> guests = q.getResultList();
			commit();			
			return guests;
			
		}
		catch(HibernateException e) {
			rollback();
			throw new UserLoginException("Guest not found"+e.getMessage(),e);			
		}
	}
	
	public boolean validateUsername(String username) {
		begin();
		Query q = getSession().createQuery("from Users where username = :username");
		q.setParameter("username", username);
		List<Users> users = q.getResultList();
		if(users.isEmpty()){
			System.out.println("Username does not exists");
			return false;
		}
		else{
			return true;
		}
}

     public boolean validateEmailID(String email){
	begin();
	  Query q = getSession().createQuery("from Guest where emailID = :emailId");
	  q.setParameter("emailId", email);
	List<Guest> guest = q.getResultList();
	if(guest.isEmpty()){
		System.out.println("Email id  does not exists");
		return false;
	}
	else{
		return true;
	}
}
        

}
