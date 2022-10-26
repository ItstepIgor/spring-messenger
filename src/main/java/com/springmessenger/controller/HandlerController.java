package com.springmessenger.controller;


import com.springmessenger.exception.AuthException;
import com.springmessenger.exception.BadLoginOrPasswordException;
import com.springmessenger.exception.TemplateResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerController {

    @ExceptionHandler(BadLoginOrPasswordException.class)
    public ResponseEntity<TemplateResponseException> handleMyException(BadLoginOrPasswordException exception) {
        return getResponseEntity(exception.getClass().getName(), exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<TemplateResponseException> handleMyException(AuthException exception) {
        return getResponseEntity(exception.getClass().getName(), exception.getMessage(), HttpStatus.FORBIDDEN);
    }

    private ResponseEntity<TemplateResponseException> getResponseEntity(String error, String message, HttpStatus status) {
        System.out.println(message);
        return new ResponseEntity<>(new TemplateResponseException(status.value(), error, message), status);
    }
}
