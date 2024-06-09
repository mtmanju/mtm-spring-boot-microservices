package com.mtm.examples.ratelimiting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mtm.examples.ratelimiting.config.ActivityConfig;
import com.mtm.examples.ratelimiting.dto.ActivityDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Manjunath M T
 * @since 09-Jun-2024
 */
@Slf4j
@Component
public class ActivityService {

	@Autowired
	ActivityConfig activityConfig;

	@Autowired
	RestTemplate restTemplate;

	public String getRandomActivity() {
		ResponseEntity<ActivityDto> responseEntity = restTemplate.getForEntity(activityConfig.getBoredApiActitiyUrl(),
				ActivityDto.class);
		ActivityDto activityDto = responseEntity.getBody();
		String activity = null != activityDto ? activityDto.getActivity() : "";
		log.info("Activity Received: {}", activity);
		return activity;
	}
}
