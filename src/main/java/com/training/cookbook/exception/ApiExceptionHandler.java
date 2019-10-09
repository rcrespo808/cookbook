package com.training.cookbook.exception;

import com.training.cookbook.exception.exceptions.general.ApiInternalServerException;
import com.training.cookbook.exception.exceptions.general.ApiNotFoundException;
import com.training.cookbook.exception.exceptions.general.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {ApiInternalServerException.class})
    public ResponseEntity<Object> handleInternalServerException(ApiInternalServerException e){
        HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {ApiNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(ApiNotFoundException e){
        HttpStatus badRequest = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, badRequest);
    }
}
