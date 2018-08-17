package com.resolution.domain.details;

import com.resolution.domain.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * @author maxima - 16.08.2018
 */

public class CustomUserDetails extends User {
    private static final long serialVersionUID = 1L;

    private final Long id;

    public CustomUserDetails(Long id, String name, String phone, String email, String password) {
        super(name, phone, email, password);
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
