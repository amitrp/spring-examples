package com.amitph.spring.webclients;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class ApplicationConfig {
    private final ApplicationProperties props;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(props.getFileServerUrl())
                .build();
    }

    @Bean
    public WebClient webClientWithLargeBuffer() {
        return WebClient.builder()
                .baseUrl(props.getFileServerUrl())
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer ->
                                configurer.defaultCodecs()
                                        .maxInMemorySize(2 * 1024)
                        )
                        .build())
                .build();
    }

    private static final Map<HttpMethod, Integer> requestCounterMap = new HashMap<>();
    private final String userName = "userName";
    private final String password = "password";

    @Bean
    public WebClient webClientWithFilter() {
        return WebClient.builder()
                .baseUrl("http://localhost:8081")
                .filter(changeUrlFilter()
                        .andThen(statsFilter())
                        .andThen(loggingFilter())
                        .andThen(ExchangeFilterFunctions
                                .basicAuthentication(userName, password))
                        .andThen(ExchangeFilterFunctions
                                .limitResponseSize(1024 * 10))
                        .andThen(ExchangeFilterFunctions.statusError(
                                HttpStatus::is4xxClientError,
                                clientResponse -> {
                                    throw new RuntimeException();
                                }))
                )
                // Either use filter() - as above or use filters() - as in next
//                .filters(filtersList -> {
//                    filtersList.add(changeUrlFilter());
//                    filtersList.add(loggingFilter());
//                    filtersList.add(statsFilter());
//                    filtersList.add(ExchangeFilterFunctions
//                            .basicAuthentication(userName, password));
//                    filtersList.add(ExchangeFilterFunctions
//                            .limitResponseSize(1024 * 10));
//                    filtersList.add(ExchangeFilterFunctions.statusError(
//                            HttpStatus::is4xxClientError,
//                            clientResponse -> {
//                                throw new RuntimeException();
//                            }
//                    ));
//                })
                .build();
    }

    private static ExchangeFilterFunction changeUrlFilter() {
        return (request, next) -> {
            String currentUrl = request.url().toString();
            ClientRequest newRequest = ClientRequest.from(request)
                    .url(URI.create(currentUrl.replace("8081", "8080")))
                    .build();

            return next.exchange(newRequest);
        };
    }

    private static ExchangeFilterFunction statsFilter() {
        return (request, next) -> {
            int counter = requestCounterMap.getOrDefault(request.method(), 0);
            requestCounterMap.put(request.method(), ++counter);
            return next.exchange(request);
        };
    }

    private static ExchangeFilterFunction loggingFilter() {
        return (request, next) -> {
            log.info("Executing " + request.method() + " " + request.url());
            return next.exchange(request);
        };
    }
}