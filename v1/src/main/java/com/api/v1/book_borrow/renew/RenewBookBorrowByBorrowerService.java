package com.api.v1.book_borrow.renew;

import jakarta.validation.constraints.NotNull;

public interface RenewBookBorrowByBorrowerService {

    void RenewByBorrower(BookBorrowDataDTO dto);

}
