package com.spring.vehicleSystem.config;


import com.spring.vehicleSystem.dao.DatabaseOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.spring.vehicleSystem")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public DatabaseOperations databaseOperations() {
        return new DatabaseOperations();
    }
}
