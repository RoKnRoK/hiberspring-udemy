package com.rok.udemy.dao;

import com.rok.udemy.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.createQuery("from Customer ORDER BY lastName", Customer.class).getResultList();

    }

    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(customer);
    }
}
