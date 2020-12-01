package com.nextgate.assesment.datatypes;

import java.io.Serializable;
import java.time.Year;
import java.time.format.DateTimeParseException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="albums")
public class Album implements Serializable {
	
	/* State */
	@Column(name ="Singer")
	private String mSingerName; 
	
	@Id @Column(name = "Album")
	private String mAlbumName;
	
	@Column(name ="Company")
	private String mAlbumCompany;
	
	@Id @Column(name="Year")
	private Year mAlbumYear;
	
	/* Constructor*/
	
	public Album(String aAlbumName, String aCompany, String aSingerName, String aYearString) {
		this.mAlbumName = aAlbumName;
		this.mAlbumCompany = aCompany;
		this.mSingerName = aSingerName;
		setAlbumYear(aYearString);
	}
	
	/* Public accessors and mutators */
	
	public String getAlbumName() { return this.mAlbumName; }
	public void setAlbumName(String aAlbumName) { this.mAlbumName = aAlbumName; }
	public String getSingerName() { return this.mSingerName; }
	public void setSingerName(String aName) { this.mSingerName = aName; }
	public String getCompanyName() { return this.mAlbumCompany; }
	public void setCompanyName(String aCompanyName) { this.mAlbumCompany = aCompanyName; }
	public Year getAlbumYear() { return mAlbumYear; }
	
	public boolean setAlbumYear(String aYearString) {
		try {
			mAlbumYear = Year.parse(aYearString);
			return true;
		}
		catch(DateTimeParseException e) {
			System.out.println("An exception was thrown during parsing of the album year string: " + e.getMessage());
			return false;
		}
	}
}
