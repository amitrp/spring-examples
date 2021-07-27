package com.amitph.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setApplicationStartup(new BufferingApplicationStartup(10000));
        //application.setApplicationStartup(new FlightRecorderApplicationStartup());
        application.run(args);
    }
}