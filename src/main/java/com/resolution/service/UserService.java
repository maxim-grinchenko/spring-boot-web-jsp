package com.resolution.service;

import com.resolution.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findUserById(long id);

    User saveUser(User user);

    List<User> findAllUsers();

    void updateUser(User user);

    void deleteById(long id);

    void deleteAll();

    boolean confirmPasswordForChangeEmail(String password);

}