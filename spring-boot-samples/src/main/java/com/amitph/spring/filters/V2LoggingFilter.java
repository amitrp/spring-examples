package com.amitph.spring.filters;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class V2LoggingFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        log.info("V2 Logging request: request: {}", request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("V2 Logging response: response: {}", servletResponse.getContentType());
    }
}