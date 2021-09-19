package com.amitph.spring.headers;

import com.amitph.spring.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Slf4j
@RestController
public class RequestHeadersController {
    @PostMapping("v1/students")
    public void postStudent(
            @RequestHeader Map<String, String> headers,
            @RequestBody Student student) {

        log.info("Header values: {}", headers);
    }

    @PostMapping("/v2/students")
    public void postStudent(
            @RequestHeader HttpHeaders headers,
            @RequestBody Student student) {

        log.info("Header values: {}", headers);
    }

    @PostMapping("/v3/students")
    public void postStudent(
            @RequestHeader MultiValueMap<String, String> headers,
            @RequestBody Student student) {

        log.info("Header values: {}", headers);
    }

    @PostMapping("/v4/students")
    public void postStudent(
            @RequestHeader(
                    value = "content-type",
                    defaultValue = "application/json")
                    String contentType,
            @RequestBody Student student) {

        log.info("Header value - Content-Type: {}", contentType);
    }

    @PostMapping("/v5/students")
    public void postStudent(
            HttpServletRequest request,
            @RequestBody Student student) {

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            log.info(key + ": " + request.getHeader(key));
        }
    }
}