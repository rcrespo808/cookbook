package com.training.cookbook.exceptionhandler.dto;

import com.training.cookbook.util.DateUtil;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiErrorDto {
    private final String message;
    private final HttpStatus httpStatus;
    private final Date timestamp;
    private List<ErrorDetailDto> errorDetails;

    public ApiErrorDto(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = DateUtil.Today();
        this.errorDetails = new ArrayList<>(0);
    }

    public List<ErrorDetailDto> getErrorDetails() {
        return errorDetails;
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

    public void addError(String name, String message) {
        if( this.errorDetails == null){
            this.errorDetails = new ArrayList<>();
        }
        this.errorDetails.add(new ErrorDetailDto(name, message));
    }
}
