package com.api.v1.book_borrow.find_by_borrower.active;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySSnService;
import com.api.v1.customized_annotations.SSN;

@Service
public class FindActiveBookBorrowsByBorrowerServiceImpl implements FindActiveBookBorrowsByBorrowerService {

    @Autowired
    private BookBorrowRepository repository;

    @Autowired
    private FindBorrowerBySSnService findBorrowerBySSn;

    @Override
    public List<BookBorrow> findActiveBookBorrows(@SSN String ssn) {
        Borrower borrower = findBorrowerBySSn.findBySsn(ssn);
        return repository.findActiveBookBorrowsByBorrowers(borrower);
    }
    
}
