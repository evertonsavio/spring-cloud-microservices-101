package br.com.evertonsavio.usersmicroservice.appusers.services;

import br.com.evertonsavio.usersmicroservice.appusers.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService { //extends UserDetailsService, necessario por causa do WebSecurity userService
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
    UserDto getUserByUserPublicId(String userId);
}
