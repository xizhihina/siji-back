package com.sijiback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("index.html");
        registry.addViewController("index").setViewName("index.html");
        registry.addViewController("login").setViewName("index.html");
        registry.addViewController("device").setViewName("index.html");
        registry.addViewController("report/**").setViewName("index.html");
        registry.addViewController("ticket/**").setViewName("index.html");
        registry.addViewController("user/**").setViewName("index.html");
    }
}
