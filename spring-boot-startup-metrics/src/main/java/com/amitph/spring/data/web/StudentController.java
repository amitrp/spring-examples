package com.amitph.spring.data.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {
    @GetMapping("/")
    public String getStudents() {
        return "Hello!!";
    }
}