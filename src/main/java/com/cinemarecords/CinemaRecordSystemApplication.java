package com.cinemarecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class CinemaRecordSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaRecordSystemApplication.class, args);
	}

}
