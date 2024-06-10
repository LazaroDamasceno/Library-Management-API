package com.api.v1.book_borrow.borrow;

import jakarta.validation.constraints.NotNull;

public interface BorrowBookService {
    
    void borrowBook(@NotNull BorrowBookDTO dto);

}
