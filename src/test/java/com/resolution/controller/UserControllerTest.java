package com.resolution.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resolution.Utils.Util;
import com.resolution.domain.dto.UserConfirmDto;
import com.resolution.domain.dto.UserDTO;
import com.resolution.domain.entity.User;
import com.resolution.infra.transformer.UserMapper;
import com.resolution.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author maxima - 30.07.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private UserService service;

    private UserMapper mapper = UserMapper.INSTANCE;

    @Before
    public void setUp(){
    }

    @Test
    public void register() {
    }

    @Test
    public void saveEmployee() {
        User user = Util.createUser();

        UserController userController = new UserController();
        userController.saveEmployee(user);
    }



    @Test
    public void edit() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getAllUsers() {

        int howMatchUserCreate = Integer.parseInt(RandomStringUtils.randomNumeric(1, 5));
        addUserInDataBase(howMatchUserCreate);

        List<UserDTO> collect = service.findAllUsers().stream().map(mapper::userToUserDTO).collect(Collectors.toList());
        collect.forEach(System.out::print);

        assertNotNull(collect);
        assertEquals(howMatchUserCreate, collect.size());
    }

    private void addUserInDataBase(int howMatch) {
        for (int i = 0; i < howMatch; i++) {
            User user = Util.createUser();
            service.saveUser(user);
        }
    }


    @Test
    public void updateEmailCorrectEmailAndPassTest() throws Exception {
        UserConfirmDto userConfirmDto = new UserConfirmDto();
        userConfirmDto.setEmail("test@email.com");
        userConfirmDto.setPassword("testPassword");

        mockMvc.perform(post("/users-ext/updateEmail")
                .contentType(contentType)
                .content(asJsonString(userConfirmDto)))
                .andExpect((ResultMatcher) jsonPath("EMAIL_CHANGED", status().isOk()));

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    @After
    public void clearAll(){
        service.deleteAll();
    }

}
