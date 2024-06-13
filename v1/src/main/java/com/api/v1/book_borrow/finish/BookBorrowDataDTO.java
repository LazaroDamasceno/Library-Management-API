package com.api.v1.book_borrow.finish;

import com.api.v1.customized_annotations.SSN;
import jakarta.validation.constraints.NotNull;

public record BookBorrowDataDTO(
        @NotNull String isbn,
        @SSN String ssn
) {
}
