package com.amitph.spring.nonweb.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class NonWebService {
    public void printMessage(String[] arguments) {
        System.out.println("Inside NonWebService Class. Received below arguments");
        Arrays.stream(arguments).forEach(System.out::println);
    }
}