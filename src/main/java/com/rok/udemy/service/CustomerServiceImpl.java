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
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }
}
