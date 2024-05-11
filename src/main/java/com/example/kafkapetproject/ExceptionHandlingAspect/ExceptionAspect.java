package com.example.kafkapetproject.ExceptionHandlingAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ExceptionAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.example.kafkapetproject.Service.*.*(..))")
    public void loggingPontCut(){}

    @AfterThrowing(pointcut = "loggingPontCut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in {}.{}() with cause = '{}' and exception = '{}'",
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
                exception.getCause() != null ? exception.getCause() : "NULL", exception.getMessage(), exception);
    }
}
