package com.amitph.spring.dogs.model;

import lombok.Data;

@Data
public class DogDto {
    private long id;
    private String name;
    private int age;
}