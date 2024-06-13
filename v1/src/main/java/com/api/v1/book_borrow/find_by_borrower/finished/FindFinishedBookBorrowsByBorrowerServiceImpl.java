package com.api.v1.book_borrow.find_by_borrower.finished;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;

public class FindFinishedBookBorrowsByBorrowerServiceImpl implements FindFinishedBookBorrowsByBorrowerService {

    private final FindBorrowerBySsnService findBorrowerBySsn;
    private final BookBorrowRepository repository;

    public FindFinishedBookBorrowsByBorrowerServiceImpl(FindBorrowerBySsnService findBorrowerBySsn,
            BookBorrowRepository repository) {
        this.findBorrowerBySsn = findBorrowerBySsn;
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookBorrow> findReturnedBookBorrows(@SSN String ssn) {
        Borrower borrower = findBorrowerBySsn.findBySsn(ssn);
        return repository.findReturnedBookBorrowByBorrower(borrower);
    }
    
}
