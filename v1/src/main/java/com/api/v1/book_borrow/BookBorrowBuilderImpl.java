package com.api.v1.book_borrow;

import org.springframework.stereotype.Service;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

@Service
public class BookBorrowBuilderImpl implements BookBorrowBuilder {

    private final Book book;
    private final Borrower borrower;

    private BookBorrowBuilderImpl(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
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
