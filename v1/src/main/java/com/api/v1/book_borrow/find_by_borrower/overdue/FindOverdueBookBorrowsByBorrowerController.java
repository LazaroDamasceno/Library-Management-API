package com.api.v1.book_borrow.find_by_borrower.overdue;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.customized_annotations.SSN;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FindOverdueBookBorrowsByBorrowerController {

    public FindOverdueBookBorrowsByBorrowerController(findOverdueBookBorrowsByBorrowerervice service) {
        this.service = service;
    }

    private final findOverdueBookBorrowsByBorrowerervice service;

    @GetMapping("overdue/by-ssn/{ssn}")
    public ResponseEntity<List<BookBorrow>> findOverdueBookBorrows(@SSN @PathVariable String ssn) {
        return ResponseEntity.ok(service.findOverdueBookBorrows(ssn));
    }
    
}
