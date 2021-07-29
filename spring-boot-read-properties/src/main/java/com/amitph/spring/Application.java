package com.amitph.spring;

import com.amitph.spring.properties.ConstructorBasedLoginProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Uncomment @EnableConfigurationProperties, to use
 * constructor based properties binding in {@link ConstructorBasedLoginProperties}
 */
//@EnableConfigurationProperties(ConstructorBasedLoginProperties.class)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}