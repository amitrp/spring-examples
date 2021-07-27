package com.amitph.spring.songs.actuator;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "custom-endpoint")
public class ServerTimeActuator {

    @ReadOperation
    public Map<String, String> readOperation() {
        Map<String, String> map = new HashMap<>();
        map.put("server.date", LocalDate.now().toString());
        map.put("server.time", LocalTime.now().toString());
        return map;
    }

    @WriteOperation
    public String writeOperation() {
        // Implementation skipped
        return "";
    }

    @DeleteOperation
    public String deleteOperation() {
        // Implementation skipped
        return "";
    }
}