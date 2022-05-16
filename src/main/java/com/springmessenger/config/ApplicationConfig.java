package com.springmessenger.config;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springmessenger")
public class ApplicationConfig {

    @Bean
    public ColumnPositionMappingStrategy columnPositionMappingStrategy() {
        return new ColumnPositionMappingStrategy();
    }

}
