package com.amitph.spring.pathvariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PathVariableExampleController {

    @GetMapping("/v1/students/{id}")
    public String mapSimplePathVariable(@PathVariable String id) {
        return "id: " + id;
    }

    @GetMapping("/v2/students/{id}")
    public String mapPathVariableByName(
            @PathVariable("id") String studentId) {
        return "id: " + studentId;
    }

    @GetMapping("/v3/students/{id}/terms/{termId}")
    public String mapPathVariableByName(
            @PathVariable String id,
            @PathVariable String termId) {
        return "id: " + id + ", term id: " + termId;
    }

    @GetMapping("/v4/students/{id}/terms/{termId}")
    public String mapPathVariableByName(
            @PathVariable Map<String, String> pathVariables) {
        return pathVariables.toString();
    }
}