package com.api.v1.book_borrow.renew;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/book-borrows")
public class RenewBookBorrowController {

    private final RenewBookBorrowService service;

    public RenewBookBorrowController(RenewBookBorrowService service) {
        this.service = service;
    }

    @PatchMapping("renew")
    public ResponseEntity<Void> RenewByBorrower(@NotNull BookBorrowDataDTO dto) {
        service.RenewByBorrower(dto);
        return ResponseEntity.status(204).build();
    }

}
