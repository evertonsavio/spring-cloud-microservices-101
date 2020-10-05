package br.com.padotec.usersmicroservice.padousers.users.controller;

import br.com.padotec.usersmicroservice.padousers.models.ResponseModel;
import br.com.padotec.usersmicroservice.padousers.models.UserModel;
import br.com.padotec.usersmicroservice.padousers.services.UsersService;
import br.com.padotec.usersmicroservice.padousers.shared.UserDto;
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

    @GetMapping("/status/check")
    public String status(){
        return "working" + "on Port" + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<ResponseModel> createUser(@Valid @RequestBody UserModel userDetails){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createdUser = usersService.createUser(userDto);

        ResponseModel returnUser = modelMapper.map(createdUser, ResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnUser);
        //return new ResponseEntity(HttpStatus.CREATED);
    }
}
