package com.api.v1.book_borrow.find_all;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book_borrow.BookBorrow;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FindAllBorrowsController {
    
    @Autowired
    private FindAllBorrowsService service;

    @GetMapping
    public ResponseEntity<List<BookBorrow>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
