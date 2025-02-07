package com.amitph.spring.dogs;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner, printing all arguments...");
        Arrays.stream(args).forEach(System.out::println);
    }
}
