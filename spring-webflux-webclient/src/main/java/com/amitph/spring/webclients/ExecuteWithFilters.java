package com.amitph.spring.webclients;

import com.amitph.spring.webclients.service.WebClientWithFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ExecuteWithFilters {
    private final WebClientWithFilterService service;

    @PostConstruct
    public void executeFilteredWebClient() {
        service.fetchResource(3L);
    }
}
