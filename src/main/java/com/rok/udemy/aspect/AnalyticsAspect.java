package com.rok.udemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@Aspect
@Component
@Order(2)
public class AnalyticsAspect {

    @Before("SharedPointcuts.saveCustomerPointCut())")
    public void performAPIAnalytics(){
        System.out.println("Some API analytics going around...");
    }
}
