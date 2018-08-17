package com.resolution.service;

import com.resolution.Utils.Util;
import com.resolution.domain.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveUser(){
        User user = Util.createUser();
        user = service.saveUser(user);
        assertNotNull(user);
    }

    @Test
    public void createUsers(){
        User user = Util.createUser();
        assertNotNull(user);
    }



}
