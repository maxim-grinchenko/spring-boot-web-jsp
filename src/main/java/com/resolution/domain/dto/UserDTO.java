package com.resolution.domain.dto;

import com.resolution.domain.dto.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserDTO extends BaseDTO {
    private String name;
    private String lastName;
    private String middleName;
    private String phone;
    private String email;
}