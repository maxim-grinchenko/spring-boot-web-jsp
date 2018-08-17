package com.resolution.config;

import com.resolution.controller.SecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author maxima - 17.08.2018
 */
@Configuration
public class WebConfig {

    @Bean
    public Filter securityFilter() {
        return new SecurityFilter();
    }
}
