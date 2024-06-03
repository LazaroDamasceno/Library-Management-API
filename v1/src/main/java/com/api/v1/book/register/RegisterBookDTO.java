package com.api.v1.book.register;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterBookDTO(
    @NotBlank String title,
    @NotBlank String subtitle,
    @NotNull int numberOfPages,
    @NotNull @Size(min = 13, max = 13) String isbn,
    @NotNull int vesion,
    @NotNull AuthorsDTO authorsDTO,
    @NotNull FieldsDTO fieldsDTO
) {
    
}
