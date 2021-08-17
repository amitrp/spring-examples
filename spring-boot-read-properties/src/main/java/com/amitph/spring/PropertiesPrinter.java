package com.amitph.spring;

import com.amitph.spring.properties.SetterBasedLoginProperties;
import com.amitph.spring.properties.SimpleProperties;
import com.amitph.spring.properties.list.ListOfMapProperties;
import com.amitph.spring.properties.list.ListOfObjectProperties;
import com.amitph.spring.properties.list.PlainListProperties;
import com.amitph.spring.properties.map.MapProperties;
import com.amitph.spring.properties.map.NestedMapProperties;
import com.amitph.spring.properties.nested.NestedClassesProperties;
import com.amitph.spring.properties.nested.NestedProperties;
import com.amitph.spring.properties.prefixed.DifferentlyNamedProperties;
import com.amitph.spring.properties.prefixed.LoginServiceProperties;
import com.amitph.spring.properties.prefixed.UserServiceProperties;
import com.amitph.spring.properties.set.SetOfObjectProperties;
import com.amitph.spring.properties.validated.ValidatedProperties;
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
    private final PlainListProperties plainListProperties;
    private final ListOfMapProperties listOfMapProperties;
    private final ListOfObjectProperties listOfObjectProperties;
    private final SetOfObjectProperties setOfObjectProperties;
    private final ValidatedProperties validatedProperties;

    @PostConstruct
    public void print() {

        System.out.println("* Simple Properties: ");
        System.out.println(simpleProperties);
        System.out.println();

        System.out.println("* Login Service Properties: ");
        System.out.println(loginServiceProperties);
        System.out.println();

        System.out.println("* User Service Properties");
        System.out.println(userServiceProperties);
        System.out.println();

        System.out.println("* Setter Based Properties");
        System.out.println(setterBasedLoginProperties);
        System.out.println();

        System.out.println("* Differently Named Properties");
        System.out.println(differentlyNamedProperties);
        System.out.println();

        System.out.println("* Nested Properties");
        System.out.println(nestedProperties);
        System.out.println();

        System.out.println("* Nested Properties with Inner Classes");
        System.out.println(nestedClassesProperties);
        System.out.println();

        System.out.println("* Java Map based Properties");
        System.out.println(mapProperties);
        System.out.println();

        System.out.println("* Java Map based nested Properties");
        System.out.println(nestedMapProperties);
        System.out.println();

        System.out.println("* Plain Java List based Properties");
        System.out.println(plainListProperties);
        System.out.println();

        System.out.println("* Java List of Map based Properties");
        System.out.println(listOfMapProperties);
        System.out.println();

        System.out.println("* Java List of Object based Properties");
        System.out.println(listOfObjectProperties);
        System.out.println();

        System.out.println("* Java Set of Object based Properties");
        System.out.println(setOfObjectProperties);
        System.out.println();

        System.out.println("* Validated Properties");
        System.out.println(validatedProperties);
        System.out.println();
    }
}