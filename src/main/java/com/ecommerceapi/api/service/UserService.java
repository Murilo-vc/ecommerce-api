package com.ecommerceapi.api.service;

import com.ecommerceapi.api.dto.UserCreateDto;
import com.ecommerceapi.api.dto.UserGetByIdDto;
import com.ecommerceapi.api.payload.UserPayload;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<UserCreateDto> create(final UserPayload payload);

    ResponseEntity<UserGetByIdDto> getOneById(@NotNull final Long userId);

    ResponseEntity<String> update(final UserPayload payload,
                final Long userId);

    ResponseEntity<String> delete(final Long userId);
}
