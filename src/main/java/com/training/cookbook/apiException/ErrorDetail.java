package com.training.cookbook.apiException;

public class ErrorDetail {
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

    public ErrorDetail(String cause, String message) {
        this.cause = cause;
        this.message = message;
    }
}
