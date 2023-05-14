package com.mtm.examples.service;

import com.mtm.examples.config.ActivityConfig;
import com.mtm.examples.dto.ActivityDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
@Service
public class ActivityService {

    @Autowired
    ActivityConfig activityConfig;

    @Autowired
    RestTemplate restTemplate;

    public String getRandomActivity() {
        ResponseEntity<ActivityDto> responseEntity = restTemplate.getForEntity(activityConfig.getBoredApiActitiyUrl(), ActivityDto.class);
        ActivityDto activityDto = responseEntity.getBody();
        String activity = null != activityDto ? activityDto.getActivity() : "";
        log.info("Activity Received: {}", activity);
        return activity;
    }
}
