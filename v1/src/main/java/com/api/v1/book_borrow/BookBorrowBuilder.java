package com.api.v1.book_borrow;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

public class BookBorrowBuilder {

    private final Book book;
    private final Borrower borrower;

    public BookBorrowBuilder(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
    }
    
    public BookBorrow build() {
        return new BookBorrow(book, borrower);
    }

}
