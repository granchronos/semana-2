package com.idat.semana2.expose;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String index(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "hello";
    }

}
