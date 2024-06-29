package com.api.v1.book_borrow.borrow;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.find_by_isbn.FindBookByIsbnService;
import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowBuilder;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;

import jakarta.validation.constraints.NotNull;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

    private final BookBorrowRepository repository;
    private final FindBorrowerBySsnService findBorrowerBySSn; 
    private final FindBookByIsbnService findBookByISBN;
    private final BookBorrowBuilder builder;

    public BorrowBookServiceImpl(BookBorrowBuilder builder, FindBookByIsbnService findBookByISBN, FindBorrowerBySsnService findBorrowerBySSn, BookBorrowRepository repository) {
        this.builder = builder;
        this.findBookByISBN = findBookByISBN;
        this.findBorrowerBySSn = findBorrowerBySSn;
        this.repository = repository;
    }

    @Override
    @Transactional
    public void borrowBook(@NotNull BorrowBookDTO dto) {
        Borrower borrower = findBorrowerBySSn.findBySsn(dto.ssn()); 
        doesBorrowerHaveThreeActiveBookBorrows(borrower.getSsn());
        Book book = findBookByISBN.findByISBN(dto.isbn());
        BookBorrow borrow = builder.create(book, borrower).build();
        repository.save(borrow);
    }

    private final int BOOK_BORROWS_LIMIT = 3;

    private void doesBorrowerHaveThreeActiveBookBorrows(String ssn) {
        if (countHowManyBorrowsByBorrower(ssn) == BOOK_BORROWS_LIMIT) {
            throw new BookBorrowLimitReachedException(ssn);
        }
    }

    private long countHowManyBorrowsByBorrower(String ssn) {
        Borrower borrower = findBorrowerBySSn.findBySsn(ssn); 
        return repository
            .findAll()
            .stream()
            .filter(e -> e.getBorrower().equals(borrower))
            .count();
    }

}
