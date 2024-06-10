package com.api.v1.book_borrow.find_by_borrower.active;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.customized_annotations.SSN;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FindActiveBookBorrowsByBorrowerController {
    
    @Autowired
    private FindActiveBookBorrowsByBorrowerService service;

    @GetMapping("all/active/by-ssn/{ssn}")
    public ResponseEntity<List<BookBorrow>> findActiveBookBorrows(@SSN @PathVariable String ssn) {
        return ResponseEntity.ok(service.findActiveBookBorrows(ssn));
    }

}
