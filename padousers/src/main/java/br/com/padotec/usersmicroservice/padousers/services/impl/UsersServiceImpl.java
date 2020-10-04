package br.com.padotec.usersmicroservice.padousers.services.impl;

import br.com.padotec.usersmicroservice.padousers.data.UserEntity;
import br.com.padotec.usersmicroservice.padousers.data.UsersRepository;
import br.com.padotec.usersmicroservice.padousers.services.UsersService;
import br.com.padotec.usersmicroservice.padousers.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

        //TODO SpringSecurity
        userEntity.setEncryptedPassword("TEST");

        usersRepository.save(userEntity);

        return null;
    }
}
