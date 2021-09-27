package com.amitph.spring;

import com.amitph.spring.filters.V2LoggingFilter;
import com.amitph.spring.naming.Heart;
import com.amitph.spring.naming.Pentagon;
import com.amitph.spring.naming.Shape;
import com.amitph.spring.naming.Square;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public FilterRegistrationBean<V2LoggingFilter> v2LoggingFilter() {
        FilterRegistrationBean<V2LoggingFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new V2LoggingFilter());
        registrationBean.addUrlPatterns("/v2/*");
        registrationBean.setOrder(3);

        return registrationBean;
    }

    @Bean
    public Shape squareType() {
        return new Square();
    }

    @Bean("pentagonShape")
    public Shape shape() {
        return new Pentagon();
    }

    @Bean
    @Qualifier("heartBean")
    public Shape heartType() {
        return new Heart();
    }
}