package dev.evertonsavio.projetospring.ui.controller;

import dev.evertonsavio.projetospring.exceptions.UserServiceExcception;
import dev.evertonsavio.projetospring.model.UserRest;
import dev.evertonsavio.projetospring.model.request.UserDetailsRequestModel;
import dev.evertonsavio.projetospring.userservice.UserService;
import dev.evertonsavio.projetospring.userservice.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "10") int limit,
                          @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort)
    {
        return "Retorna isso com page: " + page + ", limit:" + limit + sort ;
    }
    @GetMapping(path = "/{userId}",
                produces = {MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUserById(@PathVariable String userId){

        if(true) throw  new UserServiceExcception("Minha exception propria");

        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel){

        //SEM Independecy Injection ficaria assim, ruim para testar e mockar, instacia direta da classe.
        //UserRest returnValue = new UserServiceImpl().createUser(userDetailsRequestModel);

        UserRest returnValue = userService.createUser(userDetailsRequestModel);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public UserRest putUser(@PathVariable String userId,
                          @RequestBody UserDetailsRequestModel userDetailsRequestModel){

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetailsRequestModel.getFirstName());
        storedUserDetails.setLastName(userDetailsRequestModel.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id)
    {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }

}
