package com.training.cookbook.exception.exceptions.general;

public class ApiInternalServerException extends RuntimeException {
    public ApiInternalServerException(String message) {
        super(message);
    }

    public ApiInternalServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
