package com.resolution.repository;

import com.resolution.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    Optional<User> findUserById(Long id);

    Optional<User> findOneByLogin(String login);

//    Query()
//    boolean findUserByIdInAndPhone();
}