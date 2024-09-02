package com.ecommerceapi.api.dto;

import com.ecommerceapi.api.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductGetByIdDto extends IdDto {

    private final String name;
    private final String description;
    private final BigDecimal price;

    @Builder
    public ProductGetByIdDto(@NotNull final Long id,
                             @NotNull final String name,
                             @NotNull final String description,
                             @NotNull final BigDecimal price) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static ProductGetByIdDto toDto(Product entity) {
        return ProductGetByIdDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice()).build();
    }
}
