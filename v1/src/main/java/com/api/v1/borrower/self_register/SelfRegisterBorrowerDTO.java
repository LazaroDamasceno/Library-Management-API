package com.api.v1.borrower.self_register;

import java.time.LocalDate;

import com.api.v1.customized_annotations.SSN;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SelfRegisterBorrowerDTO(
	@NotBlank String firstName,
	String middleName,
	@NotBlank String lastName,
	@SSN String ssn,
	@NotNull LocalDate birthDate,
	@NotNull @Email String email,
	@NotBlank String address,
	@NotNull @Size(min = 1) String gender,
	@NotNull @Size(min = 10, max = 10) String phoneNumber
) {
	
}
