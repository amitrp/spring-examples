package com.amitph.spring.properties.list;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "config")
public class ListOfMapProperties {
    private List<Map<String, Object>> miscellaneous;

    @Override
    public String toString() {
        return "miscellaneous: \n\t"
                + miscellaneous.stream().map(Object::toString).collect(joining("\n\t"));
    }
}
