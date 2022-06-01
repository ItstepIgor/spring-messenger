package com.springmessenger.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MainAspect {


    @Pointcut("execution(* com.springmessenger.repository.MessageRepository.*(..))")
//    @Before("@within(org.springframework.stereotype.Repository)")
    public void selectAllMethod() {
    }


    @Before("selectAllMethod()")
    public void beforeGetAll(JoinPoint joinPoint) {
        System.out.println("Метод вызвали под названием " + joinPoint.getSignature().getName());
    }
}
