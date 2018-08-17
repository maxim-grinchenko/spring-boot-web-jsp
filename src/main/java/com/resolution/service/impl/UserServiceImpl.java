package com.resolution.service.impl;

import com.resolution.domain.entity.RoleType;
import com.resolution.domain.entity.User;
import com.resolution.infra.exception.ValidationException;
import com.resolution.infra.validation.ValidationFactory;
import com.resolution.repository.UserRepository;
import com.resolution.security.SecurityUtils;
import com.resolution.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findUserById(final long id) {
        LOGGER.info("Find user by id: {}", id);
        return repository.findOne(id);
    }

    @Override
    public User saveUser(final User user) {
        LOGGER.info("Save user: {}", user);

        Validator validator = ValidationFactory.getValidator();
        validator.disableProfile("UPDATE");

        List<ConstraintViolation> violations = validator.validate(user);
        if (!violations.isEmpty())
            throw new ValidationException("User validation fail", violations);
        user.setRole(RoleType.USER.getROLE());
        repository.save(user);
        return repository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        LOGGER.info("Start find all users");
        return repository.findAll();
    }

    @Override
    public void updateUser(final User user) {
        LOGGER.info("Update user: {}", user);

        Validator validator = ValidationFactory.getValidator();
        validator.enableProfile("UPDATE");

        List<ConstraintViolation> violations = validator.validate(user);
        if (!violations.isEmpty())
            throw new ValidationException("User validation fail", violations);
        repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        repository.delete(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    public boolean confirmPasswordForChangeEmail(String password){
        User user = repository.findOneByLogin(SecurityUtils.getCurrentUserLogin()).orElseGet(User::new);
        return passwordEncoder.matches(password, user.getPassword());
    }

}