package com.api.v1.book_borrow.find_by_borrower.active;

import java.util.List;

import com.api.v1.book_borrow.BookBorrow;

public interface FindActiveBookBorrowsByBorrowerService {

    List<BookBorrow> findActiveBookBorrows(String ssn);
    
}
