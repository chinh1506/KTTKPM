package com.example.onthigk.config;

import com.example.onthigk.filter.JWTFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Bean
    public FilterRegistrationBean<JWTFilter> filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean= new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new JWTFilter());
        filterRegistrationBean.addUrlPatterns("/users");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
