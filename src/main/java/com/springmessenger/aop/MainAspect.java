package com.springmessenger.aop;

import com.springmessenger.controller.OutputController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
        outputController.showMessage("called.method.name", "", joinPoint.getSignature().getName());

        Object[] parameters = joinPoint.getArgs();
        if (parameters.length > 0) {
            for (Object parameter : parameters) {
                outputController.showMessage("parameter", "", parameter.toString());
                System.out.println("------------------");
            }
        }
    }

    @AfterReturning(pointcut = "selectAllMethod()", returning = "value")
    public void afterShowMethodName(Object value) {
        if (value != null) {
            outputController.showMessage("parameter.return", "", value.toString());
            System.out.println("-----------------------");
        }
    }
}
