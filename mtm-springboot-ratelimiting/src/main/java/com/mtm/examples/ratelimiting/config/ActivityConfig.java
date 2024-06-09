package com.mtm.examples.ratelimiting.config;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Manjunath M T
 * @since 09-Jun-2024
 */
@Getter
@Configuration
public class ActivityConfig {

    @Value("${boredapi.activity.url:http://www.boredapi.com/api/activity/}")
    String boredApiActitiyUrl;

}