package com.api.v1.book.register;

import jakarta.validation.constraints.NotBlank;

public record AuthorsDTO(
    @NotBlank String firstAuthor,
    String secondAuthor,
    String thirdAuthor
) {
    
}
