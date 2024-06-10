package com.api.v1.book_borrow.find_by_book_and_borrower;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.customized_annotations.SSN;

import jakarta.validation.constraints.NotBlank;

public class FindBookBorrowByBookAndBorrowerServiceImpl implements FindBookBorrowByBookAndBorrowerService {
 
    @Autowired
    private BookBorrowRepository repository;

    @Override
    public BookBorrow findByBookAndBorrower(@NotBlank String isbn, @SSN String ssn) {
        Optional<BookBorrow> optional = repository.findBookBorrowByBookAndBorrower(UUID.fromString(isbn), ssn);
        if (optional.isEmpty()) throw new BookBorrowWasNotFoundException(isbn, ssn);
        return optional.get();
    }

}
