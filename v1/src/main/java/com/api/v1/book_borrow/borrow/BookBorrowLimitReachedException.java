package com.api.v1.book_borrow.borrow;

public class BookBorrowLimitReachedException extends RuntimeException {

    public BookBorrowLimitReachedException(String ssn) {
        super("Borrower whose SSN is %s already reached the limit of borrows.".formatted(ssn));
    }
    
}
