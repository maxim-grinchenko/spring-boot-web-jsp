package com.resolution.infra.transformer;

import com.resolution.domain.dto.UserDTO;
import com.resolution.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author maxima - 30.07.2018
 */

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOtoUser(UserDTO userDTO);
}
