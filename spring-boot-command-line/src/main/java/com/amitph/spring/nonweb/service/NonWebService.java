package com.amitph.spring.nonweb.service;

import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class NonWebService {
    public void printMessage(String[] arguments) {
        System.out.println("Inside NonWebService Class. Received below arguments");
        Arrays.stream(arguments).forEach(System.out::println);
    }
}
