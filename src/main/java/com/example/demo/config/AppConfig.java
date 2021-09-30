package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
