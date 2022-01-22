package com.capitole.consulting.technicalassessment.controller;

import com.capitole.consulting.technicalassessment.model.ResponseError;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionGlobalResponse {

    private ResponseError responseError;

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseError> requestParameterException(MissingServletRequestParameterException ex) {
        responseError = createResponseError(ex, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> resourceNotFoundException(ResourceNotFoundException ex) {
        responseError = createResponseError(ex, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseError> argumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        responseError = createResponseError(ex, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    private ResponseError createResponseError(Exception ex, HttpStatus status) {
        ResponseError responseError = new ResponseError();
        responseError.setResponseCode(status.value());
        responseError.setErrorMessage(ex.getMessage());
        responseError.setTimeStamp(LocalDateTime.now());
        return responseError;
    }

}
