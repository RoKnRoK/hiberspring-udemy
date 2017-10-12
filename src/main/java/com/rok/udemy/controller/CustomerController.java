package com.rok.udemy.controller;

import com.rok.udemy.model.Customer;
import com.rok.udemy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){
        model.addAttribute("customerList", customerService.getCustomers());
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
        model.addAttribute("customer", customerService.getCustomer(id));

        return "customer-form";

    }
}
