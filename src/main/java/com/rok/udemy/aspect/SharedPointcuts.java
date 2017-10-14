package com.rok.udemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Aspect
@Component
public class SharedPointcuts {

    @Pointcut(value = "execution(* com.rok.udemy.dao.CustomerDAOImpl.save*(com.rok.udemy.model.Customer))")
    public void saveCustomerPointCut(){}

    @Pointcut(value = "execution(* com.rok.udemy.dao.CustomerDAOImpl.getCustomers())")
    public void getCustomersPointCut(){}

    @Pointcut(value = "execution(* com.rok.udemy.dao.CustomerDAOImpl.getCustomer(int))")
    public void getCustomerPointCut(){}


    @Pointcut(value = "execution(* com.rok.udemy.dao.CustomerDAOImpl.*(..))")
    public void allDAOMethods(){}
}
