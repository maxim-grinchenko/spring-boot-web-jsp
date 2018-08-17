package com.resolution.infra.transformer;

import com.resolution.Utils.Util;
import com.resolution.domain.dto.UserDTO;
import com.resolution.domain.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author maxima - 31.07.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperImplTest {

    private User user;
    private UserDTO userDTO = new UserDTO();


    @Before
    public void starUP(){
        user = Util.createUser();
    }

    @Test
    public void userToUserDTO() {
        BeanUtils.copyProperties(user, userDTO);
        assertNotNull(userDTO);
    }

    @Test
    public void userDTOtoUser() {

    }
}
