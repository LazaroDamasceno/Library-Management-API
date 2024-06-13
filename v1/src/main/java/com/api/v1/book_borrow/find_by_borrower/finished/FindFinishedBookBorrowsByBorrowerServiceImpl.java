package com.api.v1.book_borrow.find_by_borrower.finished;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindFinishedBookBorrowsByBorrowerServiceImpl
        implements  FindFinishedBookBorrowsByBorrowerService
{

    private final FindBorrowerBySsnService findBorrowerBySsn;
    private final BookBorrowRepository repository;

    public FindFinishedBookBorrowsByBorrowerServiceImpl(FindBorrowerBySsnService findBorrowerBySsn,
                                                        BookBorrowRepository repository)
    {
        this.findBorrowerBySsn = findBorrowerBySsn;
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookBorrow> findFinishedByBorrower(@SSN String ssn) {
        Borrower borrower = findBorrowerBySsn.findBySsn(ssn);
        return repository.findFinishedBookBorrowsByBorrower(borrower);
    }

}
