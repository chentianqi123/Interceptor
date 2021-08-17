package com.example.servlet.springbootservlet.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

@Configuration
public class SystemConfig {
    /*@Bean
    public FilterRegistrationBean myFilter(){

        //创建字符编码过滤器
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        //设置强制使用指定字符编码
        encodingFilter.setForceEncoding(true);
        //设置指定字符编码
        encodingFilter.setEncoding("UTF-8");

        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        //设置字符编码过滤器
        registrationBean.setFilter(encodingFilter);

        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }*/
}
