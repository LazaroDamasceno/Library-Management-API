package com.api.v1.book_borrow.find_by_borrower.all;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.customized_annotations.SSN;

@Service
public class FindAllBorrowsByBorrowerServiceImpl implements FindAllBorrowsByBorrowerService {

    @Autowired
    private BookBorrowRepository repository;

    @Override
    public List<BookBorrow> findAllBorrowsByBorrower(@SSN String ssn) {
        return repository.findAllBorrowsByBorrowers(ssn);
    }
    
}
