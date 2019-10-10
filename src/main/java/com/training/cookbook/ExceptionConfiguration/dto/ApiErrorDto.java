package com.training.cookbook.ExceptionConfiguration.dto;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class ApiErrorDto {
    private final String message;
    private final HttpStatus httpStatus;
    private final Date timestamp;
    private List<ErrorDetailDto> errorDetails;

    public ApiErrorDto(String message, HttpStatus httpStatus, Date timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public List<ErrorDetailDto> getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(List<ErrorDetailDto> errorDetails) {
        this.errorDetails = errorDetails;
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
