package com.mtm.examples.ratelimiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Manjunath M T
 * @since 09-Jun-2024
 * 
 */
@SpringBootApplication
public class RateLimitingApplicationBoot {

	public static void main(String[] args) {
		SpringApplication.run(RateLimitingApplicationBoot.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
