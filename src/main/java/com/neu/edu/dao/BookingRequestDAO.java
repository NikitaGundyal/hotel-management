package com.neu.edu.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import com.neu.edu.exception.BookingRequestExeption;
import com.neu.edu.pojo.Booking;
import com.neu.edu.pojo.Guest;

@Transactional
public class BookingRequestDAO extends DAO{
	
	public List<Booking> getStatus(String status) throws Exception {
		try{
			begin();
			Query q = getSession().createQuery("from Booking where requestStatus = :status");
			q.setParameter("status", status);			
			List<Booking> requests = q.getResultList();
			commit();
			return requests;
		}catch(HibernateException e){
			rollback();
			throw new BookingRequestExeption("Exception while getting status: " + e.getMessage());
		}
	}
	
	public List<Booking> getSpecificGuestBookedRoom(Guest guest) throws Exception{
		try{
			begin();
			Query q = getSession().createQuery("from Booking b where b.guest.guest_id =:memId order by b.updateDate desc");
			q.setParameter("memId", guest.getGuest_id());
			List<Booking> result = q.getResultList();
			commit();
			return result;
		}catch(HibernateException e){
			rollback();
			throw new BookingRequestExeption("Exception while retreiving requests: " + e.getMessage());
		}
	}

	public List<Booking> getAllBookings() throws Exception{
		try{
			begin();
			Query q = getSession().createQuery("from Booking");			
			List<Booking> result = q.getResultList();
			commit();
			return result;
		}catch(HibernateException e){
			rollback();
			throw new BookingRequestExeption("Exception while retreiving requests: " + e.getMessage());
		}
	}

}
