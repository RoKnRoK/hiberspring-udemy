package com.rok.udemy.aspect;

import com.rok.udemy.model.Customer;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Aspect
@Component
public class LoggingAspect {

    @Before(value = "execution(* saveCustomer(com.rok.udemy.model.Customer))")
    public void beforeSaveCustomer(/*Customer customer*/){
        System.out.println("Going to save customer " /*+ customer*/);
    }
}
