package com.api.v1.book_borrow.borrow;

import com.api.v1.customized_annotations.SSN;

public record BorrowBookDTO(
    String isbn, 
    @SSN String ssn
) {
    
}
