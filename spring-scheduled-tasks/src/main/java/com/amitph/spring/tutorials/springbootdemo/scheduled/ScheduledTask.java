package com.amitph.spring.tutorials.springbootdemo.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Component
@EnableAsync
public class ScheduledTask {
    private final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Scheduled(fixedDelayString = "${schedule.fixedDelay}")
    public void taskWithFixedDelay() {
        logger.info("Task with Fixed Delay, " + (LocalTime.now().getSecond()));
    }

    @Scheduled(fixedRateString = "${schedule.fixedRate}")
    @Async
    public void taskWithFixedRate() throws InterruptedException {
        logger.info("Task with Fixed Rate, " + (LocalTime.now().getSecond()));
        MILLISECONDS.sleep(4000L);
    }

    @Scheduled(fixedRateString = "${schedule.fixedRate}", initialDelayString = "${schedule.initialDelay}")
    public void taskWithFixedRateAndInitialDelay() {
        logger.info("Task with Fixed Rate and Initial Delay, " + (LocalTime.now().getSecond()));
    }

    @Scheduled(cron = "${schedule.cron}", zone = "${schedule.timezone}")
    public void taskWithCronExpression() {
        logger.info("Task with Cron Expression, " + (LocalTime.now().getSecond()));
    }
}