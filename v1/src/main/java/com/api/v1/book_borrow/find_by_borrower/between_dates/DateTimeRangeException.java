package com.api.v1.book_borrow.find_by_borrower.between_dates;

import java.time.LocalDateTime;

public class DateTimeRangeException extends RuntimeException {

    public DateTimeRangeException(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        super("The first datetime %s cannot be beyond the last datetime %s.".formatted(firstDateTime, lastDateTime));
    }
    
}
