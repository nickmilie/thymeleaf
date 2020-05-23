package com.nick.spring.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class MomentController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("date", new Date());

        return "hello-world";
    }
}
