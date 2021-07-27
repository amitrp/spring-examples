package com.amitph.spring.songs.actuator;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RestControllerEndpoint(id = "custom-rest-endpoint")
public class CustomRestActuator {

    @GetMapping
    public Map<String, String> get() {
        Map<String, String> map = new HashMap<>();
        map.put("server.date", LocalDate.now().toString());
        map.put("server.time", LocalTime.now().toString());
        return map;
    }

    @PostMapping
    public String post(@RequestBody  String request) {
        return "We have received your request: " + request;
    }
}