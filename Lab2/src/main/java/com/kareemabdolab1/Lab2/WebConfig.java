package com.kareemabdolab1.Lab2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://kareemabdoapp-new.azurewebsites.net")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}