package com.api.v1.book.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
