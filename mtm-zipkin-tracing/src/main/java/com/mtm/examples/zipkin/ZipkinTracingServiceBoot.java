package com.mtm.examples.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZipkinTracingServiceBoot {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinTracingServiceBoot.class, args);
    }
}