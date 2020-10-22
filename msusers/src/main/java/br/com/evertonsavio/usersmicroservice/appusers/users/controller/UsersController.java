package br.com.evertonsavio.usersmicroservice.appusers.users.controller;

import br.com.evertonsavio.usersmicroservice.appusers.models.ResponseModel;
import br.com.evertonsavio.usersmicroservice.appusers.models.UserModel;
import br.com.evertonsavio.usersmicroservice.appusers.shared.UserDto;
import br.com.evertonsavio.usersmicroservice.appusers.services.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment env;

    @Autowired
    UsersService usersService;

    @GetMapping("/status")
    public String status(){
        return "Working " + "on Port = " + env.getProperty("local.server.port");
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseModel> createUser(@Valid @RequestBody UserModel userDetails){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createdUser = usersService.createUser(userDto);

        ResponseModel returnUser = modelMapper.map(createdUser, ResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnUser);
    }
}
