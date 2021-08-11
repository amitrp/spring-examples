package com.amitph.spring;

import com.amitph.spring.properties.SetterBasedLoginProperties;
import com.amitph.spring.properties.SimpleProperties;
import com.amitph.spring.properties.map.MapProperties;
import com.amitph.spring.properties.map.NestedMapProperties;
import com.amitph.spring.properties.nested.NestedClassesProperties;
import com.amitph.spring.properties.nested.NestedProperties;
import com.amitph.spring.properties.prefixed.DifferentlyNamedProperties;
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
    private final NestedProperties nestedProperties;
    private final NestedClassesProperties nestedClassesProperties;
    private final MapProperties mapProperties;
    private final NestedMapProperties nestedMapProperties;

    @PostConstruct
    public void print() {
        System.out.println("Simple Properties: ");
        System.out.println(simpleProperties);

        System.out.println("* Login Service Properties: ");
        System.out.println(loginServiceProperties);

        System.out.println("* User Service Properties");
        System.out.println(userServiceProperties);

        System.out.println("* Setter Based Properties");
        System.out.println(setterBasedLoginProperties);

        System.out.println("* Differently Named Properties");
        System.out.println(differentlyNamedProperties);

        System.out.println("* Nested Properties");
        System.out.println(nestedProperties);

        System.out.println("* Nested Properties with Inner Classes");
        System.out.println(nestedClassesProperties);

        System.out.println("* Java Map based Properties");
        System.out.println(mapProperties);

        System.out.println("* Java Map based nested Properties");
        System.out.println(nestedMapProperties);
    }
}