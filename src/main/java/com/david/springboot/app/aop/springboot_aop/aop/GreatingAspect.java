package com.david.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreatingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.david.springboot.app.aop.springboot_aop.services.GreatingServices.*(..))")
    public void loggerBefore(JoinPoint jPoint) {
        String method = jPoint.getSignature().getName();
        String args = Arrays.toString(jPoint.getArgs());
        logger.info("Antes " + method + " Con los argumentos " + args);
    }

    @After("execution(String com.david.springboot.app.aop.springboot_aop.services.GreatingServices.sayHello(..))")
    public void loggerAfter(JoinPoint jPoint) {
        String method = jPoint.getSignature().getName();
        String args = Arrays.toString(jPoint.getArgs());
        logger.info("Despues " + method + " Con los argumentos " + args);
    }

    @AfterReturning("execution(String com.david.springboot.app.aop.springboot_aop.services.GreatingServices.sayHello(..))")
    public void loggerAfterReturning(JoinPoint jPoint) {
        String method = jPoint.getSignature().getName();
        String args = Arrays.toString(jPoint.getArgs());
        logger.info("Despues retornar la excepcion " + method + " Con los argumentos " + args);
    }

    @AfterThrowing("execution(String com.david.springboot.app.aop.springboot_aop.services.GreatingServices.*(..))")
    public void loggerAfterThowing(JoinPoint jPoint) {
        String method = jPoint.getSignature().getName();
        String args = Arrays.toString(jPoint.getArgs());
        logger.info("Despues lanzar la excepcion " + method + " Con los argumentos " + args);
    }

    @Around("execution(String com.david.springboot.app.aop.springboot_aop.services.GreatingServices.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;

        try {
            logger.info("El metodo " + method + " con  los parametros " + args);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "() retorna el resultado " + result);
            return result;
        } catch (Throwable e) {

            logger.error("El error en la llamada del metodo " + method + "()");
        }
        return result;
    }
}
