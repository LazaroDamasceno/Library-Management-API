package com.api.v1.book_borrow.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.book.Book;
import com.api.v1.book.find_by_isbn.FindBookByIsbnService;
import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySSnService;

import jakarta.validation.constraints.NotNull;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

    @Autowired
    private BookBorrowRepository repository;

    @Autowired
    private FindBorrowerBySSnService findBorrowerBySSn;

    @Autowired 
    FindBookByIsbnService findBookByISBN;

    @Override
    public void borrowBook(@NotNull BorrowBookDTO dto) {
        Borrower borrower = findBorrowerBySSn.findBySsn(dto.ssn()); 
        doesBorrowerHaveThreeActiveBookBorrows(borrower.getSsn());
        Book book = findBookByISBN.findByISBN(dto.isbn());
        BookBorrow borrow = BookBorrow.createInstance(book, borrower);
        repository.save(borrow);
    }

    private void doesBorrowerHaveThreeActiveBookBorrows(String ssn) {
        if (repository.countHowManyBorrowsByBorrower(ssn) == 3) {
            throw new BookBorrowLimitReachedException(ssn);
        }
    }

}
