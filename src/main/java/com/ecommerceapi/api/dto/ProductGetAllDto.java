package com.ecommerceapi.api.dto;

import com.ecommerceapi.api.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductGetAllDto extends IdDto {

    private final String name;
    private final BigDecimal price;

    @Builder
    public ProductGetAllDto(@NotNull final Long id,
                            @NotNull final String name,
                            @NotNull final BigDecimal price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public static ProductGetAllDto toDto(@NotNull final Product entity) {
        return ProductGetAllDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice()).build();
    }
}
