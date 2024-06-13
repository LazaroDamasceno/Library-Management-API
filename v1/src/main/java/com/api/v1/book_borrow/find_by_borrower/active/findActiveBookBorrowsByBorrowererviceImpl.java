package com.api.v1.book_borrow.find_by_borrower.active;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;

@Service
public class findActiveBookBorrowsByBorrowererviceImpl implements findActiveBookBorrowsByBorrowerervice {

    private final BookBorrowRepository repository;
    private final FindBorrowerBySsnService findBorrowerBySSn;

    public findActiveBookBorrowsByBorrowererviceImpl(BookBorrowRepository repository,
            FindBorrowerBySsnService findBorrowerBySSn) {
        this.repository = repository;
        this.findBorrowerBySSn = findBorrowerBySSn;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookBorrow> findActiveBookBorrows(@SSN String ssn) {
        Borrower borrower = findBorrowerBySSn.findBySsn(ssn);
        return repository.findActiveBookBorrowsByBorrower(borrower);
    }
    
}