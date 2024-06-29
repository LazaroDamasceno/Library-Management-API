package com.api.v1.book_borrow;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

public interface BookBorrowBuilder {
    
    BookBorrowBuilderImpl create(Book book, Borrower borrower);
    BookBorrow build();

}
