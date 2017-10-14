package com.rok.udemy.aspect;

import com.rok.udemy.model.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Aspect
@Component
@Order(1)
public class LoggingAspect {

    private static int saveCustomerCalled = 0;



    @Before("SharedPointcuts.saveCustomerPointCut())")
    public void logSaveCustomer(JoinPoint joinPoint){
        System.out.println("Going to save customer " + joinPoint.getArgs()[0]);
    }

    @Before("SharedPointcuts.saveCustomerPointCut())")
    public void countSaveCustomer(){
        saveCustomerCalled++;
        System.out.println("saveCustomer called " + saveCustomerCalled + " times");
    }

    @Before(value = "SharedPointcuts.allDAOMethods() && !SharedPointcuts.saveCustomerPointCut()")
    public void beforeDAOAccess(JoinPoint joinPoint){
        System.out.println("Method of DAO accessed: " + joinPoint.getSignature().toShortString() );
    }

    @AfterReturning(
            pointcut = "SharedPointcuts.getCustomersPointCut()",
            returning = "customers")
    public void afterGetCustomers(JoinPoint joinPoint, List<Customer> customers){
        System.out.println("Method finished: " + joinPoint.getSignature().toLongString());
        System.out.println("Customers retrieved: " + customers);
        if (customers != null && !customers.isEmpty()) {
            customers.get(0).setFirstName("INTERRUPTED");
            System.out.println("Customer changed");
        }
    }

    @AfterThrowing(
            pointcut = "SharedPointcuts.getCustomerPointCut()",
            throwing = "exception")
    public void afterGetCustomer(JoinPoint joinPoint, Exception exception){
        System.out.println("Method finished: " + joinPoint.getSignature().toLongString());
        System.out.println("Exception thrown: " + exception.getClass());
        System.out.println("Exception messge: " + exception.getMessage());
    }

    @Around("SharedPointcuts.getCustomersPointCut()")
    public Object profileGetCustomers(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("Time to retrieve customers: " + (end-start));
        return result;
    }


}
