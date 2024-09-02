package com.ecommerceapi.api.exception;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException() {
        super("Product not found or is deleted.");
    }
}
