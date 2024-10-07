package com.david.springboot.app.aop.springboot_aop.services;

public interface GreatingServices {

    String sayHello(String person, String phrase);

    String sayHelloError(String person, String phrase);
}
