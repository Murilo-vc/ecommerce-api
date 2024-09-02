package com.ecommerceapi.api.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPayload {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    private String name;

    @DecimalMax("99999999999.99")
    @DecimalMin("0")
    @Digits(integer = 11, fraction = 2)
    private BigDecimal price;

    @NotNull
    @NotBlank
    @Size(min = 1)
    private String description;
}
