package com.david.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreatingServicePointCuts {

    @Pointcut("execution(String com.david.springboot.app.aop.springboot_aop.services..*(..))")
    public void greatingLoggerPointCut() {

    }

    @Pointcut("execution(String com.david.springboot.app.aop.springboot_aop.services..*(..))")
    public void greatingLoggerFooPointCut() {

    }

}
