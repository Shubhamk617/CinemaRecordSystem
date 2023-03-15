package com.cinemarecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@EnableFeignClients("com.cinemarecords.clientProxy")
public class CinemaRecordSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaRecordSystemApplication.class, args);
	}

}
