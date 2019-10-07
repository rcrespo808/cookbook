package com.training.cookbook.publisher.web.exception.exceptions;

public class NotFoundEceptionException extends RuntimeException {
    public NotFoundEceptionException(String message) {
        super(message + " EXCEPTION: Not Found");
    }
}
