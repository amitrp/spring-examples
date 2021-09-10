package com.amitph.spring.webclients.service;

import com.amitph.spring.webclients.model.Dog;
import com.amitph.spring.webclients.model.OwnedDog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;

@Slf4j
@Service
public class DogsFetcherWebClientService {

    public void getInSequence(Long... ids) {
        Arrays.stream(ids)
                .map(this::getDog)
                .map(d -> d.share().block())
                .forEach(d -> log.info(d.toString()));
    }

    public void getWithParallelStream(Long... ids) {
        Arrays.stream(ids)
                .parallel()
                .map(this::getDog)
                .map(d -> d.share().block())
                .forEach(d -> log.info(d.toString()));
    }

    public void getWithParallelFlux(Long... ids) {
        Flux.fromArray(ids)
                .parallel()
                .flatMap(this::getDog).log()
                .ordered((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .toStream()
                .forEach(d -> log.info(d.toString()));
    }

    public void getWithParallelFluxAndScheduler(Long... ids) {
        Flux.fromArray(ids)
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .flatMap(this::getDog)
                .ordered((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .toStream()
                .forEach(d -> log.info(d.toString()));
    }

    public void getFromMultipleServicesUsingParallelFlux(Long... ids) {
        Flux.merge(
                        getDog(ids[0]),
                        getDog(ids[1]),
                        getOtherDog(ids[2]),
                        getOtherDog(ids[3]))
                .parallel()
                .ordered((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .toStream()
                .forEach(d -> log.info(d.toString()));
    }

    public void getDifferentObjectsUsingParallelFlux(Long... id) {
        Arrays.stream(id)
                .map(i -> {
                    Scheduler scheduler = Schedulers.boundedElastic();
                    Mono<Dog> dogMono = getDog(i).subscribeOn(scheduler);
                    Mono<String> ownerMono = getOwner(i).subscribeOn(scheduler);
                    return Mono.zip(dogMono, ownerMono, OwnedDog::new).block();
                })
                .forEach(ownedDog -> log.info(ownedDog.toString()));
    }

    private Mono<Dog> getDog(Long id) {
        return webClient()
                .get()
                .uri("/dogs/{id}", id)
                .retrieve()
                .bodyToMono(Dog.class);
    }

    private Mono<Dog> getOtherDog(Long id) {
        return webClient2()
                .get()
                .uri("/dogs/{id}", id)
                .retrieve()
                .bodyToMono(Dog.class);
    }

    private Mono<String> getOwner(Long id) {
        return webClient()
                .get()
                .uri("/dogs/{id}/owner", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    private WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .build();
    }

    private WebClient webClient2() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .build();
    }
}
