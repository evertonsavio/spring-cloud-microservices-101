package br.com.evertonsavio.usersmicroservice.appusers.data;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> { //<TIPO DO OBJETO A SER SALVO E O TIPO DO ID>
UserEntity findByEmail(String email);
UserEntity findByUserPublicId(String userId);
}
