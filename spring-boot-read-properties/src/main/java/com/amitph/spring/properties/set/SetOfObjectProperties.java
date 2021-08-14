package com.amitph.spring.properties.set;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

import static java.util.stream.Collectors.joining;

@Data
@Configuration
@ConfigurationProperties(prefix = "config")
public class SetOfObjectProperties {
    private Set<Service> services;

    @Data
    public static class Service {
        private String name;
        private String url;

        @Override
        public String toString() {
            return "name: " + name
                    + ", url: " + url;
        }
    }

    @Override
    public String toString() {
        return "services: \n\t"
                + services.stream()
                .map(Object::toString)
                .collect(joining("\n\t"));
    }
}