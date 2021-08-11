package com.amitph.spring.properties.map;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring")
public class MapProperties {
    Map<String, String> application;
    Map<String, String> servlet;
    Map<String, String> datasource;

    private static final String NEW_LINE_TAB = "\n\t";

    @Override
    public String toString() {
        return "application:" + NEW_LINE_TAB +
                application.entrySet().stream()
                        .map(Objects::toString)
                        .collect(joining(NEW_LINE_TAB))

                + "\nservlet:" + NEW_LINE_TAB
                + servlet.entrySet().stream()
                .map(Objects::toString)
                .collect(joining(NEW_LINE_TAB))

                + "\ndatasource:" + NEW_LINE_TAB
                + datasource.entrySet().stream()
                .map(Objects::toString)
                .collect(joining(NEW_LINE_TAB));
    }
}