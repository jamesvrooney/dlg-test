package com.rooney.james.dlgtest.exception;

public class UserWithMatchingEmailException extends RuntimeException {
    public UserWithMatchingEmailException(String email) {

        super(String.format("A user with email %s already exists.", email));
    }
}
