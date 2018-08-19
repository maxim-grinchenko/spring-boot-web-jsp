package com.resolution.infra.exception;

import com.resolution.infra.exception.base.AppException;

public class UserNotFoundException extends AppException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
