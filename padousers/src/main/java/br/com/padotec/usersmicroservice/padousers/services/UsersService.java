package br.com.padotec.usersmicroservice.padousers.services;

import br.com.padotec.usersmicroservice.padousers.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService { //extends UserDetailsService, necessario por causa do WebSecurity userService
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
}
