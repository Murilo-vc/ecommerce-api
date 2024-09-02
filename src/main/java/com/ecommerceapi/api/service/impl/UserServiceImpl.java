package com.ecommerceapi.api.service.impl;

import com.ecommerceapi.api.dto.UserCreateDto;
import com.ecommerceapi.api.dto.UserGetByIdDto;
import com.ecommerceapi.api.entity.User;
import com.ecommerceapi.api.exception.UserNotFoundException;
import com.ecommerceapi.api.exception.UserValidationErrorException;
import com.ecommerceapi.api.payload.UserPayload;
import com.ecommerceapi.api.repository.UserRepository;
import com.ecommerceapi.api.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(@NotNull final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<UserCreateDto> create(final UserPayload payload) {

        if (payload.getName() == null || payload.getEmail() == null || payload.getPassword() == null)
            throw new UserValidationErrorException();

        User user = new User();

        user.setPassword(payload.getPassword());
        user.setName(payload.getName());
        user.setEmail(payload.getEmail());
        user.setIsDeleted(false);

        this.userRepository.save(user);

        return ResponseEntity.ok().body(UserCreateDto.toDto(user));
    }

    @Override
    public ResponseEntity<UserGetByIdDto> getOneById(@NotNull final Long userId) {
        User user = this.userRepository.getOneByIdAndIsDeletedFalse(userId)
                .orElseThrow(UserNotFoundException::new);

        return ResponseEntity.ok().body(UserGetByIdDto.toDto(user));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> update(@NotNull final UserPayload payload,
                                         @NotNull final Long userId) {

        if (payload.getName() == null || payload.getEmail() == null || payload.getPassword() == null)
            throw new UserValidationErrorException();

        User user = this.userRepository.getOneByIdAndIsDeletedFalse(userId)
                .orElseThrow(UserNotFoundException::new);

        user.setPassword(payload.getPassword());
        user.setEmail(payload.getEmail());
        user.setName(payload.getName());

        this.userRepository.save(user);

        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> delete(final Long userId) {

        User user = this.userRepository.getOneByIdAndIsDeletedFalse(userId)
                .orElseThrow(UserNotFoundException::new);

        user.setIsDeleted(true);
        user.setDeletedAt(Instant.now());

        this.userRepository.save(user);

        return ResponseEntity.noContent().build();
    }
}
