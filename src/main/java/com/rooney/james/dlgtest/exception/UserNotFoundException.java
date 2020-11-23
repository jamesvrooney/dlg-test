package com.rooney.james.dlgtest.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super(String.format("A user with email %s already exists.", email));
    }
}