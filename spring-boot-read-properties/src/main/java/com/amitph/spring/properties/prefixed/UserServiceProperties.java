package com.amitph.spring.properties.prefixed;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "user-service")
public class UserServiceProperties {
    private String url;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "url: " + url
                + ",\nusername: " + username
                + ",\npassword: " + password;
    }
}