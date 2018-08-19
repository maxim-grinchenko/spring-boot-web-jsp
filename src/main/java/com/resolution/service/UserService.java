package com.resolution.service;

import com.resolution.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findUserById(long id);

    User saveUser(User student);

    List<User> findAllUsers();

    void updateUser(User student);

    void deleteById(long id);

    Optional<User> findOneByLogin(Long id);

}