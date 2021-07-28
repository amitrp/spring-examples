package com.amitph.spring.dogs.repo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Dog {
    private long id;
    private String name;
    private int age;
}
