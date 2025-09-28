package com.spring.di.task1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.spring.vehicleSystem")
@PropertySource("classpath:application.properties")
public class AppConfig {

}
