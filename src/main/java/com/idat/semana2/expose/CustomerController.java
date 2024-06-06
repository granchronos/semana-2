package com.idat.semana2.expose;

import com.idat.semana2.model.Customer;
import com.idat.semana2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registro";
    }

    @PostMapping("/register")
    public String postForm(Model model, @ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        model.addAttribute("customers", customerService.allCustomers());
        return "clientes";
    }

    @GetMapping("/list")
    public String listTable(Model model) {
        model.addAttribute("customers", customerService.allCustomers());
        return "clientes";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable Long id) {
        customerService.get(id).ifPresent(c -> model.addAttribute("customer", c));
        return "edit";
    }

    @PostMapping("/edit")
    public String editForm(Model model, @ModelAttribute Customer customer) {
        customerService.editCustomer(customer);
        model.addAttribute("customers", customerService.allCustomers());
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(Model model, @PathVariable Long id) {
        customerService.deleteCustomer(id);
        model.addAttribute("customers", customerService.allCustomers());
        return "redirect:/list";
    }

}
