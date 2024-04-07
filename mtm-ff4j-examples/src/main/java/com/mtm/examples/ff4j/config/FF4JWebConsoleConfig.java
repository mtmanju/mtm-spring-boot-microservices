package com.mtm.examples.ff4j.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@AutoConfigureAfter(FF4JConfig.class)
public class FF4JWebConsoleConfig {


}