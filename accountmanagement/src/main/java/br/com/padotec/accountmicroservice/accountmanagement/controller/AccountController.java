package br.com.padotec.accountmicroservice.accountmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    Environment environment;

    @Autowired
    public AccountController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/status")
    public String status(){
        return environment.getProperty("config.bus.test") ;
    }

}
