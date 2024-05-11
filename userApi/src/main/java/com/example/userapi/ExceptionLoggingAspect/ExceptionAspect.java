package com.example.userapi.ExceptionLoggingAspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ExceptionAspect {

    @Pointcut("execution(* com.example.userapi.Service.*.*(..))")
    public void loggingPointCut() {}

    @AfterThrowing(pointcut = "loggingPointCut()", throwing = "ex")
    public void logError(Throwable ex) {
        System.out.println(ex.getMessage());
    }

}
