package com.amitph.spring.properties.nested;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class NestedClassesProperties {
    private LoginProperties loginService;
    private UserProperties userService;

    @Data
    public static class LoginProperties {
        private String loginUrl;
        private String username;
        private String password;
        private LoginHeaderProperties header;

        @Data
        public static class LoginHeaderProperties {
            private String authToken;
            private String content;
        }
    }

    @Data
    public static class UserProperties {
        private String url;
        private String username;
        private String password;
    }

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