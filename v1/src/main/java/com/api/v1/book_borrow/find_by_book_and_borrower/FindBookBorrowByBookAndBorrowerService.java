package com.api.v1.book_borrow.find_by_book_and_borrower;

import com.api.v1.book_borrow.BookBorrow;

import jakarta.validation.constraints.NotBlank;

public interface FindBookBorrowByBookAndBorrowerService {
    
    BookBorrow findByBookAndBorrower(@NotBlank String isbn, String ssn);

}
