package com.api.v1.book_borrow.find_by_book_and_borrower;

public class BookBorrowWasNotFoundException extends RuntimeException {

    public BookBorrowWasNotFoundException(String isbn, String ssn) {
        super("""
            Book borrow which book's ISBN is %s and borrower's SSN is %s was not found.
        """.formatted(isbn, ssn));
    }
    
}
