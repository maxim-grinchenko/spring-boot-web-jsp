package com.resolution.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public enum UserProfileType implements Serializable {
    USER("USER"),
    ADMIN("ADMIN");

    String userProfileType;

    String getUserProfileType() {
        return userProfileType;
    }

}
