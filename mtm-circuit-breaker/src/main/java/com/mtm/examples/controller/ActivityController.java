package com.mtm.examples.controller;

import com.mtm.examples.dto.ActivityDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Manjunath M T
 */
@Slf4j
@RequestMapping("/activity")
@RestController
public class ActivityController {

    @Value("${boredapi.activity.url:http://www.boredapi.com/api/activity/}")
    String boredApiActitiyUrl;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    @CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
    private String getRandomActivity() {
        ResponseEntity<ActivityDto> responseEntity = restTemplate.getForEntity(boredApiActitiyUrl, ActivityDto.class);
        ActivityDto activityDto = responseEntity.getBody();
        String activity = null != activityDto ? activityDto.getActivity() : "";
        log.info("Activity Received: {}", activity);
        return activity;
    }

    public String fallbackRandomActivity(Throwable throwable) {
        return "Hello world !!!";
    }

}