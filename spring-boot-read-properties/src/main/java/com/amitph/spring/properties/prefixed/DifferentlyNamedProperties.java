package com.amitph.spring.properties.prefixed;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "login-service")
public class DifferentlyNamedProperties {
    private String url;

    public void setLoginUrl(String loginUrl) {
        this.url = loginUrl;
    }

    @Override
    public String toString() {
        return "url: " + url;
    }
}