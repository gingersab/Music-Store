package com.nextgate.assesment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Month;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Sex;
import com.nextgate.assesment.datatypes.Singer;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AssesmentApplicationTests {

	//Note: Not actually a James Blunt fan.
	
	private Singer testSinger = new Singer("James Blunt", "James Blunt Inc", Sex.MALE, "19740227");
	private Album testAlbum = new Album("Back to Bedlam", "Atlantic", "James Blunt", "2004");
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

}
