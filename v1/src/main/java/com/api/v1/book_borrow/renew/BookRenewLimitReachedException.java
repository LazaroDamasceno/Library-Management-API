package com.api.v1.book_borrow.renew;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookRenewLimitReachedException  extends RuntimeException {

    public BookRenewLimitReachedException(LocalDateTime dueDateTime, UUID isbn, String ssn) {
        super(
                """
                    Book borrow which due datetime is %s, book's ISBN is %s and borrower's SSN is %s is already renewed.
                """.formatted(dueDateTime, isbn, ssn)
        );
    }

}
