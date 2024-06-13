package com.api.v1.book_borrow.find_by_borrower.finished;

import java.util.List;

import com.api.v1.book_borrow.BookBorrow;

public interface FindFinishedBookBorrowsByBorrowerService {
    
    List<BookBorrow> findReturnedBookBorrows(String ssn);

}
