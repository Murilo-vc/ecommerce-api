package com.ecommerceapi.api.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPayload {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 4000)
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 350)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 150)
    private String name;
}
