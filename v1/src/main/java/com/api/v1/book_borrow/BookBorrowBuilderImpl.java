package com.api.v1.book_borrow;

import org.springframework.stereotype.Service;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

@Service
public class BookBorrowBuilderImpl implements BookBorrowBuilder {

    private Book book;
    private Borrower borrower;

    @Override
    public BookBorrowBuilderImpl create(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        return this;
    }

    @Override
    public BookBorrow build() {
        return new BookBorrow(book, borrower);
    }

}
