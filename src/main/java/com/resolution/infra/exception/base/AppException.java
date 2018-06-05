package com.resolution.infra.exception.base;


public abstract class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}