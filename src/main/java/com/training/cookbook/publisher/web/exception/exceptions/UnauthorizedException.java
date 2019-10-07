package com.training.cookbook.publisher.web.exception.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message + " EXCEPTION: unauthorized");
    }
}
