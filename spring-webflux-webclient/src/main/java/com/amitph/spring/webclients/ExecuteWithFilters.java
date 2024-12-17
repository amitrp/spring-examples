package com.amitph.spring.webclients;

import com.amitph.spring.webclients.service.WebClientWithFilterService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExecuteWithFilters {
    private final WebClientWithFilterService service;

    @PostConstruct
    public void executeFilteredWebClient() {
        service.fetchResource(3L);
    }
}
