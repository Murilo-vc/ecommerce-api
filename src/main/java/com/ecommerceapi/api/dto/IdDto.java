package com.ecommerceapi.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class IdDto {

    private final Long id;

    protected IdDto(@NotNull final Long id) {
        this.id = id;
    }
}
