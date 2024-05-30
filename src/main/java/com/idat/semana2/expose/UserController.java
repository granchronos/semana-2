package com.idat.semana2.expose;

import com.idat.semana2.exceptions.model.UserNotFoundException;
import com.idat.semana2.model.User;
import com.idat.semana2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.save(user);
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("/all")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        model.addAttribute("user", user);
        return "userDetails";
    }

}
