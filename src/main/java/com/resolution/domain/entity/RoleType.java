package com.resolution.domain.entity;


import lombok.Getter;

@Getter
public enum RoleType {

    ADMIN("admin"),
    USER("user"),
    MANAGER("manager");

    private final String ROLE;

    RoleType(final String role) {
        ROLE = role;
    }
}
