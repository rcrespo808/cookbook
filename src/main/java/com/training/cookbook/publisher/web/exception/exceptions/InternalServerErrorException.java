package com.training.cookbook.publisher.web.exception.exceptions;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message + " EXCEPTION: Internal server error");
    }
}
