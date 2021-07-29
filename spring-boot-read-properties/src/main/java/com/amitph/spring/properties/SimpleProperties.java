package com.amitph.spring.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class SimpleProperties {
    private String defaultUsername;
    private String defaultPassword;
    private int connectionTimeout;

    @Override
    public String toString() {
        return "defaultUsername: " + defaultUsername
                + ",\ndefaultPassword: " + defaultPassword
                + ",\nconnectionTimeout: " + connectionTimeout;
    }
}