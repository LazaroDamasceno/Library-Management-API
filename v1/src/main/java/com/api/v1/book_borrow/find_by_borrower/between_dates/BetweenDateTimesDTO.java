package com.api.v1.book_borrow.find_by_borrower.between_dates;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record BetweenDateTimesDTO(
    @NotNull LocalDateTime firstDate,
    @NotNull LocalDateTime lastDate
) {
    
}
