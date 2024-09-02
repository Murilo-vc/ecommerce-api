package com.ecommerceapi.api.exception;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super("User not found or is deleted.");
    }
}
