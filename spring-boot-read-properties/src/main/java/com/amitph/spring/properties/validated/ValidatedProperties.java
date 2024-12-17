package com.amitph.spring.properties.validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "connection")
public class ValidatedProperties {

    @NotBlank private String host;

    @Min(1025)
    @Max(65536)
    private int port;

    @PositiveOrZero private long timeout;

    @Email private String notify;

    @Pattern(regexp = "([^\\s]+(\\.(?i)(log))$)")
    private String errorFile;

    @Override
    public String toString() {
        return "host: "
                + host
                + "\nport: "
                + port
                + "\ntimeout: "
                + timeout
                + "\nnotify: "
                + notify
                + "\nerrorFile: "
                + errorFile;
    }
}
