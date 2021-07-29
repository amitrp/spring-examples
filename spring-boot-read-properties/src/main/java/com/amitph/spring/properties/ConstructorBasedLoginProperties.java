package com.amitph.spring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*
 * To use constructor binding
 * 1. Uncomment next two lines
 * 2. Explicitly enable configuration class using
 *    @EnableConfigurationProperties or with @ConfigurationPropertiesScan
 */
//@ConstructorBinding
@ConfigurationProperties(prefix = "login-service")
public class ConstructorBasedLoginProperties {
    private String loginUrl;
    private String username;
    private String password;

    public ConstructorBasedLoginProperties(
            String loginUrl,
            String username,
            String password) {
        this.loginUrl = loginUrl;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "loginUrl: " + loginUrl
                + ",\nusername: " + username
                + ",\npassword: " + password;
    }
}