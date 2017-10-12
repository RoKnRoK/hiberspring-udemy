package com.rok.udemy.service;

import com.rok.udemy.model.Customer;

import java.util.List;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
}
