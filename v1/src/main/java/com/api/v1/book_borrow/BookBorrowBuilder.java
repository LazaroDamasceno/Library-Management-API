package com.api.v1.book_borrow;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

public class BookBorrowBuilder {

    private Book book;
    private Borrower borrower;

    public BookBorrowBuilder book(Book book) {
        this.book = book;
        return this;
    }

    public BookBorrowBuilder borrower(Borrower borrower) {
        this.borrower = borrower;
        return this;
    }

    public BookBorrow build() {
        return new BookBorrow(book, borrower);
    }

}
