package com.amitph.spring.webclients.service;

import com.amitph.spring.webclients.model.Dog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebClientWithFilterService {
    private final WebClient webClientWithFilter;

    public void fetchResource(Long id) {
        Dog dog = webClientWithFilter
                .get()
                .uri("/dogs/{id}", id)
                .retrieve()
                .bodyToMono(Dog.class)
                .share().block();
        log.info("Retrieved Dog: {}", dog);
    }
}