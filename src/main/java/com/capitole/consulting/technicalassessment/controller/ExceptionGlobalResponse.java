package com.capitole.consulting.technicalassessment.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionGlobalResponse {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String mismatchException(MethodArgumentTypeMismatchException ex) {
        return ex.getMessage();
    }

}
