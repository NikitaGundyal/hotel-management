package com.neu.edu.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "bookingID", unique=true, nullable = false)
	private long bookingID;
	
	@ManyToOne
	@JoinColumn(name = "guest_id")
	private Guest guest;
	
	@OneToOne
	private Room room;
	
	@Column(name="roomStatus")
	private String roomStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "checkIn")
	private Date checkIn;
	
	@Temporal(TemporalType.DATE)
	@Column(name="checkOut")
	private Date checkOut;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateDate")
	private Date updateDate;
	
	@Column
	private int numOfDays;
	

	public int getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
//
//	public String getRequestStatus() {
//		return roomStatus;
//	}
//
//	public void setRequestStatus(String roomStatus) {
//		this.roomStatus = roomStatus;
//	}

	public Date getCheckIn() {
		return checkIn;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
