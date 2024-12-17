package com.amitph.spring.adminserver;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfiguration {
    private final String adminContextPath;

    public SecurityConfiguration(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeHttpRequests(
                        req ->
                                req.requestMatchers(adminContextPath + "/assets/**")
                                        .permitAll()
                                        .requestMatchers(adminContextPath + "/login")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated())
                .formLogin(
                        formLogin ->
                                formLogin
                                        .loginPage(adminContextPath + "/login")
                                        .successHandler(successHandler))
                .logout(logout -> logout.logoutUrl(adminContextPath + "/logout"))
                .httpBasic(Customizer.withDefaults())
                .csrf(
                        csrf ->
                                csrf.csrfTokenRepository(
                                                CookieCsrfTokenRepository.withHttpOnlyFalse())
                                        .ignoringRequestMatchers(
                                                adminContextPath + "/instances",
                                                adminContextPath + "/actuator/**"));
        return http.build();
    }
}
