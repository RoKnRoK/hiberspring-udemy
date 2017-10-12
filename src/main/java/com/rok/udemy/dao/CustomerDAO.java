package com.rok.udemy.dao;

import com.rok.udemy.model.Customer;

import java.util.List;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public interface CustomerDAO {

    List<Customer> getCustomers();
    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
