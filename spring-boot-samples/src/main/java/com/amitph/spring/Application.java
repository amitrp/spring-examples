package com.amitph.spring;

import com.amitph.spring.filters.RequestStatsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class Application {
    private static ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);

        // Turn off the startup Spring Boot Banner
        // app.setBannerMode(Banner.Mode.OFF);

        context = app.run(args);
        printBeanByName();
        printBeanByType();
        printBeanNames();
    }

    private static void printBeanByName() {
        String beanName = "requestStatsFilter";
        RequestStatsFilter requestStatsFilter = (RequestStatsFilter) context.getBean(beanName);

        System.out.println(beanName + " of type " + requestStatsFilter.getClass());
    }

    private static void printBeanByType() {
        Map<String, Filter> filterBeans = context.getBeansOfType(Filter.class);

        filterBeans.forEach((s, filter) -> System.out.println(s + " of type " + filter.getClass()));
    }

    private static void printBeanNames() {
        String[] beansNames = context.getBeanDefinitionNames();

        Arrays.stream(beansNames).forEach(beansName -> {
            Object bean = context.getBean(beansName);
            System.out.println(beansName + " of type " + bean.getClass());
        });
    }
}