package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	
	public Payment() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "billNum", unique=true, nullable = false)
	private long id;
	
	@Column(name = "billingDays")
	private int billingDays;
	
	@Column(name = "totalRent")
	private float totalRent;
	
	@Column(name = "serviceCharge")
	private float serviceCharge;
	
	@Column(name = "serviceTax")
	private float serviceTax;
	
	@Column(name = "netBill")
	private float netBill;
	
	@OneToOne
	private Room room;
	
	@OneToOne
	private Guest guest;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBillingDays() {
		return billingDays;
	}

	public void setBillingDays(int billingDays) {
		this.billingDays = billingDays;
	}

	public float getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(float totalRent) {
		this.totalRent = totalRent;
	}

	public float getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(float serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public float getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(float serviceTax) {
		this.serviceTax = serviceTax;
	}

	public float getNetBill() {
		return netBill;
	}

	public void setNetBill(float netBill) {
		this.netBill = netBill;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	
	

}
