package com.amitph.spring.properties.map;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring")
public class NestedMapProperties {
    Map<String, String> application;
    Map<String, Map<String, String>> servlet;
    Map<String, String> datasource;
    Map<String, List<String>> profiles;

    private static final String NEW_LINE_TAB = "\n\t";

    @Override
    public String toString() {
        return "application:"
                + NEW_LINE_TAB
                + application.entrySet().stream()
                        .map(Objects::toString)
                        .collect(joining(NEW_LINE_TAB))
                + "\nservlet:"
                + NEW_LINE_TAB
                + servlet.entrySet().stream().map(Objects::toString).collect(joining(NEW_LINE_TAB))
                + "\ndatasource:"
                + NEW_LINE_TAB
                + datasource.entrySet().stream()
                        .map(Objects::toString)
                        .collect(joining(NEW_LINE_TAB))
                + "\nprofiles:"
                + NEW_LINE_TAB
                + profiles.entrySet().stream()
                        .map(Objects::toString)
                        .collect(joining(NEW_LINE_TAB));
    }
}
