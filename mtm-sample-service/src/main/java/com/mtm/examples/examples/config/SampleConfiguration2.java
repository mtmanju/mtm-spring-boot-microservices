package com.mtm.examples.examples.config;

import com.mtm.examples.examples.exceptions.CustomException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
@Getter
@Slf4j
public class SampleConfiguration2 {

    @Value("${sample.baseurl2}")
    private String baseUrl2;

    @Bean("sampleWebClient2")
    @Lazy
    public WebClient sampleWebClient() throws CustomException {
        log.info("SampleConfiguration.getWebClient() -->");
        WebClient webClient = WebClient.builder().baseUrl(baseUrl2)
                .defaultHeader("Authorization",
                        "Basic " + Base64.getEncoder().encodeToString("admin:admin".getBytes(StandardCharsets.UTF_8)))
                .build();
        log.info("<-- SampleConfiguration.getWebClient()");
        return webClient;
    }
}
