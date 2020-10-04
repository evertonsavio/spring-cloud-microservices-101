package br.com.padotec.usersmicroservice.padousers.services;

import br.com.padotec.usersmicroservice.padousers.shared.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
}
