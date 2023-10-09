package ru;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class ApplicationConfig {
    @Bean
    public HelloBean helloBean() {
        return new HelloBean("Hello, World!");
    }
}
