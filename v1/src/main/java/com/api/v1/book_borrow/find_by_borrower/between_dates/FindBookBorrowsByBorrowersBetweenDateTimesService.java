package com.api.v1.book_borrow.find_by_borrower.between_dates;

import java.util.List;

import com.api.v1.book_borrow.BookBorrow;

import jakarta.validation.constraints.NotNull;

public interface FindBookBorrowsByBorrowersBetweenDateTimesService {
    
    List<BookBorrow> findBookBorrowsBetweenDateTimes(String ssn, @NotNull BetweenDateTimesDTO dto);

}
