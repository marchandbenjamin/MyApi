package com.example.my_api.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/swagger")
    public String redirectToSwaggerUi() {
        return "redirect:/swagger-ui/index.html";
    }
}