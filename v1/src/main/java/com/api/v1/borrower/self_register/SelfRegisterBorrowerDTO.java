package com.api.v1.borrower.self_register;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SelfRegisterBorrowerDTO(
	@NotBlank String name,
	@NotNull @Size(min = 9, max = 9) String ssn,
	@NotNull LocalDate birthDate,
	@Email String email,
	@NotBlank String address,
	@NotNull @Size(min = 1) String gender,
	@NotNull @Size(min = 7, max = 7) String phoneNumber
) {
	
}
