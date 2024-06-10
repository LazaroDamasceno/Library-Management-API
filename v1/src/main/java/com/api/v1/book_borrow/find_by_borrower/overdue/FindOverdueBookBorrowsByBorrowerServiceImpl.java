package com.api.v1.book_borrow.find_by_borrower.overdue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;

public class FindOverdueBookBorrowsByBorrowerServiceImpl implements FindOverdueBookBorrowsByBorrowerService {

    @Autowired
    private BookBorrowRepository repository;

    @Autowired
    private FindBorrowerBySsnService findBorrowerBySSn;

    @Override
    public List<BookBorrow> findOverdueBookBorrows(@SSN String ssn) {
        Borrower borrower = findBorrowerBySSn.findBySsn(ssn);
        return repository.findOverdueBookBorrowsByBorrowers(borrower);
    }
    
}
