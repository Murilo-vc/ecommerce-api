package com.ecommerceapi.api.service.impl;

import com.ecommerceapi.api.dto.ProductGetAllDto;
import com.ecommerceapi.api.dto.ProductGetByIdDto;
import com.ecommerceapi.api.entity.Product;
import com.ecommerceapi.api.exception.ProductNotFoundException;
import com.ecommerceapi.api.exception.ProductValidationErrorException;
import com.ecommerceapi.api.payload.ProductPayload;
import com.ecommerceapi.api.repository.ProductRepository;
import com.ecommerceapi.api.service.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service("productService")
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductGetAllDto>> getAll() {

        List<Product> products = this.productRepository.findAllByIsDeletedFalse();

        List<ProductGetAllDto> response = new ArrayList<ProductGetAllDto>();

        for (Product entity : products) {
            response.add(ProductGetAllDto.toDto(entity));
        }

        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<ProductGetByIdDto> getOneById(@NotNull final Long productId) {
        Product product = this.productRepository.getOneByIdAndIsDeletedFalse(productId)
                .orElseThrow(ProductNotFoundException::new);

        return ResponseEntity.ok().body(ProductGetByIdDto.toDto(product));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<ProductGetByIdDto> create(@NotNull final ProductPayload payload) {

        if (payload.getName() == null || payload.getDescription() == null || payload.getPrice() == null)
            throw new ProductValidationErrorException();

        Product product = new Product();

        product.setName(payload.getName());
        product.setDescription(payload.getDescription());
        product.setPrice(payload.getPrice());
        product.setIsDeleted(false);

        this.productRepository.save(product);

        return ResponseEntity.ok().body(ProductGetByIdDto.toDto(product));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> update(@NotNull final ProductPayload payload,
                                         @NotNull final Long productId) {

        if (payload.getName() == null || payload.getDescription() == null || payload.getPrice() == null)
            throw new ProductValidationErrorException();

        Product product = this.productRepository.getOneByIdAndIsDeletedFalse(productId)
                .orElseThrow(ProductNotFoundException::new);


        product.setName(payload.getName());
        try {
            product.setPrice(payload.getPrice());
        } catch (IllegalArgumentException e) {
            throw new ProductValidationErrorException();
        }
        product.setDescription(payload.getDescription());

        this.productRepository.save(product);

        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> delete(@NotNull final Long productId) {

        Product product = this.productRepository.getOneByIdAndIsDeletedFalse(productId)
                .orElseThrow(ProductNotFoundException::new);

        product.setIsDeleted(true);
        product.setDeletedAt(Instant.now());

        this.productRepository.save(product);

        return ResponseEntity.noContent().build();
    }
}
