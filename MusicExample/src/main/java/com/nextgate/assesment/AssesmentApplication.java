package com.nextgate.assesment;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nextgate.assesment.utlities.SimpleTextFileLoader;

/**
 * The entry point for our Spring Boot application
 * 
 * @author nextgate.employee
 */
@SpringBootApplication
public class AssesmentApplication {
	
	@Autowired
	private SimpleTextFileLoader mFileLoader;

    public static void main(String[] args) {
        SpringApplication.run(AssesmentApplication.class, args);
    }
    
    //Since mFileLoader is not static it cannot be accessed within main()
    //Instead bind this method to execute after the beans are initialised
    @PostConstruct
    public void init() {
    	mFileLoader.loadFileAndPopulate();
    }
}