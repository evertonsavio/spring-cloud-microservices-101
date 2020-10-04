package dev.evertonsavio.projetospring.userservice;

import dev.evertonsavio.projetospring.model.UserRest;
import dev.evertonsavio.projetospring.model.request.UserDetailsRequestModel;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);
}
