package com.api.v1.book.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book.Book;

@RestController
@RequestMapping("api/v1/books")
public class FindAllBooksController {
    
    private final FindAllBooksService service;

    public FindAllBooksController(FindAllBooksService service) {
        this.service = service;
    }

    @GetMapping
    @Async
    public CompletableFuture<List<Book>> findAll() {
        return service.findAll();
    }

}
