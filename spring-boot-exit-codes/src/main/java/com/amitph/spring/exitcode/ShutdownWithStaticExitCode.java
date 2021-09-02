package com.amitph.spring.exitcode;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ShutdownWithStaticExitCode {
    private final ApplicationContext applicationContext;

    /*
     * Next two are the examples CommandLineRunner and ApplicationRunner
     * Comment either of them, and they work similarly
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            if (args.length == 0) {
                throw new IllegalArgumentException("Illegal argument received");
            }

            long value = Long.parseLong(args[0]);
            if (value < 100) {
                throw new ValueTooSmallException("Value should be >= 100");
            }

            System.exit(
                    SpringApplication.exit(applicationContext, () -> 11));
        };
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("application runner");
            if (args.getSourceArgs().length == 0) {
                throw new IllegalArgumentException("Illegal argument received");
            }
            long value = Long.parseLong(args.getSourceArgs()[0]);

            if (value < 100) {
                throw new ValueTooSmallException("Value should be >= 100");
            }

            System.exit(
                    SpringApplication.exit(applicationContext, () -> 11));
        };
    }

    /*
     * If you are trying ValueTooSmallException, comment the next
     * ExitCodeExceptionMapper factory method
     */
    @Bean
    public ExitCodeExceptionMapper exceptionBasedExitCode() {
        return exception -> {
            if (exception.getCause() instanceof NumberFormatException) {
                return 30;
            }
            if (exception.getCause() instanceof IllegalArgumentException) {
                return 20;
            }
            return 99;
        };
    }
}