package com.david.springboot.app.aop.springboot_aop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.david.springboot.app.aop.springboot_aop.services.GreatingServiceImpl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GreatingController {

    @Autowired
    private GreatingServiceImpl greating;

    @GetMapping("/greating")
    public ResponseEntity<?> greating() {

        return ResponseEntity.ok(Collections.singletonMap("greating", greating.sayHello("pepe", "Hola que tal")));
    }

}
