package com.mtm.examples.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ActivityConfig {

    @Value("${boredapi.activity.url:http://www.boredapi.com/api/activity/}")
    String boredApiActitiyUrl;
}

