package com.amitph.spring;

import com.amitph.spring.properties.prefixed.DifferentlyNamedProperties;
import com.amitph.spring.properties.SetterBasedLoginProperties;
import com.amitph.spring.properties.SimpleProperties;
import com.amitph.spring.properties.prefixed.LoginServiceProperties;
import com.amitph.spring.properties.prefixed.UserServiceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class PropertiesPrinter {
    private final SimpleProperties simpleProperties;
    private final LoginServiceProperties loginServiceProperties;
    private final UserServiceProperties userServiceProperties;
    private final SetterBasedLoginProperties setterBasedLoginProperties;
    private final DifferentlyNamedProperties differentlyNamedProperties;

    @PostConstruct
    public void print() {
        System.out.println("Simple Properties: ");
        System.out.println(simpleProperties);

        System.out.println("* Login Service Properties: ");
        System.out.println(loginServiceProperties);

        System.out.println("* User Service Properties");
        System.out.println(userServiceProperties);

        System.out.println("* SetterBasedLoginProperties");
        System.out.println(setterBasedLoginProperties);

        System.out.println("* DifferentlyNamedProperties");
        System.out.println(differentlyNamedProperties);
    }
}
