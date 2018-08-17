package com.resolution.infra.transformer;

import com.resolution.domain.dto.UserDTO;
import com.resolution.domain.entity.User;
import org.springframework.beans.BeanUtils;

/**
 * @author maxima - 31.07.2018
 */

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public User userDTOtoUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
