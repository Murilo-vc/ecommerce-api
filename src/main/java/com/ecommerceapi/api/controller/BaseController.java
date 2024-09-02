package com.ecommerceapi.api.controller;

import com.ecommerceapi.api.exception.ApiError;
import com.ecommerceapi.api.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

public class BaseController {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError> handleBaseException(final BaseException e, final HttpServletRequest request) {
        return ResponseEntity.status(e.getStatus())
                .body(ApiError.builder()
                        .timestamp(Instant.now())
                        .status(e.getStatus().value())
                        .error(e.getStatus().getReasonPhrase())
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }
}
