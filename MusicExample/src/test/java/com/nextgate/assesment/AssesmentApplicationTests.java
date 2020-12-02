package com.nextgate.assesment;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Month;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Sex;
import com.nextgate.assesment.datatypes.Singer;


@SpringBootTest
@AutoConfigureMockMvc
class AssesmentApplicationTests {

	//Note: Not actually a James Blunt fan.
	
	private Singer testSinger = new Singer("James Blunt", "James Blunt Inc", Sex.MALE, "19740227");
	private Album testAlbum = new Album("Back to Bedlam", "Atlantic", "James Blunt", 2004);
	
	@Autowired
	private MockMvc mMockMVC;
	
	//Album and Singer datatype tests
    @Test
    void basicObjectPersistenceTests() throws Exception{
    	
    	//Singer tests
    	assertThat( testSinger.getSingerName()).isEqualTo("James Blunt");
    	testSinger.setSingerName("Not James Blunt");
    	assertThat(testSinger.getSingerName()).isEqualTo("Not James Blunt");
    	assertThat(testSinger.getSingerSex()).isNotEqualTo(Sex.FEMALE);
    	assertThat(testSinger.getDateOfBirth().getYear()).isEqualTo(1974);
    	assertThat(testSinger.getDateOfBirth().getMonth()).isEqualTo(Month.FEBRUARY);
    	assertThat(testSinger.getDateOfBirth().getDayOfMonth()).isEqualTo(27);
    	
    	//Album tests
    	assertThat( testAlbum.getAlbumName()).isEqualTo("Back to Bedlam");
    	assertThat(testAlbum.getSingerName()).isEqualTo("James Blunt");
    	testAlbum.setSingerName("Not James Blunt");
    	assertThat(testAlbum.getSingerName()).isEqualTo("Not James Blunt");
    	assertThat(testAlbum.getAlbumYear()).isEqualTo(2004);
    	testAlbum.setAlbumYear(2003);
    	assertThat(testAlbum.getAlbumYear()).isEqualTo(2003);
    }
    
    //Rest API tests
    @Test
	public void restAPITests() throws Exception {
    	
    	//Test GET all albums
		this.mMockMVC.perform(get("/api/albums"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("[")))
		.andExpect(content().string(containsString("]"))); //crude test for checking /api/albums returns a list
		
		//Test GET all singers
		this.mMockMVC.perform(get("/api/singers"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("[")))
		.andExpect(content().string(containsString("]"))); //crude test for checking /api/singers returns a list
		
		//Test POST login
		//Note a 201 response is unexpected here since confirming the login credentials does not results in the creation of a resource
		this.mMockMVC.perform(post("/api/login")
       .contentType(MediaType.APPLICATION_JSON)
       .content("{ \"username\": \"Scott\", \"password\": \"Password\" } ")
       .accept(MediaType.APPLICATION_JSON))
	   .andExpect(content().string("true"))
	   .andExpect(status().isOk());
}
}
