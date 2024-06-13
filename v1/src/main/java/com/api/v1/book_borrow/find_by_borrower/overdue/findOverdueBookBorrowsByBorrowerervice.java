package com.api.v1.book_borrow.find_by_borrower.overdue;

import java.util.List;

import com.api.v1.book_borrow.BookBorrow;

public interface findOverdueBookBorrowsByBorrowerervice {

    List<BookBorrow> findOverdueBookBorrows(String ssn);
    
}
