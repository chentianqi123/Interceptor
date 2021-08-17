package com.example.servlet.springbootservlet.config;

import com.example.servlet.springbootservlet.Servlet.MyServlet;
import com.example.servlet.springbootservlet.Servlet.MyServlet2;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean registrationBean(){
        ServletRegistrationBean<MyServlet> myServlet = new ServletRegistrationBean(new MyServlet2(), "/myServlet");
        return myServlet;
    }
}
