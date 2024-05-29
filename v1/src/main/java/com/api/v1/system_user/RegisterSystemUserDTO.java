package com.api.v1.system_user;

import java.time.LocalDateTime;

import com.api.v1.customized_annotations.SSN;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterSystemUserDTO(
    @NotBlank String fullName, 
    @NotNull LocalDateTime birthDate,
    @SSN String ssn,
    @Email @NotBlank String email,
    @NotNull @Size(min=1) String gender,
    @NotBlank String phoneNumber
) {
    
}
