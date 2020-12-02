package com.nextgate.assesment.datatypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="User")
public class User {

	/* State */
	@Id @Column(name="Username")
	private String mUsername;
	
	@Column(name="Password")
	private String mPassword;
	
	/* Constructors */
	public User() {
	}
	
	public User(String aUsername, String aPassword) {
		this.mUsername = aUsername;
		this.mPassword =aPassword;
	}
	
	/* Public accessors and mutators */
	
	public String getUsername() { return this.mUsername; }
	public void setUsername(String aUsername) { this.mUsername = aUsername; }
	public String getPassword() { return this.mPassword; }
	public void setPassword(String aPassword) { this.mPassword = aPassword; }
}
