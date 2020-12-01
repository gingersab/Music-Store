package com.nextgate.assesment.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Singer;
import com.nextgate.assesment.datatypes.User;
import com.nextgate.assesment.service.AlbumService;
import com.nextgate.assesment.service.SingerService;
import com.nextgate.assesment.service.UserService;

@RestController
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	private AlbumService mAlbumService;
	
	@Autowired
	private SingerService mSingerService;
	
	@Autowired
	private UserService mUserService;
	
	@GetMapping("/albums")
	public List<Album>getAlbums(){
		List<Album> results = mAlbumService.allAlbums();
		System.out.println("Successfully fetched all albums");
		return results;
	}
	
	@GetMapping("/singers")
	public List<Singer> getSingers(){
		List<Singer> results = mSingerService.allSingers();
		System.out.println("Successfully fetched all singers");
		return results;
	}
	
	@PostMapping("/login")
	@ResponseBody
	public boolean login(@RequestBody User aUser ) {
		System.out.println(String.format("Confirming that @RequestBody is mapping: %1$s %2$s", aUser.getUsername(), aUser.getPassword()));
		return mUserService.Login(aUser);
	}
}
