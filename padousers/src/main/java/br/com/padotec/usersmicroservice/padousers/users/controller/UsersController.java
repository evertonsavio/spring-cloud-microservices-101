package br.com.padotec.usersmicroservice.padousers.users.controller;

import br.com.padotec.usersmicroservice.padousers.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String status(){
        return "working" + "on Port" + env.getProperty("local.server.port");
    }

    @PostMapping("/signup")
    public String createUser(@Valid @RequestBody UserModel userDetails){
        return "Create user method --" + userDetails;
    }
}
