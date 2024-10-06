package com.david.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreatingServiceImpl implements GreatingServices {

    @Override
    public String sayHello(String person, String phrase) {
        String greating = phrase + " " + person;
        System.out.println(greating);
        return greating;
    }

}
