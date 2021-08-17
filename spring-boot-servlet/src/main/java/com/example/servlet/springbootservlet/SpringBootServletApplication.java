package com.example.servlet.springbootservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.servlet.springbootservlet.Servlet")
public class SpringBootServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletApplication.class, args);
    }

}
