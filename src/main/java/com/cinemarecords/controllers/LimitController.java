package com.cinemarecords.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemarecords.Configuration;
import com.cinemarecords.model.LimitConfig;

@RestController
public class LimitController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limitsFromBean")
	public LimitConfig getLimitBeanData() {
		// TODO Auto-generated method stub
		return new LimitConfig(1, 1000);
	}

	@GetMapping("/limitsFromConfig")
	public LimitConfig getLimitConfigData() {
		// TODO Auto-generated method stub
		return new LimitConfig(configuration.getMinimum(), configuration.getMaximum());
	}

}
