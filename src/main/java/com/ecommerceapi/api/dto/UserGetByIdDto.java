package com.ecommerceapi.api.dto;

import com.ecommerceapi.api.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGetByIdDto extends IdDto {

    private final String name;
    private final String email;

    @Builder
    public UserGetByIdDto(@NotNull final Long id,
                          @NotNull final String name,
                          @NotNull final String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public static UserGetByIdDto toDto(User entity) {
        return UserGetByIdDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName()).build();
    }
}
