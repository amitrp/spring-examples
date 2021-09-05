package com.amitph.spring.webclients.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileDownloaderWebClientService {
    private final WebClient webClient;

    /**
     * Reads the complete file in-memory. Thus, only useful for very large file
     */
    public void downloadUsingByteArray(Path destination) throws IOException {
        Mono<byte[]> monoContents = webClient
                .get()
                .uri("/largefiles/1")
                .retrieve()
                .bodyToMono(byte[].class);

        Files.write(destination, Objects.requireNonNull(monoContents.share().block()),
                StandardOpenOption.CREATE);
    }

    /**
     * Reading file using Mono will try to fit the entire file into the DataBuffer.
     * Results in exception when the file is larger than the DataBuffer capacity.
     */
    public void downloadUsingMono(Path destination) {
        Mono<DataBuffer> dataBuffer = webClient
                .get()
                .uri("/largefiles/1")
                .retrieve()
                .bodyToMono(DataBuffer.class);

        DataBufferUtils.write(dataBuffer, destination,
                StandardOpenOption.CREATE)
                .share().block();
    }

    /**
     * Having using Flux we can download files of any size safely.
     * Optionally, we can configure DataBuffer capacity for better memory utilization.
     */
    public void downloadUsingFlux(Path destination) {
        Flux<DataBuffer> dataBuffer = webClient
                .get()
                .uri("/largefiles/1")
                .retrieve()
                .bodyToFlux(DataBuffer.class);

        DataBufferUtils.write(dataBuffer, destination,
                StandardOpenOption.CREATE)
                .share().block();
    }
}