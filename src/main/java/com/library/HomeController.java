package com.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String renderHomePage(){
        System.out.println("rendering");
        return "index";
    }


}
