package com.amitph.spring.properties.nested;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class NestedProperties {
    private LoginProperties loginService;
    private UserProperties userService;

    @Override
    public String toString() {
        return "loginService: "
                + "\n\tloginUrl: " + loginService.getLoginUrl()
                + "\n\tusername: " + loginService.getUsername()
                + "\n\tpassword: " + loginService.getPassword()
                + "\n\theader: "
                + "\n\t\tauthToken: " + loginService.getHeader().getAuthToken()
                + "\n\t\tcontent: " + loginService.getHeader().getContent()
                + "\nuserService: "
                + "\n\turl: " + userService.getUrl()
                + "\n\tusername: " + userService.getUsername()
                + "\n\tpassword: " + userService.getPassword();
    }
}