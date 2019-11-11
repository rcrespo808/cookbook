package com.training.cookbook.exceptions.api;

import com.training.cookbook.exceptionhandler.dto.ApiErrorDto;
import com.training.cookbook.exceptionhandler.dto.ErrorDetailDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiException extends RuntimeException {

    ApiErrorDto apiErrorDto;
    
    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(String message, Throwable cause, List<String> errorList, HttpStatus httpStatus){
        this.apiErrorDto = new ApiErrorDto(message, httpStatus);
        assert false;
        errorList.forEach((String e) -> this.apiErrorDto.getErrorDetails().add(new ErrorDetailDto(cause.toString(),message)));
    }
    
    public ApiErrorDto getApiErrorDto() {
        return apiErrorDto;
    }
}
