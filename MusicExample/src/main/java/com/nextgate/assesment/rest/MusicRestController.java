package com.nextgate.assesment.rest;

import com.nextgate.assesment.datatypes.Song;
import com.nextgate.assesment.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller for managing the music catalogue via the Music service
 *
 * TODO: Add more methods
 *
 * @author nextgate.employee
 */
@RestController
public class MusicRestController {
    
    @Autowired
    private MusicService musicSerivce;
    
    /**
     * GET method to retrieve a song via an Id
     * @param songId the song Id
     * @return Song
     */
    @GetMapping("song/{songId}")
    public Song song(@PathVariable("songId") String songId) {
        return musicSerivce.getSongById(songId);
    }
    
}
