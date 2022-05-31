package com.springmessenger.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MainAspect {


    @Before("execution(* com.springmessenger.repository.MessageRepository.getAll())")
//    @Before("@within(org.springframework.stereotype.Repository)")
    public void beforeGetAll(/*Joinpoint joinpoint*/) {
        System.out.println(/*joinpoint. +*/ " вызвали");
    }
}
