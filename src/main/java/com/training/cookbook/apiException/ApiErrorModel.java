package com.training.cookbook.apiException;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class ApiErrorModel {
    private final String message;
    private final HttpStatus httpStatus;
    private final Date timestamp;
    private List<ErrorDetail> errorDetails;

    public List<ErrorDetail> getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(List<ErrorDetail> errorDetails) {
        this.errorDetails = errorDetails;
    }

    public ApiErrorModel(String message, HttpStatus httpStatus, Date timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
