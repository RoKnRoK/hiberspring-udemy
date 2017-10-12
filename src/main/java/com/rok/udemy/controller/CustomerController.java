package com.rok.udemy.controller;

import com.rok.udemy.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model){
        model.addAttribute("customerList", customerDAO.getCustomers());
        return "list-customers";
    }
}
