package com.amitph.spring.webclients;

import com.amitph.spring.webclients.service.FileDownloaderWebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class FileDownloader {
    private final FileDownloaderWebClientService webClientService;
    private final ApplicationProperties props;

    @PostConstruct
    public void onApplicationEvent() throws IOException {
        Path output = Paths.get(props.getOutputPath());
        //webClientService.downloadUsingByteArray(output);
        //webClientService.downloadUsingMono(output);
        webClientService.downloadUsingFlux(output);
    }
}