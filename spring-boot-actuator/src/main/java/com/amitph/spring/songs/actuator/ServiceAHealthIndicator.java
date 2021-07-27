package com.amitph.spring.songs.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceAHealthIndicator implements HealthIndicator {
        private final String message_key = "Service A";
    @Override
    public Health health() {
        if (!isRunningServiceA()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }
        return Health.up().withDetail(message_key, "Available").build();
    }

    private Boolean isRunningServiceA() {
        Boolean isRunning = true;
        // Logic Skipped

        return isRunning;
    }
}