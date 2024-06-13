package com.api.v1.book_borrow.finish;

import java.time.LocalDateTime;
import java.util.UUID;

public class FinishingBookBorrowException extends RuntimeException {

    public FinishingBookBorrowException(LocalDateTime dueDateTime, UUID isbn, String ssn) {
        super("""
                Book borrow which due datetime is %s, book's ISBN is %s and borrower's SSN is %s is already finished.
              """.formatted(dueDateTime, isbn, ssn));
    }

}
