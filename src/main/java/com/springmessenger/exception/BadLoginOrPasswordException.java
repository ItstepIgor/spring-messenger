package com.springmessenger.exception;

public class BadLoginOrPasswordException extends RuntimeException {
    public BadLoginOrPasswordException(String message) {
        super(message);
    }
}
