package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
    @Bean
    public String time(){
        return "Hello";
    }
}
