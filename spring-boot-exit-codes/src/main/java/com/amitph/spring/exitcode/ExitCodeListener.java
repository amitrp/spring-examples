package com.amitph.spring.exitcode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExitCodeListener {

    @EventListener
    public void listenExitCodes(ExitCodeEvent event) {
        log.info("Exiting with code: {}", event.getExitCode());
    }
}