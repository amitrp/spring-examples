package com.amitph.spring.tutorials.springdatajdbc.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private Integer enrollmentYear;
}