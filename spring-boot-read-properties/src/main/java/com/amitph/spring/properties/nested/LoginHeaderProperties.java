package com.amitph.spring.properties.nested;

import lombok.Data;

@Data
public class LoginHeaderProperties {
    private String authToken;
    private String content;
}