package com.river;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.boot.autoconfigure.SpringBootApplication(scanBasePackages = "com.river")
public class SpringBootJUnitTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJUnitTestApplication.class, args);
    }
}
