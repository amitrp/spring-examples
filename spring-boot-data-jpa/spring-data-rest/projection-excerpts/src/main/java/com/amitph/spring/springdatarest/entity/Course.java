package com.amitph.spring.springdatarest.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "enrolment",
            inverseJoinColumns =
            @JoinColumn(name = "student_id", referencedColumnName = "id"),
            joinColumns =
            @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Student> students;
}
