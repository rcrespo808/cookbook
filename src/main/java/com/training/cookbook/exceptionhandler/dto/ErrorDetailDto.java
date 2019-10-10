package com.training.cookbook.exceptionhandler.dto;

public class ErrorDetailDto {
    private String cause;
    private String message;

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDetailDto(String cause, String message) {
        this.cause = cause;
        this.message = message;
    }
}
