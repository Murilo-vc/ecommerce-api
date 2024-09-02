package com.ecommerceapi.api.service;

import com.ecommerceapi.api.dto.ProductGetAllDto;
import com.ecommerceapi.api.dto.ProductGetByIdDto;
import com.ecommerceapi.api.payload.ProductPayload;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<List<ProductGetAllDto>> getAll();

    ResponseEntity<ProductGetByIdDto> getOneById(@NotNull final Long productId);

    ResponseEntity<ProductGetByIdDto> create(@NotNull final ProductPayload payload);

    ResponseEntity<String> update(@NotNull final ProductPayload payload,
                                  @NotNull final Long productId);

    ResponseEntity<String> delete(@NotNull final Long productId);
}
