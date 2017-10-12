package com.rok.udemy.service;

import com.rok.udemy.dao.CustomerDAO;
import com.rok.udemy.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerDAO customerDAO;

    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }
}
