package com.blueeyes.demo.dtos;

import com.blueeyes.demo.domain.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsersDTO(
        @NotBlank
        String username,
        @NotBlank
        String email,
        @NotNull
        Address address
) {
}
