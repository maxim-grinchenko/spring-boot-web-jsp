package com.resolution.service;

import com.resolution.domain.entity.User;
import sun.jvm.hotspot.debugger.cdbg.ClosestSymbol;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findUserById(long id);

    User saveUser(User student);

    List<User> findAllUsers();

    void updateUser(User student);

    void deleteById(long id);

    Optional<User> findOneByLogin(String login);

    Optional<User> findOneByEmail(String email);

    boolean confirmPasswordForChangeEmail(String password);

//    User save(User user);

}