package com.rok.udemy.dao;

import com.rok.udemy.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.createQuery("from Customer", Customer.class).getResultList();

    }
}
