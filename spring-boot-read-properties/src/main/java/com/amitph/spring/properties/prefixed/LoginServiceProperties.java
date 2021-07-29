package com.amitph.spring.properties.prefixed;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "login-service")
public class LoginServiceProperties {
    private String loginUrl;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "loginUrl: " + loginUrl
                + ",\nusername: " + username
                + ",\npassword: " + password;
    }
}