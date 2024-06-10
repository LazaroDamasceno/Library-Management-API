package com.api.v1.book_borrow.find_by_borrower.between_dates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;

import jakarta.validation.constraints.NotNull;

@Service
public class FindBookBorrowsByBorrowersBetweenDateTimesServiceImpl implements FindBookBorrowsByBorrowersBetweenDateTimesService {

    @Autowired
    private BookBorrowRepository repository;

    @Autowired
    private FindBorrowerBySsnService findBorrowerBySSN;

    @Override
    public List<BookBorrow> findBookBorrowsBetweenDateTimes(@SSN String ssn, @NotNull BetweenDateTimesDTO dto) {
        Borrower borrower = findBorrowerBySSN.findBySsn(ssn);
        return repository.findBookBorrowsByBorrowersBetweenDateTimes(borrower, dto.firstDate(), dto.lastDate());
    }

    
}
