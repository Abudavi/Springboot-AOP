package com.david.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class GreatingFooAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(String com.david.springboot.app.aop.springboot_aop.services..*(..))")
    private void greatingLoggerFooPointCut() {

    }

    @Before("greatingLoggerFooPointCut()")
    public void loggerBefore(JoinPoint jPoint) {
        String method = jPoint.getSignature().getName();
        String args = Arrays.toString(jPoint.getArgs());
        logger.info("Antes: " + method + " invocado con los argumentos foo " + args);
    }

    @After("greatingLoggerFooPointCut()")
    public void loggerAfter(JoinPoint jPoint) {
        String method = jPoint.getSignature().getName();
        String args = Arrays.toString(jPoint.getArgs());
        logger.info("Despues " + method + " Con los parametros foo " + args);
    }

}
