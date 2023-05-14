package com.mtm.examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.examples.service.ActivityService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

/**
 * @author Manjunath M T
 * @since 14-May-2023
 *
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	ActivityService activityService;

	@GetMapping
	@CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
	private String randomActivity() {
		return activityService.getRandomActivity();
	}

	public String fallbackRandomActivity(Throwable throwable) {
		return "Hello world !!!";
	}

}