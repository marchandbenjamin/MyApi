package com.roldaice.myboardgames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SwaggerController {

    @GetMapping("/")
    public RedirectView rootRedirectToSwagger() {
        return new RedirectView("/api/swagger-ui.html");
    }

    @GetMapping("/api")
    public RedirectView apiRedirectToSwagger() {
        return new RedirectView("/api/swagger-ui.html");
    }

    @GetMapping("/swagger")
    public RedirectView swaggerRedirectToSwaggerUi() {
        return new RedirectView("/api/swagger-ui.html");
    }

    @GetMapping("/api/swagger")
    public RedirectView apiSwaggerRedirectToSwaggerUi() {
        return new RedirectView("/api/swagger-ui.html");
    }
}
