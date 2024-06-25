package com.api.v1.book.register;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterBookDTO(
    @NotBlank String title,
    @NotBlank String subtitle,
    @NotNull int numberOfPages,
    @NotNull @Min(1) int version,
    @NotNull AuthorsDTO authorsDTO,
    @NotNull FieldsDTO fieldsDTO,
    @NotNull @Min(1) int numberOfCopies
) {
    
}
