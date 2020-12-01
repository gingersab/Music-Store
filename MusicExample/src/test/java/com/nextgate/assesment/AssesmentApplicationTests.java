package com.nextgate.assesment;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
	private Album testAlbum = new Album("Back to Bedlam", "Atlantic", "James Blunt", "2004");
	
	@Autowired
	private MockMvc mMockMVC;
	
	//Album and Singer datatype tests
    @Test
    void contextLoads() throws Exception{
    	
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
    	assertThat(testAlbum.getAlbumYear().getValue()).isEqualTo(2004);
    	testAlbum.setAlbumYear("2003");
    	assertThat(testAlbum.getAlbumYear().getValue()).isEqualTo(2003);
    }
    
    //Rest API tests
    @Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mMockMVC.perform(get("/api/albums"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("[")))
		.andExpect(content().string(containsString("]"))); //crude test for checking /api/albums returns a list
	}
   
    

}
