package com.amitph.spring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "login-service")
public class SetterBasedLoginProperties {
    private String loginUrl;
    private String username;
    private String password;

    public SetterBasedLoginProperties(){}

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "loginUrl: " + loginUrl
                + ",\nusername: " + username
                + ",\npassword: " + password;
    }
}