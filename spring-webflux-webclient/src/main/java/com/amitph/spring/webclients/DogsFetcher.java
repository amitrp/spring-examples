package com.amitph.spring.webclients;

import com.amitph.spring.webclients.service.DogsFetcherWebClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class DogsFetcher {
    private final DogsFetcherWebClientService webClientService;

    @PostConstruct
    public void fetchStudents() {
        log.info("Beginning to fetch");

        log.info("Fetching dogs sequentially");
        webClientService.getInSequence(1L, 3L, 4L, 2L);

        log.info("Fetching dogs in parallel using Java Streams");
        webClientService.getWithParallelStream(1L, 3L, 4L, 2L);

        log.info("Fetching dogs in parallel using Flux");
        webClientService.getWithParallelFlux(1L, 3L, 4L, 2L);

        log.info("Fetching dogs in parallel using Flux and Thread Scheduler");
        webClientService.getWithParallelFluxAndScheduler(1L, 3L, 4L, 2L);

        log.info("Fetching dogs in parallel from different services using Flux");
        webClientService.getFromMultipleServicesUsingParallelFlux(1L, 3L, 4L, 2L);

        log.info("Fetching different resources in parallel from different services using Flux");
        webClientService.getDifferentObjectsUsingParallelFlux(1L, 3L, 4L, 2L);

        log.info("Finished fetching");
    }
}