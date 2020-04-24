package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
public class Room {
	
	public Room() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomID", unique=true, nullable = false)
	private long id;
	
	
	@Column(name = "roomNumber")
	private String roomNumber;
	

	@Column(name = "roomType")
	private String roomType;
	
//	@Column(name = "roomFacility")
//	private String roomFacility;
	
	
	@Column(name = "roomPrice")
	private double roomPrice;
	
	
	@Column(name = "roomDesc")
	private String roomDesc;
	
//	@Column(name = "roomSchema")
//	private String roomSchema;
	
	@Column(name="filename")
	private String filename;
	
	@Type(type = "true_false")
	private boolean available;	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
    }

	@Transient
	private CommonsMultipartFile roomPhoto;
	
//	@Transient
//	private MultipartFile photo;
//	
//	@Transient
//	private String photoFile;	
	

//	public MultipartFile getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(MultipartFile photo) {
//		this.photo = photo;
//	}
//
//	public String getPhotoFile() {
//		return photoFile;
//	}
//
//	public void setPhotoFile(String photoFile) {
//		this.photoFile = photoFile;
//	}

//	public CommonsMultipartFile getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(CommonsMultipartFile photo) {
//		this.photo = photo;
//	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public CommonsMultipartFile getRoomPhoto() {
		return roomPhoto;
	}

	public void setRoomPhoto(CommonsMultipartFile roomPhoto) {
		this.roomPhoto = roomPhoto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

//	public String getRoomFacility() {
//		return roomFacility;
//	}
//
//	public void setRoomFacility(String roomFacility) {
//		this.roomFacility = roomFacility;
//	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}
//
//	public String getRoomSchema() {
//		return roomSchema;
//	}
//
//	public void setRoomSchema(String roomSchema) {
//		this.roomSchema = roomSchema;
//	}

	public Room(Room room) {
		super();		
		this.roomNumber = room.roomNumber;
		this.roomType = room.roomType;
		this.roomPrice = room.roomPrice;
		this.roomDesc = room.roomDesc;
		this.filename = room.filename;
		this.available = true;
		
	}

//	@Override
//	public String toString() {
//		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", roomFacility="
//				+ roomFacility + ", roomPrice=" + roomPrice + ", roomDesc=" + roomDesc + ", roomSchema=" + roomSchema
//				+ "]";
//	}
	
	
	

}
