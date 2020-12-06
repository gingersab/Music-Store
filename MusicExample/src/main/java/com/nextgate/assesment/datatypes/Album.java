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
	private int mAlbumYear;
	
	/* Constructors*/
	
	public Album() {
		
	}
	
	public Album(String aAlbumName, String aCompany, String aSingerName, String aAlbumYear) {
		this.mAlbumName = aAlbumName;
		this.mAlbumCompany = aCompany;
		this.mSingerName = aSingerName;
		this.mAlbumYear = Integer.parseInt(aAlbumYear);
	}
	
	/* Public accessors and mutators */
	
	public String getAlbumName() { return this.mAlbumName; }
	public void setAlbumName(String aAlbumName) { this.mAlbumName = aAlbumName; }
	public String getSingerName() { return this.mSingerName; }
	public void setSingerName(String aName) { this.mSingerName = aName; }
	public String getCompanyName() { return this.mAlbumCompany; }
	public void setCompanyName(String aCompanyName) { this.mAlbumCompany = aCompanyName; }
	public int getAlbumYear() { return mAlbumYear; }
	public void setAlbumYear(int aAlbumYear) { this.mAlbumYear = aAlbumYear; }
}
