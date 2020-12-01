package com.nextgate.assesment.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.service.AlbumService;

@RestController
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	private AlbumService mAlbumService;
	
	@GetMapping("/albums")
	public List<Album>getAlbums(){
		System.out.println("seems to have worked");
		return mAlbumService.allAlbums();
	}
}
