package com.api.v1.book_borrow.find_by_borrower.finished;

import com.api.v1.book_borrow.BookBorrow;

import java.util.List;

public interface FindFinishedBookBorrowsByBorrowerService {

    List<BookBorrow> findFinishedByBorrower(String ssn);

}
