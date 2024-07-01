package com.api.v1.book_borrow.find_by_borrower.finished;

import com.api.v1.book_borrow.BookBorrow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FindFinishedBookBorrowsByBorrowerService {

    CompletableFuture<List<BookBorrow>> findFinishedByBorrower(String ssn);

}
