package com.resolution.infra.exception;


import com.resolution.infra.exception.base.AppException;

public class UnauthorizedException extends AppException {
    private static final String UNAUTHORIZED = "unauthorized";

    public UnauthorizedException() {
        super(UNAUTHORIZED);
    }
}