package com.ecommerceapi.api.controller;

import com.ecommerceapi.api.dto.UserCreateDto;
import com.ecommerceapi.api.dto.UserGetByIdDto;
import com.ecommerceapi.api.payload.UserPayload;
import com.ecommerceapi.api.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("UserController")
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(@NotNull final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCreateDto> create(@RequestBody UserPayload payload) {

        return this.userService.create(payload);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> update(@RequestBody @NotNull final UserPayload payload,
                                         @PathVariable @NotNull final Long userId) {
        return this.userService.update(payload, userId);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserGetByIdDto> getById(@PathVariable final Long userId) {
        return this.userService.getOneById(userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable @NotNull final Long userId) {
        return this.userService.delete(userId);
    }
}
