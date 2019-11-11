package com.training.cookbook.exceptionhandler.configuration;

import com.training.cookbook.exceptionhandler.dto.ApiErrorDto;
import com.training.cookbook.exceptions.api.ApiBadRequestException;
import com.training.cookbook.exceptions.api.ApiInternalServerException;
import com.training.cookbook.exceptions.api.ApiNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.validation.ConstraintViolation;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        ApiErrorDto errorResponse = new ApiErrorDto("Validation error",BAD_REQUEST);
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorResponse.addError(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errorResponse.addError(error.getObjectName(), error.getDefaultMessage());
        }
        return handleExceptionInternal(ex, errorResponse, headers, BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {ApiBadRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiBadRequestException e){
        return getObjectResponseEntity(e, BAD_REQUEST);
    }

    @ExceptionHandler(value = {ApiInternalServerException.class})
    public ResponseEntity<Object> handleInternalServerException(ApiInternalServerException e){
        return getObjectResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ApiNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(ApiNotFoundException e){
        return getObjectResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({javax.validation.ConstraintViolationException.class})
    public ResponseEntity<ApiErrorDto> handleConstraintViolation(final javax.validation.ConstraintViolationException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.warn(request.toString());
        String errorMessage = ex.getMessage() == null || ex.getMessage().length() == 0 ? "Constrain Violation Error" : ex.getMessage();
        final ApiErrorDto apiError = new ApiErrorDto(errorMessage, HttpStatus.BAD_REQUEST);
        for (final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            logger.warn(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
            apiError.addError(violation.getRootBeanClass().getName(), violation.getMessage());
        }
        return new ResponseEntity<>(apiError, BAD_REQUEST);
    }

    @ExceptionHandler({org.hibernate.exception.ConstraintViolationException.class})
    public ResponseEntity<ApiErrorDto> handleConstraintViolation(final org.hibernate.exception.ConstraintViolationException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.warn(request.toString());
        String errorMessage = ex.getMessage() == null || ex.getMessage().length() == 0 ? "Constrain Violation Error" : ex.getMessage();
        final ApiErrorDto apiError = new ApiErrorDto(errorMessage, BAD_REQUEST);
        return new ResponseEntity<>(apiError, BAD_REQUEST);
    }

    private ResponseEntity<Object> getObjectResponseEntity(RuntimeException e, HttpStatus httpStatus) {
        ApiErrorDto apiErrorModel = new ApiErrorDto(
                e.getMessage(),
                httpStatus);

        return new ResponseEntity<>(apiErrorModel, httpStatus);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }
}
