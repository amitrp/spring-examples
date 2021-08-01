package com.amitph.spring.webclients;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Configuration
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
}