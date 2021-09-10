package com.amitph.spring.webclients.model;

import lombok.ToString;

@ToString
public class OwnedDog {
    private long id;
    private String name;
    private int age;
    private String owner;

    public OwnedDog(Dog d, String owner) {
        this.id = d.getId();
        this.name = d.getName();
        this.age = d.getAge();
        this.owner = owner;
    }
}