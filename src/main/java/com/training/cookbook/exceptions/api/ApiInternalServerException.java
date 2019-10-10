package com.training.cookbook.exceptions.api;

public class ApiInternalServerException extends ApiException {
    public ApiInternalServerException(String message) {
        super(message);
    }

    public ApiInternalServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
