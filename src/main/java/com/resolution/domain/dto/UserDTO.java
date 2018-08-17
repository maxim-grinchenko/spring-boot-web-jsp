package com.resolution.domain.dto;


import com.resolution.domain.dto.base.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author maxima - 30.07.2018
 */


@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends AbstractDTO {

    private String name;
    private String phone;
    private String email;
    private String role;
}
