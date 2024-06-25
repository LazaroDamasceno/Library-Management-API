package com.api.v1.book.register;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FieldsDTO(
    @NotBlank String mainField,
    String secondaryField,
    String ternaryField
) {
    
}
