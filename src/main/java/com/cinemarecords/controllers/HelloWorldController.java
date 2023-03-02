/**
 * 
 */
package com.cinemarecords.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName HelloWorldController.java
 * @Description
 */

@RestController
@RequestMapping("/demo")
public class HelloWorldController {
	
	@GetMapping("/helloWorldString")
	private String helloWorldDemo() {
		// TODO Auto-generated method stub
		return "Hello World as String";
	}

}
