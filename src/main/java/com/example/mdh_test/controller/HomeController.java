package com.example.mdh_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Index(Model model) {
        model.addAttribute("message", "Hello, Spring Boot!");
        return "Index";
    }
}