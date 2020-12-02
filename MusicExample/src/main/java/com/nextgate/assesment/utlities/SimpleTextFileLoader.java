package com.nextgate.assesment.utlities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Sex;
import com.nextgate.assesment.datatypes.Singer;
import com.nextgate.assesment.datatypes.User;
import com.nextgate.assesment.service.AlbumService;
import com.nextgate.assesment.service.SingerService;
import com.nextgate.assesment.service.UserService;

@Component
public class SimpleTextFileLoader {

	private String mDataFile = "data/ng_music_data.txt";
	
	@Autowired
	private UserService mUserService;
	
	@Autowired
	private AlbumService mAlbumService;
	
	@Autowired
	private SingerService mSingerService;
	
	
	public void loadFileAndPopulate() {
		try {
		    BufferedReader fileLineReader = new BufferedReader ( new FileReader (mDataFile));
		    String lineText= null;
		   
		    while((lineText = fileLineReader.readLine())!= null) {
		    	String[] lineData = lineText.split("\\|");
		    	
		    	int i =0;
		    	for(String s : lineData) {
		    		lineData[i] = s.trim();
		    		i++;
		    	}
		    	
		    	switch(lineData[0]) {
		    	case "S":
		    		if(lineData[1] == null || lineData[2] == null ||  lineData[3]==null || lineData[4] == null) {
		    			System.out.println("User data was incomplete");
		    			break;
		    		}
		    		else {
		    			
		    		mSingerService.addSinger( new Singer(lineData[1], lineData[4], Sex.valueOf(lineData[3]), lineData[2]));
		    		}
		    	case "U":
		    		if(lineData[1] == null || lineData[2] == null) {
		    			System.out.println("User data was incomplete");
		    			break;
		    		}
		    		else {
		    			User newUser = new User(lineData[1], lineData[2]);
		    			mUserService.addNewUser(newUser);
		    		}
		    		break;
		    		
		    	case "A":
		    		if(lineData[1] == null || lineData[2] == null ||  lineData[3]==null || lineData[4] == null) {
		    			System.out.println("Album data was incomplete");
		    			break;
		    		}
		    		else {
		    			Album newAlbum = new Album(lineData[2], lineData[4], lineData[1], Integer.parseInt(lineData[3]));
		    			mAlbumService.addAlbum(newAlbum);
		    		}
		    		break;
		    		
	    		default:
	    			System.out.println("Unexpected identifier in file");
	    			break;
		    	}
		    }
		    fileLineReader.close(); 
		}
		catch(FileNotFoundException e) {
			System.out.println(String.format("File %s was not found", mDataFile));
		} 
		catch (IOException e) {
			System.out.println(String.format("IO exception occurent: %s", e.getMessage()));
		}
	}
}
