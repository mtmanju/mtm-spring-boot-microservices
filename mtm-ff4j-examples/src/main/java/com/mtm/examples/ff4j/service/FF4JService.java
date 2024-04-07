package com.mtm.examples.ff4j.service;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mtm.examples.ff4j.config.FF4JConfig;

@Service
public class FF4JService {

    @Autowired
    private FF4j ff4j;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            while (true) {
                if (ff4j.check(FF4JConfig.HELLO_FEATURE)) {
                    System.out.println("Hello Manjunath!");
                } else {
                    System.out.println("Hello World!");
                }
                Thread.sleep(5000);
            }
        };
    }
}
