package com.api.v1.borrower.update;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateBorrowerDataDTO(
		@NotBlank String firstName,
		String middleName,
		@NotBlank String lastName,
		@NotNull LocalDate birthDate,
		@Email String email,
		@NotBlank String address,
		@NotNull @Size(min = 1) String gender,
		@NotNull @Size(min = 7, max = 7) String phoneNumber
) {

}
