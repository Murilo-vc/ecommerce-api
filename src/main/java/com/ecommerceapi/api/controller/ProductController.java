package com.ecommerceapi.api.controller;

import com.ecommerceapi.api.dto.ProductGetAllDto;
import com.ecommerceapi.api.dto.ProductGetByIdDto;
import com.ecommerceapi.api.payload.ProductPayload;
import com.ecommerceapi.api.service.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ProductController")
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController extends BaseController {

    private final ProductService productService;

    public ProductController(@NotNull final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductGetAllDto>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductGetByIdDto> getOneById(@NotNull @PathVariable final Long productId) {
        return this.productService.getOneById(productId);
    }

    @PostMapping
    public ResponseEntity<ProductGetByIdDto> create(@NotNull @RequestBody ProductPayload payload) {
        return this.productService.create(payload);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> update(@NotNull @RequestBody ProductPayload payload,
                                         @NotNull @PathVariable Long productId) {
        return this.productService.update(payload, productId);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> delete(@NotNull @PathVariable Long productId) {
        return this.productService.delete(productId);
    }
}
