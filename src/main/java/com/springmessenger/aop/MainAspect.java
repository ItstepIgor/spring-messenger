package com.springmessenger.aop;

import com.springmessenger.cache.MessageCacheMap;
import com.springmessenger.controller.OutputController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MainAspect {

    private final OutputController outputController;

    private final MessageCacheMap messageCacheMap;

    public MainAspect(OutputController outputController, MessageCacheMap messageCacheMap) {
        this.outputController = outputController;
        this.messageCacheMap = messageCacheMap;
    }

    @Pointcut("execution(* com.springmessenger.repository.MessageRepository.*(..))")
    public void selectAllMethod() {
    }

    @Pointcut("execution(* com.springmessenger.service.MessageService.findById(*))")
    public void getByIdServiceMethod() {
    }

    @Before("selectAllMethod()")
    public void beforeShowMethodName(JoinPoint joinPoint) {
        outputController.showMessage("called.method.name", "", joinPoint.getSignature().getName());

        Object[] parameters = joinPoint.getArgs();
        if (parameters.length == 0) {
            return;
        }
        for (Object parameter : parameters) {
            outputController.showMessage("parameter", "", parameter.toString());
            System.out.println("------------------");
        }
    }

    @AfterReturning(pointcut = "selectAllMethod()", returning = "value")
    public void afterShowMethodName(Object value) {
        if (value != null) {
            outputController.showMessage("parameter.return", "", value.toString());
            System.out.println("-----------------------");
        }
    }

    @Around("getByIdServiceMethod() && args(id)")
    public Object writeCache(ProceedingJoinPoint joinPoint, long id) throws Throwable {
        Object result = joinPoint.proceed();
        if (id > 2) {
            messageCacheMap.addCache(id, result.toString());
        }
        return result;
    }
}
