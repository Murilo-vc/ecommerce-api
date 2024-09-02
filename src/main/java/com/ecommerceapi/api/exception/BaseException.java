package com.ecommerceapi.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private final HttpStatus status;

    public BaseException(final String message, final HttpStatus status) {
        super(message);
        this.status = status;
    }
}
