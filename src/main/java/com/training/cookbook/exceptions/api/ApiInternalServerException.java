package com.training.cookbook.exceptions.api;

import com.training.cookbook.exceptionhandler.dto.ApiErrorDto;
import com.training.cookbook.exceptionhandler.dto.ErrorDetailDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiInternalServerException extends ApiException {
    public ApiInternalServerException(String message) {
        super(message);
    }

    public ApiInternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiInternalServerException(String message, Throwable cause, List<String> errorList, HttpStatus httpStatus){
        this.apiErrorDto = new ApiErrorDto(message, httpStatus);
        assert false;
        errorList.forEach((String e) -> this.apiErrorDto.getErrorDetails().add(new ErrorDetailDto(cause.toString(),message)));
    }
}
