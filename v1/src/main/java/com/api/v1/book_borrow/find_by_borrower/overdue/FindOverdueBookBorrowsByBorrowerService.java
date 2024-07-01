package com.api.v1.book_borrow.find_by_borrower.overdue;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.api.v1.book_borrow.BookBorrow;

public interface FindOverdueBookBorrowsByBorrowerService {

    CompletableFuture<List<BookBorrow>> findOverdueBookBorrows(String ssn);
    
}
