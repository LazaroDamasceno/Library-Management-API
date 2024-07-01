package com.api.v1.book_borrow.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book_borrow.BookBorrow;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FindAllBorrowsController {
    
    private final FindAllBorrowsService service;

    public FindAllBorrowsController(FindAllBorrowsService service) {
        this.service = service;
    }

    @GetMapping
    @Async
    public CompletableFuture<List<BookBorrow>> findAll() {
        return service.findAll();
    }

}
