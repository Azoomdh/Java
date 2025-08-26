package com.example.demoJava1.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(){
        return "Home/home"; 
        // trỏ tới file : "src\main\resources\templates\Home\home.html"
    }
}
