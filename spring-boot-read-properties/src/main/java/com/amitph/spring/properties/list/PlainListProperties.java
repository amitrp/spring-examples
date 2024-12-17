package com.amitph.spring.properties.list;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "config")
public class PlainListProperties {
    private List<String> env;

    @Override
    public String toString() {
        return "env: " + env;
    }
}
