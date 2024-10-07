package com.david.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
}
