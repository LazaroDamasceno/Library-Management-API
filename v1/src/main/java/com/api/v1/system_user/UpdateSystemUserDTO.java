package com.api.v1.system_user;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateSystemUserDTO(
    @NotBlank String fullName, 
    @NotNull LocalDateTime birthDate,
    @Email @NotBlank String email,
    @NotNull @Size(min=1) String gender,
    @NotBlank String phoneNumber
) {
    
}
