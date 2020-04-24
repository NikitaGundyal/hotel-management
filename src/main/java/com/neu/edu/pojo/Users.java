package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
public class Users {
	
	public Users() {
		
	}
	
	

	public Users(String username, String firstname, String lastname,String password, Role role,boolean isEnabled) {
		super();
	
		this.firstname=firstname;
		this.lastname=lastname;
		this.username = username;
		this.password = password;		
		this.role = role;
		this.isEnabled = isEnabled;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", unique=true, nullable = false)
	private long userId;
	
	
	@Column(name = "firstname")
	private String firstname;
	
	
	@Column(name = "lastname")
	private String lastname;
	
	
	@Column(name="username")
	private String username;
	
	
	@Column(name="password")
	private String password;	
	
	@ManyToOne
	private Role role;
	
	@Type(type = "true_false")
	private boolean isEnabled;

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
}
