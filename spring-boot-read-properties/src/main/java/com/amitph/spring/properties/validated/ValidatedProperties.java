package com.amitph.spring.properties.validated;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "connection")
public class ValidatedProperties {

    @NotBlank
    private String host;

    @Min(1025)
    @Max(65536)
    private int port;

    @PositiveOrZero
    private long timeout;

    @Email
    private String notify;

    @Pattern(regexp = "([^\\s]+(\\.(?i)(log))$)")
    private String errorFile;

    @Override
    public String toString() {
        return "host: " + host
                + "\nport: " + port
                + "\ntimeout: " + timeout
                + "\nnotify: " + notify
                + "\nerrorFile: " + errorFile;
    }
}