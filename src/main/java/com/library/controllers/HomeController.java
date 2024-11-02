package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String renderHomePage(){
        System.out.println("rendering");
        return "home";
    }


}
