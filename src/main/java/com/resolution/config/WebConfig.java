package com.resolution.config;

import com.resolution.controller.SecurityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Collections;

/**
 * @author maxima - 17.08.2018
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean securityFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean =
                new FilterRegistrationBean(securityFilter());

//        filterRegistrationBean.addUrlPatterns(
//                "/edit/*",
//                "/property-access/*",
//                "/property/*",
//                "gas-request/17769"
//        );
        filterRegistrationBean.setUrlPatterns(Collections.singleton("/edit/*"));
        return filterRegistrationBean;
    }

    @Bean
    public Filter securityFilter() {
        return new SecurityFilter();
    }
}
