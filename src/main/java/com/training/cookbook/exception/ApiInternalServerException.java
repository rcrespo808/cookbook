package com.training.cookbook.exception;

public class ApiInternalServerException extends RuntimeException {
    public ApiInternalServerException(String message) {
        super(message);
    }

    public ApiInternalServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
