package com.mtm.examples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mtm.examples.config.ActivityConfig;
import com.mtm.examples.dto.ActivityDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Manjunath M T
 * @since 14-May-2023
 *
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
