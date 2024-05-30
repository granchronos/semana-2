package com.idat.semana2.expose;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, Locale locale) {
        model.addAttribute("welcomeMessage", locale.getLanguage().equals("es") ? "¡Bienvenido a Spring Boot!" : "Welcome to Spring Boot!");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
