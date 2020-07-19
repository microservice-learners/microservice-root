package com.edureka.ms.training.securitysimple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "secured")
//http://localhost:<port>/secured
public class ProtectedService {

    @GetMapping
    public String getHello(){
        return "I am an secured API";
    }
}
