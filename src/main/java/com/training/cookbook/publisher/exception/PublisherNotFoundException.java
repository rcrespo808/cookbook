package com.training.cookbook.publisher.exception;

public class PublisherNotFoundException extends RuntimeException {
    public PublisherNotFoundException(){ super("Unable to find publisher with requested Id");}

    public PublisherNotFoundException(String message) {
        super(message);
    }

    public PublisherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
