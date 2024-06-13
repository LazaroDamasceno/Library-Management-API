package com.api.v1.book_borrow.renew;

import com.api.v1.customized_annotations.SSN;
import jakarta.validation.constraints.NotNull;

public record BookBorrowDataDTO(
        @SSN String ssn,
        @NotNull String isbn
) {
}
