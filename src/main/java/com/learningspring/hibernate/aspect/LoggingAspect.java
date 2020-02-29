package com.learningspring.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.learningspring.hibernate.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.learningspring.hibernate.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("execution(* com.learningspring.hibernate.service.*.*(..))")
    private void forServicePackage(){}


    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    private void finalExpression(){}

    @Before("finalExpression()")
    public void before(JoinPoint joinPoint) {

        //display method name
        logger.info("Method : [" + joinPoint.getSignature().toShortString() + "]");

        //display arguments
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info("Argument : [" + arg + "]");
        }
    }

    @AfterReturning(
            pointcut = "finalExpression()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        //display method name
        logger.info("Method : [" + joinPoint.getSignature().toShortString() + "]");

        //display data returned
        logger.info("Method returned : [" + result + "]");
    }


}
