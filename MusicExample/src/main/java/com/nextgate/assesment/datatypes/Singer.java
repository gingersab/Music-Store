package com.nextgate.assesment.datatypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Singer {
	
	/* State */
	
	private String mSingerName;
	private String mSingerCompany;
	private LocalDate mDateOfBirth;
	private Sex mSex; 
	
	/* Constructor*/
	
	public Singer(String aName, String aCompany, Sex aSex, String aDateString) {
		this.mSingerName = aName;
		this.mSingerCompany = aCompany;
		this.mSex = aSex;
		setDateOfBirth(aDateString);
	}
	
	/* Public accessors and mutators */
	
	public String getSingerName() {
		return this.mSingerName;
	}
	
	public void setSingerName(String aSingerName) {
		this.mSingerName = aSingerName;
	}
	
	public String getCompanyName() {
		return this.mSingerCompany;
	}
	
	public void setCompanyName(String aCompanyName) {
		this.mSingerCompany = aCompanyName;
		
	}
	
	public Sex getSingerSex() {
		return this.mSex;
	}
	
	public void setSingerSex(Sex aSex) {
		
			this.mSex = aSex;
	}
	
	
	public LocalDate getDateOfBirth() {
		return mDateOfBirth;
	}
	
	public boolean setDateOfBirth(String aDateString) {
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
			mDateOfBirth = LocalDate.parse(aDateString, format);
			return true;
		}
		catch(DateTimeParseException e) {
			System.out.println("An exception was thrown during parsing of the DoB string");
			return false;
		}
	}
}
