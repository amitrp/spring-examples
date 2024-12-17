package com.amitph.spring.springdatarest.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Data;

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
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private List<Student> students;
}
