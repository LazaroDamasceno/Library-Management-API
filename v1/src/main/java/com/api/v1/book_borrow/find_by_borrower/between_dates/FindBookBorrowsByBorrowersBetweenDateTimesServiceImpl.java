package com.api.v1.book_borrow.find_by_borrower.between_dates;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;

import jakarta.validation.constraints.NotNull;

@Service
public class FindBookBorrowsByBorrowersBetweenDateTimesServiceImpl implements FindBookBorrowsByBorrowersBetweenDateTimesService {

    private final BookBorrowRepository repository;
    private final FindBorrowerBySsnService findBorrowerBySSN;

    public FindBookBorrowsByBorrowersBetweenDateTimesServiceImpl(BookBorrowRepository repository,
            FindBorrowerBySsnService findBorrowerBySSN) {
        this.repository = repository;
        this.findBorrowerBySSN = findBorrowerBySSN;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookBorrow> findBookBorrowsBetweenDateTimes(@SSN String ssn, @NotNull BetweenDateTimesDTO dto) {
        Borrower borrower = findBorrowerBySSN.findBySsn(ssn);
        checkDateTimes(dto);
        return repository.findBookBorrowsByBorrowersBetweenDateTimes(borrower, dto.firstDateTime(), dto.lastDateTime());
    }

    private void checkDateTimes(BetweenDateTimesDTO dto) {
        if (dto.firstDateTime().isAfter(dto.lastDateTime())) {
            throw new DateTimeRangeException(dto.firstDateTime(), dto.lastDateTime());
        }
    }
    
}
