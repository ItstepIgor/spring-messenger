package com.springmessenger.aop;

import com.springmessenger.controller.OutputController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MainAspect {

    @Autowired
    private OutputController outputController;

    @Pointcut("execution(* com.springmessenger.repository.MessageRepository.*(..))")
    public void selectAllMethod() {
    }

    @Before("selectAllMethod()")
    public void beforeShowMethodName(JoinPoint joinPoint) {
//        System.out.println("Вызвали метод под названием: " + joinPoint.getSignature().getName());
        outputController.showMessage("called.method.name", "", joinPoint.getSignature().getName());
    }
}
