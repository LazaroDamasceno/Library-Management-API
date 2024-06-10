package com.api.v1.book_borrow.find_by_borrower.all;

import java.util.List;

import com.api.v1.book_borrow.BookBorrow;

public interface FindAllBorrowsByBorrowerService {
    
    List<BookBorrow> findAllBorrowsByBorrower(String ssn);

}
