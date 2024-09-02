package com.ecommerceapi.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product extends BaseEntity {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @Column(name = "name", nullable = false)
    private String name;

    @DecimalMax("99999999999.99")
    @DecimalMin("0")
    @Digits(integer = 11, fraction = 2)
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotNull
    @NotBlank
    @Size(min = 1)
    @Column(name = "description", nullable = false)
    private String description;
}
