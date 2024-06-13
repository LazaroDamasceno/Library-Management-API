package com.api.v1.book_borrow.finish;

import com.api.v1.book_borrow.BookBorrow;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FinishBookBorrowController {

    private final FinishBookBorrowService service;

    public FinishBookBorrowController(FinishBookBorrowService service) {
        this.service = service;
    }

    @PatchMapping("finish")
    public ResponseEntity<Void> finishBookBorrow(@NotNull @RequestBody BookBorrowDataDTO dto) {
        service.finishBookBorrow(dto);
        return ResponseEntity.status(204).build();
    }

}