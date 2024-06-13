package com.api.v1.book_borrow.finish;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.book_borrow.find_by_book_and_borrower.FindBookBorrowByBookAndBorrowerService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FinishBookBorrowServiceImpl implements FinishBookBorrowService {

    private final FindBookBorrowByBookAndBorrowerService findBookBorrowByBookAndBorrower;
    private final BookBorrowRepository repository;

    public FinishBookBorrowServiceImpl(FindBookBorrowByBookAndBorrowerService findBookBorrowByBookAndBorrower,
                                       BookBorrowRepository repository)
    {
        this.findBookBorrowByBookAndBorrower = findBookBorrowByBookAndBorrower;
        this.repository = repository;
    }

    @Override
    @Transactional
    public void finishBookBorrow(@NotNull BookBorrowDataDTO dto) {
        BookBorrow borrow = findBookBorrowByBookAndBorrower.findByBookAndBorrower(dto.isbn(), dto.ssn());
        borrow.markAsReturned();
        repository.save(borrow);
    }

}
