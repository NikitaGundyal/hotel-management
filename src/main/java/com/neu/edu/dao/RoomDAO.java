package com.neu.edu.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.neu.edu.exception.RoomException;
import com.neu.edu.pojo.Booking;
import com.neu.edu.pojo.Guest;
import com.neu.edu.pojo.Room;

public class RoomDAO extends DAO{
	
	public Room addRoom(Room room) throws RoomException{
		try {
			begin();
			getSession().save(room);
			commit();
			return room;
		}
		catch(HibernateException e) {
			rollback();
			throw new RoomException("Exception while creating room: " + e.getMessage());
		}		
		
	}
	
	public List<Room> getAllRoomsByType() throws RoomException{
		
		try {
			begin();
			Query q = getSession().createQuery("from Room r group by r.roomType");
			List<Room> room = q.getResultList();
			commit();
			return room;
		}
		catch(HibernateException e) {
			rollback();
			throw new RoomException("Room not found"+e.getMessage(),e);
		}
	}
	
	public List<Room> getAllRooms() throws RoomException{
		
		try {
			begin();
			Query q = getSession().createQuery("from Room");
			List<Room> room = q.getResultList();
			commit();
			return room;
		}
		catch(HibernateException e) {
			rollback();
			throw new RoomException("Room not found"+e.getMessage(),e);
		}
	}
	
	public List<Room> getAvailableRooms() throws RoomException{
		try {
            begin();          
            Query q = getSession().createQuery("select r from Room r where r.available = true group by r.roomType");
            List<Room> rooms = q.getResultList();
            commit();
            return rooms;
        } catch (HibernateException e) {
            rollback();
            throw new RoomException("No rooms available", e);
        }
	}
	
	public Room getRoomRequested(Long roomId) throws Exception{
		try{
			begin();
			Query q = getSession().createQuery("from Room where id = :id");
			q.setParameter("id" , roomId);
			Room room = (Room)q.getSingleResult();
			commit();			
			return room;
		}catch(HibernateException e){
			rollback();
			throw new RoomException("Exception while retriving room details: " + e.getMessage());
		}
		
	}
	
	public void updateRoomAvailability(Room room) throws RoomException{
		try{
			begin();
			getSession().update(room);
			commit();
			
		}
		catch(HibernateException e){
			rollback();
			throw new RoomException("Exception while updating room availability: " + e.getMessage());
		}
		
	}
	
	public Booking createReservation(Booking reserveRoom) throws Exception {
		try {
			begin();
			System.out.println("inside DAO");
			reserveRoom.setRoomStatus("Booked");			
			getSession().save(reserveRoom);
			commit();			
			return reserveRoom;

		} catch (HibernateException e) {
			rollback();
			throw new RoomException("Exception while creating room request: " + e.getMessage());
		}
		
	}
	
	public void addRooms(List<Room> rooms) throws RoomException {
		try{
			begin();
			for(Room room : rooms){
				getSession().save(new Room(room));
			}
			commit();
		
		}
		catch(HibernateException e){
			rollback();
			throw new RoomException("Exception while adding room: " + e.getMessage());
		}
				
	}
	
	public void updateRoom(Room room) throws RoomException{
		try {
			begin();
			getSession().update(room);
			commit();
		}
		catch(HibernateException e){
			rollback();
			throw new RoomException("Exception while updating room: " + e.getMessage());
		}
		
		
	}
	
	public void removeRoom(Long roomID)throws RoomException {
		try {
			begin();
			Query q = getSession().createQuery("delete from Room where id=:roomid");
			q.setParameter("roomid", roomID);
			q.executeUpdate();
			commit();
			
		}
		catch(HibernateException e) {
			rollback();
			throw new RoomException("Exception while deleting room: " + e.getMessage());
		}
	}
	
	
	public boolean validateRoomNumber(String roomNumber){
		begin();
		  Query q = getSession().createQuery("from Room where roomNumber = :roomNumber");
		  q.setParameter("roomNumber", roomNumber);
		List<Room> room = q.getResultList();
		if(room.isEmpty()){
			System.out.println("Room number does not exists");
			return false;
		}
		else{
			return true;
		}
	}

}
