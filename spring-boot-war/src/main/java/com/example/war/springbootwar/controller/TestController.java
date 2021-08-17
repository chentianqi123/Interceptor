package com.example.war.springbootwar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView view = new ModelAndView();
        view.addObject("message","testSpringBoot");
        view.setViewName("test");
        return view;
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("message","testSpringBoot123");
        return "test";
    }
}
