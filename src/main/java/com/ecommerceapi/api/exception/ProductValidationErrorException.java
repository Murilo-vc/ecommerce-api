package com.ecommerceapi.api.exception;

public class ProductValidationErrorException extends BadRequestException {
    public ProductValidationErrorException() {
        super("Product Validation Error");
    }
}
