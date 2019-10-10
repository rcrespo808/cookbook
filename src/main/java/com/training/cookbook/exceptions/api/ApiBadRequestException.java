package com.training.cookbook.exceptions.api;

public class ApiBadRequestException extends ApiException {
    public ApiBadRequestException(String message) {
        super(message);
    }

    public ApiBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
