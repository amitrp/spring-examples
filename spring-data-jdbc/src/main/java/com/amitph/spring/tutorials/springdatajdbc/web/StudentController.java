package com.amitph.spring.tutorials.springdatajdbc.web;

import com.amitph.spring.tutorials.springdatajdbc.repo.Student;
import com.amitph.spring.tutorials.springdatajdbc.repo.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class StudentController {
    private final StudentRepository repository;

    @PostMapping("/students")
    public Student postStudent(@RequestBody Student student) {
        log.info("Request to create student: {}", student);

        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents(@RequestParam(required = false) String lastName) {
        if (StringUtils.hasLength(lastName)) {
            return repository.findByLastName(lastName);
        }

        return (List<Student>) repository.findAll();
    }
}
