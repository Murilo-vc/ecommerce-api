package com.ecommerceapi.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_user")
@NoArgsConstructor
public class User extends BaseEntity {

    @NotNull
    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 350)
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 150)
    @Column(name = "name", nullable = false)
    private String name;
}
