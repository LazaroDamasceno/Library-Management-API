package com.api.v1.book.register;

import jakarta.validation.constraints.NotBlank;

public record FieldsDTO(
    @NotBlank String mainField,
    String secondaryField,
    String ternaryField
) {
    
}
