package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.List;


@Entity
public class Guest {
	
	public Guest() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guestID", unique=true, nullable = false)
	private long guest_id;
	
//	@Column(name = "firstName")
//	private String firstName;
//	
//	@Column(name = "lastName")
//	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "zipcode")
	private long zipcode;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "phNum")
	private int phNum;
	
	@Column(name = "emailID")
	private String emailID;
	
//	@CreationTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "checkIn")
//	private Date checkIn;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "checkOut")
//	private Date checkOut;
	
	@OneToMany
	private List<Room> rooms;
	
	@OneToOne
	@JoinColumn(name="userId")
	private Users user;
	

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getZipcode() {
		return zipcode;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPhNum() {
		return phNum;
	}

	public void setPhNum(int phNum) {
		this.phNum = phNum;
	}
	
	

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
//
//	public Date getCheckIn() {
//		return checkIn;
//	}
//
//	public void setCheckIn(Date checkIn) {
//		this.checkIn = checkIn;
//	}
//
//	public Date getCheckOut() {
//		return checkOut;
//	}
//
//	public void setCheckOut(Date checkOut) {
//		this.checkOut = checkOut;
//	}

	public long getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(long guest_id) {
		this.guest_id = guest_id;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
