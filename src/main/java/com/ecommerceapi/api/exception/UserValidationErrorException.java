package com.ecommerceapi.api.exception;

public class UserValidationErrorException extends BadRequestException {
    public UserValidationErrorException() {
        super("User validation error.");
    }
}
