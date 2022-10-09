package com.example.tuan05ontap.config;

import com.example.tuan05ontap.filter.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {
    @Bean
    public FilterRegistrationBean<AuthorizationFilter> filterRegistrationBean() {
        FilterRegistrationBean < AuthorizationFilter > registrationBean = new FilterRegistrationBean();
        AuthorizationFilter authorization = new AuthorizationFilter();

        registrationBean.setFilter(authorization);
        registrationBean.addUrlPatterns("/messages/*");
        registrationBean.setOrder(2); //set precedence
        return registrationBean;
    }
}
