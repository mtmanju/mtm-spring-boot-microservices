package com.mtm.examples.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinTracingServiceBoot {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinTracingServiceBoot.class, args);
    }
}