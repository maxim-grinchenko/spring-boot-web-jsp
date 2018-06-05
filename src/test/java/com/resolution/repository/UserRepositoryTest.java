package com.resolution.repository;

import com.resolution.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void findAll() {
        System.out.println(repository.findAll());
    }

    @Test
    public void saveAndFindAll() {
        User user = new User();
        user.setPhone("0935291647");
        user.setName("Some name");
        user.setEmail("Some email");

        repository.save(user);

        System.out.println("find some users: " + repository.findAll());
    }
}