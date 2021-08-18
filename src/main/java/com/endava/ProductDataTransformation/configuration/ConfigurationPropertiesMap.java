package com.endava.ProductDataTransformation.configuration;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@ConfigurationProperties
@Setter
public class ConfigurationPropertiesMap {

    private HashMap<String, String> categories;
    private HashMap<String, String> occasions;

    @Bean
    public HashMap<String, String> categories() {
        return categories;
    }

    @Bean
    public HashMap<String, String> occasion() {
        return occasions;
    }

}
