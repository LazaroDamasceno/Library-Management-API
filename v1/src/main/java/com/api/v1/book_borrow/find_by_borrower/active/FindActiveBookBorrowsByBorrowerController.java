package com.api.v1.book_borrow.find_by_borrower.active;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.customized_annotations.SSN;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FindActiveBookBorrowsByBorrowerController {
    
    private final FindActiveBookBorrowsByBorrowerService service;

    public FindActiveBookBorrowsByBorrowerController(FindActiveBookBorrowsByBorrowerService service) {
        this.service = service;
    }

    @GetMapping("active/by-ssn/{ssn}")
    public CompletableFuture<List<BookBorrow>> findActiveBookBorrows(@SSN @PathVariable String ssn) {
        return service.findActiveBookBorrows(ssn);
    }

}
