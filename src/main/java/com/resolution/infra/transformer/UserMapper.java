package com.resolution.infra.transformer;

import com.resolution.domain.dto.UserDTO;
import com.resolution.domain.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);

    User userDTOtoUser(UserDTO userDTO);
}