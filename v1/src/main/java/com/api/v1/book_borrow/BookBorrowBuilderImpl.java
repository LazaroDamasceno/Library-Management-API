package com.api.v1.book_borrow;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;


public class BookBorrowBuilderImpl implements BookBorrowBuilder {

    private Book book;
    private Borrower borrower;

    private BookBorrowBuilderImpl(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
    }

    public BookBorrowBuilderImpl() {

    }

    @Override
    public BookBorrowBuilderImpl create(Book book, Borrower borrower) {
        return new BookBorrowBuilderImpl(book, borrower);
    }

    @Override
    public BookBorrow build() {
        return new BookBorrow(book, borrower);
    }


}
