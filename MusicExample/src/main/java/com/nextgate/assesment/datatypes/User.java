package com.nextgate.assesment.datatypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="User")
public class User {

	/* State */
	@Id @Column
	private String mUsername;
	
	@Column
	private String mPassword;
	
	/* Constructor */
	public User(String aUsername, String aPassword) {
		this.mUsername = aUsername;
		this.mPassword = aPassword;
	}
	
	/* Public accessors and mutators */
	
	public String getUsername() { return this.mUsername; }
	public String getPassword() { return this.mPassword; }
}
