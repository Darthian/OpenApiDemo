package com.company.TechnicalDemo.api;

import org.apache.maven.InternalErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.webjars.NotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFoundException() {
    }

    @ExceptionHandler({InternalErrorException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleInternalErrorException() {
    }
}
