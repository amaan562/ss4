package com.thecodeveal.app.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");         //'*' allows all endpoints, Provide your URL/endpoint, if any.
        config.addAllowedHeader("*");         
        config.addAllowedMethod("POST");   //add the methods you want to allow like 'GET', 'PUT',etc. using similar statements.
        config.addAllowedMethod("GET");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter();
    }
}
