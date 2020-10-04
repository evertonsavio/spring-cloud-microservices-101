package dev.evertonsavio.projetospring.userservice.impl;

import dev.evertonsavio.projetospring.model.UserRest;
import dev.evertonsavio.projetospring.model.request.UserDetailsRequestModel;
import dev.evertonsavio.projetospring.shared.Utils;
import dev.evertonsavio.projetospring.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {

        UserRest userRest = new UserRest();
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setLastName(userDetailsRequestModel.getLastName());
        userRest.setEmail(userDetailsRequestModel.getEmail());

        String userId = utils.generateUserId();
        userRest.setUserId(userId);

        if(users == null) users = new HashMap<>();
        users.put(userId, userRest);

        return userRest;

    }
}
