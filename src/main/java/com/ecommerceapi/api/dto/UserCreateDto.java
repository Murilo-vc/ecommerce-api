package com.ecommerceapi.api.dto;

import com.ecommerceapi.api.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreateDto extends IdDto {

    @NotNull
    private final String name;

    @Builder
    public UserCreateDto(@NotNull final Long id,
                         @NotNull final String name) {
        super(id);
        this.name = name;
    }

    public static UserCreateDto toDto(User entity) {
        return UserCreateDto.builder()
                .id(entity.getId())
                .name(entity.getName()).build();
    }
}
