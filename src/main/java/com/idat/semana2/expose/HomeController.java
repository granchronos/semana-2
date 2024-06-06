package com.idat.semana2.expose;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, Locale locale) {
        model.addAttribute("welcomeTittle", locale.getLanguage().equals("en") ? "Welcome to Customer Application" : "Bienvenido a la aplicaición de clientes");
        model.addAttribute("welcomeMessage", locale.getLanguage().equals("en") ? "Manage your clients in a simple way.": "Gestiona a tus clientes de forma sencilla.");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
