package com.mtm.examples.controller;

import com.mtm.examples.service.ActivityService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manjunath M T
 */
@Slf4j
@RequestMapping("/activity")
@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping
    @CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
    private String getRandomActivity() {
        return activityService.getRandomActivity();
    }

    public String fallbackRandomActivity(Throwable throwable) {
        return "Hello world !!!";
    }

}