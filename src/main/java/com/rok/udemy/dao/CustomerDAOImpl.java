package com.rok.udemy.dao;

import com.rok.udemy.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        currentSession.saveOrUpdate(customer);
    }

    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

//        Query<Customer> query = currentSession.createQuery("from Customer Where id=:id", Customer.class);
//        query.setParameter("id", id);
//        return query.getSingleResult();

        Customer customer = currentSession.get(Customer.class, id);
        if (customer== null) {
            throw new IllegalArgumentException("No Customer with id" + id);
        }
        return customer;
    }

    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
//        Customer customer = currentSession.get(Customer.class, id);
//        currentSession.delete(customer);

        Query query = currentSession.createQuery("delete from Customer Where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }
}
