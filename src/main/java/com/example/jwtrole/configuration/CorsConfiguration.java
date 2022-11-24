package com.example.jwtrole.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";
    private static final String PUT = "PUT";

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**") //allow any mapping
                       .allowedMethods(GET, POST, PUT, DELETE)
                       .allowedHeaders("*")//all kind of headrs
                       .allowedOriginPatterns("*")
                       .allowCredentials(true);
            }
        };
    }
}
