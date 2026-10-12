package com.example.ashiquir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToClassRequest() {
        return "redirect:/class-rescheduling-request";
    }
}