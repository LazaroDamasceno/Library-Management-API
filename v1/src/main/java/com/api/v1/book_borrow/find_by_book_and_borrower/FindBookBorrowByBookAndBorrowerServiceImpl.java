package com.api.v1.book_borrow.find_by_book_and_borrower;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.find_by_isbn.FindBookByIsbnService;
import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;

import jakarta.validation.constraints.NotBlank;

public class FindBookBorrowByBookAndBorrowerServiceImpl implements FindBookBorrowByBookAndBorrowerService {
 
    private final BookBorrowRepository repository;
    private final FindBorrowerBySsnService findBorrowerBySSN;
    private final FindBookByIsbnService findBookByISBN;

    public FindBookBorrowByBookAndBorrowerServiceImpl(BookBorrowRepository repository,
            FindBorrowerBySsnService findBorrowerBySSN, FindBookByIsbnService findBookByISBN) {
        this.repository = repository;
        this.findBorrowerBySSN = findBorrowerBySSN;
        this.findBookByISBN = findBookByISBN;
    }

    @Override
    @Transactional(readOnly = true)
    public BookBorrow findByBookAndBorrower(@NotBlank String isbn, @SSN String ssn) {
        Borrower borrower = findBorrowerBySSN.findBySsn(ssn);
        Book book = findBookByISBN.findByISBN(isbn);
        Optional<BookBorrow> optional = repository.findBookBorrowByBookAndBorrower(book, borrower);
        if (optional.isEmpty()) throw new BookBorrowWasNotFoundException(isbn, ssn);
        return optional.get();
    }

}
