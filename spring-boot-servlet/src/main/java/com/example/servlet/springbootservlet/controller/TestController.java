package com.example.servlet.springbootservlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/get")
    public String get(){
        return "你好，hello world";
    }
}
