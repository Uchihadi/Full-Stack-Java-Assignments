package com.springbootNurhadi.springsg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonConfiguration implements WebMvcConfigurer {
    //Whenever Request comes from localhost 3000 --> It is allowable

    @Override
    public void addCorsMappings(CorsRegistry registry) { //Adding Cross Origin Requests
        registry.addMapping("/**").allowedOrigins("http://localhost:3000");
        // Path Pattern can be anywhere
    }   // Cors Mapping Cors Configuration allows different locations to work together
}
