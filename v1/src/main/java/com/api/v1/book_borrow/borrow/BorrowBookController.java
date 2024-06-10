package com.api.v1.book_borrow.borrow;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/book-borrows")
public class BorrowBookController {

    private final BorrowBookService service;

    public BorrowBookController(BorrowBookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> borrowBook(@NotNull BorrowBookDTO dto) {
        service.borrowBook(dto);
        return ResponseEntity.status(201).build();
    }
    
}
