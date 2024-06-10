package com.api.v1.book_borrow.find_by_borrower.between_dates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.customized_annotations.SSN;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FindBookBorrowsByBorrowersBetweenDateTimesController {

    @Autowired
    private FindBookBorrowsByBorrowersBetweenDateTimesService service;

    @GetMapping("all/by-ssn/{ssn}/between-datetimes")
    public ResponseEntity<List<BookBorrow>> findBetweenDateTimes(
        @SSN @PathVariable String ssn, 
        @NotNull @RequestBody BetweenDateTimesDTO dto
    ) {
        return ResponseEntity.ok(service.findBookBorrowsBetweenDateTimes(ssn, dto));
    }
    
}
