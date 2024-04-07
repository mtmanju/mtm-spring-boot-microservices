package com.mtm.examples.springshell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringShellBoot {

    public static void main(String[] args) {

        System.out.println("args " + args);
        SpringApplication.run(SpringShellBoot.class, args);
    }
}