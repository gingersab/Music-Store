package com.nextgate.assesment.datatypes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="singers")
public class Singer implements Serializable {
	
	/* State */
	@Id @Column(name="Name")
	private String mSingerName;
	
	@Column(name="Company")
	private String mSingerCompany;
	
	@Id @Column(name="DOB")
	private LocalDate mDateOfBirth;
	
	@Column(name="Sex")@Enumerated(EnumType.STRING)
	private Sex mSex; 
	
	/* Constructors*/
	
	public Singer() {
	}
	
	public Singer(String aName, String aCompany, Sex aSex, String aDateString) {
		this.mSingerName = aName;
		this.mSingerCompany = aCompany;
		this.mSex = aSex;
		setDateOfBirth(aDateString);
	}
	
	/* Public accessors and mutators */
	
	public String getSingerName() { return this.mSingerName; }
	public void setSingerName(String aSingerName) { this.mSingerName = aSingerName; }
	public String getCompanyName() { return this.mSingerCompany; }
	public void setCompanyName(String aCompanyName) { this.mSingerCompany = aCompanyName; }
	public Sex getSingerSex() { return Sex.valueOf(mSex.name()); }
	public void setSingerSex(Sex aSex) { this.mSex = aSex; }
	public LocalDate getDateOfBirth() { return mDateOfBirth; }
	
	public boolean setDateOfBirth(String aDateString) {
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
			mDateOfBirth = LocalDate.parse(aDateString, format);
			return true;
		}
		catch(DateTimeParseException e) {
			System.out.println("DOB parsing error: " + e.getMessage());
			return false;
		}
	}
}
