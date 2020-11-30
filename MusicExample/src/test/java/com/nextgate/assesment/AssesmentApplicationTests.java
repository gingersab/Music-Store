package com.nextgate.assesment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Month;
import com.nextgate.assesment.datatypes.Sex;
import com.nextgate.assesment.datatypes.Singer;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AssesmentApplicationTests {

	
	private Singer testSinger = new Singer("James Blunt", "James Blunt Inc", Sex.MALE, "19740227");;
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
    		
    }

}
