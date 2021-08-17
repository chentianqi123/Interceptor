package com.example.servlet.springbootservlet.config;

import com.example.servlet.springbootservlet.Servlet.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean myfilter(){
        FilterRegistrationBean<MyFilter2> registrationBean = new FilterRegistrationBean<>(new MyFilter2());
        registrationBean.addUrlPatterns("/test/*");
        return registrationBean;
    }
}
