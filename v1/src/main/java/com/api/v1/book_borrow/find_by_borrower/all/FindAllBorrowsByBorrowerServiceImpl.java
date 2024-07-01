package com.api.v1.book_borrow.find_by_borrower.all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;

@Service
public class FindAllBorrowsByBorrowerServiceImpl implements FindAllBorrowsByBorrowerService {

    private final BookBorrowRepository repository;
    private final FindBorrowerBySsnService findBorrowerBySSn;

    public FindAllBorrowsByBorrowerServiceImpl(BookBorrowRepository repository,
            FindBorrowerBySsnService findBorrowerBySSn) {
        this.repository = repository;
        this.findBorrowerBySSn = findBorrowerBySSn;
    }

    @Override
    @Async
    public CompletableFuture<List<BookBorrow>> findAllBorrowsByBorrower(@SSN String ssn) {
        Borrower borrower = findBorrowerBySSn.findBySsn(ssn);
        List<BookBorrow> borrows = repository.findActiveBookBorrowsByBorrower(borrower);
        return CompletableFuture.completedFuture(borrows);
    }
    
}
