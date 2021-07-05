package com.example.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.limitservice.bean.Limits;
import com.example.limitservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retierveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}
}
