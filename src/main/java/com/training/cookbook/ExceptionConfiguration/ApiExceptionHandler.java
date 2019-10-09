package com.training.cookbook.ExceptionConfiguration;

import com.training.cookbook.apiException.ApiErrorModel;
import com.training.cookbook.exception.ApiBadRequestException;
import com.training.cookbook.exception.ApiInternalServerException;
import com.training.cookbook.exception.ApiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiBadRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiBadRequestException e){
        return getObjectResponseEntity(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ApiInternalServerException.class})
    public ResponseEntity<Object> handleInternalServerException(ApiInternalServerException e){
        return getObjectResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ApiNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(ApiNotFoundException e){
        return getObjectResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> getObjectResponseEntity(RuntimeException e, HttpStatus httpStatus) {
        ApiErrorModel apiErrorModel = new ApiErrorModel(
                e.getMessage(),
                httpStatus,
                new Date());

        return new ResponseEntity<>(apiErrorModel, httpStatus);
    }
}
