package com.amitph.spring.pathvariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

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
    public String mapMultiplePathVariables(
            @PathVariable String id,
            @PathVariable String termId) {
        return "id: " + id + ", term id: " + termId;
    }

    @GetMapping("/v4/students/{id}/terms/{termId}")
    public String mapMultiplePathVariablesAsMap(
            @PathVariable Map<String, String> pathVariables) {
        return pathVariables.toString();
    }

    @GetMapping("/v5/students/{id}")
    public String mapPathVariableAsLong(
            @PathVariable("id") Long id) {
        return "id: " + id;
    }

    @GetMapping({
            "/v6/students/{id}/terms/{termId}",
            "/v6/students/{id}/terms/"
    })
    public String mapNotRequiredPathVariables(
            @PathVariable String id,
            @PathVariable(required = false) String termId) {
        return "id: " + id + ", term id: " + termId;
    }

    @GetMapping({
            "/v7/students/{id}/terms/{termId}",
            "/v7/students/{id}/terms/"
    })
    public String mapOptionalPathVariables(
            @PathVariable String id,
            @PathVariable Optional<String> termId) {
        return "id: " + id + ", term id: " + termId.orElse("3");
    }

    @GetMapping("/v8/students/{id}/terms/{termId}")
    public String mapPathVariableWithTermId(
            @PathVariable String id,
            @PathVariable String termId) {
        return "id: " + id + ", term id: " + termId;
    }

    @GetMapping("/v8/students/{id}/terms/")
    public String mapPathVariableWithoutTermId(
            @PathVariable String id) {
        return "id: " + id;
    }
}