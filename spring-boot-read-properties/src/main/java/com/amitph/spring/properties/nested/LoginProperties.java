package com.amitph.spring.properties.nested;

import lombok.Data;

@Data
public class LoginProperties {
    private String loginUrl;
    private String username;
    private String password;
    private LoginHeaderProperties header;
}