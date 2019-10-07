package com.training.cookbook.publisher.web.exception.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message + " EXCEPTION: Bad Request");
    }
}
