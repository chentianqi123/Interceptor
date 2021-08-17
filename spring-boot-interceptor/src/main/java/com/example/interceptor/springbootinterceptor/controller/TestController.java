package com.example.interceptor.springbootinterceptor.controller;

import com.example.interceptor.springbootinterceptor.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {

    //不需要拦截
    @GetMapping("/login")
    public String login(HttpServletRequest request){
        User user = new User();
        user.setName("陈天奇");
        user.setPassword("123456");
        request.getSession().setAttribute("user",user);

        return "LOGIN SUCCESS";
    }

    //不需要拦截
    @GetMapping("/loginfailed")
    public String loginfailed(){
        return "LOGIN FAILED";
    }

    //需要拦截
    @GetMapping("/getInfo")
    public String getInfo(){
        return "Info Message";
    }

    //不需要拦截
    @GetMapping("/err")
    public String err(){
        return "err";
    }
}
